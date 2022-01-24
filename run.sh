# java -jar target/encryption-api-0.0.1-SNAPSHOT.jar
# java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar target/encryption-api-0.0.1-SNAPSHOT.jar
docker run \
	-p 80:80 \
	-p 8080:8080 \
	-e CATALINA_OPTS='-agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n' \
	local/encryption

