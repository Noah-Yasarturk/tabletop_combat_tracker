# Setup app 
# Requirements:
# - Docker: https://www.docker.com/get-started/
# - Java: https://bell-sw.com/pages/downloads/#jdk-21-lts
# - Maven: https://maven.apache.org/install.html

# Deploy database
DB_PORT=7687
echo 'Pulling postgres image'
docker pull postgres
docker tag postgres:latest pg-tabletop:1
docker run -d --publish 5432:5432 -e "POSTGRES_PASSWORD=mysecretpassword" pg-tabletop:1


#  Deploy Rest API
TOMCAT_PORT=8080
echo "Starting Java REST API"
cd backend/tabletopCombatTracker/
mvn spring-boot:run


# TODO: Deploy UI
NGINX_PORT=80


