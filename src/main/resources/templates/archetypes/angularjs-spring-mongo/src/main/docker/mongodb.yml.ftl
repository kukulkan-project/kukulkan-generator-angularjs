version: '2'
services:
    ${project.id}-mongodb:
        image: mongo:3.4.10
        ports:
            - "27017:27017"
        # volumes:
        #     - ~/volumes/jhipster/${project.id}/mongodb/:/data/db/
