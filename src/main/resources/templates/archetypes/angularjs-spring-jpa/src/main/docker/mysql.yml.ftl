version: '2'
services:
    ${project.id}-mysql:
        image: mysql:5.7.20
        # volumes:
        #     - ~/volumes/jhipster/${project.id}/mysql/:/var/lib/mysql/
        environment:
            - MYSQL_USER=root
            - MYSQL_ALLOW_EMPTY_PASSWORD=yes
            - MYSQL_DATABASE=${project.id}
        ports:
            - 3306:3306
        command: mysqld --lower_case_table_names=1 --skip-ssl --character_set_server=utf8 --explicit_defaults_for_timestamp
