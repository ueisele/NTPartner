FROM debian:jessie

RUN apt-get update && apt-get -y install wget \
    && wget -q -O - https://dev.mysql.com/get/Downloads/MySQL-Shell/mysql-shell-1.0.9-linux-glibc2.12-x86-64bit.tar.gz | tar -xzC / --strip 1 \
    && apt-get -y remove wget && apt-get -y autoremove && apt-get clean

COPY *.sql /data/
CMD mysqlsh --sql -h ${MYSQL_HOST} --user=${MYSQL_USER} --password=${MYSQL_PASSWORD} --database=${MYSQL_DATABASE} -f /data/tables.sql
