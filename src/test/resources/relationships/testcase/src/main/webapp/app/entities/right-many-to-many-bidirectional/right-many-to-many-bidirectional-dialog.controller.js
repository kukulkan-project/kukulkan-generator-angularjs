(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyBidirectionalDialogController', RightManyToManyBidirectionalDialogController);

    RightManyToManyBidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftBidirectional', 'RightManyToManyBidirectional'];

    function RightManyToManyBidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftBidirectional, RightManyToManyBidirectional) {
        var vm = this;

        vm.rightManyToManyBidirectional = entity;
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
            if (vm.rightManyToManyBidirectional.id !== null) {
                RightManyToManyBidirectional.update(vm.rightManyToManyBidirectional, onSaveSuccess, onSaveError);
            } else {
                RightManyToManyBidirectional.save(vm.rightManyToManyBidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightManyToManyBidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
