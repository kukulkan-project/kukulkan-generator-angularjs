(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyUnidirectionalDeleteController',RightManyToManyUnidirectionalDeleteController);

    RightManyToManyUnidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightManyToManyUnidirectional'];

    function RightManyToManyUnidirectionalDeleteController($uibModalInstance, entity, RightManyToManyUnidirectional) {
        var vm = this;

        vm.rightManyToManyUnidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightManyToManyUnidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
