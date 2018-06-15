package com.hejazi.boostan.Controller;

import com.hejazi.boostan.database.mysql.Student;
import com.hejazi.boostan.database.mysql.studentRepository;
import com.hejazi.boostan.database.redis.userSession;
import com.hejazi.boostan.database.redis.userSessionRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logging_in_controller {
    @Autowired
    private studentRepository studentRepository;

    @Autowired
    private userSessionRepository userSessionRepository;


    @RequestMapping(value = "/signup"  , produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestParam(name = "username", required = true) String username,
                         @RequestParam(name = "password", required = true) String password,
                         @RequestParam(name = "api_key", required = true) String api_key) {
        Student student = new Student();
        student.setPassword(password);
        student.setUsername(username);
        JSONObject jsonObject = new JSONObject();
        if (api_key.equals("123isagoodpassword")) {
            for (Student thestudent :
                    studentRepository.findAll()) {
                if (thestudent.getUsername().equals(student.getUsername())) {
                    jsonObject.put("token", "");
                    jsonObject.put("message", "This username is taken.Try another.");
                    return jsonObject.toString();
                }
            }
            studentRepository.save(student);
            jsonObject.put("token", "");
            jsonObject.put("message", "you signed up successfully.");
            return jsonObject.toString();
        }
        jsonObject.put("token", "");
        jsonObject.put("message", "your request was rejected.");
        return jsonObject.toString();
    }

    @RequestMapping(value = "/signin"  , produces = MediaType.APPLICATION_JSON_VALUE)
    public String signin(@RequestParam(name = "username", required = true) String username,
                         @RequestParam(name = "password", required = true) String password,
                         @RequestParam(name = "api_key", required = true) String api_key) {
        Student student = new Student();
        student.setPassword(password);
        student.setUsername(username);
        JSONObject jsonObject = new JSONObject();
        if (userValid(student, api_key)) {
            String token = cacheUser(student, api_key);
            jsonObject.put("token", token);
            jsonObject.put("message", "signed in successfully.");
            jsonObject.put("first name",studentRepository.findByUsername(username).get().getFirstName());
            jsonObject.put("last name",studentRepository.findByUsername(username).get().getLastName());
            return jsonObject.toString();
        }
        jsonObject.put("token", "");
        jsonObject.put("message", "your username or password is incorrect");
        return jsonObject.toString();
    }

    private boolean userValid(Student student, String api_key) {
        if (api_key.equals("123isagoodpassword")) {
            for (Student thestudent :
                    studentRepository.findAll()) {
                if (thestudent.getUsername().equals(student.getUsername())
                        && thestudent.getPassword().equals(student.getPassword()))
                    return true;
            }
        }
        return false;
    }

    private String cacheUser(Student student, String api_key) {
        String token = DigestUtils.sha256Hex(student.getUsername() + student.getPassword());
        userSession userSession = new userSession(token, student.getUsername(), student.getPassword());
        if(!userSessionRepository.findById(token).isPresent())
            userSessionRepository.save(userSession);
        return token;
    }
}
