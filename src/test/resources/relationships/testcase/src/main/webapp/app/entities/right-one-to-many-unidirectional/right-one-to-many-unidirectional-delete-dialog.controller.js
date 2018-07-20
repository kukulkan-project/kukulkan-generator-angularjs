(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyUnidirectionalDeleteController',RightOneToManyUnidirectionalDeleteController);

    RightOneToManyUnidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightOneToManyUnidirectional'];

    function RightOneToManyUnidirectionalDeleteController($uibModalInstance, entity, RightOneToManyUnidirectional) {
        var vm = this;

        vm.rightOneToManyUnidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightOneToManyUnidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
