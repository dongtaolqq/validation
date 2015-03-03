package com.alipay.validation.rule;

import org.springmodules.validation.bean.rule.AbstractValidationRule;

/**
 * 接口提供更新当前校验规则的错误码
 * @author wb-dongtao
 * @version $Id: DynamicErrorCodeValidationRule.java, v 0.1 2015-2-28 下午7:55:47 wb-dongtao Exp $
 */
public interface DynamicErrorCodeValidationRule {
    /**
     * 更新错误码, Condition层回调的接口方法，提供被校验的JAVABean
     * @param targetBean    被校验JavaBean
     */
    void updateErrorCode(Object targetBean);

    /**
     * Condition层回调的接口方法, 提供实际做校验的ValidationRule
     * @return
     */
    AbstractValidationRule getActualRule();
}
