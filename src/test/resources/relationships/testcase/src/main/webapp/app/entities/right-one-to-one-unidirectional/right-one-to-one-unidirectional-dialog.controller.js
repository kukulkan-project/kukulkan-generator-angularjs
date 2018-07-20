(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneUnidirectionalDialogController', RightOneToOneUnidirectionalDialogController);

    RightOneToOneUnidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'RightOneToOneUnidirectional'];

    function RightOneToOneUnidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, RightOneToOneUnidirectional) {
        var vm = this;

        vm.rightOneToOneUnidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.rightOneToOneUnidirectional.id !== null) {
                RightOneToOneUnidirectional.update(vm.rightOneToOneUnidirectional, onSaveSuccess, onSaveError);
            } else {
                RightOneToOneUnidirectional.save(vm.rightOneToOneUnidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightOneToOneUnidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
