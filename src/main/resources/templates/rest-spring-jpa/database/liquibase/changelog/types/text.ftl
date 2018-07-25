
            <column name="${property.columnName}" type="varchar(<#if property.constraint.max??>${property.constraint.max}<#else>255</#if>)">
                <constraints <#if property.constraint.indexed>unique="true" </#if>nullable="${property.constraint.nullable?c}" />
            </column>