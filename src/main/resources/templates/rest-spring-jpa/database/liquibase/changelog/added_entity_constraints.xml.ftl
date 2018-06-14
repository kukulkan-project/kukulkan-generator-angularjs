<?xml version="1.0" encoding="utf-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.4.xsd">
    <!--
        Added the constraints for entity ${entity.name}.
    -->
    <changeSet id="${entity.timestampString}-2" author="${author}">
       <#list ownerAssociations as association>
        	<#if association.type.name() == "ONE_TO_ONE" || association.type.name() == "MANY_TO_ONE">
        <addForeignKeyConstraint baseColumnNames="${association.toTargetPropertyNameUnderscore}_id"
                                 baseTableName="${entity.tableName}"
                                 constraintName="fk_${association.source.tableName}_${association.target.tableName}_id"
                                 referencedColumnNames="id"
                                 referencedTableName="${association.target.tableName}"/>
        	</#if>
		</#list>
        <#list notOwnerAssociations as association>
        	<#if association.type.name() == "ONE_TO_MANY">
        <addForeignKeyConstraint baseColumnNames="${association.source.name?lower_case}_id"
                                 baseTableName="${entity.tableName}"
                                 constraintName="fk_${association.source.tableName}_${association.target.tableName}_id"
                                 referencedColumnNames="id"
                                 referencedTableName="${association.source.tableName}"/>
        	</#if>
		</#list>

       <#list ownerAssociations as association>
        	<#if association.type.name() == "MANY_TO_MANY">
        <addForeignKeyConstraint baseColumnNames="${association.source.name?lower_case}_id"
                                 baseTableName="${association.associationName}"
                                 constraintName="fk_${association.associationName}_${association.source.tableName}_id"
                                 referencedColumnNames="id"
                                 referencedTableName="${association.source.tableName}"/>
        <addForeignKeyConstraint baseColumnNames="${association.target.name?lower_case}_id"
                                 baseTableName="${association.associationName}"
                                 constraintName="fk_${association.associationName}_${association.target.tableName}_id"
                                 referencedColumnNames="id"
                                 referencedTableName="${association.target.tableName}"/>

        	</#if>
		</#list>

    </changeSet>
</databaseChangeLog>
