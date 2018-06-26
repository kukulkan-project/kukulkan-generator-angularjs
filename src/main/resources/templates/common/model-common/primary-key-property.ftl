    /**
     * Este campo fue generado automaticamente por ${author} 
     * Este campo corresponde a la llave primaria ${primaryKey.name}
     *
     * @kukulkanGenerated ${timestamp}
     */
    <#if primaryKey.composed == true>
    @EmbeddedId
    <#else>
    @Id
    	<#if primaryKey.generationType.name() == "SEQUENCE">
    @SequenceGenerator(name = "SEQ_${tableName}", sequenceName = "SEQ_${tableName}", allocationSize=100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_${tableName}")
    	<#elseif primaryKey.generationType.name() == "IDENTITY">
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    	<#elseif primaryKey.generationType.name() == "TABLE">
    @TableGenerator(name = "${tableName}_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_${tableName}",
    valueColumnName = "${tableName}_COUNT", pkColumnValue = "SEQ_${tableName}")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    	<#elseif primaryKey.generationType.name() == "AUTO">
    @GeneratedValue(strategy = GenerationType.AUTO)
    	</#if>
    @Column(name = "${primaryKey.name}", unique = true, nullable = false)
    </#if>
    private ${primaryKey.type} ${primaryKey.name};
    