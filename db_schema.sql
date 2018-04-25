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



commit;
