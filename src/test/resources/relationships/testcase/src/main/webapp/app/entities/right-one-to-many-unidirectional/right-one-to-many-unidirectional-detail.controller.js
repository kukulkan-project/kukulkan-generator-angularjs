(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyUnidirectionalDetailController', RightOneToManyUnidirectionalDetailController);

    RightOneToManyUnidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftUnidirectional', 'RightOneToManyUnidirectional'];

    function RightOneToManyUnidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftUnidirectional, RightOneToManyUnidirectional) {
        var vm = this;

        vm.rightOneToManyUnidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightOneToManyUnidirectionalUpdate', function(event, result) {
            vm.rightOneToManyUnidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
