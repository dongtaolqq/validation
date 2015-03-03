package com.alipay.validation.handler;

import java.lang.annotation.Annotation;

import org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler;
import org.springmodules.validation.bean.rule.AbstractValidationRule;

import com.alipay.validation.annotation.WebBlackList;
import com.alipay.validation.rule.WebBlackListValidationRule;

/**
 * 支持动态错误码和checkService的注解必须要有 checkService值
 * @author wb-dongtao
 * @version $Id: WithCheckServiceValidationAnnotationHandler.java, v 0.1 2015-3-2 下午5:32:18 wb-dongtao Exp $
 */
public class WithCheckServiceValidationAnnotationHandler extends
                                                        AbstractPropertyValidationAnnotationHandler {

    public WithCheckServiceValidationAnnotationHandler() {
        super(WebBlackList.class);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected AbstractValidationRule createValidationRule(Annotation annotation, Class clazz,
                                                          String propertyName) {
        String checkServiceName = "";
        if (WebBlackList.class.isInstance(annotation)) {
            WebBlackList webBlackList = (WebBlackList) annotation;
            checkServiceName = webBlackList.checkServiceName();
        }
        return new WebBlackListValidationRule(checkServiceName);
    }
}
