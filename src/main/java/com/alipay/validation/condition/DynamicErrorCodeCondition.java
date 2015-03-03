package com.alipay.validation.condition;

import org.springmodules.validation.util.condition.AbstractCondition;

import com.alipay.validation.rule.DynamicErrorCodeValidationRule;

public class DynamicErrorCodeCondition extends AbstractCondition implements ValidatedJavaBeanAware {

    private Object                         targetBean;
    private DynamicErrorCodeValidationRule ruleWrapper;

    public DynamicErrorCodeCondition(DynamicErrorCodeValidationRule ruleWrapper) {
        this.ruleWrapper = ruleWrapper;
    }

    @Override
    public void setTargetBean(Object targetBean) {
        this.targetBean = targetBean;
    }

    @Override
    public boolean doCheck(Object object) {
        ruleWrapper.updateErrorCode(targetBean);
        return ruleWrapper.getActualRule().getCondition().check(object);
    }
}
