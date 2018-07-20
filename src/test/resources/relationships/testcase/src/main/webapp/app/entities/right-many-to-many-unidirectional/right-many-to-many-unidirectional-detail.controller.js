(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyUnidirectionalDetailController', RightManyToManyUnidirectionalDetailController);

    RightManyToManyUnidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'RightManyToManyUnidirectional'];

    function RightManyToManyUnidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, RightManyToManyUnidirectional) {
        var vm = this;

        vm.rightManyToManyUnidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightManyToManyUnidirectionalUpdate', function(event, result) {
            vm.rightManyToManyUnidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
