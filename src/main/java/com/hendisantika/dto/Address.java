package com.hendisantika.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    private String street;
    private Integer doorNo;
    private String additionalInfo;
}
