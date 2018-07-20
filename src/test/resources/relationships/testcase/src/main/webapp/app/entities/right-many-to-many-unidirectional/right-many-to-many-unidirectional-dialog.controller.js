(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyUnidirectionalDialogController', RightManyToManyUnidirectionalDialogController);

    RightManyToManyUnidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'RightManyToManyUnidirectional'];

    function RightManyToManyUnidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, RightManyToManyUnidirectional) {
        var vm = this;

        vm.rightManyToManyUnidirectional = entity;
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
            if (vm.rightManyToManyUnidirectional.id !== null) {
                RightManyToManyUnidirectional.update(vm.rightManyToManyUnidirectional, onSaveSuccess, onSaveError);
            } else {
                RightManyToManyUnidirectional.save(vm.rightManyToManyUnidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightManyToManyUnidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
