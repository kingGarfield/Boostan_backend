package com.hejazi.boostan.logging_in;

import com.hejazi.boostan.database.Student;
import com.hejazi.boostan.database.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class logging_in_controller {
    @Autowired
    private studentRepository studentRepository;



    @RequestMapping("/signup")
    public String signup(@RequestParam(name="username", required=true) String username,
                           @RequestParam(name="password", required=true) String password,
                           @RequestParam(name="api_key", required=true) String api_key) {
        if(api_key.equals("123isagoodpassword")){
            Student student = new Student();
            student.setPassword(password);
            student.setUsername(username);
            for (Student thestudent:
                 studentRepository.findAll()) {
                if(thestudent.getUsername().equals(username))
                    return new String("This username is taken.Try another.");
            }
            studentRepository.save(student);
            return new String("you signed up successfully.");
        }
        return new String("your request was rejected.");
    }

    @RequestMapping("/signin")
    public String signin(@RequestParam(name="username", required=true) String username,
                         @RequestParam(name="password", required=true) String password,
                         @RequestParam(name="api_key", required=true) String api_key) {
        if(api_key.equals("123isagoodpassword")){
            Student student = new Student();
            student.setPassword(password);
            student.setUsername(username);
            for (Student thestudent:
                    studentRepository.findAll()) {
                if(thestudent.getUsername().equals(username) && student.getPassword().equals(password))
                    return new String("signed in successfully.");
            }
        }
        return new String("your username or password is incorrect");
    }
}
