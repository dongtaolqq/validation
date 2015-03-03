package com.alipay.validation.errcode.provider;

import com.alipay.model.Person;

public class PersonNameBlankErrorCodeProvider implements ErrorCodeProvider {

    @Override
    public String getErrorCode(Object targetBean) {
        Person person = (Person) targetBean;
        return person.getType().equals("1") ? "REGISTER_INFO_LICENSE_NUMBER_BANK"
            : "REGISTER_INFO_DOCUMENT_NUMBER_BANK";
    }

}
