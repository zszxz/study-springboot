package com.zszxz.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author lsc
 * <p> </p>
 */
public class GenderValidator implements ConstraintValidator<Gender, String> {


    // 初始化校验值
    @Override
    public void initialize(Gender constraintAnnotation) {

    }

    // 校验规则
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return "男".equals(value) || "女".equals(value);
    }
}
