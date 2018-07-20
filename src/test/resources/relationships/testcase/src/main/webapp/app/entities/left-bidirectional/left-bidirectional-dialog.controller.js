(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftBidirectionalDialogController', LeftBidirectionalDialogController);

    LeftBidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftBidirectional', 'RightManyToManyBidirectional', 'RightManyToOneBidirectional', 'RightOneToManyBidirectional', 'RightOneToOneBidirectional'];

    function LeftBidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftBidirectional, RightManyToManyBidirectional, RightManyToOneBidirectional, RightOneToManyBidirectional, RightOneToOneBidirectional) {
        var vm = this;

        vm.leftBidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        vm.recursiveChildOneToOneBidirectional = LeftBidirectional.query({filter: 'leftBidirectional-is-null'});
        $q.all([vm.leftBidirectional.$promise, vm.recursiveChildOneToOneBidirectional.$promise]).then(function() {
            if (!vm.leftBidirectional.recursiveChildOneToOneBidirectional || !vm.leftBidirectional.recursiveChildOneToOneBidirectional.id) {
                return $q.reject();
            }
            return LeftBidirectional.get({id : vm.leftBidirectional.recursiveChildOneToOneBidirectional.id}).$promise;
        }).then(function(recursiveChildOneToOneBidirectional) {
            vm.recursiveChildOneToOneBidirectional.push(recursiveChildOneToOneBidirectional);
        });
        vm.rightManyToManyBidirectional = RightManyToManyBidirectional.query();
        vm.rightManyToOneBidirectional = RightManyToOneBidirectional.query();
        vm.rightOneToManyBidirectional = RightOneToManyBidirectional.query();
        vm.rightOneToOneBidirectional = RightOneToOneBidirectional.query({filter: 'leftBidirectional-is-null'});
        $q.all([vm.leftBidirectional.$promise, vm.rightOneToOneBidirectional.$promise]).then(function() {
            if (!vm.leftBidirectional.rightOneToOneBidirectional || !vm.leftBidirectional.rightOneToOneBidirectional.id) {
                return $q.reject();
            }
            return RightOneToOneBidirectional.get({id : vm.leftBidirectional.rightOneToOneBidirectional.id}).$promise;
        }).then(function(rightOneToOneBidirectional) {
            vm.rightOneToOneBidirectional.push(rightOneToOneBidirectional);
        });
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.leftBidirectional.id !== null) {
                LeftBidirectional.update(vm.leftBidirectional, onSaveSuccess, onSaveError);
            } else {
                LeftBidirectional.save(vm.leftBidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:leftBidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
