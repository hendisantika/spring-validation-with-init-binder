package com.hendisantika.controller;

import com.hendisantika.dto.Student;
import com.hendisantika.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-validation-with-init-binder
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/04/22
 * Time: 16.49
 */
@RestController("/")
public class StudentController {

    @Autowired
    private StudentValidator studentValidator;

    @InitBinder(value = "student")
    void initStudentValidator(WebDataBinder binder) {
        binder.setValidator(studentValidator);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid Student student) {
        // Other logic here(Calling the service layer,etc.)
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
