version: '2'
services:
    ${project.id}-app:
        image: ${project.id}
        environment:
            - SPRING_PROFILES_ACTIVE=prod,swagger
            - SPRING_DATASOURCE_URL=jdbc:mysql://${project.id}-mysql:3306/${project.id}?useUnicode=true&characterEncoding=utf8&useSSL=false
            - APP_SLEEP=10 # gives time for the database to boot before the application
        ports:
            - 8080:8080
    ${project.id}-mysql:
        extends:
            file: mysql.yml
            service: ${project.id}-mysql
