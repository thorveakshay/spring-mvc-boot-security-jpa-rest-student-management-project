# Student Management System

## Functionality covered

Completed the CRUD operation on MySQL database.

RESTful endpoints working using id.

Intigrated HTTP basic auth for securing API's

## Requirements

1.  Java 
2.  Maven
3.  MySQL
4.  Spring Boot

## Database configurations files
* db_schema.sql
* application.properties


## Steps to Setup
### DB setup

Please execute below commands in your mysql database.

````


CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

DROP TABLE IF EXISTS student_info;

CREATE TABLE student_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  dob varchar(45) DEFAULT NULL,
  division varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

select * from student_info;


DROP TABLE IF EXISTS s_score;

CREATE TABLE s_score (

  id int(11) REFERENCES student_info (id),
  subject1 int(11),
   subject2 int(11),
   subject3 int(11)
);


````


### Code Setup

* Download spring-boot-rest-student-management-example.zip
* Extract zip 
* Build and run the backend app using maven**

1) You can run the app without packaging it using

```bash
cd spring-boot-rest-student-management-example-master
mvn spring-boot:run
```


2) You can run the app without packaging it using

```bash
cd spring-boot-rest-student-management-example-master
mvn package
java -jar target/studentmanagement.jar
```

## Output

The backend localhost service will start at <http://localhost:8080>.

### Bootstrap:
View all students in DB
Create student
Update Student
Delete Student


### REST Endpoints:

Created 3 users for HTTP basic Auth
henry,mike, akshay - username and password are same

````
localhost
http://localhost:8080/api/all-students/
http://localhost:8080/api/all-students/{provide student id}

Using http POST request we can delete students by using below URI (Using Postman)
http://localhost:8080/api/all-students/1


````

## Remaining functionality

Connecting 2 tables
Small percentage calculation
UI improvements

## Future scope
Validations
Date picker for DOB
unit tests

Including challange 1 and 2 total challange completion would be around 75% in one day. I will take one more day to complete both challanges including remaining functionality and future scope. 
