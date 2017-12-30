version: '2'
services:
    ${project.id}-mongodb:
        image: mongo:3.4.10
        ports:
            - "27017:27017"
        command: mongos --configdb ${project.id}-mongodb-config
    ${project.id}-mongodb-node:
        build:
            context: .
            dockerfile: mongodb/MongoDB.Dockerfile
        command: mongod --replSet rs1 --noprealloc --smallfiles
    ${project.id}-mongodb-config:
        image: mongo:3.4.10
        container_name: ${project.id}-mongodb-config
        command: mongod --noprealloc --smallfiles --configsvr --dbpath /data/db
