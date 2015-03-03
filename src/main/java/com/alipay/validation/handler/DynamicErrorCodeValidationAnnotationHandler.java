package com.alipay.validation.handler;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;

import org.springmodules.validation.bean.conf.MutableBeanValidationConfiguration;
import org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler;
import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.bean.rule.NotBlankValidationRule;
import org.springmodules.validation.bean.rule.RegExpValidationRule;
import org.springmodules.validation.bean.rule.resolver.ErrorArgumentsResolver;
import org.springmodules.validation.util.condition.Condition;

import com.alipay.validation.annotation.ErrorCustomNotBlank;
import com.alipay.validation.annotation.ErrorCustomRegExp;
import com.alipay.validation.errcode.provider.ErrorCodeProvider;
import com.alipay.validation.rule.GlobalprodPropertyValidationRule;
import com.alipay.validation.rule.wrapper.DynamicErrorCodeValidationRuleImpl;

/**
 * ֧�ֶ�̬�������ע�����Ҫ��errorCodeProviderֵ
 * 
 * @author wb-dongtao
 * @version $Id: DynamicErrorCodeValidationAnnotationHandler.java, v 0.1 2015-2-28 ����9:35:52 wb-dongtao Exp $
 */
public class DynamicErrorCodeValidationAnnotationHandler extends
                                                        AbstractPropertyValidationAnnotationHandler {

    public DynamicErrorCodeValidationAnnotationHandler() {
        super(ErrorCustomNotBlank.class, ErrorCustomRegExp.class);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected AbstractValidationRule createValidationRule(Annotation annotation, Class clazz,
                                                          String propertyName) {
        AbstractValidationRule ruleWrapper = null;
        AbstractValidationRule actualRule = null;
        ErrorCodeProvider errorCodeProvider = null;
        try {
            if (ErrorCustomNotBlank.class.isInstance(annotation)) {
                ErrorCustomNotBlank enb = (ErrorCustomNotBlank) annotation;
                errorCodeProvider = enb.errorCodeProvider().getCodeProvider();
                actualRule = new NotBlankValidationRule();
            }
            if (ErrorCustomRegExp.class.isInstance(annotation)) {
                ErrorCustomRegExp ere = (ErrorCustomRegExp) annotation;
                errorCodeProvider = ere.errorCodeProvider().getCodeProvider();
                actualRule = new RegExpValidationRule(ere.value());
            }
            ruleWrapper = new DynamicErrorCodeValidationRuleImpl(errorCodeProvider, actualRule);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ruleWrapper;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void handleAnnotation(Annotation annotation, Class clazz, PropertyDescriptor descriptor,
                                 MutableBeanValidationConfiguration configuration) {
        AbstractValidationRule rule = createValidationRule(annotation, clazz, descriptor.getName());

        String errorCode = extractErrorCode(annotation);
        if (errorCode != null) {
            rule.setErrorCode(errorCode);
        }

        String message = extractDefaultMessage(annotation);
        if (message != null) {
            rule.setDefaultErrorMessage(message);
        }

        ErrorArgumentsResolver argumentsResolver = extractArgumentsResolver(annotation);
        if (argumentsResolver != null) {
            rule.setErrorArgumentsResolver(argumentsResolver);
        }

        Condition applicabilityCondition = extractApplicabilityContidion(annotation);
        if (applicabilityCondition != null) {
            rule.setApplicabilityCondition(applicabilityCondition);
        }

        String[] applicableContexts = extractApplicableContexts(annotation);
        if (applicableContexts != null) {
            rule.setContextTokens(applicableContexts);
        }

        if (isConditionGloballyScoped(annotation)) {
            configuration.addPropertyRule(descriptor.getName(), rule);
        } else {
            // Ϊ�ѱ�У��Bean���ݸ� ValidationRule, �����滻ΪExtPropertyValidationRule
            GlobalprodPropertyValidationRule propertyRule = new GlobalprodPropertyValidationRule(
                descriptor.getName(), rule);

            if (applicabilityCondition != null) {
                propertyRule.setApplicabilityCondition(applicabilityCondition);
            }

            configuration.addPropertyRule(descriptor.getName(), propertyRule);
        }
    }
}
