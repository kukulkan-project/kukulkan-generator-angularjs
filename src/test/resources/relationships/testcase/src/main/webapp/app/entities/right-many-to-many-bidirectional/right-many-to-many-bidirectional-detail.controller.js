(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyBidirectionalDetailController', RightManyToManyBidirectionalDetailController);

    RightManyToManyBidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftBidirectional', 'RightManyToManyBidirectional'];

    function RightManyToManyBidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftBidirectional, RightManyToManyBidirectional) {
        var vm = this;

        vm.rightManyToManyBidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightManyToManyBidirectionalUpdate', function(event, result) {
            vm.rightManyToManyBidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
