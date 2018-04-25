package com.thorveakshay;

import com.thorveakshay.dao.StudentRepository;
import com.thorveakshay.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// MAIN APPLICATION CLASS


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private ScoreCardRepository scoreCardRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String...args) throws Exception{
        studentRepository.deleteAll();
       // scoreCardRepository.deleteAll();

        Student s1 = new Student("Akshay","Thorve","01/01/2000","A");

        Student s2 = new Student("Sam","Doe","01/01/2003","A");
        Student s3 = new Student("John","Doe","01/01/2005","B");


//        ScoreCard c1 = new ScoreCard(s1,100,90,95);
//        ScoreCard c2 = new ScoreCard(s2,90,90,95);
//        ScoreCard c3 = new ScoreCard(s3,99,70,95);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);

//        scoreCardRepository.save(c1);
//        scoreCardRepository.save(c2);
//        scoreCardRepository.save(c3);

    }
}
