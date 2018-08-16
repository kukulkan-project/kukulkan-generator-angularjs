<#include "/common/licences/mit.ftl">

${package}

<#list imports as import>
import ${import};
</#list>
import javax.persistence.*;
<#if hasConstraints == true>
import javax.validation.constraints.*;
</#if><#if entity.features.sheetable>
import mx.infotec.dads.kukulkan.tables.handsontable.annotations.Sheet;
import mx.infotec.dads.kukulkan.tables.handsontable.annotations.SheetColumn;
</#if>
import java.util.Objects;
import java.io.Serializable;

/**
 * The ${entity.name}
 * 
 * @author ${author}
 *
 */
<#if entity.features.sheetable>
@Sheet
</#if>
@Entity
@Table(name = "${tableNameLowerCase}")
public class ${entity.name} implements Serializable {

    private static final long serialVersionUID = 1L;
    
    <#include "/common/model-common/primary-key-property.ftl">
    <#include "/common/model-common/properties.ftl">
	<#include "/common/model-common/entity-owner-associations.ftl">
    <#include "/common/model-common/entity-not-owner-associations.ftl">	
    <#include "/common/model-common/primary-key-getter-setter.ftl">
    <#include "/common/model-common/properties-getter-setter.ftl">
    <#include "/common/model-common/properties-mandatories.ftl">
    <#include "/common/model-common/associations-getter-setter.ftl">
    <#include "/common/model-common/equals-method.ftl">
    <#include "/common/model-common/hashcode-method.ftl">
    <#include "/common/model-common/tostring-method.ftl">

}
