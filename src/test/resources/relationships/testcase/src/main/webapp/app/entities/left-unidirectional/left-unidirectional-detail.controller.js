(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftUnidirectionalDetailController', LeftUnidirectionalDetailController);

    LeftUnidirectionalDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LeftUnidirectional', 'RightManyToManyUnidirectional', 'RightManyToOneUnidirectional', 'RightOneToManyUnidirectional', 'RightOneToOneUnidirectional'];

    function LeftUnidirectionalDetailController($scope, $rootScope, $stateParams, previousState, entity, LeftUnidirectional, RightManyToManyUnidirectional, RightManyToOneUnidirectional, RightOneToManyUnidirectional, RightOneToOneUnidirectional) {
        var vm = this;

        vm.leftUnidirectional = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('testcaseApp:leftUnidirectionalUpdate', function(event, result) {
            vm.leftUnidirectional = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
