# ===================================================================
# Spring Boot configuration.
#
# This configuration will be overridden by the Spring profile you use,
# for example application-dev.yml if you use the "dev" profile.
#
# More information on profiles: http://www.jhipster.tech/profiles/
# More information on configuration properties: http://www.jhipster.tech/common-application-properties/
# ===================================================================

# ===================================================================
# Standard Spring Boot properties.
# Full reference is available at:
# http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
# ===================================================================

management:
    security:
        roles: ADMIN
    context-path: /management
    info:
        git:
            mode: full
    health:
        mail:
            enabled: false # When using the MailService, configure an SMTP server and set this to true
spring:
    application:
        name: ${project.id}
    profiles:
        # The commented value for `active` can be replaced with valid Spring profiles to load.
        # Otherwise, it will be filled in by maven when building the WAR file
        # Either way, it can be overridden by `--spring.profiles.active` value passed in the commandline or `-Dspring.profiles.active` set in `JAVA_OPTS`
        active: #spring.profiles.active#
    jackson:
        serialization.write_dates_as_timestamps: false
    jpa:
        open-in-view: false
        hibernate:
            ddl-auto: none
            naming:
                physical-strategy: org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
                implicit-strategy: org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
    messages:
        basename: i18n/messages
    mvc:
        favicon:
            enabled: false
    thymeleaf:
        mode: XHTML
security:
    basic:
        enabled: false

server:
    session:
        cookie:
            http-only: true

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
        core-pool-size: 2
        max-pool-size: 50
        queue-capacity: 10000
    # By default CORS is disabled. Uncomment to enable.
    #cors:
        #allowed-origins: "*"
        #allowed-methods: "*"
        #allowed-headers: "*"
        #exposed-headers: "Authorization,Link,X-Total-Count"
        #allow-credentials: true
        #max-age: 1800
    mail:
        from: ${project.id}@localhost
    swagger:
        default-include-pattern: /api/.*
        title: ${project.id} API
        description: ${project.id} API documentation
        version: 0.0.1
        terms-of-service-url:
        contact-name:
        contact-url:
        contact-email:
        license:
        license-url:
    ribbon:
        display-on-active-profiles: dev

# ===================================================================
# Application specific properties
# Add your own application properties here, see the ApplicationProperties class
# to have type-safe configuration, like in the JHipsterProperties above
#
# More documentation is available at:
# http://www.jhipster.tech/common-application-properties/
# ===================================================================

application:
