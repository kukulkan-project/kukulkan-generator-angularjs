# ===================================================================
# Spring Boot configuration.
#
# This configuration is used for unit/integration tests.
#
# More information on profiles: http://www.jhipster.tech/profiles/
# More information on configuration properties: http://www.jhipster.tech/common-application-properties/
# ===================================================================

# ===================================================================
# Standard Spring Boot properties.
# Full reference is available at:
# http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
# ===================================================================


spring:
    application:
        name: ${project.id}
    jackson:
        serialization.write_dates_as_timestamps: false
    cache:
        type: simple
    datasource:
        type: com.zaxxer.hikari.HikariDataSource
        url: jdbc:h2:mem:${project.id};DB_CLOSE_DELAY=-1
        name:
        username:
        password:
    jpa:
        database-platform: io.github.jhipster.domain.util.FixedH2Dialect
        database: H2
        open-in-view: false
        show-sql: false
        hibernate:
            ddl-auto: none
            naming:
                physical-strategy: org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
                implicit-strategy: org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
        properties:
            hibernate.id.new_generator_mappings: true
            hibernate.cache.use_second_level_cache: false
            hibernate.cache.use_query_cache: false
            hibernate.generate_statistics: true
            hibernate.hbm2ddl.auto: validate
    mail:
        host: localhost
    messages:
        basename: i18n/messages
    mvc:
        favicon:
            enabled: false
    thymeleaf:
        mode: XHTML

liquibase:
    contexts: test

server:
    port: 10344
    address: localhost

info:
    project:
        version: #project.version#

# ===================================================================
# JHipster specific properties
#
# Full reference is available at: http://www.jhipster.tech/common-application-properties/
# ===================================================================

jhipster:
    async:
        core-pool-size: 1
        max-pool-size: 50
        queue-capacity: 10000
    # To test logstash appender
    logging:
        logstash:
            enabled: true
            host: localhost
            port: 5000
            queue-size: 512
    mail:
        from: test@localhost
        base-url: http://127.0.0.1:8080
    security:
        authentication:
            jwt:
                secret: b811449f6c0926263c7d47deef1df9edc3f734f8
                # Token is valid 24 hours
                token-validity-in-seconds: 86400
    metrics: # DropWizard Metrics configuration, used by MetricsConfiguration
        jmx.enabled: true
        logs: # Reports Dropwizard metrics in the logs
            enabled: true
            report-frequency: 60 # in seconds

# ===================================================================
# Application specific properties
# Add your own application properties here, see the ApplicationProperties class
# to have type-safe configuration, like in the JHipsterProperties above
#
# More documentation is available at:
# http://www.jhipster.tech/common-application-properties/
# ===================================================================

application: