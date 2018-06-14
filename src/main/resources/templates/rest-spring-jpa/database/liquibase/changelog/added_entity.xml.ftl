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

    <!--
        Added the entity ${entity.name}.
    -->
    <changeSet id="${entity.timestampString}-1" author="${author}">
        <createTable tableName="${tableName}">
            <column name="id" type="bigint" autoIncrement="${r"${autoIncrement}"}">
                <constraints primaryKey="true" nullable="false"/>
            </column>
        <#list properties as property>
        	<#if property.name?ends_with("ContentType") == false>
	        	<#if  property.blob == true>
					<#include "/rest-spring-jpa/database/liquibase/changelog/types/blob.ftl">
		    	<#elseif property.time == true>
		        	<#include "/rest-spring-jpa/database/liquibase/changelog/types/datetime.ftl">
				<#elseif property.boolean == true>
					<#include "/rest-spring-jpa/database/liquibase/changelog/types/boolean.ftl">
				<#elseif property.literal == true>
					<#if  property.clob == true>
						<#include "/rest-spring-jpa/database/liquibase/changelog/types/textblob.ftl">
			    	<#else>
			    		<#include "/rest-spring-jpa/database/liquibase/changelog/types/text.ftl">
			    	</#if>
			    <#elseif property.number == true>
					<#include "/rest-spring-jpa/database/liquibase/changelog/types/number.ftl">
		    	</#if>
        	</#if>
		</#list>
		
		<#list ownerAssociations as association>
        	<#if association.type.name() == "ONE_TO_ONE">
        	<column name="${association.toTargetPropertyNameUnderscore}_id" type="bigint">
                <constraints unique="true" nullable="true" />
            </column>
            <#elseif association.type.name() == "MANY_TO_ONE">
            <column name="${association.toTargetPropertyNameUnderscore}_id" type="bigint">
                <constraints <#if association.type.name() == "ONE_TO_ONE">unique="true" </#if>nullable="true" />
            </column>
        	</#if>        	
        	
		</#list>
		<#list notOwnerAssociations as association>
        	<#if association.type.name() == "ONE_TO_MANY">
            <column name="${association.toSourcePropertyNameUnderscore}_id" type="bigint">
                <constraints nullable="true" />
            </column>
        	</#if>
		</#list>
        </createTable>
		<#list ownerAssociations as association>
        	<#if association.type.name() == "MANY_TO_MANY">
        <createTable tableName="${association.source.tableName}_${association.target.tableName}">
            <column name="${association.source.underscoreName}_id" type="bigint">
                <constraints nullable="false"/>
            </column>
            <column name="${association.target.underscoreName}_id" type="bigint">
                <constraints nullable="false"/>
            </column>
        </createTable>

        <addPrimaryKey columnNames="${association.source.underscoreName}_id, ${association.target.underscoreName}_id" tableName="${association.source.tableName}_${association.target.tableName}"/>
        	</#if>
		</#list>
		<#list properties as property>
        	<#if property.zoneDateTime == true || property.instant == true>
        <dropDefaultValue tableName="${entity.tableName}" columnName="${property.columnName}" columnDataType="datetime"/>
        	</#if>
		</#list>

    </changeSet>
</databaseChangeLog>
