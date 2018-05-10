<#list ownerAssociations as association>
    <#if association.type.name() == "ONE_TO_ONE">
    
    @OneToOne
    @JoinColumn(unique = true)
    private ${association.target.name} ${association.sourcePropertyName};
    <#elseif association.type.name() == "ONE_TO_MANY">
    
    @OneToMany(mappedBy = "${association.targetPropertyName}")
    @JsonIgnore
    private Set<${association.target.name}> ${association.sourcePropertyNamePlural} = new HashSet<>();
    <#elseif association.type.name() == "MANY_TO_ONE">
    
    @ManyToOne
    private ${association.target.name} ${association.sourcePropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    
    @ManyToMany
    @JoinTable(name = "${association.source.tableName}_${association.target.tableName}",
               joinColumns = @JoinColumn(name="${association.source.tableName}_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="${association.target.tableName}_id", referencedColumnName="id"))
    private Set<${association.target.name}> ${association.sourcePropertyNamePlural} = new HashSet<>();
    </#if>
</#list>