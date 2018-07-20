(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneBidirectionalDetailController', RightManyToOneBidirectionalDetailController);

    RightManyToOneBidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftBidirectional', 'RightManyToOneBidirectional'];

    function RightManyToOneBidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftBidirectional, RightManyToOneBidirectional) {
        var vm = this;

        vm.rightManyToOneBidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightManyToOneBidirectionalUpdate', function(event, result) {
            vm.rightManyToOneBidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
