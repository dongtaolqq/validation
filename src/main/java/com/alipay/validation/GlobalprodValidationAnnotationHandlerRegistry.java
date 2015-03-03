package com.alipay.validation;

import org.springmodules.validation.bean.conf.loader.annotation.DefaultValidationAnnotationHandlerRegistry;

import com.alipay.validation.handler.DynamicErrorCodeValidationAnnotationHandler;
import com.alipay.validation.handler.WithCheckServiceValidationAnnotationHandler;

/**
 * У��ע�⴦��ע����<br>
 * ��չ��ע�⴦�������������
 * @author wb-dongtao
 * @version $Id: GlobalprodValidationAnnotationHandlerRegistry.java, v 0.1 2015-3-2 ����10:39:18 wb-dongtao Exp $
 */
public class GlobalprodValidationAnnotationHandlerRegistry extends
                                                          DefaultValidationAnnotationHandlerRegistry {

    public GlobalprodValidationAnnotationHandlerRegistry() {
        super();
        registerPropertyHandler(new DynamicErrorCodeValidationAnnotationHandler());
        registerPropertyHandler(new WithCheckServiceValidationAnnotationHandler());
    }
}
