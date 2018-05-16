<#list entity.fkEntityReferences as reference>
		<#if reference.autoReference == false>
        <div class="form-group">
            <label data-translate="${projectName}App.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" for="field_${reference.toTargetPropertyName}">${reference.toTargetPropertyName?cap_first}</label>
            <select class="form-control" id="field_${reference.toTargetPropertyName}" <#if reference.associationType.name() == "MANY_TO_MANY">multiple </#if>name="${reference.toTargetPropertyName}" ng-model="vm.${entity.camelCaseFormat}.${reference.toTargetPropertyName}" ng-options="${reference.target.camelCaseFormat} as ${reference.target.camelCaseFormat}.id for ${reference.target.camelCaseFormat} in vm.${reference.target.camelCasePluralFormat} <#if reference.associationType.name() == "ONE_TO_ONE">| orderBy:'id' </#if>track by ${reference.target.camelCaseFormat}.id">
                <#if reference.associationType.name() != "MANY_TO_MANY">
                <option value=""></option>
                </#if>
            </select>
        </div>
		</#if>
</#list>