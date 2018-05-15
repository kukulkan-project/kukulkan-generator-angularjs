<#list entity.entityReferences as reference>
                    <td>
                        <a ui-sref="${reference.target.camelCaseFormat}-detail({id:${entityCamelCase}.${reference.propertyName}.id})">{{${entityCamelCase}.${reference.propertyName}.id}}</a>
                    </td>
</#list>