

## Start the db
Update 'mysecretpassword' with the PG password.
This will start it on port 7687.
```bash
docker run -d --publish 7687:8080 -e "POSTGRES_PASSWORD=mysecretpassword" pg-tabletop:1
```


## Start the Spring Boot tomcat
This will start it on port 8080.
```bash
cd .\backend\tabletopCombatTracker
mvn spring-boot:run
```