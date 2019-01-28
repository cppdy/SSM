package com.jeff.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("执行前置通知");
        System.out.println("切点方法Method对象:" + arg0);
        for (int i = 0; i < arg1.length; i++) {
            System.out.println("切点方法参数" + i + ":" + arg1[i]);
        }
        System.out.println("切点方法所在类的对象:" + arg2);
    }
}
