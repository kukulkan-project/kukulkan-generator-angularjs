<?xml version="1.0" encoding="utf-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.5.xsd">

    <include file="config/liquibase/changelog/00000000000000_initial_schema.xml" relativeToChangelogFile="false"/>
<#list dataModelGroup as dmg>
	<#list dmg.entities as entity>
    <include file="classpath:config/liquibase/changelog/${entity.timestampString}_added_entity_${entity.name}.xml" relativeToChangelogFile="false"/>
	</#list>
	<!-- add-entities - entities added -->
	<#list dmg.entities as entity>
	<#if entity.hasEntitiesReferences>
    <include file="classpath:config/liquibase/changelog/${entity.timestampString}_added_entity_constraints_${entity.name}.xml" relativeToChangelogFile="false"/>
	</#if>
	</#list>
	<!-- add-constraints-entities - constraints to entities added -->
</#list>
</databaseChangeLog>
