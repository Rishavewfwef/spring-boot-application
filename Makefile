APP_NAME = test-app-java-spring

local_deploy: build docker_build docker_compose_up

build:
	mvn clean package -DskipTests

docker_build:
	docker build -t $(APP_NAME) .

docker_compose_up:
	docker-compose up
