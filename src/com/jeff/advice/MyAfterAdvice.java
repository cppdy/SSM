package com.jeff.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
        System.out.println("执行后置通知");
        System.out.println("切点方法返回值:" + arg0);
        System.out.println("切点方法Method对象:" + arg1);
        for (int i = 0; i < arg2.length; i++) {
            System.out.println("切点方法参数" + i + ":" + arg2[i]);
        }
        System.out.println("切点方法所在类的对象:" + arg3);
    }
}
