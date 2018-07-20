(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneBidirectionalDialogController', RightOneToOneBidirectionalDialogController);

    RightOneToOneBidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftBidirectional', 'RightOneToOneBidirectional'];

    function RightOneToOneBidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftBidirectional, RightOneToOneBidirectional) {
        var vm = this;

        vm.rightOneToOneBidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        vm.leftOneToOneBidirectional = LeftBidirectional.query({filter: 'rightOneToOneBidirectional-is-null'});
        $q.all([vm.rightOneToOneBidirectional.$promise, vm.leftOneToOneBidirectional.$promise]).then(function() {
            if (!vm.rightOneToOneBidirectional.leftOneToOneBidirectional || !vm.rightOneToOneBidirectional.leftOneToOneBidirectional.id) {
                return $q.reject();
            }
            return LeftBidirectional.get({id : vm.rightOneToOneBidirectional.leftOneToOneBidirectional.id}).$promise;
        }).then(function(leftOneToOneBidirectional) {
            vm.leftOneToOneBidirectional.push(leftOneToOneBidirectional);
        });
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.rightOneToOneBidirectional.id !== null) {
                RightOneToOneBidirectional.update(vm.rightOneToOneBidirectional, onSaveSuccess, onSaveError);
            } else {
                RightOneToOneBidirectional.save(vm.rightOneToOneBidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:rightOneToOneBidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
