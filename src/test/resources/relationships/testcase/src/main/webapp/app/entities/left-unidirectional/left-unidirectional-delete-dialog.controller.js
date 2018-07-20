(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftUnidirectionalDeleteController',LeftUnidirectionalDeleteController);

    LeftUnidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'LeftUnidirectional'];

    function LeftUnidirectionalDeleteController($uibModalInstance, entity, LeftUnidirectional) {
        var vm = this;

        vm.leftUnidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            LeftUnidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
