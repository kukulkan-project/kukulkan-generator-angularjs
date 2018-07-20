(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftUnidirectionalDialogController', LeftUnidirectionalDialogController);

    LeftUnidirectionalDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'LeftUnidirectional', 'RightManyToManyUnidirectional', 'RightManyToOneUnidirectional', 'RightOneToManyUnidirectional', 'RightOneToOneUnidirectional'];

    function LeftUnidirectionalDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, LeftUnidirectional, RightManyToManyUnidirectional, RightManyToOneUnidirectional, RightOneToManyUnidirectional, RightOneToOneUnidirectional) {
        var vm = this;

        vm.leftUnidirectional = entity;
        vm.clear = clear;
        vm.save = save;
        vm.recursiveChildOneToOneUnidirectional = LeftUnidirectional.query({filter: 'leftUnidirectional-is-null'});
        $q.all([vm.leftUnidirectional.$promise, vm.recursiveChildOneToOneUnidirectional.$promise]).then(function() {
            if (!vm.leftUnidirectional.recursiveChildOneToOneUnidirectional || !vm.leftUnidirectional.recursiveChildOneToOneUnidirectional.id) {
                return $q.reject();
            }
            return LeftUnidirectional.get({id : vm.leftUnidirectional.recursiveChildOneToOneUnidirectional.id}).$promise;
        }).then(function(recursiveChildOneToOneUnidirectional) {
            vm.recursiveChildOneToOneUnidirectional.push(recursiveChildOneToOneUnidirectional);
        });
        vm.rightManyToManyUnidirectional = RightManyToManyUnidirectional.query();
        vm.rightManyToOneUnidirectional = RightManyToOneUnidirectional.query();
        vm.rightOneToManyUnidirectional = RightOneToManyUnidirectional.query();
        vm.oneToOneUnidirectional = RightOneToOneUnidirectional.query({filter: 'leftUnidirectional-is-null'});
        $q.all([vm.leftUnidirectional.$promise, vm.oneToOneUnidirectional.$promise]).then(function() {
            if (!vm.leftUnidirectional.oneToOneUnidirectional || !vm.leftUnidirectional.oneToOneUnidirectional.id) {
                return $q.reject();
            }
            return RightOneToOneUnidirectional.get({id : vm.leftUnidirectional.oneToOneUnidirectional.id}).$promise;
        }).then(function(oneToOneUnidirectional) {
            vm.oneToOneUnidirectional.push(oneToOneUnidirectional);
        });
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.leftUnidirectional.id !== null) {
                LeftUnidirectional.update(vm.leftUnidirectional, onSaveSuccess, onSaveError);
            } else {
                LeftUnidirectional.save(vm.leftUnidirectional, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('testcaseApp:leftUnidirectionalUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
