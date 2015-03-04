package com.alipay.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationRule;

import com.alipay.validation.rule.WebBlackListValidationRule;

/**
 * ��ע����Ҫ�ṩICheckServiceʵ����spring�����е�beanName<br>
 * ע��У������ʹ��ָ����ICheckServiceʵ�������ֶ�ֵ��У��
 * @author wb-dongtao
 * @version $Id: WebBlackList.java, v 0.1 2015-3-3 ����1:38:57 wb-dongtao Exp $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@ValidationRule
public @interface WebBlackList {

    /**
     * Returns the error code that represents the error when the validation fails.
     */
    String errorCode() default WebBlackListValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Returns the default message that represents the error when the validation fails.
     */
    String message() default WebBlackListValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Comma-delimited list of arguments to be attached to the error code
     */
    String args() default "";

    /**
     * An condition expressed in an expression language (e.g. OGNL, Valag) that determines when
     * this validation rule should be applied.
     */
    String applyIf() default "";

    /**
     * A list of context in which this validation rule is applicable. Empty list means this rule is always applicable
     * regardless the validation context.
     */
    String[] contexts() default {};

    /**
     * ICheckServiceʵ����spring�����е�����
     */
    String checkServiceName();
}
