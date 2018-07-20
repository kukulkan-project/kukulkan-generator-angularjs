(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyBidirectionalDetailController', RightOneToManyBidirectionalDetailController);

    RightOneToManyBidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftBidirectional', 'RightOneToManyBidirectional'];

    function RightOneToManyBidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftBidirectional, RightOneToManyBidirectional) {
        var vm = this;

        vm.rightOneToManyBidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightOneToManyBidirectionalUpdate', function(event, result) {
            vm.rightOneToManyBidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
