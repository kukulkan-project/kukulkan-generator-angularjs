(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entity.name}DetailController', ${entity.name}DetailController);

    ${entity.name}DetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', '${entity.name}'];

    function ${entity.name}DetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, ${entity.name}) {
        var vm = this;

        vm.${entityCamelCase} = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('${projectName}App:${entityCamelCase}Update', function(event, result) {
            vm.${entityCamelCase} = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
