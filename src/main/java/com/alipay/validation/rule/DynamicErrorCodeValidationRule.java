package com.alipay.validation.rule;

import org.springmodules.validation.bean.rule.AbstractValidationRule;

/**
 * �ӿ��ṩ���µ�ǰУ�����Ĵ�����
 * @author wb-dongtao
 * @version $Id: DynamicErrorCodeValidationRule.java, v 0.1 2015-2-28 ����7:55:47 wb-dongtao Exp $
 */
public interface DynamicErrorCodeValidationRule {
    /**
     * ���´�����, Condition��ص��Ľӿڷ������ṩ��У���JAVABean
     * @param targetBean    ��У��JavaBean
     */
    void updateErrorCode(Object targetBean);

    /**
     * Condition��ص��Ľӿڷ���, �ṩʵ����У���ValidationRule
     * @return
     */
    AbstractValidationRule getActualRule();
}
