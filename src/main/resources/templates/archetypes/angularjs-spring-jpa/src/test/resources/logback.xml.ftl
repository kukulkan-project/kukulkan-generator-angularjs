<?xml version="1.0" encoding="UTF-8"?>

<configuration scan="true">
    <include resource="org/springframework/boot/logging/logback/base.xml"/>

    <logger name="${project.packaging}" level="INFO"/>

    <logger name="io.github.jhipster" level="WARN"/>

    <logger name="javax.activation" level="WARN"/>
    <logger name="javax.mail" level="WARN"/>
    <logger name="javax.xml.bind" level="WARN"/>
    <logger name="ch.qos.logback" level="WARN"/>
    <logger name="com.codahale.metrics" level="WARN"/>
    <logger name="com.ryantenney" level="WARN"/>
    <logger name="com.sun" level="WARN"/>
    <logger name="com.zaxxer" level="WARN"/>
    <logger name="io.undertow" level="WARN"/>
    <logger name="io.undertow.websockets.jsr" level="ERROR"/>
    <logger name="org.ehcache" level="WARN"/>
    <logger name="org.apache" level="WARN"/>
    <logger name="org.apache.catalina.startup.DigesterFactory" level="OFF"/>
    <logger name="org.bson" level="WARN"/>
    <logger name="org.hibernate.validator" level="WARN"/>
    <logger name="org.hibernate" level="WARN"/>
    <logger name="org.hibernate.ejb.HibernatePersistence" level="OFF"/>
    <logger name="org.springframework" level="WARN"/>
    <logger name="org.springframework.web" level="WARN"/>
    <logger name="org.springframework.security" level="WARN"/>
    <logger name="org.springframework.cache" level="WARN"/>
    <logger name="org.thymeleaf" level="WARN"/>
    <logger name="org.xnio" level="WARN"/>
    <logger name="springfox" level="WARN"/>
    <logger name="sun.rmi" level="WARN"/>
    <logger name="liquibase" level="WARN"/>
    <logger name="LiquibaseSchemaResolver" level="INFO"/>
    <logger name="sun.rmi.transport" level="WARN"/>

    <root level="WARN">
        <appender-ref ref="CONSOLE"/>
    </root>

</configuration>
