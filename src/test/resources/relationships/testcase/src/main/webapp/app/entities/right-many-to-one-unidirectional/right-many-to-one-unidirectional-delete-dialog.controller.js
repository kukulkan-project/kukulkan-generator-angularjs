(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneUnidirectionalDeleteController',RightManyToOneUnidirectionalDeleteController);

    RightManyToOneUnidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightManyToOneUnidirectional'];

    function RightManyToOneUnidirectionalDeleteController($uibModalInstance, entity, RightManyToOneUnidirectional) {
        var vm = this;

        vm.rightManyToOneUnidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightManyToOneUnidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
