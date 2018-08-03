version: '2'
services:
    ${project.id}-app:
        image: ${project.id}
        environment:
            - SPRING_PROFILES_ACTIVE=prod,swagger
            <#if project.targetDatabase.databaseType.name() == "SQL_MYSQL">
            - SPRING_DATASOURCE_URL=jdbc:mysql://${project.id}-mysql:3306/${project.id}?useUnicode=true&characterEncoding=utf8&useSSL=false
            <#elseif project.targetDatabase.databaseType.name() == "SQL_ORACLE">
            - SPRING_DATASOURCE_URL=jdbc:oracle:thin:@${project.id}-oracle:1521:${project.id}
            </#if>
            - APP_SLEEP=10 # gives time for the database to boot before the application
        ports:
            - 8080:8080
<#if project.targetDatabase.databaseType.name() == "SQL_MYSQL">
    ${project.id}-mysql:
        extends:
            file: mysql.yml
            service: ${project.id}-mysql
<#elseif project.targetDatabase.databaseType.name() == "SQL_ORACLE">
    ${project.id}-oracle:
        extends:
            file: oracle.yml
            service: ${project.id}-oracle
</#if>
