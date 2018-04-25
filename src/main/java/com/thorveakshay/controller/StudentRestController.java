package com.thorveakshay.controller;

import com.thorveakshay.model.Student;
import com.thorveakshay.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.List;

/* ALL RESTFUL ENDPOINTS WILL BE TRIGGRED FROM HERE */

@RestController
@EnableWebSecurity
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    @RequestMapping("/api/hello")
    public String hello() {
        return "Hello there!!!";
    }

    @GetMapping("/api/all-students")
    public ResponseEntity<List<Student>> allStudents() {
        logger.info("Returning all the students´s");
        return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/api/all-students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> oneStudents(@PathVariable("id") int id) {
        logger.info("Student id to return " + id);


        return new ResponseEntity<Student>(studentService.findStudent(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/api/all-students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeStudentById(@PathVariable("id") int id) {
        logger.info("Student id to remove " + id);

        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//
//	@GetMapping("/save-student")
//	public String saveStudent(@RequestParam String name, @RequestParam String desc){
//		Student student = new Student(name, desc, new Date(), false);
//		studentService.save(student);
//		return "Student saved!";
//	}
//
//	@GetMapping("/delete-student")
//	public String saveStudent(@RequestParam int id){
//		studentService.delete(id);
//		return "Student deleted!";
//	}
}
