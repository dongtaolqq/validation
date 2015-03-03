package com.alipay.validation.errcode;

import com.alipay.validation.errcode.provider.ErrorCodeProvider;
import com.alipay.validation.errcode.provider.PersonNameBlankErrorCodeProvider;

/**
 * ������Providerö��
 * @author wb-dongtao
 * @version $Id: ErrorCodeProviderEnum.java, v 0.1 2015-3-2 ����2:21:22 wb-dongtao Exp $
 */
public enum ErrorCodeProviderEnum {

    PERSON_NAME_BLANK(new PersonNameBlankErrorCodeProvider());

    private ErrorCodeProvider codeProvider;

    private ErrorCodeProviderEnum(ErrorCodeProvider codeProvider) {
        this.codeProvider = codeProvider;
    }

    public ErrorCodeProvider getCodeProvider() {
        return codeProvider;
    }
}
