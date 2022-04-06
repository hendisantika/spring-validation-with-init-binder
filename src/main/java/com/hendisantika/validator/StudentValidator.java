package com.hendisantika.validator;

import com.hendisantika.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;


/**
 * Created by IntelliJ IDEA.
 * Project : spring-validation-with-init-binder
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/04/22
 * Time: 16.50
 */
@Component
public class StudentValidator implements Validator {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        ValidationUtils.rejectIfEmpty(errors, "name",
                messageSource.getMessage("student.name.error", null, Locale.getDefault()));
        if (student.getGrade() <= 0) {
            errors.rejectValue("grade", messageSource.getMessage("student.grade.error", null, Locale.getDefault()),
                    "Student grade should be greater than zero");
        }
        if (null != student.getAddress() && Boolean.TRUE.equals(student.getAddress())
                && null == student.getAddressDetails()) {
            errors.rejectValue("address", messageSource.getMessage("student.address.error", null, Locale.getDefault()),
                    "Student address details should be empty");
        }
    }
}
