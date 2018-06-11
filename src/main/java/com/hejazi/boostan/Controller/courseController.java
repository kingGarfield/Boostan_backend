package com.hejazi.boostan.Controller;

import com.hejazi.boostan.database.mysql.*;
import com.hejazi.boostan.database.redis.userSession;
import com.hejazi.boostan.database.redis.userSessionRepository;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class courseController {
    @Autowired
    private courseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private userSessionRepository userSessionRepository;

    @Autowired
    private studentRepository studentRepository;

    @RequestMapping("/allCourses")
    public String allCourses(@RequestParam(name = "token", required = true) String token) {
        if (!tokenValid(token))
            return null;
        JSONArray array = new JSONArray();
        for (course course:
             courseRepository.findAll()) {
            JSONObject element = new JSONObject();
            element.put("id",course.getId());
            element.put("name",course.getName());
            element.put("type",course.getType());
            element.put("value",course.getValue());
            array.put(element);
        }
        return new JSONObject().put("courses",array).toString();
    }

    private boolean tokenValid(String token) {
        return userSessionRepository.findById(token).isPresent();
    }

    private Student retreiveStudentFromCache(String token){
        userSession userSession = userSessionRepository.findById(token).get();
        return studentRepository.findByUsername(userSession.getUsername()).get();
    }
}
