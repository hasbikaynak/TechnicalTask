# TechnicalTask

## METADATA

### PostgreSQL connection:
- user of the db is "postgres"
- port for connection is "5433"
- DB name is "technicaltask_db"

spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/technicaltask_db
    username: postgres
    password: 1453
    driver-class-name: org.postgresql.Driver
    
### Port for server
server:
  port: 8080

###You can find the collection of the postman under this link:
-- https://github.com/hasbikaynak/TechnicalTask/blob/master/A_AATechnicalTask.postman_collection.json
