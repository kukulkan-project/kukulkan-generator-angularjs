# ===================================================================
# Spring Boot configuration for the "dev" profile.
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
        ROOT: DEBUG
        ${project.packaging}: DEBUG
        io.github.jhipster: DEBUG

spring:
    profiles:
        active: dev
        include: swagger
    devtools:
        restart:
            enabled: true
        livereload:
            enabled: false # we use gulp + BrowserSync for livereload
    jackson:
        serialization.indent_output: true
    data:
        mongodb:
            uri: mongodb://localhost:27017
            database: ${project.id}
    mail:
        host: localhost
        port: 25
        username:
        password:
    messages:
        cache-seconds: 1
    thymeleaf:
        cache: false

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
#    port: 8443
#    ssl:
#        key-store: keystore.p12
#        key-store-password: <your-password>
#        key-store-type: PKCS12
#        key-alias: ${project.id}
# ===================================================================
server:
    port: 8080

# ===================================================================
# JHipster specific properties
#
# ===================================================================

jhipster:
    http:
        version: V_1_1 # To use HTTP/2 you will need SSL support (see above the "server.ssl" configuration)
    cache: # Cache configuration
        ehcache: # Ehcache configuration
            time-to-live-seconds: 3600 # By default objects stay 1 hour in the cache
            max-entries: 100 # Number of objects in each cache entry
    # CORS is only enabled by default with the "dev" profile, so BrowserSync can access the API
    cors:
        allowed-origins: "*"
        allowed-methods: "*"
        allowed-headers: "*"
        exposed-headers: "Authorization,Link,X-Total-Count"
        allow-credentials: true
        max-age: 1800
    security:
        authentication:
            jwt:
                secret: my-secret-token-to-change-in-production
                # Token is valid 24 hours
                token-validity-in-seconds: 86400
                token-validity-in-seconds-for-remember-me: 2592000
    mail: # specific app mail property, for standard properties see MailProperties
        from: ${project.id}@localhost
        base-url: http://127.0.0.1:8080
    metrics: # DropWizard Metrics configuration, used by MetricsConfiguration
        jmx.enabled: true
        graphite: # Use the "graphite" Maven profile to have the Graphite dependencies
            enabled: false
            host: localhost
            port: 2003
            prefix: ${project.id}
        prometheus: # Use the "prometheus" Maven profile to have the Prometheus dependencies
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
