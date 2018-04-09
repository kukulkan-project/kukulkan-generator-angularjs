
<#if  property.long == true>
            <column name="${property.columnName}" type="bigint">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>
<#elseif property.bigDecimal == true>
            <column name="${property.columnName}" type="decimal(10,2)">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>
<#elseif property.integer == true>
            <column name="${property.columnName}" type="integer">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>
<#elseif property.float == true>
            <column name="${property.columnName}" type="${r"${floatType}"}">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>
<#elseif property.double == true>
            <column name="${property.columnName}" type="double">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>
</#if>