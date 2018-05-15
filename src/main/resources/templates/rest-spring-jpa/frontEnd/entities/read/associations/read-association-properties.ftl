<#list entity.entityReferences as reference>
<#if reference.type.name() == "MANY_TO_MANY">
        <dt><span data-translate="${projectName}App.${entityCamelCase}.${reference.propertyName}">${reference.propertyName?cap_first}</span></dt>
        <dd>
            <span ng-repeat="${reference.propertyName} in vm.${entityCamelCase}.${reference.propertyNamePlural}">
                <a ui-sref="${reference.target.camelCaseFormat}-detail({id: ${reference.propertyName}.id})">{{${reference.propertyName}.id}}</a>{{$last ? '' : ', '}}
            </span>
        </dd>
<#else>
        <dt><span data-translate="${projectName}App.${entityCamelCase}.${reference.propertyName}">${reference.propertyName?cap_first}</span></dt>
        <dd>
            <a ui-sref="${reference.target.camelCaseFormat}-detail({id:vm.${entityCamelCase}.${reference.propertyName}.id})">{{vm.${entityCamelCase}.${reference.propertyName}.id}}</a>
        </dd>
</#if>
</#list>