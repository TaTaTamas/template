REMINDER
<br>quick setup for springboot => https://start.spring.io/

Run test with Maven
```bash
mvn clean install
```
```bash
./gradlew build
```
Run spring-boot project
```bash
mvn spring-boot:run
```
```bash
./gradlew bootRun
```

Build docker
```bash
docker build -t tatatamas/parking-service .
```

Run docker
```bash
docker run -p 8083:8083 tatatamas/parking-service
```

Run docker compose
```bash
docker compose -f docker/docker-compose.yml up
```

Test with CURL
```bash
curl -X POST http://localhost:8083/parking/location \
  -H "Content-Type: application/json" \
  -d '{"latitude":0.23,"longitude":0.23,"vehicleId":"myhonda"}'

```
```bash
curl GET http://localhost:8083/parking/locations?vehicleID=myhonda
```