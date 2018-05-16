<#list entity.fkEntityReferences as reference>
		<#if reference.autoReference == false>
        <div class="form-group">
            <label data-translate="${projectName}App.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" for="field_${reference.toTargetPropertyName}">${reference.toTargetPropertyName?cap_first}</label>
            <select class="form-control" id="field_${reference.toTargetPropertyName}" name="${reference.toTargetPropertyName}" ng-model="vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" ng-options="${reference.target.camelCaseFormat} as ${reference.target.camelCaseFormat}.id for ${reference.target.camelCaseFormat} in vm.${reference.target.camelCasePluralFormat} | orderBy:'id' track by ${reference.target.camelCaseFormat}.id">
                <option value=""></option>
            </select>
        </div>
		</#if>
</#list>