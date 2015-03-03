package com.alipay.validation.condition;

import org.springframework.beans.BeanWrapper;
import org.springmodules.validation.util.condition.Condition;
import org.springmodules.validation.util.condition.bean.PropertyBeanCondition;

/**
 * ��չPropertyBeanCondition
 * �ж�ʵ�ʵ�Condition�Ƿ�ʵ��DynamicErrorCodeCondition, ���ʵ����ע�뵱ǰ��У���JAVABean
 * @author wb-dongtao
 * @version $Id: GlobalprodPropertyBeanCondition.java, v 0.1 2015-2-28 ����8:04:06 wb-dongtao Exp $
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
