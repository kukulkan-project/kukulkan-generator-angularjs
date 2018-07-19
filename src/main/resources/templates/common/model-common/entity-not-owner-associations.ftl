
<#list notOwnerAssociations as association>
    <#if association.bidirectional || association.type.name() == "ONE_TO_MANY">
	    <#if association.type.name() == "ONE_TO_ONE">
	@JsonIgnore
    @OneToOne(mappedBy = "${association.toTargetPropertyName}")
    private ${association.source.name} ${association.toSourcePropertyName};
    	<#elseif association.type.name() == "ONE_TO_MANY">
    	
    @ManyToOne
    @JoinColumn(name = "${association.toSourcePropertyNameUnderscore}_id")
    private ${association.source.name} ${association.toSourcePropertyName};
    	</#if>
    	<#if association.type.name() == "MANY_TO_ONE">
    	
    @OneToMany(mappedBy = "${association.toTargetPropertyName}")
    private Set<${association.source.name}> ${association.toSourcePropertyNamePlural} = new HashSet<>();
    	<#elseif association.type.name() == "MANY_TO_MANY">
    	
    @ManyToMany(mappedBy = "${association.toTargetPropertyNamePlural}")
    @JsonIgnore
    private Set<${association.source.name}> ${association.toSourcePropertyNamePlural} = new HashSet<>();
    
    	</#if>    
    </#if>
</#list>