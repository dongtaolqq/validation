package com.alipay.validation.condition;

/**
 * ��ȡvalidation��ܲ㲶׽���ı�У��Bean<br>
 * ĿǰӦ���ڶ�ָ̬��������
 * @author wb-dongtao
 * @version $Id: ValidatedJavaBeanAware.java, v 0.1 2015-2-28 ����7:53:05 wb-dongtao Exp $
 */
public interface ValidatedJavaBeanAware {
    /**
     * @param targetBean    ��У���JavaBean
     */
    void setTargetBean(Object targetBean);
}
