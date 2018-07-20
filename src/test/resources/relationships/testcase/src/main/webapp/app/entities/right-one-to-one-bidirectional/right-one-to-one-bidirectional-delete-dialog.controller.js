(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToOneBidirectionalDeleteController',RightOneToOneBidirectionalDeleteController);

    RightOneToOneBidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightOneToOneBidirectional'];

    function RightOneToOneBidirectionalDeleteController($uibModalInstance, entity, RightOneToOneBidirectional) {
        var vm = this;

        vm.rightOneToOneBidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightOneToOneBidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
