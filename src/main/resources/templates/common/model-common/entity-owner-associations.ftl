<#list ownerAssociations as association>
    <#if association.type.name() == "ONE_TO_ONE">
    
    @OneToOne
    @JoinColumn(name = "${association.toTargetPropertyNameUnderscore}_id", unique = true)
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "ONE_TO_MANY">
    
    @OneToMany(mappedBy = "${association.toSourcePropertyName}")
    @JsonIgnore
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    <#elseif association.type.name() == "MANY_TO_ONE">
    
    @ManyToOne
    @JoinColumn(name = "${association.toTargetPropertyNameUnderscore}_id")
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    <#if association.bidirectional>
    
    @ManyToMany
    @JoinTable(name = "${association.toSourcePropertyNameUnderscore}_${association.toTargetPropertyNameUnderscore}",
               joinColumns = @JoinColumn(name="${association.toSourcePropertyNameUnderscore}_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="${association.toTargetPropertyNameUnderscore}_id", referencedColumnName="id"))
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    <#else>
    
    @ManyToMany
    @JoinTable(name = "${association.source.tableName}_${association.toTargetPropertyNameUnderscore}",
               joinColumns = @JoinColumn(name="${association.source.underscoreName}_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="${association.toTargetPropertyNameUnderscore}_id", referencedColumnName="id"))
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    </#if>
    </#if>
</#list>