<#list entity.entityReferences as reference>
<#if reference.type.name() != "MANY_TO_MANY">
                    <td>
                        <a ui-sref="${reference.target.camelCaseFormat}-detail({id:${entityCamelCase}.${reference.propertyName}.id})">{{${entityCamelCase}.${reference.propertyName}.id}}</a>
                    </td>
</#if>
</#list>