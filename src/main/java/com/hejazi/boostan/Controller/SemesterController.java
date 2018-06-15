package com.hejazi.boostan.Controller;

import com.hejazi.boostan.database.mysql.*;
import com.hejazi.boostan.database.redis.userSession;
import com.hejazi.boostan.database.redis.userSessionRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Autowired
    private availableCoursesRepository availableCoursesRepository;

    @RequestMapping(value = "/studentCourses" , produces = MediaType.APPLICATION_JSON_VALUE)
    public String studentCourses(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return null;
        Student student = retreiveStudentFromCache(token);
        JSONArray array = new JSONArray();
        for (Semester semester:
                semesterRepository.findAll()) {
            if(semester.getStudent() == student.getId()){
                JSONObject element = new JSONObject();
                element.put("mark",semester.getMark());
                element.put("status",semester.getStatus());
                element.put("term",semester.getTerm());
                element.put("markType",semester.getMarkType());
                element.put("registerType",semester.getRegisterType());
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

    @RequestMapping(value = "/markSummary" , produces = MediaType.APPLICATION_JSON_VALUE)
    public String avg(@RequestParam(name="token", required=true) String token) {
        if (!tokenValid(token))
            return null;
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

    @RequestMapping(value = "/enrollCourse"  , produces = MediaType.APPLICATION_JSON_VALUE)
    public String enrollCourse(@RequestParam(name="token", required=true) String token
    ,@RequestParam(name = "availableCourseId",required = true) int availableCourseId) {
        if (!tokenValid(token))
            return new JSONObject().put("message","invalid token").toString();
        Student student = retreiveStudentFromCache(token);
        if(!availableCoursesRepository.findById(availableCourseId).isPresent())
            return new JSONObject().put("message","invalid courseId").toString();
        availableCourses availableCourse = availableCoursesRepository.findById( availableCourseId).get();
        if(availableCourse.getClassCapacity() == 0)
            return new JSONObject().put("message","sorry,the class is full").toString();
        availableCourse.setClassCapacity(availableCourse.getClassCapacity() - 1);
        String pishniaz =
                courseRepository.findById( availableCourse.getCourseId()).get().getPishniazCouses();
        String [] pishniazlist = pishniaz.split("-");
        for (String s:
             pishniazlist) {
            boolean passed = false;
            for (Semester semester:
                 semesterRepository.findAll()) {
                if (semester.getStudent() == student.getId()){
                    if (semester.getCourse() == Integer.parseInt(s)){
                        passed = true;
                        break;
                    }
                }
            }
            if (!passed){
                return new JSONObject().put("message","u haven't passed prerequisite courses").toString();
            }
        }
        Semester semester =  new Semester(
                availableCourse.getCourseId(),
                availableCourse.getTeacherId(),
                student.getId(),availableCourse.getTerm(),"عادی",-1,"اعلام نشده","عادی");
        semesterRepository.save(semester);
        return new JSONObject().put("message","congratulations").toString();
    }

    private boolean tokenValid(String token) {
        return userSessionRepository.findById(token).isPresent();
    }

    private Student retreiveStudentFromCache(String token){
        userSession userSession = userSessionRepository.findById(token).get();
        return studentRepository.findByUsername(userSession.getUsername()).get();
    }
}
