{
    "${projectName}App": {
        "${entityCamelCase}" : {
            "home": {
                "title": "${entityCamelCasePlural?cap_first}",
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
            }<#if properties?size != 0 ||entity.connectedAdjacentReferences?size != 0>,</#if>
           <#list properties as property>
            "${property.name}": "${property.name?cap_first}"<#sep>, </#sep><#if property?is_last><#if entity.connectedAdjacentReferences?size != 0>,</#if></#if>
           </#list>
           <#list entity.connectedAdjacentReferences as reference>
		        <#if reference.autoReference == false>
            "${reference.toTargetPropertyName}": "${reference.toTargetPropertyName?cap_first}"<#sep>,</#sep>
		        </#if>
            </#list><#if entity.features.auditable>,
            "createdBy": "Creado por",
            "createdDate": "Fecha de creación",
            "lastModifiedBy": "Modificado por",
            "lastModifiedDate": "Fecha de modificación"
            </#if>
        }
    }
}
