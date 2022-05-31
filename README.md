# seamhealth


# Description
This repository contains the source code of seamhealth doctor service api written with Spring & Spring Boot SpringBoot.


# Prerequisite
. Spring Framework 5.3.15

. Spring Boot 2.6.6

. Spring Data JPA

. Hibernate ORM

. Model Mapper

. H2 Database

. Maven


# Code Structure

<img width="477" alt="Screenshot 2022-06-01 at 00 08 40" src="https://user-images.githubusercontent.com/26047094/171298296-aec22f43-ca7f-4aeb-b148-90652e009fa7.png">



# Screens

There are 6 API endpoints in the seamhealth doctor service api:

    ###### . Register Doctor - POST http://localhost:9191/api/doctors
    ###### . Update doctor address - PUT http://localhost:9191/api/address/{address_id}
    ###### . Update doctor data - PUT http://localhost:9191/api/doctors/{doctor_id}
    ###### . Delete doctor - DELETE http://localhost:9191/api/doctors/{doctor_id}
    ###### . Get Doctor By Id - GET http://localhost:9191/api/doctors/{doctor_id}/doctor
    ###### . Get Paginated Doctors List - GET http://localhost:9191/api/doctors?page=0&size=10

### Post Register new doctor
<img width="1370" alt="register doctor" src="https://user-images.githubusercontent.com/26047094/171299521-e433ec0a-2243-4a8d-b829-a580a36466ee.png">


### Put  Update doctor address
<img width="1388" alt="update address by id" src="https://user-images.githubusercontent.com/26047094/171299611-4e95027b-3893-4d22-8682-84bd839d96ea.png">


### Delete doctor
<img width="1362" alt="delete doctor by id" src="https://user-images.githubusercontent.com/26047094/171299648-a211f682-9eb6-4583-b009-7ab85da73a5e.png">


### Get Paginated Doctor
<img width="1358" alt="paginated doctor list" src="https://user-images.githubusercontent.com/26047094/171299682-7ebcb72b-ac5c-4001-ac21-1a80d0010b5a.png">

### Get Doctor by Id
<img width="1387" alt="get doctor by id" src="https://user-images.githubusercontent.com/26047094/171299737-0c83ecca-f2bc-47b7-81ee-a70b0ca8068d.png">


### Update Doctor data
<img width="1363" alt="update doctor by id" src="https://user-images.githubusercontent.com/26047094/171299803-08732539-9ae6-4387-9775-ca1620be66ef.png">


# Running the server locally
To be able to run this Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with Maven, use the below command. You will need to run it from the project folder which contains the mvnw.cmd file.

    ./mvnw spring-boot:run

To run the Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

    java -jar bcfInternationalTask-0.0.1-SNAPSHOT.jar
    
# Clone from repository

    git clone https://github.com/ohmsmaestro/seamhealth.git
    
# Default employee has the below id. Use the first person id to create order employee as indicated in POST EMPLOYEE
    abcdef

# Access H2 console
    url = http://localhost:9191/api/h2
    
    username = admin
    
    password = 1234



