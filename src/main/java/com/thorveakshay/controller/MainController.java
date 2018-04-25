package com.thorveakshay.controller;

import com.thorveakshay.model.Student;
import com.thorveakshay.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-students")
    public String allStudents(HttpServletRequest request) {
        request.setAttribute("students", studentService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-student")
    public String newStudent(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Student student, BindingResult bindingResult, HttpServletRequest request) {
       // student.setDob(new Date());
        studentService.save(student);
        request.setAttribute("students", studentService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/update-student")
    public String updateStudent(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("student", studentService.findStudent(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-student")
    public String deleteStudent(@RequestParam int id, HttpServletRequest request) {
        studentService.delete(id);
        request.setAttribute("students", studentService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }
}
