(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToOneBidirectionalDeleteController',RightManyToOneBidirectionalDeleteController);

    RightManyToOneBidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightManyToOneBidirectional'];

    function RightManyToOneBidirectionalDeleteController($uibModalInstance, entity, RightManyToOneBidirectional) {
        var vm = this;

        vm.rightManyToOneBidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightManyToOneBidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
