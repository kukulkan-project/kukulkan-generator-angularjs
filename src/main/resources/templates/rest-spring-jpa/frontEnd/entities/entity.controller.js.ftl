<#if !entity.features.sheetable>
(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entityCamelCase?cap_first}Controller', ${entityCamelCase?cap_first}Controller);

    ${entityCamelCase?cap_first}Controller.$inject = ['$state',<#if hasBlobProperties == true> 'DataUtils',</#if> '${entityCamelCase?cap_first}', '${entityCamelCase?cap_first}Search', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams'];

    function ${entityCamelCase?cap_first}Controller($state,<#if hasBlobProperties == true> DataUtils,</#if> ${entityCamelCase?cap_first}, ${entityCamelCase?cap_first}Search, ParseLinks, AlertService, paginationConstants, pagingParams) {

        var vm = this;
        
        vm.${entityCamelCasePlural} = [];
        vm.loadPage = loadPage;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.transition = transition;
        vm.itemsPerPage = paginationConstants.itemsPerPage;
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;
        vm.searchQuery = pagingParams.search;
        vm.currentSearch = pagingParams.search;
        <#if hasBlobProperties == true>
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;
        </#if>

        loadAll();

        function loadAll () {
            if (pagingParams.search) {
                ${entityCamelCase?cap_first}Search.query({
                    query: pagingParams.search,
                    page: pagingParams.page - 1,
                    size: vm.itemsPerPage,
                    sort: sort()
                }, onSuccess, onError);
            } else {
                ${entityCamelCase?cap_first}.query({
                    page: pagingParams.page - 1,
                    size: vm.itemsPerPage,
                    sort: sort()
                }, onSuccess, onError);
            }
            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.${entityCamelCasePlural} = data;
                vm.page = pagingParams.page;
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

        function loadPage(page) {
            vm.page = page;
            vm.transition();
        }

        function transition() {
            $state.transitionTo($state.$current, {
                page: vm.page,
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc'),
                search: vm.currentSearch
            });
        }

        function search(searchQuery) {
            if (!searchQuery){
                return vm.clear();
            }
            vm.links = null;
            vm.page = 1;
            vm.predicate = '_score';
            vm.reverse = false;
            vm.currentSearch = searchQuery;
            vm.transition();
        }

        function clear() {
            vm.links = null;
            vm.page = 1;
            vm.predicate = 'id';
            vm.reverse = true;
            vm.currentSearch = null;
            vm.transition();
        }
    }
})();
<#else>
(function () {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entityCamelCase?cap_first}Controller', ${entityCamelCase?cap_first}Controller);

    ${entityCamelCase?cap_first}Controller.$inject = ['$scope', '$state', '${entityCamelCase?cap_first}', 'AlertService', 'paginationConstants', 'pagingParams', 'FileSaver', 'hotRegisterer'];

    function ${entityCamelCase?cap_first}Controller($scope, $state, ${entityCamelCase?cap_first}, AlertService, paginationConstants, pagingParams, FileSaver, hotRegisterer) {

        var vm = this;
        var hotInstance;
        var autoRowSizePlugin;

        vm.${entityCamelCasePlural} = [];
        vm.itemsPerPage = paginationConstants.itemsPerPage;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.page = 1;
        vm.loading = false;
        vm.download = download;
        vm.refresh = refresh;

        var umbral = paginationConstants.itemsPerPage - 3;

        $scope.$on('$viewContentLoaded', function () {
            hotInstance = hotRegisterer.getInstance('${entityCamelCasePlural}Sheet');
            autoRowSizePlugin = hotInstance.getPlugin('AutoRowSize');
        });

        vm.settings = {
            columnSorting: true,
            contextMenu: true,
            search: true,
            beforeColumnSort: function (column) {
                vm.reverse = !vm.reverse;
                vm.predicate = hotInstance.getSettings().columns[column].data;
                transition();
            },
            observeChanges: true,
            manualColumnResize: true,
            sortIndicator: true,
            afterScrollVertically: loadPage,
            stretchH: 'all',
            persistenState: true,
            beforeRemoveRow: function (index) {
                var id = this.getDataAtRowProp(index, 'id');
                confirmDelete(id);
                return false;
            },
            afterChange: function (changes) {
                if (!changes) return;
                changes.forEach(function (change) {
                    var row = change[0];
                    var prop = change[1];
                    var oldVal = change[2];
                    var newVal = change[3];
                    if (oldVal !== newVal) {
                        var physicalRowNumber = hotInstance.toPhysicalRow(row);
                        var modified${entityCamelCase?cap_first} = vm.${entityCamelCasePlural}[physicalRowNumber];
                        //Replace empty string with undefined when clear a cell
                        if (newVal === "") {
                            var property = prop.substring(0, prop.indexOf("."));
                            modified${entityCamelCase?cap_first}[property] = undefined;
                        }
                        save(modified${entityCamelCase?cap_first}, physicalRowNumber);
                    }
                });
            }
        };

        loadAll();

        function sort() {
            var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
            if (vm.predicate !== 'id') {
                result.push('id');
            }
            return result;
        }

        function loadAll() {
            vm.loading = true;
            ${entityCamelCase?cap_first}.query({
                page: vm.page - 1,
                size: vm.itemsPerPage,
                sort: sort()
            }, onSuccess, onError);

            function onSuccess(data, headers) {
                vm.hasNextPage = headers('X-Has-Next-Page') === "true";

                for (var i = 0; i < data.length; i++) {
                    vm.${entityCamelCasePlural}.push(data[i]);
                }
                vm.loading = false;
            }

            function onError(error) {
                AlertService.error(error.data);
                vm.loading = false;
            }
        }

        function loadPage() {
            var page = vm.page + 1;
            if (vm.hasNextPage && !vm.loading) {
                if (autoRowSizePlugin.getLastVisibleRow() >= (hotInstance.countRows() - umbral)) {
                    vm.page = page;
                    loadAll();
                }
            }
        }

        function download() {
            ${entityCamelCase?cap_first}.download({ sort: sort() }, onSuccess, onError);
            function onSuccess(response) {
                FileSaver.saveAs(response.blob, '${entityCamelCasePlural}.xlsx');
            }
            function onError(error) {
                AlertService.error(error);
            }
        }

        function save(${entityCamelCase}, row) {
            if (${entityCamelCase}.id) {
                ${entityCamelCase?cap_first}.update(${entityCamelCase}, onSaveSuccess, onSaveError);
            } else {
                ${entityCamelCase?cap_first}.save(${entityCamelCase}, function (result) {
                    hotInstance.setDataAtRowProp(row, "id", result.id);
                }, onSaveError);
            }
        }

        function onSaveSuccess(result) {
            $scope.$emit('handsontableApp:${entityCamelCase}Update', result);
        }

        function onSaveError(error) {
            AlertService.error(error.data.message);
        }

        function confirmDelete(id) {
            $state.go('${entityCamelCasePlural}.delete', { id: id }, { reload: false });
        }

        function transition() {
            $state.transitionTo($state.$current, {
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')
            });
        }

        function refresh() {
            $state.go('${entityCamelCasePlural}', null, { reload: '${entityCamelCase}' });
        }

    }
})();
</#if>
