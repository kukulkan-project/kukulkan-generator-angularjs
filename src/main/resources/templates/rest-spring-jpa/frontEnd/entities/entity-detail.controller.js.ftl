(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entity.name}DetailController', ${entity.name}DetailController);

    ${entity.name}DetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState',<#if hasBlobProperties == true> 'DataUtils',</#if> 'entity', '${entity.name}'<#list entity.referenceTypes as type>, '${type}'</#list>];

    function ${entity.name}DetailController($scope, $rootScope, $stateParams, previousState,<#if hasBlobProperties == true> DataUtils,</#if> entity, ${entity.name}<#list entity.referenceTypes as type>, ${type}</#list>) {
        var vm = this;

        vm.${entityCamelCase} = entity;
        vm.previousState = previousState.name;
        <#if hasBlobProperties == true>
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;
        </#if>

        var unsubscribe = $rootScope.$on('${projectName}App:${entityCamelCase}Update', function(event, result) {
            vm.${entityCamelCase} = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
