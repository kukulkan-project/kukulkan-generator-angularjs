(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneBidirectionalDialogController', RightManyToOneBidirectionalDialogController);

    RightManyToOneBidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftBidirectional', 'RightManyToOneBidirectional'];

    function RightManyToOneBidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftBidirectional, RightManyToOneBidirectional) {
        var vm = this;

        vm.rightManyToOneBidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        vm.leftBidirectional = LeftBidirectional.query();
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.rightManyToOneBidirectional.id !== null) {
                RightManyToOneBidirectional.update(vm.rightManyToOneBidirectional, onSaveSuccess, onSaveError);
            } else {
                RightManyToOneBidirectional.save(vm.rightManyToOneBidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightManyToOneBidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
