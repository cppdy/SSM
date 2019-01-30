<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <form id="detailForm" name="detailForm" action="" method="post">
            <table class="grid">
                <tr style="height: 36px;">
                    <td>
                    	<label class="form_label">登录名</label>
                    </td>
                    <td>
                    	${user.loginName}
                    </td>
                    <td>
                    	<label class="form_label">性别</label>
                    </td>
                    <td>
                    	<c:if test="${user.sex==0}">
                    		男
					   	</c:if>
					   	<c:if test="${user.sex==1}">
                    		 女
					   	</c:if>
                    </td>
                </tr>
                <tr style="height: 36px;">
                    <td>
                    	<label class="form_label">用户类别</label>
                    </td>
                    <td>
                    	<c:if test="${user.userType==0}">
                    		普通用户
					   	</c:if>
					   	<c:if test="${user.userType==1}">
                    		 管理员
					   	</c:if>
					   	<c:if test="${user.userType==2}">
                    		超级管理员
					   	</c:if>
                    </td>
                    <td>
                    	<label class="form_label">用户状态</label>
                    </td>
                    <td>
                    	<c:if test="${user.status==0}">
                    		正常
					   	</c:if>
					   	<c:if test="${user.status==1}">
                    		 停用
					   	</c:if>
					   	<c:if test="${user.status==2}">
                    		已删除
					   	</c:if>
                    </td>
                </tr>
                <tr style="height: 36px;">
                    <td>
                    	<label class="form_label">出生日期</label>
                    </td>
                    <td>
                    	${user.birthday}
                    </td>
                    <td>
                    	<label class="form_label">个人头像</label>
                    </td>
                    <td>
                        ${user.photoUrl}
                    </td>
                </tr>
                
                <tr>
                    <td>
                    	<label class="form_label">昵称</label>
                    </td>
                    <td>
                    	${user.nickName}
                    </td>
                    <td>
                    	<label class="form_label">姓名</label>
                    </td>
                    <td>
                    	${user.name}
                    </td>
                </tr>
                
                <tr style="height: 36px;">
                	<td>
                    	<label class="form_label">手机号</label>
                    </td>
                    <td>
                    	${user.phone}
                    </td>
                    <td>
                    	<label class="form_label">邮箱</label>
                    </td>
                    <td>
                    	${user.email}
                    </td>
                </tr>
                
                <tr style="height: 36px;">
                	<td>
                    	<label class="form_label">创建时间</label>
                    </td>
                    <td>
                    	<fmt:formatDate value="${user.createTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />
                    </td>
                    <td>
                    	<label class="form_label">创建人</label>
                    </td>
                    <td>
                    	${user.createdBy}
                    </td>
                </tr>
                
                <tr style="height: 36px;">
                	<td>
                    	<label class="form_label">修改时间</label>
                    </td>
                    <td>
                    	<fmt:formatDate value="${user.updateTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />
                    </td>
                    <td>
                    	<label class="form_label">修改人</label>
                    </td>
                    <td>
                    	${user.updatedBy}
                    </td>
                </tr>
                
            </table>
        </form>
    </div>
</div>
</body>
</html>