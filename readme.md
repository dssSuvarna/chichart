# ChiChart

## Purpose
Contains chichart-web which is a web app used for internal testing.
Also containts chichart-api which is a REST service designed to be called from devices, which handles things like registering a device for a trial period and returning chart details.

## Getting Started

### Recommended Intellij Setup
+ Lombok plugin (instruments compile code for Intellij real time compilation errorDetails checking)
+ Flyway Migration plugin    

### Database
+ a blank chichart MySQL database needs to exist
+ a chichart user with password of chichart needs to exist and needs to have full access to the chichart database.

### Swagger URL
http://localhost:8085/swagger-ui.html
 