<?xml version="1.0" encoding="UTF-8"?>

<configuration scan="true">
    <include resource="org/springframework/boot/logging/logback/base.xml"/>

<!-- The FILE and ASYNC appenders are here as examples for a production configuration -->
<!--
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>logFile.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>90</maxHistory>
        </rollingPolicy>
        <encoder>
            <charset>utf-8</charset>
            <Pattern>%d %-5level [%thread] %logger{0}: %msg%n</Pattern>
        </encoder>
    </appender>

    <appender name="ASYNC" class="ch.qos.logback.classic.AsyncAppender">
        <queueSize>512</queueSize>
        <appender-ref ref="FILE"/>
    </appender>
-->

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

    <!-- https://logback.qos.ch/manual/configuration.html#shutdownHook and https://jira.qos.ch/browse/LOGBACK-1090 -->
    <shutdownHook class="ch.qos.logback.core.hook.DelayingShutdownHook"/>

    <contextListener class="ch.qos.logback.classic.jul.LevelChangePropagator">
        <resetJUL>true</resetJUL>
    </contextListener>

</configuration>
