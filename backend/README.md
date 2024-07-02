

## Start the db
Update 'mysecretpassword' with the PG password.
This will start it & portforward PG port 5432 to local 7001.
```bash
docker run -d --publish 7001:5432 -e "POSTGRES_PASSWORD=mysecretpassword" pg-tabletop:1
```


## Start the Spring Boot tomcat
This will start it on port 8080.
```bash
cd .\backend\tabletopCombatTracker
mvn spring-boot:run
```