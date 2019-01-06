{
    "${projectName}App": {
        "${entityCamelCase}" : {
            "home": {
                "title": "${entityCamelCasePlural?cap_first}",
                "createLabel": "Create a new ${entity.name}",
                "createOrEditLabel": "Create or edit a ${entity.name}",
                "search": "Search ${entity.name}"
            },
            "created": "A new ${entity.name} is created with identifier {{ param }}",
            "updated": "A ${entity.name} is updated with identifier {{ param }}",
            "deleted": "A ${entity.name} is deleted with identifier {{ param }}",
            "delete": {
                "question": "Are you sure you want to delete ${entity.name} {{ id }}?"
            },
            "detail": {
                "title": "${entity.name}"
            }<#if properties?size != 0 ||entity.connectedAdjacentReferences?size != 0>,</#if>
           <#list properties as property>
            "${property.name}": "${property.name?cap_first}"<#sep>, </#sep><#if property?is_last><#if entity.connectedAdjacentReferences?size != 0>,</#if></#if>
           </#list>
           <#list entity.connectedAdjacentReferences as reference>
		        <#if reference.autoReference == false>
            "${reference.toTargetPropertyName}": "${reference.toTargetPropertyName?cap_first}"<#sep>,</#sep>
		        </#if>
            </#list><#if entity.features.auditable>,
            "createdBy": "Created by",
            "createdDate": "Created date",
            "lastModifiedBy": "Modified by",
            "lastModifiedDate": "Modified date"
            </#if>
        }
    }
}
