<#list entity.entityReferences as reference>
                    <th jh-sort-by="${reference.propertyName}.id"><span data-translate="${projectName}App.${reference.source.camelCaseFormat}.${reference.propertyName}">${reference.propertyName?cap_first}</span> <span class="glyphicon glyphicon-sort"></span></th>
</#list>