version: '2'
services:
    ${project.id}-sonar:
        image: sonarqube:6.5-alpine
        ports:
            - 9000:9000
            - 9092:9092
