	<#list properties as property>
	
    /**
     * Este campo fue generado automaticamente por ${author} 
     * Este campo corresponde a la tabla ${tableName}
     *
     * @kukulkanGenerated ${timestamp}
     */
    <#if property.constraint.nullable==false>
    @NotNull
    </#if> 
    <#if property.literal==true || property.blob==true || property.clob==true>
    	<#if property.sizeValidation==true>
    @Size(<#if property.constraint.min??>min = ${property.constraint.min}</#if><#if property.constraint.min?? && property.constraint.max??>, </#if><#if property.constraint.max??>max = ${property.constraint.max}</#if>)
	    </#if>
	<#elseif property.number==true>
    	<#if property.long==true || property.integer==true>
		    <#if property.constraint.min??>
    @Min(value = ${property.constraint.min}<#if property.long==true>L</#if>)
		    </#if>
	    	<#if property.constraint.max??>
    @Max(value = ${property.constraint.max}<#if property.long==true>L</#if>)
    		</#if>
    	<#else>
    		<#if property.constraint.min??>
    @DecimalMin(value = "${property.constraint.min}")
    		</#if>
    		<#if property.constraint.max??>
    @DecimalMax(value = "${property.constraint.max}")
    		</#if>
    	</#if>	
    </#if> 
    <#if property.blob==true || property.clob==true>
    @Lob
    @Basic(fetch = FetchType.LAZY)
    </#if> 
    @Column(name = "${property.columnName}"<#if property.literal==true && property.constraint.max??>, length=${property.constraint.max}</#if><#if property.bigDecimal==true>, precision=10, scale=2</#if><#if property.constraint.indexed==true>, unique=true</#if><#if property.constraint.nullable==false>, nullable = false</#if>)
    private ${property.type} ${property.name};
    
	</#list>