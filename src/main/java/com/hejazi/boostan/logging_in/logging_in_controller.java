package com.hejazi.boostan.logging_in;

import com.hejazi.boostan.database.Student;
import com.hejazi.boostan.database.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logging_in_controller {
    @Autowired
    private studentRepository studentRepository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return new String("greeting");
    }

    @RequestMapping("/signup")
    public String signup(@RequestParam(name="username", required=true) String username,
                           @RequestParam(name="password", required=true) String password,
                           @RequestParam(name="api_key", required=true) String api_key) {
        if(api_key.equals("123")){
            Student student = new Student();
            student.setPassword(password);
            student.setUsername(username);
            studentRepository.save(student);
            return new String("you signed up successfully.");
        }
        return new String("your request was rejected.");
    }
}
