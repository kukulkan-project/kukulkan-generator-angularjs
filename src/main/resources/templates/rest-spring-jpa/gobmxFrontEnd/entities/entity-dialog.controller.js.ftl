(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .controller('${entity.name}DialogController', ${entity.name}DialogController);

    ${entity.name}DialogController.$inject = ['$timeout', '$scope', '$uibModalInstance',<#if hasBlobProperties == true> 'DataUtils',</#if> 'entity'<#list entity.referenceTypes as types>, '${types.target.name}'</#list>];

    function ${entity.name}DialogController ($timeout, $scope, $uibModalInstance,<#if hasBlobProperties == true> DataUtils,</#if> entity<#list entity.referenceTypes as types>, ${types.target.name}</#list>) {
        var vm = this;

        vm.${entityCamelCase} = entity;
        vm.clear = clear;
        <#if hasTimeProperties == true>
        vm.onChangeDate = onChangeDate;
        vm.onChangeDate();
        </#if>
        <#if hasBlobProperties == true>
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        </#if>
        vm.save = save;
        <#if hasTimeProperties == true>
        	<#list properties as property>
        	<#if property.time == true> 
        vm.${entityCamelCase}.${property.name} = new Date(new Date).toISOString().split("T")[0];
            </#if>
        	</#list>
        </#if>
        <#if hasTimeProperties == true>
        function onChangeDate () {
        	<#list properties as property>
        	<#if property.time == true> 
        	$('#${property.name}').datepicker({
                 dateFormat: "yy-mm-dd",
                 changeYear: true
             }).datepicker("show");
            </#if>
        	</#list>
        }
        </#if>
		<#list entity.referenceTypes as reference>
		<#if reference.autoReference == false>
		<#if reference.associationType.name() == "ONE_TO_ONE">
        vm.${reference.toTargetPropertyNamePlural} = ${reference.target.name}.query({filter: '${entity.camelCaseFormat}-is-null'});
        $q.all([vm.${entity.camelCaseFormat}.$promise, vm.${reference.toTargetPropertyNamePlural}.$promise]).then(function() {
            if (!vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName} || !vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName}.id) {
                return $q.reject();
            }
            return ${reference.target.name}.get({id : vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName}.id}).$promise;
        }).then(function(${reference.toTargetPropertyName}) {
            vm.${reference.toTargetPropertyNamePlural}.push(${reference.toTargetPropertyName});
        });
        <#elseif reference.associationType.name() == "MANY_TO_ONE">
        vm.${reference.target.camelCasePluralFormat} = ${reference.target.name}.query();
        <#else>
        vm.${reference.target.camelCasePluralFormat} = ${reference.target.name}.query();
		</#if>
		</#if>
		</#list>
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.${entityCamelCase}.id !== null) {
                ${entity.name}.update(vm.${entityCamelCase}, onSaveSuccess, onSaveError);
            } else {
                ${entity.name}.save(vm.${entityCamelCase}, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('${projectName}App:${entityCamelCase}Update', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        <#if hasBlobProperties == true>
        	<#list properties as property>
        	<#if property.blob == true> 
        vm.set${property.name?cap_first} = function ($file, ${entityCamelCase}) {
        	<#if property.imageBlob == true>
            if ($file && $file.$error === 'pattern') {
                return;
            }
			</#if>
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        ${entityCamelCase}.${property.name} = base64Data;
                        ${entityCamelCase}.${property.name}ContentType = $file.type;
                    });
                });
            }
        };
            </#if>
        	</#list>
        </#if>
    }
})();
