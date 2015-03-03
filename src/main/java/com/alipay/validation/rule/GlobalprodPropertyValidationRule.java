package com.alipay.validation.rule;

import org.springmodules.validation.bean.rule.PropertyValidationRule;
import org.springmodules.validation.bean.rule.ValidationRule;
import org.springmodules.validation.util.condition.Condition;

import com.alipay.validation.condition.GlobalprodPropertyBeanCondition;

/**
 * 扩展属性校验规则, 此类为向上层提供自定义的propertyBeanCondition而存在
 * @author wb-dongtao
 * @version $Id: GlobalprodPropertyValidationRule.java, v 0.1 2015-2-28 下午8:02:40 wb-dongtao Exp $
 */
public class GlobalprodPropertyValidationRule extends PropertyValidationRule {

    private String         propertyName;
    private ValidationRule validationRule;

    public GlobalprodPropertyValidationRule(String propertyName, ValidationRule validationRule) {
        super(propertyName, validationRule);
        this.propertyName = propertyName;
        this.validationRule = validationRule;
    }

    /**
     * 
     * @see org.springmodules.validation.bean.rule.PropertyValidationRule#getCondition()
     */
    @Override
    public Condition getCondition() {
        return new GlobalprodPropertyBeanCondition(propertyName, validationRule.getCondition());
    }
}
