package com.alipay.validation.rule;

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

import com.alipay.validation.condition.BaseOnCheckServiceCondition;

public class WebBlackListValidationRule extends AbstractValidationRule {

    public static final String DEFAULT_ERROR_CODE = "web.black.list";

    /** checkService */
    private String             beanName;

    public WebBlackListValidationRule(String beanName) {
        super(DEFAULT_ERROR_CODE);
        this.beanName = beanName;
    }

    @Override
    public Condition getCondition() {
        return new BaseOnCheckServiceCondition(beanName);
    }

}
