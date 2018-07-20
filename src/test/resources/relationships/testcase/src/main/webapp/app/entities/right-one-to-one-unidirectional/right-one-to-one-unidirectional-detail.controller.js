(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneUnidirectionalDetailController', RightOneToOneUnidirectionalDetailController);

    RightOneToOneUnidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'RightOneToOneUnidirectional'];

    function RightOneToOneUnidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, RightOneToOneUnidirectional) {
        var vm = this;

        vm.rightOneToOneUnidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightOneToOneUnidirectionalUpdate', function(event, result) {
            vm.rightOneToOneUnidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
