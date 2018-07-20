(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightOneToManyBidirectionalDeleteController',RightOneToManyBidirectionalDeleteController);

    RightOneToManyBidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightOneToManyBidirectional'];

    function RightOneToManyBidirectionalDeleteController($uibModalInstance, entity, RightOneToManyBidirectional) {
        var vm = this;

        vm.rightOneToManyBidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightOneToManyBidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
