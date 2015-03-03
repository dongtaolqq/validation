package com.alipay.model;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import com.alipay.validation.annotation.ErrorCustomNotBlank;
import com.alipay.validation.annotation.WebBlackList;
import com.alipay.validation.errcode.ErrorCodeProviderEnum;

public class Person {
    @ErrorCustomNotBlank(errorCodeProvider = ErrorCodeProviderEnum.PERSON_NAME_BLANK, args = "5")
    @MaxLength(value = 5, errorCode = "errors", args = "5")
    @RegExp(value = "^[\u0020-\u007E]+$", applyIf = "this.name IS NOT BLANK")
    private String name;

    private String type;

    @WebBlackList(checkServiceName = "testCheckService")
    private int    count;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
