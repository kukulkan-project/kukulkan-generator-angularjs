{
    "${projectName}App": {
        "${entityCamelCase}" : {
            "home": {
                "title": "${entityCamelCasePlural}",
                "createLabel": "Create a new ${entity.name}",
                "createOrEditLabel": "Create or edit a ${entity.name}"
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
            },
           <#list properties as property>
            "${property.name}": "${property.name?cap_first}"<#sep>, </#sep>
           </#list>
        }
    }
}
