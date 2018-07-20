(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('LeftBidirectionalDeleteController',LeftBidirectionalDeleteController);

    LeftBidirectionalDeleteController.$inject = ['$uibModalInstance', 'entity', 'LeftBidirectional'];

    function LeftBidirectionalDeleteController($uibModalInstance, entity, LeftBidirectional) {
        var vm = this;

        vm.leftBidirectional = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            LeftBidirectional.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
