
            <column name="nombre" type="varchar(50)">
                <constraints nullable="false" />
            </column>

            <column name="edad" type="integer">
                <constraints nullable="false" />
            </column>

            <column name="numero_credencial" type="bigint">
                <constraints nullable="false" />
            </column>

            <column name="sueldo" type="decimal(10,2)">
                <constraints nullable="false" />
            </column>

            <column name="impuesto" type="${r"${floatType}"}">
                <constraints nullable="false" />
            </column>

            <column name="impuesto_detalle" type="double">
                <constraints nullable="false" />
            </column>

            <column name="activo" type="bit">
                <constraints nullable="false" />
            </column>

            <column name="fecha_local_date" type="date">
                <constraints nullable="false" />
            </column>

            <column name="fecha_zone_date_time" type="timestamp">
                <constraints nullable="false" />
            </column>

            <column name="imagen" type="longblob">
                <constraints nullable="false" />
            </column>
            <column name="imagen_content_type" type="varchar(255)">
                <constraints nullable="false" />
            </column>

            <column name="imagen_any_blob" type="longblob">
                <constraints nullable="false" />
            </column>
            <column name="imagen_any_blob_content_type" type="varchar(255)">
                <constraints nullable="false" />
            </column>

            <column name="imagen_blob" type="longblob">
                <constraints nullable="false" />
            </column>
            <column name="imagen_blob_content_type" type="varchar(255)">
                <constraints nullable="false" />
            </column>

            <column name="jhi_desc" type="clob">
                <constraints nullable="false" />
            </column>

            <column name="instante" type="timestamp">
                <constraints nullable="false" />
            </column>