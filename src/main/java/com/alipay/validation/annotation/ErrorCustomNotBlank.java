package com.alipay.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationRule;
import org.springmodules.validation.bean.rule.NotBlankValidationRule;

import com.alipay.validation.errcode.ErrorCodeProviderEnum;

/**
 * ����NotBlank��һ�������棬���Զ�ָ̬���˹���Ĵ���У����.<br>
 * ��Ҫ�ṩһ��ErrorCodeProviderʵ��
 * @author wb-dongtao
 * @version $Id: ErrorCustomNotBlank.java, v 0.1 2015-3-3 ����1:41:23 wb-dongtao Exp $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@ValidationRule
public @interface ErrorCustomNotBlank {
    /**
     * Returns the error code that represents the error when the validation fails.
     */
    String errorCode() default NotBlankValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Returns the default message that represents the error when the validation fails.
     */
    String message() default NotBlankValidationRule.DEFAULT_ERROR_CODE;

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
     * �������ṩ��
     */
    ErrorCodeProviderEnum errorCodeProvider();
}
