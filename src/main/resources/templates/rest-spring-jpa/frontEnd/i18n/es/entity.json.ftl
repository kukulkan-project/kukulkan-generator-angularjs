{
    "${projectName}App": {
        "${entityCamelCase}" : {
            "home": {
                "title": "${entityCamelCasePlural}",
                "createLabel": "Crear nuevo ${entity.name}",
                "createOrEditLabel": "Crear o editar ${entity.name}",
                "search": "Buscar ${entity.name}"
            },
            "created": "Un nuevo ${entity.name} ha sido creado con el identificador {{ param }}",
            "updated": "Un ${entity.name} ha sido actualizado con el identificador {{ param }}",
            "deleted": "Un ${entity.name} ha sido eliminado con el identificador {{ param }}",
            "delete": {
                "question": "¿Seguro que quiere eliminar ${entity.name} {{ id }}?"
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
