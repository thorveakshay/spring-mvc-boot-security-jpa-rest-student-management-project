package com.thorveakshay.dao;

import com.thorveakshay.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// USING SPRING BOOT JPA AND CRUD REPO TO COMMUNICATE WITH DATABASE

// implementation of this is in package com.thorveakshay.service;

public interface StudentRepository extends CrudRepository<Student, Integer> {

//    @Query(value = "SELECT * FROM student_info WHERE first_name = name", nativeQuery = true)
//    public Student findStudent(String name);

}
