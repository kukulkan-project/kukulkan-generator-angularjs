version: '2'
services:
    ${project.id}-oracle:
        image: sath89/oracle-12c:latest
        # volumes:
        #     - ~/volumes/${project.id}/oracle/data:/u01/app/oracle
        environment:
            - DBCA_TOTAL_MEMORY=1024
            - WEB_CONSOLE=true
        ports:
            - 1580:8080
            - 1521:1521