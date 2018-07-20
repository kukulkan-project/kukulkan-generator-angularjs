(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyUnidirectionalDialogController', RightOneToManyUnidirectionalDialogController);

    RightOneToManyUnidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftUnidirectional', 'RightOneToManyUnidirectional'];

    function RightOneToManyUnidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftUnidirectional, RightOneToManyUnidirectional) {
        var vm = this;

        vm.rightOneToManyUnidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        vm.leftUnidirectional = LeftUnidirectional.query();
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.rightOneToManyUnidirectional.id !== null) {
                RightOneToManyUnidirectional.update(vm.rightOneToManyUnidirectional, onSaveSuccess, onSaveError);
            } else {
                RightOneToManyUnidirectional.save(vm.rightOneToManyUnidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightOneToManyUnidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
