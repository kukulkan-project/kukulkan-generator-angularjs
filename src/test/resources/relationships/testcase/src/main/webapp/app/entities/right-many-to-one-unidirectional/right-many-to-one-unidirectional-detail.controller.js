(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneUnidirectionalDetailController', RightManyToOneUnidirectionalDetailController);

    RightManyToOneUnidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'RightManyToOneUnidirectional'];

    function RightManyToOneUnidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, RightManyToOneUnidirectional) {
        var vm = this;

        vm.rightManyToOneUnidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:rightManyToOneUnidirectionalUpdate', function(event, result) {
            vm.rightManyToOneUnidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
