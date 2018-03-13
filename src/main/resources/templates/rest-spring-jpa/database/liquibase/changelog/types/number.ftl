            
<#if  property.long == true>
            <column name="${property.columnName}" type="bigint">
                <constraints nullable="false" />
            </column>
<#elseif property.bigDecimal == true>
            <column name="${property.columnName}" type="decimal(10,2)">
                <constraints nullable="false" />
            </column>
<#elseif property.integer == true>
            <column name="${property.columnName}" type="integer">
                <constraints nullable="false" />
            </column>
<#elseif property.float == true>
            <column name="${property.columnName}" type="${r"${floatType}"}">
                <constraints nullable="false" />
            </column>
<#elseif property.double == true>
            <column name="${property.columnName}" type="double">
                <constraints nullable="false" />
            </column>
</#if>