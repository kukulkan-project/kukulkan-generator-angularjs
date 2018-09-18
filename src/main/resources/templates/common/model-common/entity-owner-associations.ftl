<#list ownerAssociations as association>
    <#if association.type.name() == "ONE_TO_ONE">
    
    @OneToOne
    @JoinColumn(name = "${association.toTargetReferencePhysicalName}", unique = true)
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "ONE_TO_MANY">
    
    @OneToMany(mappedBy = "${association.toSourcePropertyName}")
    @JsonIgnore
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    <#elseif association.type.name() == "MANY_TO_ONE">
    
    @ManyToOne
    @JoinColumn(name = "${association.toTargetReferencePhysicalName}")
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    <#if association.bidirectional>
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "${association.toSourcePropertyNameUnderscore}_${association.toTargetPropertyNameUnderscore}",
               joinColumns = @JoinColumn(name="${association.toSourceReferencePhysicalName}", referencedColumnName="${association.source.primaryKey.physicalName.snakeCasePlural}"),
               inverseJoinColumns = @JoinColumn(name="${association.toTargetReferencePhysicalName}", referencedColumnName="${association.target.primaryKey.physicalName.snakeCasePlural}"))
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    <#else>
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "${association.source.tableName}_${association.toTargetPropertyNameUnderscore}",
               joinColumns = @JoinColumn(name="${association.source.referencePhysicalName}", referencedColumnName="${association.source.primaryKey.physicalName.snakeCasePlural}"),
               inverseJoinColumns = @JoinColumn(name="${association.toTargetReferencePhysicalName}", referencedColumnName="${association.target.primaryKey.physicalName.snakeCasePlural}"))
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    </#if>
    </#if>
</#list>