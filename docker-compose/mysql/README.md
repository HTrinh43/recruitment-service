# Start database

```bash
docker compose up -d
```
Start mysql server using docker

Default port is `3306`, `username` root and `password` is `MYSQL_ROOT_PASSWORD` in `docker-compose.yml`

# Stop database
```bash
docker compose stop
```

# Creating database dumps
```bash
docker exec mysqldb_mysql-db_1 sh -c 'exec mysqldump --all-databases -uroot -p"Admin@123"' > db-dumps/all-databases.sql
```

# Restoring data from dump files
```bash
docker exec -i mysqldb_mysql-db_1 sh -c 'exec mysql -uroot -p"Admin@123"' < db-dumps/all-databases.sql
```
