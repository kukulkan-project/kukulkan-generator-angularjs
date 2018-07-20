(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneUnidirectionalDeleteController',RightOneToOneUnidirectionalDeleteController);

    RightOneToOneUnidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightOneToOneUnidirectional'];

    function RightOneToOneUnidirectionalDeleteController($uibModalInstance, entity, RightOneToOneUnidirectional) {
        var vm = this;

        vm.rightOneToOneUnidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightOneToOneUnidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
