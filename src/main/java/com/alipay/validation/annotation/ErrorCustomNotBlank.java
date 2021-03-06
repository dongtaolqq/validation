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
 * 这是NotBlank的一个升级版，可以动态指定此规则的错误校验码.<br>
 * 需要提供一个ErrorCodeProvider实例
 * @author wb-dongtao
 * @version $Id: ErrorCustomNotBlank.java, v 0.1 2015-3-3 下午1:41:23 wb-dongtao Exp $
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
     * 错误码提供者
     */
    ErrorCodeProviderEnum errorCodeProvider();
}
