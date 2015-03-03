package com.alipay.validation.rule.wrapper;

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

import com.alipay.validation.condition.DynamicErrorCodeCondition;
import com.alipay.validation.errcode.provider.ErrorCodeProvider;
import com.alipay.validation.rule.DynamicErrorCodeValidationRule;

/**
 * ��̬������У�����ʵ����, ������һ����װ������������һ���������ṩ�������ã�һ��Ҫ����ʵ��У���actualRule<br>
 * ʵ��DynamicErrorCodeValidationRuleΪ�˸��ݱ�У��Bean������״̬��ָ̬�� actualRule �Ĵ�����
 * @author wb-dongtao
 * @version $Id: DynamicErrorCodeValidationRuleImpl.java, v 0.1 2015-2-28 ����7:57:01 wb-dongtao Exp $
 */
public class DynamicErrorCodeValidationRuleImpl extends AbstractValidationRule implements
                                                                              DynamicErrorCodeValidationRule {

    /** �������ṩ�� */
    private ErrorCodeProvider      errorCodeProvider;
    /** ʵ�ʵ�У�������� */
    private AbstractValidationRule actualRule;

    public DynamicErrorCodeValidationRuleImpl(ErrorCodeProvider errorCodeProvider,
                                              AbstractValidationRule actualRule) {
        super(actualRule.getErrorCode());
        this.errorCodeProvider = errorCodeProvider;
        this.actualRule = actualRule;
    }

    @Override
    public Condition getCondition() {
        return new DynamicErrorCodeCondition(this);
    }

    @Override
    public String getErrorCode() {
        return actualRule.getErrorCode();
    }

    @Override
    public void updateErrorCode(Object targetBean) {
        String errorCode = errorCodeProvider.getErrorCode(targetBean);
        actualRule.setErrorCode(errorCode);
    }

    @Override
    public AbstractValidationRule getActualRule() {
        return this.actualRule;
    }
}
