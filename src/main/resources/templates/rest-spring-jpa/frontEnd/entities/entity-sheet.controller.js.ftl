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
