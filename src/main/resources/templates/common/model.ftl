<#assign aDateTime = .now>
/*
 *  
 * The MIT License (MIT)
 * Copyright (c) ${year} ${author}
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
${package}

<#list imports as import>
import ${import};
</#list>
import javax.persistence.*;
<#if hasConstraints == true>
import javax.validation.constraints.*;
</#if>
<#if hasOneToMany == true || hasManyToMany == true >
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
</#if>
import java.io.Serializable;

/**
 * The ${entity}
 * 
 * @author ${author}
 *
 */
@Entity
@Table(name = "${tableNameLowerCase}")
public class ${entity} implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Este campo fue generado automaticamente por ${author} 
     * Este campo corresponde a la llave primaria ${primaryKey.name}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
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
    
	<#list ownerAssociations as association>
    <#if association.type.name() == "ONE_TO_ONE">
    @OneToOne
    @JoinColumn(unique = true)
    private ${association.target.name} ${association.sourcePropertyName};
    <#elseif association.type.name() == "ONE_TO_MANY">
    @OneToMany(mappedBy = "${association.targetPropertyName}")
    @JsonIgnore
    private List<${association.target.name}> ${association.sourcePropertyName};
    <#elseif association.type.name() == "MANY_TO_ONE">
    @ManyToOne
    private ${association.target.name} ${association.sourcePropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    @ManyToMany
    @JoinTable(name = "${association.source.tableName}_${association.target.tableName}",
               joinColumns = @JoinColumn(name="${association.source.tableName}_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="${association.target.tableName}_id", referencedColumnName="id"))
    private List<${association.target.name}> ${association.sourcePropertyName};
    </#if>
    </#list>

    <#list notOwnerAssociations as association>
    ${association.type}
    <#if association.type.name() == "ONE_TO_MANY">
    @ManyToOne
    private ${association.source.name} ${association.sourcePropertyName};
    <#elseif association.type.name() == "MANY_TO_MANY">
    @ManyToMany(mappedBy = "${association.source.sourcePropertyName}")
    @JsonIgnore
    private List<${association.target.name}> ${association.sourcePropertyName};
    </#if>    

	</#list>
	<#list properties as property>
	
    /**
     * Este campo fue generado automaticamente por ${author} 
     * Este campo corresponde a la tabla ${tableName}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
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
	
    /**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity}() {

    }
	<#if mandatoryProperties?has_content>
	/**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity}(<#list mandatoryProperties as property>${property.type} ${property.name}<#sep>, </#sep></#list>) {
    <#list mandatoryProperties as property>
        this.${property.name} = ${property.name};
    </#list>
    }
        
	</#if>
    
    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método GETTER fue generado para la llave primaria ${tableName}.${primaryKey.name}
     *
     * @return el valor de ${primaryKey.name}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public ${primaryKey.type} get${primaryKey.name?cap_first}() {
        return ${primaryKey.name};
    }

    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método SETTER fue generado para la llave primaria. ${tableName}.${primaryKey.name}
     *
     * @return el valor de area_conocimiento.id
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public void set${primaryKey.name?cap_first}(${primaryKey.type} ${primaryKey.name}) {
        this.${primaryKey.name} = ${primaryKey.name};
    }

	<#list ownerAssociations as association>
	<#if association.type.name() == "ONE_TO_MANY" || association.type.name() == "MANY_TO_MANY">
    public List<${association.target.name}> get${association.sourcePropertyName?cap_first}() {
        return ${association.sourcePropertyName};
    }

    public void set${association.sourcePropertyName?cap_first}(List<${association.target.name}> ${association.sourcePropertyName}) {
        this.${association.sourcePropertyName} = ${association.sourcePropertyName};
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
    
    <#list notOwnerAssociations as association>
	<#if association.type.name() == "ONE_TO_MANY" >
    public ${association.source.name}> get${association.targetPropertyName?cap_first}() {
        return ${association.targetPropertyName};
    }

    public void set${association.targetPropertyName?cap_first}(${association.source.name} ${association.targetPropertyName}) {
        this.${association.targetPropertyName} = ${association.targetPropertyName};
    }
    <#elseif association.type.name() == "MANY_TO_MANY">
    public List<${association.source.name}> get${association.targetPropertyName?cap_first}() {
        return ${association.targetPropertyName};
    }

    public void set${association.targetPropertyName?cap_first}(List<${association.source.name}> ${association.targetPropertyName}) {
        this.${association.targetPropertyName} = ${association.targetPropertyName};
    }
    
    </#if>
    </#list>

	<#list properties as property>
    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método GETTER fue generado para la propiedad ${tableName}.${property.columnName}
     *
     * @return el valor de ${property.name}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }

    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método SETTER fue generado para la propiedad. ${tableName}.${property.name}
     *
     * @return el valor de ${property.name?cap_first}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
    </#list>

    /**
     * Este método fue generado automaticamente por ${author}
     *
     * @return el valor de representado por la entidad ${entity}
     *
     * @kukulkanGenerated ${aDateTime?iso_utc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        <#list properties as property>
        sb.append(", ${property.name}=").append(${property.name});
        </#list>
        sb.append("]");
        return sb.toString();
    }
}
