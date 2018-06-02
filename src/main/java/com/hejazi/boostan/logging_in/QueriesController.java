package com.hejazi.boostan.logging_in;

import com.hejazi.boostan.database.mysql.*;
import com.hejazi.boostan.database.redis.userSession;
import com.hejazi.boostan.database.redis.userSessionRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueriesController {
    @Autowired
    private courseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private userSessionRepository userSessionRepository;

    @Autowired
    private studentRepository studentRepository;

    @RequestMapping("/allcourses")
    public String sign(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return "invalid token";
        userSession userSession = userSessionRepository.findById(token).get();
        Student student = studentRepository.findByUsername(userSession.getUsername()).get();
        JSONArray jsonArray = new JSONArray();
        for (Semester semester:
                semesterRepository.findAll()) {
            if(semester.getStudent() == student.getId()){
                JSONObject jsonObject = new JSONObject();
                for (course course:
                     courseRepository.findAll()) {
                    if(course.getId() == semester.getCourse())
                        jsonObject.put("course", course.getName());
                }
                jsonObject.put("mark",semester.getMark());
                for (Student student1:
                     studentRepository.findAll()) {
                    if(student1.getId() == semester.getTeacher())
                        jsonObject.put("teacher",student1.getLastName());
                }
                jsonArray.put(jsonObject);
            }
        }
        return new JSONObject().put("semesters",jsonArray).toString();
    }

    @RequestMapping("/avgpassedreceived")
    public String avg(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return "invalid token";
        userSession userSession = userSessionRepository.findById(token).get();
        Student student = studentRepository.findByUsername(userSession.getUsername()).get();
        JSONObject jsonObject = new JSONObject();
        if (student.getUsername().equals("9421983")){
            jsonObject.put("pass","18");
            jsonObject.put("receive","18");
            jsonObject.put("avg","18.43");
        }
        return new JSONObject().toString();
    }

    private boolean tokenValid(String token) {
        return userSessionRepository.findById(token).isPresent();
    }
}
