(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyBidirectionalDialogController', RightOneToManyBidirectionalDialogController);

    RightOneToManyBidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftBidirectional', 'RightOneToManyBidirectional'];

    function RightOneToManyBidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftBidirectional, RightOneToManyBidirectional) {
        var vm = this;

        vm.rightOneToManyBidirectional = entity;
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
            if (vm.rightOneToManyBidirectional.id !== null) {
                RightOneToManyBidirectional.update(vm.rightOneToManyBidirectional, onSaveSuccess, onSaveError);
            } else {
                RightOneToManyBidirectional.save(vm.rightOneToManyBidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightOneToManyBidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
