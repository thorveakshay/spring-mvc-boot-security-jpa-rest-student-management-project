package com.thorveakshay.service;

import com.thorveakshay.dao.StudentRepository;
import com.thorveakshay.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (Student student : studentRepository.findAll()) {
            students.add(student);
        }
        return students;
    }

    public Student findStudent(int id) {
        return studentRepository.findOne(id);
    }


    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }



}
