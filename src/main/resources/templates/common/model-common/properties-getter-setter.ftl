	<#list properties as property>
    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método GETTER fue generado para la propiedad ${tableName}.${property.columnName}
     *
     * @return el valor de ${property.name}
     *
     * @kukulkanGenerated ${timestamp}
     */
    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método SETTER fue generado para la propiedad. ${tableName}.${property.name}
     *
     * @return el valor de ${property.name?cap_first}
     *
     * @kukulkanGenerated ${timestamp}
     */
    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
    </#list>