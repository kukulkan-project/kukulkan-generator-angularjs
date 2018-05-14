<#list entity.referenceType as association>
	<#if association.type.></#>
                    <th jh-sort-by="${entity.id}"><span data-translate="${translateKey}.${property.name}">${property.name?cap_first}</span> <span class="glyphicon glyphicon-sort"></span></th>
</#list>
<#list entity.notOwnerAssociations as entity>
                    <th jh-sort-by="${entity.id}"><span data-translate="${translateKey}.${property.name}">${property.name?cap_first}</span> <span class="glyphicon glyphicon-sort"></span></th>
</#list>