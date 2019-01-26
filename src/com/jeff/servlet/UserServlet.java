package com.jeff.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.service.UserService;
import com.jeff.service.impl.UserServiceImpl;

@WebServlet("/show")
public class UserServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        // 对service实例化
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // spring和web整合后所有信息都存放在webApplicationContext
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = ac.getBean("userService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        /*
         * if (loginName != null && !loginName.equals("")) { loginName = new
         * String(loginName.getBytes("iso-8859-1"), "utf-8"); }
         */
        String name = req.getParameter("name");
        /*
         * if (name != null && !name.equals("")) { name = new String(name.getBytes("iso-8859-1"), "utf-8");
         * }
         */
        int pageSize = Integer.parseInt(req.getParameter("rows"));
        int pageNumber = Integer.parseInt(req.getParameter("page"));
        User user = new User();
        user.setLoginName(loginName);
        user.setName(name);
        Map<String, Integer> map = new HashMap<>();
        map.put("pageStart", pageSize * (pageNumber - 1));
        map.put("pageSize", pageSize);
        EasyUIDatagrid datagrid = userService.showPage(user, map);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(datagrid);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

}
