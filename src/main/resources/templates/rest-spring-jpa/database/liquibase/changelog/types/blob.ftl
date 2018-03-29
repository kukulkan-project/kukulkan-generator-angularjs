
            <column name="${property.columnName}" type="longblob">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>

            <column name="${property.columnName}_content_type" type="varchar(255)">
                <constraints nullable="${property.constraint.nullable?c}" />
            </column>