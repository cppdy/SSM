package com.jeff.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.commons.ActionType;
import com.jeff.commons.Result;
import com.jeff.entity.EasyUIDatagrid;
import com.jeff.entity.User;
import com.jeff.service.UserService;
import com.jeff.utils.ResultUtil;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("manager")
    public String manager() {

        return "/page/userList.jsp";
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public EasyUIDatagrid dataGrid(User user, int rows, int page) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        map.put("pageStart", rows * (page - 1));
        map.put("pageSize", rows);
        return userService.showPage(user, map);
    }

    @RequestMapping("addPage")
    public String addPage() {

        return "/page/userAdd.jsp";
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(User user) {
        user.setCreateTime(new Date());
        user.setCreatedBy("jeff");
        user.setUpdateTime(new Date());
        user.setUpdatedBy("jeff");

        boolean flag = userService.insUser(user);

        return ResultUtil.renderActionResult(flag, ActionType.ADD);
    }

    @RequestMapping("editPage")
    public String editPage(Model model, int id) throws ServletException, IOException {

        User user = userService.selUserById(id);
        model.addAttribute("user", user);

        return "/page/userEdit.jsp";
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(User user) {

        user.setUpdateTime(new Date());
        user.setUpdatedBy("jeff");

        boolean flag = userService.updUser(user);

        return ResultUtil.renderActionResult(flag, ActionType.EDIT);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(int id) {

        boolean flag = userService.delUser(id);

        return ResultUtil.renderActionResult(flag, ActionType.DELETE);
    }

    @RequestMapping("viewPage")
    public String viewPage(Model model, int id) {

        User user = userService.selUserById(id);
        model.addAttribute("user", user);
        return "/page/userView.jsp";
    }

}
