<?xml version="1.0" encoding="utf-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.5.xsd
                        http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd">

    <property name="now" value="now()" dbms="h2"/>

    <property name="now" value="now()" dbms="mysql"/>
    <property name="autoIncrement" value="true"/>

    <property name="floatType" value="float4" dbms="postgresql, h2"/>
    <property name="floatType" value="float" dbms="mysql, oracle, mssql"/>
<#list dataModelGroup as dmg>
	<#list dmg.entities as entity>
    <!--
        Added the entity ${entity.name}.
    -->
    <changeSet id="${timestamp}-${entity?index+1}" author="kukulkan">
        <createTable tableName="${entity.name}">
            <column name="id" type="bigint" autoIncrement="${r"${autoIncrement}"}">
                <constraints primaryKey="true" nullable="false"/>
            </column>
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

        </createTable>
        <dropDefaultValue tableName="persona" columnName="fecha_zone_date_time" columnDataType="datetime"/>
        <dropDefaultValue tableName="persona" columnName="instante" columnDataType="datetime"/>
        
    </changeSet>
	</#list>    
</#list>
</databaseChangeLog>
