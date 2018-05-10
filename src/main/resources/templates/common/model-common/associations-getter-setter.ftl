<#list notOwnerAssociations as association>
	<#if association.bidirectional == true>
		<#if association.type.name() == "ONE_TO_MANY" || association.type.name() == "ONE_TO_ONE" >
    public ${association.source.name} get${association.targetPropertyName?cap_first}() {
        return ${association.targetPropertyName};
    }

    public void set${association.targetPropertyName?cap_first}(${association.source.name} ${association.targetPropertyName}) {
        this.${association.targetPropertyName} = ${association.targetPropertyName};
    }
    	<#elseif association.type.name() == "MANY_TO_MANY" || association.type.name() == "MANY_TO_ONE">
    public Set<${association.source.name}> get${association.targetPropertyNamePlural?cap_first}() {
        return ${association.targetPropertyNamePlural};
    }
		<#if association.type.name() == "MANY_TO_MANY">
    public ${association.target.name} add${association.targetPropertyName?cap_first}(${association.source.name} ${association.targetPropertyName}) {
        this.${association.targetPropertyNamePlural}.add(${association.targetPropertyName});
        ${association.targetPropertyName}.get${association.sourcePropertyNamePlural?cap_first}().add(this);
        return this;
    }

    public ${association.target.name} remove${association.targetPropertyName?cap_first}(${association.source.name} ${association.targetPropertyName}) {
        this.${association.targetPropertyNamePlural}.remove(${association.targetPropertyName});
        ${association.targetPropertyName}.get${association.sourcePropertyNamePlural?cap_first}().remove(this);
        return this;
    }
		</#if>

    public void set${association.targetPropertyNamePlural?cap_first}(Set<${association.source.name}> ${association.targetPropertyNamePlural}) {
        this.${association.targetPropertyNamePlural} = ${association.targetPropertyNamePlural};
    }
    	</#if>
    </#if>
</#list>
<#list ownerAssociations as association>
	<#if association.type.name() == "ONE_TO_MANY" || association.type.name() == "MANY_TO_MANY">
    public Set<${association.target.name}> get${association.sourcePropertyNamePlural?cap_first}() {
        return ${association.sourcePropertyNamePlural};
    }

    public ${association.source.name} add${association.sourcePropertyName?cap_first}(${association.target.name} ${association.sourcePropertyName}) {
        this.${association.sourcePropertyNamePlural}.add(${association.sourcePropertyName});
        <#if association.type.name() == "ONE_TO_MANY">
        ${association.sourcePropertyName}.set${association.targetPropertyName?cap_first}(this);
        <#elseif association.type.name() == "MANY_TO_MANY">
        ${association.sourcePropertyName}.get${association.targetPropertyNamePlural?cap_first}().add(this);
        </#if>
        return this;
    }

    public ${association.source.name} remove${association.sourcePropertyName?cap_first}(${association.target.name} ${association.sourcePropertyName}) {
        this.${association.sourcePropertyNamePlural}.remove(${association.sourcePropertyName});
        <#if association.type.name() == "ONE_TO_MANY">
        ${association.sourcePropertyName}.set${association.targetPropertyName?cap_first}(null);
        <#elseif association.type.name() == "MANY_TO_MANY">
        ${association.sourcePropertyName}.get${association.targetPropertyNamePlural?cap_first}().remove(this);
        </#if>
        return this;
    }

    public void set${association.sourcePropertyNamePlural?cap_first}(Set<${association.target.name}> ${association.sourcePropertyNamePlural}) {
        this.${association.sourcePropertyNamePlural} = ${association.sourcePropertyNamePlural};
    }
    <#elseif association.type.name() == "ONE_TO_ONE" || association.type.name() == "MANY_TO_ONE">
    public ${association.target.name} get${association.sourcePropertyName?cap_first}() {
        return ${association.sourcePropertyName};
    }

    public void set${association.sourcePropertyName?cap_first}(${association.target.name} ${association.sourcePropertyName}) {
        this.${association.sourcePropertyName} = ${association.sourcePropertyName};
    }
    </#if>
</#list>