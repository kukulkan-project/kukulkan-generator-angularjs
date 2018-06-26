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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

<#if hasConstraints==true>
import javax.validation.constraints.*;
</#if>

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
/**
 * The ${entity.name}
 * 
 * @author ${author}
 *
 */
@Document(collection = "${tableName}")
public class ${entity.name} implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Este campo fue generado automaticamente por ${author} 
     * Este campo corresponde a la llave primaria ${primaryKey.name}
     *
     * @kukulkanGenerated ${timestamp}
     */
    @Id
    private ${primaryKey.type} ${primaryKey.name};
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
    <#if property.sizeValidation==true>
	    <#if property.blob==true>
    @Size(<#if property.constraint.min??>min = ${property.constraint.min}</#if><#if property.constraint.min?? && property.constraint.max??>, </#if><#if property.constraint.max??>max = ${property.constraint.max}</#if>)
	    <#else>
    @Size(<#if property.constraint.min??>min = ${property.constraint.min}</#if><#if property.constraint.min?? && property.constraint.max??>, </#if><#if property.constraint.max??>max = ${property.constraint.max}</#if>)	    
	    </#if>
    </#if>
    <#if property.constraint.pattern??>
    @Pattern(regexp = "${property.constraint.pattern}")
    </#if>
    <#if property.number==true>
    	<#if property.long==true || property.integer==true>
		    <#if property.constraint.min??>
    @Min(value = ${property.constraint.min})
		    </#if>
	    	<#if property.constraint.max??>
    @Max(value = ${property.constraint.max})
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
    @Field("${property.columnName}")
    private ${property.type} ${property.name};
	</#list>
	
    /**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity.name}() {

    }
	<#if mandatoryProperties?has_content>
	/**
     * Este constructor fue generado automáticamente por ${author}
     * 
     */
    public ${entity.name}(<#list mandatoryProperties as property>${property.type} ${property.name}<#sep>, </#sep></#list>) {
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
     * @kukulkanGenerated ${timestamp}
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
     * @kukulkanGenerated ${timestamp}
     */
    public void set${primaryKey.name?cap_first}(${primaryKey.type} ${primaryKey.name}) {
        this.${primaryKey.name} = ${primaryKey.name};
    }

	<#list properties as property>
    /**
     * Este método fue generado automaticamente por ${author} 
     * Este método GETTER fue generado para la propiedad ${tableName}.${property.columnName}
     *
     * @return el valor de ${property.name}
     *
     * @kukulkanGenerated ${timestamp}
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
     * @kukulkanGenerated ${timestamp}
     */
    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
    </#list>

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ${entity.name} entity = (${entity.name}) o;
        if (entity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    /**
     * Este método fue generado automaticamente por ${author}
     *
     * @return el valor de representado por la entidad ${entity.name}
     *
     * @kukulkanGenerated ${timestamp}
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
