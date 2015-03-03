package com.alipay.validation.rule.wrapper;

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

import com.alipay.validation.condition.DynamicErrorCodeCondition;
import com.alipay.validation.errcode.provider.ErrorCodeProvider;
import com.alipay.validation.rule.DynamicErrorCodeValidationRule;

/**
 * 动态错误码校验规则实现类, 此类是一个包装，其中引用了一个错误码提供对象引用，一个要进行实际校验的actualRule<br>
 * 实现DynamicErrorCodeValidationRule为了根据被校验Bean的属性状态动态指定 actualRule 的错误码
 * @author wb-dongtao
 * @version $Id: DynamicErrorCodeValidationRuleImpl.java, v 0.1 2015-2-28 下午7:57:01 wb-dongtao Exp $
 */
public class DynamicErrorCodeValidationRuleImpl extends AbstractValidationRule implements
                                                                              DynamicErrorCodeValidationRule {

    /** 错误码提供者 */
    private ErrorCodeProvider      errorCodeProvider;
    /** 实际的校验规则对象 */
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
