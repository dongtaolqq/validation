package com.alipay.validation.condition;

/**
 * 获取validation框架层捕捉到的被校验Bean<br>
 * 目前应用于动态指定错误码
 * @author wb-dongtao
 * @version $Id: ValidatedJavaBeanAware.java, v 0.1 2015-2-28 下午7:53:05 wb-dongtao Exp $
 */
public interface ValidatedJavaBeanAware {
    /**
     * @param targetBean    被校验的JavaBean
     */
    void setTargetBean(Object targetBean);
}
