package com.jeff.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jeff.entity.User;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ac.getBean("user", User.class);
        System.out.println(user);
        // Spring 容器中目前管理的所有对象
        String[] names = ac.getBeanDefinitionNames();
        for (String string : names) {
            System.out.println(string);
        }
    }

}
