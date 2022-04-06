package com.hendisantika.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-validation-with-init-binder
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/04/22
 * Time: 16.47
 */
@Getter
@Setter
public class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private String error;
    private Integer count;
    private List<String> errors;
}
