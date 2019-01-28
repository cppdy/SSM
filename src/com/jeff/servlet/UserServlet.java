package com.jeff.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.jeff.commons.ActionType;
import com.jeff.commons.Result;
import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.service.UserService;
import com.jeff.service.impl.UserServiceImpl;
import com.jeff.utils.ResultUtil;

@WebServlet("/user")
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
        String control = req.getParameter("control");

        if ("manager".equals(control)) {
            manager(req, resp);
        } else if ("dataGrid".equals(control)) {
            dataGrid(req, resp);
        } else if ("addPage".equals(control)) {
            addPage(req, resp);
        } else if ("add".equals(control)) {
            add(req, resp);
        } else if ("editPage".equals(control)) {
            editPage(req, resp);
        } else if ("edit".equals(control)) {
            edit(req, resp);
        } else if ("delete".equals(control)) {
            delete(req, resp);
        } else if ("viewPage".equals(control)) {
            viewPage(req, resp);
        }

    }

    private void manager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/userList.jsp").forward(req, resp);
    }

    private void dataGrid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginName = req.getParameter("loginName");
        String name = req.getParameter("name");
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

    private void addPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/page/userAdd.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginName = req.getParameter("loginName");
        int sex = Integer.parseInt(req.getParameter("sex"));
        int userType = Integer.parseInt(req.getParameter("userType"));
        int status = Integer.parseInt(req.getParameter("status"));
        String password = req.getParameter("password");
        String nickName = req.getParameter("nickName");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String birthdayStr = req.getParameter("birthday");
        String photoUrl = req.getParameter("photoUrl");

        if (nickName != null && !nickName.equals("")) {
            nickName = new String(nickName.getBytes("iso-8859-1"), "utf-8");
        }
        if (name != null && !name.equals("")) {
            name = new String(name.getBytes("iso-8859-1"), "utf-8");
        }

        User user = new User();
        user.setLoginName(loginName);
        user.setSex(sex);
        user.setUserType(userType);
        user.setStatus(status);
        user.setPassword(password);
        user.setNickName(nickName);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPhotoUrl(photoUrl);
        user.setCreateTime(new Date());
        user.setCreatedBy("jeff");
        user.setUpdateTime(new Date());
        user.setUpdatedBy("jeff");
        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
            user.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = userService.insUser(user);

        Result r = ResultUtil.renderActionResult(flag, ActionType.ADD);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(r);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    private void editPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.selUserById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/page/userEdit.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        String loginName = req.getParameter("loginName");
        int sex = Integer.parseInt(req.getParameter("sex"));
        int userType = Integer.parseInt(req.getParameter("userType"));
        int status = Integer.parseInt(req.getParameter("status"));
        String password = req.getParameter("password");
        String nickName = req.getParameter("nickName");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String birthdayStr = req.getParameter("birthday");
        String photoUrl = req.getParameter("photoUrl");

        if (nickName != null && !nickName.equals("")) {
            nickName = new String(nickName.getBytes("iso-8859-1"), "utf-8");
        }
        if (name != null && !name.equals("")) {
            name = new String(name.getBytes("iso-8859-1"), "utf-8");
        }

        User user = new User();
        user.setId(id);
        user.setLoginName(loginName);
        user.setSex(sex);
        user.setUserType(userType);
        user.setStatus(status);
        user.setPassword(password);
        user.setNickName(nickName);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPhotoUrl(photoUrl);
        user.setUpdateTime(new Date());
        user.setUpdatedBy("jeff");
        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
            user.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = userService.updUser(user);

        Result r = ResultUtil.renderActionResult(flag, ActionType.EDIT);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(r);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean flag = userService.delUser(id);

        Result r = ResultUtil.renderActionResult(flag, ActionType.DELETE);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(r);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    private void viewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.selUserById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/page/userView.jsp").forward(req, resp);
    }

}
