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
                                 constraintName="fk_${association.source.tableName[0..1]}.${association.toTargetPropertyNameUnderscore}_${association.target.tableName}"
                                 referencedColumnNames="${association.target.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.target.tableName}"/>
        	</#if>
		</#list>
        <#list notOwnerAssociations as association>
        	<#if association.type.name() == "ONE_TO_MANY">
        	<#if association.bidirectional>
        	<addForeignKeyConstraint baseColumnNames="${association.toSourcePropertyNameUnderscore}_id"
        						baseTableName="${entity.tableName}"
                                constraintName="fk_${association.source.tableName[0..1]}.${association.toSourcePropertyNameUnderscore}_${association.target.tableName}"
        	<#else>
        	<addForeignKeyConstraint baseColumnNames="${association.source.underscoreName}_id"
        						baseTableName="${entity.tableName}"
                                constraintName="fk_${association.source.tableName[0..1]}.${association.source.underscoreName}_${association.target.tableName}"		
        	</#if>
                                 referencedColumnNames="${association.source.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.source.tableName}"/>
        	</#if>
		</#list>

       <#list ownerAssociations as association>
        	<#if association.type.name() == "MANY_TO_MANY">
        	<#if association.bidirectional>
        	<addForeignKeyConstraint baseColumnNames="${association.toSourcePropertyNameUnderscore}_id"
                                 baseTableName="${association.toSourcePropertyNameUnderscore}_${association.toTargetPropertyNameUnderscore}"
                                 constraintName="fk_${association.toSourcePropertyNameUnderscore[0..1]}${association.toTargetPropertyNameUnderscore[0..1]}.${association.toTargetPropertyNameUnderscore}_${association.source.tableName}"
                                 referencedColumnNames="${association.source.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.source.tableName}"/>
        	<addForeignKeyConstraint baseColumnNames="${association.toTargetPropertyNameUnderscore}_id"
                                 baseTableName="${association.toSourcePropertyNameUnderscore}_${association.toTargetPropertyNameUnderscore}"
                                 constraintName="fk_${association.toSourcePropertyNameUnderscore[0..1]}${association.toTargetPropertyNameUnderscore[0..1]}.${association.toTargetPropertyNameUnderscore}_${association.target.tableName}"
                                 referencedColumnNames="${association.target.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.target.tableName}"/>        	
        	<#else>
        	<addForeignKeyConstraint baseColumnNames="${association.source.underscoreName}_id"
                                 baseTableName="${association.source.tableName}_${association.toTargetPropertyNameUnderscore}"
                                 constraintName="fk_${association.toSourcePropertyNameUnderscore[0..1]}${association.toTargetPropertyNameUnderscore[0..1]}.${association.toTargetPropertyNameUnderscore}_${association.source.tableName}"
                                 referencedColumnNames="${association.source.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.source.tableName}"/>
        	<addForeignKeyConstraint baseColumnNames="${association.toTargetPropertyNameUnderscore}_id"
                                 baseTableName="${association.source.tableName}_${association.toTargetPropertyNameUnderscore}"
                                 constraintName="fk_${association.toSourcePropertyNameUnderscore[0..1]}${association.toTargetPropertyNameUnderscore[0..1]}.${association.toTargetPropertyNameUnderscore}_${association.target.tableName}"
                                 referencedColumnNames="${association.target.primaryKey.physicalName.lowerCamelCase}"
                                 referencedTableName="${association.target.tableName}"/>
        	</#if>
        

        	</#if>
		</#list>

    </changeSet>
</databaseChangeLog>