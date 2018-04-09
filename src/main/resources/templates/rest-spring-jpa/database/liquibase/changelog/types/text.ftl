
            <column name="${property.columnName}" type="varchar(<#if property.constraint.max??>${property.constraint.max}<#else>255</#if>)">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>