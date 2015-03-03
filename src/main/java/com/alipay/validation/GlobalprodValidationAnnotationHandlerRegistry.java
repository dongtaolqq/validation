package com.alipay.validation;

import org.springmodules.validation.bean.conf.loader.annotation.DefaultValidationAnnotationHandlerRegistry;

import com.alipay.validation.handler.DynamicErrorCodeValidationAnnotationHandler;
import com.alipay.validation.handler.WithCheckServiceValidationAnnotationHandler;

/**
 * 校验注解处理注册器<br>
 * 扩展的注解处理器在这里添加
 * @author wb-dongtao
 * @version $Id: GlobalprodValidationAnnotationHandlerRegistry.java, v 0.1 2015-3-2 上午10:39:18 wb-dongtao Exp $
 */
public class GlobalprodValidationAnnotationHandlerRegistry extends
                                                          DefaultValidationAnnotationHandlerRegistry {

    public GlobalprodValidationAnnotationHandlerRegistry() {
        super();
        registerPropertyHandler(new DynamicErrorCodeValidationAnnotationHandler());
        registerPropertyHandler(new WithCheckServiceValidationAnnotationHandler());
    }
}
