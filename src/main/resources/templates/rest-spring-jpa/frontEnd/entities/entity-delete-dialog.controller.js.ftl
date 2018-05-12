(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entity.name}DeleteController',${entity.name}DeleteController);

    ${entity.name}DeleteController.$inject = ['$uibModalInstance', 'entity', '${entity.name}'];

    function ${entity.name}DeleteController($uibModalInstance, entity, ${entity.name}) {
        var vm = this;

        vm.${entityCamelCase} = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ${entity.name}.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
