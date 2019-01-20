package com.jeff.test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jeff.entity.User;

public class Test {

    public static void main(String[] args) throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        // 使用工厂设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 生产SqlSession
        SqlSession session = factory.openSession();

        // --------------------------适用于查询结果都需要遍历的需求-----------------------
        List<User> list = session.selectList("a.b.selAll");
        System.out.println("适用于查询结果都需要遍历的需求");
        for (User flower : list) {
            System.out.println(flower.toString());
        }

        // --------------------------适用于返回结果只是变量或一行数据时-----------------------
        User user = session.selectOne("a.b.selById", 1);
        System.out.println("适用于返回结果只是变量或一行数据时");
        System.out.println(user);

        // --------------------------适用于需要在查询结果中通过某列的值取到这行数据的需求-----------------------
        Map<Object, Object> map = session.selectMap("a.b.selAll", "id");
        System.out.println("适用于需要在查询结果中通过某列的值取到这行数据的需求");
        System.out.println(map);

        session.close();
    }

}
