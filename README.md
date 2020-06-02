## Salesforce Data Ingestion
Data Ingestion From Salesforce Endpoints

## Technologies:

-SpringBoot  
-Gradle  
-Lombok  
-JPA  
-Actuator  
-H2 Database  

## How to run

Development environment: 
-Dspring.profiles.active=dev

Production environment:
-Dspring.profiles.active=prod

## Dependency

Sonarqube running: http://localhost:9000  
docker run -d --name sonarqube -p 9000:9000 sonarqube:7.5-community


## Run DynamoDB locally

docker pull amazon/dynamodb-local  

docker run -p 8000:8000 amazon/dynamodb-local
