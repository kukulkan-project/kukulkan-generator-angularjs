<#list ownerAssociations as association>
    <#if association.type.name() == "ONE_TO_ONE">
    
    @OneToOne
    @JoinColumn(name = "${association.toTargetPropertyNameUnderscore}_id", unique = true)
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "ONE_TO_MANY">
    
    @OneToMany(mappedBy = "${association.toSourcePropertyNameUnderscore}")
    @JsonIgnore
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    <#elseif association.type.name() == "MANY_TO_ONE">
    
    @ManyToOne
    private ${association.target.name} ${association.toTargetPropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    
    @ManyToMany
    @JoinTable(name = "${association.associationName}",
               joinColumns = @JoinColumn(name="${association.toSourcePropertyNameUnderscore}_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="${association.toTargetPropertyNameUnderscore}_id", referencedColumnName="id"))
    private Set<${association.target.name}> ${association.toTargetPropertyNamePlural} = new HashSet<>();
    </#if>
</#list>