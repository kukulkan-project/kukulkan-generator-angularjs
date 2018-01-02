# ===================================================================
# Spring Boot configuration for the "prod" profile.
#
# This configuration overrides the application.yml file.
#
# ===================================================================

# ===================================================================
# Standard Spring Boot properties.
# Full reference is available at:
# http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
# ===================================================================

logging:
    level:
        ROOT: INFO
        ${project.packaging}: INFO
        io.github.jhipster: INFO

spring:
    devtools:
        restart:
            enabled: false
        livereload:
            enabled: false
    data:
        mongodb:
            uri: mongodb://localhost:27017
            database: ${project.id}
    mail:
        host: localhost
        port: 25
        username:
        password:
    thymeleaf:
        cache: true

# ===================================================================
# To enable SSL, generate a certificate using:
# keytool -genkey -alias ${project.id} -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
#
# You can also use Let's Encrypt:
# https://maximilian-boehm.com/hp2121/Create-a-Java-Keystore-JKS-from-Let-s-Encrypt-Certificates.htm
#
# Then, modify the server.ssl properties so your "server" configuration looks like:
#
# server:
#    port: 443
#    ssl:
#        key-store: keystore.p12
#        key-store-password: <your-password>
#        key-store-type: PKCS12
#        key-alias: ${project.id}
# ===================================================================
server:
    port: 8080
    compression:
        enabled: true
        mime-types: text/html,text/xml,text/plain,text/css, application/javascript, application/json
        min-response-size: 1024

# ===================================================================
# JHipster specific properties
#
# ===================================================================

jhipster:
    http:
        version: V_1_1 # To use HTTP/2 you will need SSL support (see above the "server.ssl" configuration)
        cache: # Used by the CachingHttpHeadersFilter
            timeToLiveInDays: 1461
    cache: # Cache configuration
        ehcache: # Ehcache configuration
            time-to-live-seconds: 3600 # By default objects stay 1 hour in the cache
            max-entries: 1000 # Number of objects in each cache entry
    security:
        authentication:
            jwt:
                secret: 5c2a02df170aeae66115c8082849762c2e3de115
                # Token is valid 24 hours
                token-validity-in-seconds: 86400
                token-validity-in-seconds-for-remember-me: 2592000
    mail: # specific JHipster mail property, for standard properties see MailProperties
        from: ${project.id}@localhost
        base-url: http://my-server-url-to-change # Modify according to your server's URL
    metrics: # DropWizard Metrics configuration, used by MetricsConfiguration
        jmx.enabled: true
        graphite:
            enabled: false
            host: localhost
            port: 2003
            prefix: ${project.id}
        prometheus:
            enabled: false
            endpoint: /prometheusMetrics
        logs: # Reports Dropwizard metrics in the logs
            enabled: false
            report-frequency: 60 # in seconds
    logging:
        logstash: # Forward logs to logstash over a socket, used by LoggingConfiguration
            enabled: false
            host: localhost
            port: 5000
            queue-size: 512


# ===================================================================
# Application specific properties
# Add your own application properties here, see the ApplicationProperties class
# to have type-safe configuration.
#
# ===================================================================

application:
