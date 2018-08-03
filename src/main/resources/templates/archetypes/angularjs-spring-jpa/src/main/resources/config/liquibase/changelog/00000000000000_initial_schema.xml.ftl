<?xml version="1.0" encoding="utf-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.5.xsd
                        http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd">

    <property name="now" value="now()" dbms="h2"/>
<#if project.targetDatabase.databaseType.name() == "SQL_MYSQL">
    <property name="now" value="now()" dbms="mysql"/>
    <property name="autoIncrement" value="true"/>
<#elseif project.targetDatabase.databaseType.name() == "SQL_ORACLE">
    <property name="now" value="sysdate" dbms="oracle"/>

    <changeSet id="00000000000000" author="core">
        <createSequence sequenceName="hibernate_sequence" startValue="1000" incrementBy="50"/>
    </changeSet>
</#if>

    <changeSet id="00000000000001" author="core">
        <createTable tableName="core_user">
            <column name="id" type="bigint" autoIncrement="${r"${autoIncrement}"}">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="login" type="varchar(50)">
                <constraints unique="true" nullable="false" uniqueConstraintName="ux_user_login"/>
            </column>
            <column name="password_hash" type="varchar(60)"/>
            <column name="first_name" type="varchar(50)"/>
            <column name="last_name" type="varchar(50)"/>
            <column name="email" type="varchar(100)">
                <constraints unique="true" nullable="true" uniqueConstraintName="ux_user_email"/>
            </column>
            <column name="image_url" type="varchar(256)"/>
            <column name="activated" type="boolean" valueBoolean="false">
                <constraints nullable="false" />
            </column>
            <column name="lang_key" type="varchar(6)"/>
            <column name="activation_key" type="varchar(20)"/>
            <column name="reset_key" type="varchar(20)"/>
            <column name="created_by" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
            <column name="created_date" type="timestamp" defaultValueDate="${r"${now}"}">
                <constraints nullable="false"/>
            </column>
            <column name="reset_date" type="timestamp">
                <constraints nullable="true"/>
            </column>
            <column name="last_modified_by" type="varchar(50)"/>
            <column name="last_modified_date" type="timestamp"/>
        </createTable>
        <createIndex indexName="idx_user_login"
            tableName="core_user"
            unique="true">
            <column name="login" type="varchar(50)"/>
        </createIndex>

        <createIndex indexName="idx_user_email"
            tableName="core_user"
            unique="true">
            <column name="email" type="varchar(100)"/>
        </createIndex>
        <createTable tableName="core_authority">
            <column name="name" type="varchar(50)">
                <constraints primaryKey="true" nullable="false"/>
            </column>
        </createTable>

        <createTable tableName="core_user_authority">
            <column name="user_id" type="bigint">
                <constraints nullable="false"/>
            </column>
            <column name="authority_name" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
        </createTable>

        <addPrimaryKey columnNames="user_id, authority_name" tableName="core_user_authority"/>

        <addForeignKeyConstraint baseColumnNames="authority_name"
                                 baseTableName="core_user_authority"
                                 constraintName="fk_authority_name"
                                 referencedColumnNames="name"
                                 referencedTableName="core_authority"/>
        <addForeignKeyConstraint baseColumnNames="user_id"
                                 baseTableName="core_user_authority"
                                 constraintName="fk_user_id"
                                 referencedColumnNames="id"
                                 referencedTableName="core_user"/>
        <loadData encoding="UTF-8"
                  file="config/liquibase/users.csv"
                  separator=";"
                  tableName="core_user">
            <column name="activated" type="boolean"/>
            <column name="created_date" type="timestamp"/>
        </loadData>
        <dropDefaultValue tableName="core_user" columnName="created_date" columnDataType="datetime"/>
        <loadData encoding="UTF-8"
                  file="config/liquibase/authorities.csv"
                  separator=";"
                  tableName="core_authority"/>

        <loadData encoding="UTF-8"
                  file="config/liquibase/users_authorities.csv"
                  separator=";"
                  tableName="core_user_authority"/>
        <createTable tableName="core_persistent_audit_event">
            <column name="event_id" type="bigint" autoIncrement="${r"${autoIncrement}"}">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="principal" type="varchar(50)">
                <constraints nullable="false" />
            </column>
            <column name="event_date" type="timestamp"/>
            <column name="event_type" type="varchar(255)"/>
        </createTable>

        <createTable tableName="core_persistent_audit_evt_data">
            <column name="event_id" type="bigint">
                <constraints nullable="false"/>
            </column>
            <column name="name" type="varchar(150)">
                <constraints nullable="false"/>
            </column>
            <column name="value" type="varchar(255)"/>
        </createTable>
        <addPrimaryKey columnNames="event_id, name" tableName="core_persistent_audit_evt_data"/>

        <createIndex indexName="idx_persistent_audit_event"
                     tableName="core_persistent_audit_event"
                     unique="false">
            <column name="principal" type="varchar(50)"/>
            <column name="event_date" type="timestamp"/>
        </createIndex>

        <createIndex indexName="idx_persistent_audit_evt_data"
                     tableName="core_persistent_audit_evt_data"
                     unique="false">
            <column name="event_id" type="bigint"/>
        </createIndex>

        <addForeignKeyConstraint baseColumnNames="event_id"
                                 baseTableName="core_persistent_audit_evt_data"
                                 constraintName="fk_evt_pers_audit_evt_data"
                                 referencedColumnNames="event_id"
                                 referencedTableName="core_persistent_audit_event"/>
    </changeSet>
</databaseChangeLog>
