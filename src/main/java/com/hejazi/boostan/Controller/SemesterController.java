package com.hejazi.boostan.Controller;

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
public class SemesterController {
    @Autowired
    private courseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private userSessionRepository userSessionRepository;

    @Autowired
    private studentRepository studentRepository;

    @RequestMapping("/studentCourses")
    public String studentCourses(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return "invalid token";
        Student student = retreiveStudentFromCache(token);
        JSONArray array = new JSONArray();
        for (Semester semester:
                semesterRepository.findAll()) {
            if(semester.getStudent() == student.getId()){
                JSONObject element = new JSONObject();
                element.put("mark",semester.getMark());
                element.put("status",semester.getStatus());
                element.put("term",semester.getTerm());
                element.put("markTypr",semester.getMarkType());
                for (course course:
                     courseRepository.findAll()) {
                    if(course.getId() == semester.getCourse()) {
                        element.put("id",course.getId());
                        element.put("name",course.getName());
                        element.put("type",course.getType());
                        element.put("value",course.getValue());
                    }
                }
                array.put(element);
            }
        }
        return new JSONObject().put("studentCourses",array).toString();
    }

    @RequestMapping("/markSummary")
    public String avg(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return "invalid token";
        Student student = retreiveStudentFromCache(token);
        int sumOfMarks = 0;
        int numberOfCourses = 0;
        int numberOfPassedCourses = 0;
        for (Semester semester:
             semesterRepository.findAll()) {
            if (student.getId() == semester.getStudent()){
                sumOfMarks += semester.getMark();
                numberOfCourses++;
                if (semester.getStatus().equals("قبول شده"))
                    numberOfPassedCourses++;
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("numberOfCourses",numberOfCourses);
        jsonObject.put("average of marks",(sumOfMarks / numberOfCourses));
        jsonObject.put("numberOfPassedCourses",numberOfPassedCourses);
        return jsonObject.toString();
    }

    private boolean tokenValid(String token) {
        return userSessionRepository.findById(token).isPresent();
    }

    private Student retreiveStudentFromCache(String token){
        userSession userSession = userSessionRepository.findById(token).get();
        return studentRepository.findByUsername(userSession.getUsername()).get();
    }
}
