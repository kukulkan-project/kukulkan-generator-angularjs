(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneBidirectionalDetailController', RightOneToOneBidirectionalDetailController);

    RightOneToOneBidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftBidirectional', 'RightOneToOneBidirectional'];

    function RightOneToOneBidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftBidirectional, RightOneToOneBidirectional) {
        var vm = this;

        vm.rightOneToOneBidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightOneToOneBidirectionalUpdate', function(event, result) {
            vm.rightOneToOneBidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
