package com.alipay.validation.errcode.provider;

/**
 * validation i18n �������ṩ�ӿ�
 * 
 * @author wb-dongtao
 * @version $Id: ErrorCodeProvider.java, v 0.1 2015-2-28 ����8:15:36 wb-dongtao Exp $
 */
public interface ErrorCodeProvider {
    String getErrorCode(Object targetBean);
}
