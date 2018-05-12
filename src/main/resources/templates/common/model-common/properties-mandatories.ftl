<#if mandatoryProperties?has_content>
    
    /**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity.name}() {

    }
    
	/**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity.name}(<#list mandatoryProperties as property>${property.type} ${property.name}<#sep>, </#sep></#list>) {
    <#list mandatoryProperties as property>
        this.${property.name} = ${property.name};
    </#list>
    }
        
</#if>