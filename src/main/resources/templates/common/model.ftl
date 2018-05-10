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

import java.util.Objects;
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
    
    <#include "/common/model-common/primary-key-property.ftl">
    <#include "/common/model-common/properties.ftl">
	<#include "/common/model-common/entity-owner-associations.ftl">
    <#include "/common/model-common/entity-not-owner-associations.ftl">	
    <#include "/common/model-common/primary-key-property.ftl">
    <#include "/common/model-common/properties-mandatories.ftl">
    <#include "/common/model-common/associations-getter-setter.ftl">
    <#include "/common/model-common/properties-getter-setter.ftl">
    <#include "/common/model-common/equals-method.ftl">
    <#include "/common/model-common/hashcode-method.ftl">
    <#include "/common/model-common/tostring-method.ftl">
}
