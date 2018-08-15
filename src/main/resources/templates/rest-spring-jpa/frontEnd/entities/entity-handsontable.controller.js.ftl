(function () {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entityCamelCase?cap_first}SheetController', ${entityCamelCase?cap_first}SheetController);

    ${entityCamelCase?cap_first}SheetController.$inject = ['$scope', 'hotRegisterer', '${entityCamelCase?cap_first}Sheet', 'AlertService', 'paginationConstants'];

    function ${entityCamelCase?cap_first}SheetController($scope, hotRegisterer, ${entityCamelCase?cap_first}Sheet, AlertService, paginationConstants) {
        
        var vm = this;
        
        var hotInstance;
        var autoRowSizePlugin;
        var nearLastRowsCount = 3;
        vm.data = [];
        vm.itemsPerPage = paginationConstants.itemsPerPage;
        vm.page = 0;
        vm.loading = false;

        vm.settings = {
            rowHeaders: true,
            colHeaders: true
        }

        function loadPage() {
            if (vm.hasNextPage && !vm.loading) {
                if (autoRowSizePlugin.getLastVisibleRow() >= (hotInstance.countRows() - nearLastRowsCount)) {
                    vm.page++;
                    loadAll();
                }
            }
        }

        $scope.$on('$viewContentLoaded', function () {
            hotInstance = hotRegisterer.getInstance('${entityHyphenNotation}-handsontable');
            autoRowSizePlugin = hotInstance.getPlugin('AutoRowSize');
            loadAll();
        });

        function overwriteSettings() {
            vm.settings.height = 450;
            vm.settings.stretchH = 'all';
            vm.settings.afterScrollVertically = loadPage;
            vm.settings.maxRows = vm.data.length;
        }

        function loadAll() {
            vm.loading = true;
            ${entityCamelCase?cap_first}Sheet.query({
                page: vm.page,
                size: vm.itemsPerPage
            }, onSuccess, onError);
            function onSuccess(settings, headers) {
                vm.hasNextPage = headers('X-Has-Next-Page') === "true";
                vm.settings = settings;
                overwriteSettings();

                for (var i = 0; i < settings.data.length; i++) {
                    vm.data.push(settings.data[i]);
                }
                vm.settings.data = vm.data;
                hotInstance.updateSettings(vm.settings);
                vm.loading = false;
            }
            function onError(error) {
                AlertService.error(error.data);
                vm.loading = false;
            }
        }
    }
})();
