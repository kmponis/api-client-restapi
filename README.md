# API CLIENT REST API
A REST API to send HTTP request, deployed using Docker.

## Prerequisites: 
* Download and install docker and docker-compose
* Download and move to 'api-client-restapi'
<br>`$ git clone https://github.com/kmponis/api-client-restapi.git`

## Deploy with docker-compose 
<br>`$ docker-compose up`

## Test URL and Code Coverage (100%)
<br>`$ open http://<docker_ip_address>:9991/swagger-ui.html`
<br>`$ open api-client/target/jacoco-reports/index.html`

### (Optional) Build, deploy and upload using Dockerfile-noDC
* Move to 'api-client', Build and Deploy
<br>`$ cd api-client`
<br>`$ docker build -t apiclientimage -f Dockerfile-noDC .`
<br>`$ docker run -p 9991:8882 apiclientimage`
* Upload to dockerhub for external use
<br>`$ docker tag apiclientimage kbonis/api-client-image:latest`
<br>`$ docker login`
<br>`$ docker push kbonis/api-client-image:latest`
