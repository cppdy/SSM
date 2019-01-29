<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/color.css"> 
<link rel="stylesheet" type="text/css" href="${path}/static/css/common.css">
<link rel="stylesheet" type="text/css" href="${path}/static/css/icon.css">
<script type="text/javascript" src="${path}/static/js/easyui/jquery.min.js"></script>   
<script type="text/javascript" src="${path}/static/js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="${path}/static/js/easyui/locale/easyui-lang-zh_CN.js"></script> 
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="detailForm" name="detailForm" action="add" method="post">
            <table class="grid">
                <tr>
                    <td>
                    	<label class="form_label">登录名</label>
                    </td>
                    <td>
                    	<input name="loginName"  class="easyui-validatebox" prompt="请输入登录名" data-options="required:true" style="width: 250px;height: 25px;">
                    </td>
                    <td>
                    	<label class="form_label">性别</label>
                    </td>
                    <td>
                    	<select name="sex" class="easyui-combobox" data-options="width:250,height:25,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">男</option>
                            <option value="1">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<label class="form_label">用户类别</label>
                    </td>
                    <td>
                    	<select name="userType" class="easyui-combobox" data-options="width:250,height:25,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">普通用户</option>
                            <option value="1">管理员</option>
                            <option value="2">超级管理员</option>
                        </select>
                    </td>
                    <td>
                    	<label class="form_label">用户状态</label>
                    </td>
                    <td>
                    	<select name="status" class="easyui-combobox" data-options="width:250,height:25,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">正常</option>
                            <option value="1">停用</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<label class="form_label">密码</label>
                    </td>
                    <td>
                    	<input id="password" name="password" prompt="请输入密码" class="easyui-passwordbox" data-options="required:true" style="width: 250px;height: 25px;"/>
                    </td>
                    <td>
                    	<label class="form_label">确认密码</label>
                    </td>
                    <td>
                    	<input id="confirmPassword" name="confirmPassword" prompt="请输入确认密码" class="easyui-passwordbox" data-options="required:true" style="width: 250px;height: 25px;"/>
                    </td>
                </tr>
                
                <tr>
                    <td>
                    	<label class="form_label">出生日期</label>
                    </td>
                    <td>
                    	<input id="birthday" name="birthday" class="easyui-datebox" style="width: 250px;height: 25px;"/>
                    </td>
                    <td>
                    	<label class="form_label">个人头像</label>
                    </td>
                    <td>
                        <input name="photoUrl" class="easyui-validatebox" style="width: 250px;height: 25px;"/>
                    </td>
                </tr>
                
                <tr>
                    <td>
                    	<label class="form_label">昵称</label>
                    </td>
                    <td>
                    	<input name="nickName"  class="easyui-validatebox" style="width: 250px;height: 25px;">
                    </td>
                    <td>
                    	<label class="form_label">姓名</label>
                    </td>
                    <td>
                    	<input name="name"  class="easyui-validatebox" style="width: 250px;height: 25px;">
                    </td>
                </tr>
                
                <tr>
                	<td>
                    	<label class="form_label">手机号</label>
                    </td>
                    <td>
                    	<input name="phone" class="easyui-validatebox" style="width: 250px;height: 25px;"/>
                    </td>
                    <td>
                    	<label class="form_label">邮箱</label>
                    </td>
                    <td>
                    	<input name="email"  class="easyui-validatebox" style="width: 250px;height: 25px;">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>