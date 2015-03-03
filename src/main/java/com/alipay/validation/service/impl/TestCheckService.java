package com.alipay.validation.service.impl;

import org.apache.commons.lang.ArrayUtils;

import com.alipay.validation.service.ICheckService;

public class TestCheckService implements ICheckService {

    private int default_lenth[] = { 0, 1, 2 };

    @Override
    public boolean check(Object obj) {
        return ArrayUtils.contains(default_lenth, Integer.parseInt(obj.toString()));
    }
}
