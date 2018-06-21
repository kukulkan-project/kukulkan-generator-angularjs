<#list notOwnerAssociations as association>
	<#if association.bidirectional || association.type.name() == "ONE_TO_MANY">
		<#if association.type.name() == "ONE_TO_MANY" || association.type.name() == "ONE_TO_ONE" >
    public ${association.source.name} get${association.toSourcePropertyName?cap_first}() {
        return ${association.toSourcePropertyName};
    }

    public void set${association.toSourcePropertyName?cap_first}(${association.source.name} ${association.toSourcePropertyName}) {
        this.${association.toSourcePropertyName} = ${association.toSourcePropertyName};
    }
    	<#elseif association.type.name() == "MANY_TO_MANY" || association.type.name() == "MANY_TO_ONE">
    public Set<${association.source.name}> get${association.toSourcePropertyNamePlural?cap_first}() {
        return ${association.toSourcePropertyNamePlural};
    }
    
    public ${association.target.name} add${association.toSourcePropertyName?cap_first}(${association.source.name} ${association.toSourcePropertyName}) {
        this.${association.toSourcePropertyNamePlural}.add(${association.toSourcePropertyName});
        <#if association.type.name() == "MANY_TO_ONE">
        ${association.toSourcePropertyName}.set${association.toTargetPropertyNamePlural?cap_first}(this);
        <#elseif association.type.name() == "MANY_TO_MANY">
        ${association.toSourcePropertyName}.get${association.toTargetPropertyNamePlural?cap_first}().add(this);
        </#if>
        return this;
    }

    public ${association.target.name} remove${association.toSourcePropertyName?cap_first}(${association.source.name} ${association.toSourcePropertyName}) {
        this.${association.toSourcePropertyNamePlural}.remove(${association.toSourcePropertyName});
        <#if association.type.name() == "MANY_TO_ONE">
        ${association.toSourcePropertyName}.set${association.toTargetPropertyNamePlural?cap_first}(null);
        <#elseif association.type.name() == "MANY_TO_MANY">
        ${association.toSourcePropertyName}.get${association.toTargetPropertyNamePlural?cap_first}().remove(this);
        </#if> 
        return this;
    }

    public void set${association.toSourcePropertyNamePlural?cap_first}(Set<${association.source.name}> ${association.toSourcePropertyNamePlural}) {
        this.${association.toSourcePropertyNamePlural} = ${association.toSourcePropertyNamePlural};
    }
    	</#if>
    </#if>
</#list>
<#list ownerAssociations as association>
	<#if association.type.name() == "ONE_TO_MANY" || association.type.name() == "MANY_TO_MANY">
    public Set<${association.target.name}> get${association.toTargetPropertyNamePlural?cap_first}() {
        return ${association.toTargetPropertyNamePlural};
    }

    public ${association.source.name} add${association.toTargetPropertyName?cap_first}(${association.target.name} ${association.toTargetPropertyName}) {
        this.${association.toTargetPropertyNamePlural}.add(${association.toTargetPropertyName});
        <#if association.type.name() == "ONE_TO_MANY">
        ${association.toTargetPropertyName}.set${association.toSourcePropertyName?cap_first}(this);
        <#elseif association.type.name() == "MANY_TO_MANY" && association.bidirectional>
        ${association.toTargetPropertyName}.get${association.toSourcePropertyNamePlural?cap_first}().add(this);
        </#if>
        return this;
    }

    public ${association.source.name} remove${association.toTargetPropertyName?cap_first}(${association.target.name} ${association.toTargetPropertyName}) {
        this.${association.toTargetPropertyNamePlural}.remove(${association.toTargetPropertyName});
        <#if association.type.name() == "ONE_TO_MANY">
        ${association.toTargetPropertyName}.set${association.toSourcePropertyName?cap_first}(null);
        <#elseif association.type.name() == "MANY_TO_MANY" && association.bidirectional>
        ${association.toTargetPropertyName}.get${association.toSourcePropertyNamePlural?cap_first}().remove(this);
        </#if>
        return this;
    }

    public void set${association.toTargetPropertyNamePlural?cap_first}(Set<${association.target.name}> ${association.toTargetPropertyNamePlural}) {
        this.${association.toTargetPropertyNamePlural} = ${association.toTargetPropertyNamePlural};
    }
    <#elseif association.type.name() == "ONE_TO_ONE" || association.type.name() == "MANY_TO_ONE">
    public ${association.target.name} get${association.toTargetPropertyName?cap_first}() {
        return ${association.toTargetPropertyName};
    }

    public void set${association.toTargetPropertyName?cap_first}(${association.target.name} ${association.toTargetPropertyName}) {
        this.${association.toTargetPropertyName} = ${association.toTargetPropertyName};
    }
    </#if>
</#list>