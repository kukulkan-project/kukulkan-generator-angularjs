    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método GETTER fue generado para la llave primaria ${tableName}.${primaryKey.name}
     *
     * @return el valor de ${primaryKey.name}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public ${primaryKey.type} get${primaryKey.name?cap_first}() {
        return ${primaryKey.name};
    }

    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método SETTER fue generado para la llave primaria. ${tableName}.${primaryKey.name}
     *
     * @return el valor de area_conocimiento.id
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public void set${primaryKey.name?cap_first}(${primaryKey.type} ${primaryKey.name}) {
        this.${primaryKey.name} = ${primaryKey.name};
    }