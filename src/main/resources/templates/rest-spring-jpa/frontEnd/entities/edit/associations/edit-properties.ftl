<#list entity.fkEntityReferences as reference>
		<#if reference.autoReference == false>
        	<#if reference.associationType.name() != "MANY_TO_MANY">
        <div class="form-group">
            <label data-translate="${projectName}App.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" for="field_${reference.toTargetPropertyName}">${reference.toTargetPropertyName?cap_first}</label>
            <select class="form-control" id="field_${reference.toTargetPropertyName}" name="${reference.toTargetPropertyName}" ng-model="vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" ng-options="${reference.target.camelCaseFormat} as ${reference.target.camelCaseFormat}.${reference.target.displayField.name} for ${reference.target.camelCaseFormat} in <#if reference.associationType.name() == "ONE_TO_ONE">vm.${reference.toTargetPropertyNamePlural} | orderBy:'id' <#else>vm.${reference.target.camelCasePluralFormat} </#if>track by ${reference.target.camelCaseFormat}.id">
                <option value=""></option>
            </select>
        </div>
        	<#else>
        <div class="form-group">
            <label data-translate="${projectName}App.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" for="field_${reference.toTargetPropertyName}">${reference.toTargetPropertyName?cap_first}</label>
            <select class="form-control" id="field_${reference.toTargetPropertyName}" multiple name="${reference.toTargetPropertyName}" ng-model="vm.${entity.camelCaseFormat}.${reference.toTargetPropertyNamePlural}" ng-options="${reference.target.camelCaseFormat} as ${reference.target.camelCaseFormat}.${reference.target.displayField.name} for ${reference.target.camelCaseFormat} in vm.${reference.target.camelCasePluralFormat} track by ${reference.target.camelCaseFormat}.id"></select>
        </div>
        	</#if>
		</#if>
</#list>