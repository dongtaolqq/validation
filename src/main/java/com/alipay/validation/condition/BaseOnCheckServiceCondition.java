package com.alipay.validation.condition;

import org.springframework.util.Assert;
import org.springmodules.validation.util.condition.AbstractCondition;

import com.alipay.context.ApplicationContextHolder;
import com.alipay.validation.service.ICheckService;

/**
 * ����CheckService������.
 * �����ṩ��beanName�����Ҷ�Ӧ��ICheckServiceʵ�����������жϹ���
 * @author wb-dongtao
 * @version $Id: BaseOnCheckServiceCondition.java, v 0.1 2015-3-3 ����11:07:14 wb-dongtao Exp $
 */
public class BaseOnCheckServiceCondition extends AbstractCondition {

    private String beanName;

    public BaseOnCheckServiceCondition(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public boolean doCheck(Object object) {

        ICheckService validationCheckService = (ICheckService) ApplicationContextHolder
            .getBean(beanName);

        Assert.notNull(validationCheckService);

        return validationCheckService.check(object);
    }
}
