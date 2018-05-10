<#list notOwnerAssociations as association>
    <#if association.bidirectional == true>
	    <#if association.type.name() == "ONE_TO_ONE">
    NOT YET SUPPORTED
    	<#elseif association.type.name() == "ONE_TO_MANY">
    	
    @ManyToOne
    private ${association.source.name} ${association.targetPropertyName};
    	</#if>
    	<#if association.type.name() == "MANY_TO_ONE">
    	
    @OneToMany(mappedBy = "${association.sourcePropertyName}")
    private Set<${association.source.name}> ${association.targetPropertyNamePlural} = new HashSet<>();
    	<#elseif association.type.name() == "MANY_TO_MANY">
    	
    @ManyToMany(mappedBy = "${association.sourcePropertyNamePlural}")
    @JsonIgnore
    private Set<${association.source.name}> ${association.targetPropertyNamePlural} = new HashSet<>();
    	</#if>    
    </#if>
</#list>