(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('RightManyToManyBidirectionalDeleteController',RightManyToManyBidirectionalDeleteController);

    RightManyToManyBidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'RightManyToManyBidirectional'];

    function RightManyToManyBidirectionalDeleteController($uibModalInstance, entity, RightManyToManyBidirectional) {
        var vm = this;

        vm.rightManyToManyBidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RightManyToManyBidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
