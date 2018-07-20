(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneUnidirectionalDialogController', RightManyToOneUnidirectionalDialogController);

    RightManyToOneUnidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'RightManyToOneUnidirectional'];

    function RightManyToOneUnidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, RightManyToOneUnidirectional) {
        var vm = this;

        vm.rightManyToOneUnidirectional = entity;
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
            if (vm.rightManyToOneUnidirectional.id !== null) {
                RightManyToOneUnidirectional.update(vm.rightManyToOneUnidirectional, onSaveSuccess, onSaveError);
            } else {
                RightManyToOneUnidirectional.save(vm.rightManyToOneUnidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightManyToOneUnidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
