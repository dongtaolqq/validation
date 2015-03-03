package com.alipay.validation.condition;

import org.springframework.beans.BeanWrapper;
import org.springmodules.validation.util.condition.Condition;
import org.springmodules.validation.util.condition.bean.PropertyBeanCondition;

/**
 * 扩展PropertyBeanCondition
 * 判断实际的Condition是否实现DynamicErrorCodeCondition, 如果实现则注入当前被校验的JAVABean
 * @author wb-dongtao
 * @version $Id: GlobalprodPropertyBeanCondition.java, v 0.1 2015-2-28 下午8:04:06 wb-dongtao Exp $
 */
public class GlobalprodPropertyBeanCondition extends PropertyBeanCondition {

    public GlobalprodPropertyBeanCondition(String propertyName, Condition propertyCondition) {
        super(propertyName, propertyCondition);
    }

    @Override
    protected boolean checkBean(BeanWrapper bean) {
        Condition propertyCondition = getPropertyCondition();
        if (propertyCondition instanceof ValidatedJavaBeanAware) {
            ValidatedJavaBeanAware decCondition = (ValidatedJavaBeanAware) propertyCondition;
            decCondition.setTargetBean(bean.getWrappedInstance());
        }
        return super.checkBean(bean);
    }
}
