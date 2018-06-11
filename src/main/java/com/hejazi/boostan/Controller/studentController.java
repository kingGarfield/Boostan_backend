package com.hejazi.boostan.Controller;

import com.hejazi.boostan.database.mysql.SemesterRepository;
import com.hejazi.boostan.database.mysql.Student;
import com.hejazi.boostan.database.mysql.courseRepository;
import com.hejazi.boostan.database.mysql.studentRepository;
import com.hejazi.boostan.database.redis.userSession;
import com.hejazi.boostan.database.redis.userSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {
    @Autowired
    private courseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private userSessionRepository userSessionRepository;

    @Autowired
    private studentRepository studentRepository;

    @RequestMapping("/account_information")
    public Student accounInformation(@RequestParam(name = "token", required = true) String token) {
        if (!tokenValid(token))
            return null;
        return retreiveStudentFromCache(token);
    }

    private boolean tokenValid(String token) {
        return userSessionRepository.findById(token).isPresent();
    }

    private Student retreiveStudentFromCache(String token){
        userSession userSession = userSessionRepository.findById(token).get();
        return studentRepository.findByUsername(userSession.getUsername()).get();
    }
}
