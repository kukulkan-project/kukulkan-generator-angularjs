version: '2'
services:
    ${project.id}-app:
        image: ${project.id}
        environment:
            - SPRING_PROFILES_ACTIVE=prod,swagger
            - SPRING_DATA_MONGODB_URI=mongodb://${project.id}-mongodb:27017
            - SPRING_DATA_MONGODB_DATABASE=${project.id}
            - APP_SLEEP=10 # gives time for the database to boot before the application
        ports:
            - 8080:8080
    ${project.id}-mongodb:
        extends:
            file: mongodb.yml
            service: ${project.id}-mongodb
