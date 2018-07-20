(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftBidirectionalDetailController', LeftBidirectionalDetailController);

    LeftBidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftBidirectional', 'RightManyToManyBidirectional', 'RightManyToOneBidirectional', 'RightOneToManyBidirectional', 'RightOneToOneBidirectional'];

    function LeftBidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftBidirectional, RightManyToManyBidirectional, RightManyToOneBidirectional, RightOneToManyBidirectional, RightOneToOneBidirectional) {
        var vm = this;

        vm.leftBidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:leftBidirectionalUpdate', function(event, result) {
            vm.leftBidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
