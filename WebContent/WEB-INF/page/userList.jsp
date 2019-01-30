<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${path}/static/js/easyui/themes/icon.css">   
<script type="text/javascript" src="${path}/static/js/easyui/jquery.min.js"></script>   
<script type="text/javascript" src="${path}/static/js/easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="${path}/static/js/easyui/locale/easyui-lang-zh_CN.js"></script> 
<script type="text/javascript" src="${path}/static/js/user.js"></script> 
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
    <!-- 页面表格布局 -->
    <div data-options="region:'center',border:true" >
        <table id="grid" class="easyui-datagrid" 
        	data-options="
        	    url : 'dataGrid',//一个URL从远程站点请求数据
        	    fit : false,//自适应布局
	            striped : true,//是否显示斑马线效果
	            rownumbers : true,//如果为true，则显示一个行号列
	            pagination : true,//如果为true，则在DataGrid控件底部显示分页工具栏
	            singleSelect : true,//如果为true，则只允许选择一行
	            checkOnSelect: false,//如果为true，当用户点击行的时候该复选框就会被选中或取消选中
	            idField : 'id',//指明哪一个字段是标识字段
	            sortName : 'id',//定义哪些列可以进行排序
	            sortOrder : 'asc',//定义列的排序顺序，只能是'asc'或'desc'
	            pageSize : 5,//在设置分页属性的时候初始化页面大小 
	            pageList : [ 5, 10, 15, 20],//在设置分页属性的时候 初始化页面大小选择列表
        		toolbar: '#tb',//定义表头操作工具栏 
		        queryParams:$.serializeObject($('#searchForm')),//在请求远程数据的时候发送额外的参数
		        onLoadSuccess:function(row, data){loadSuccess_on(data)},//数据加载成功触发,无数据也返回 
		        method: 'post',//该方法类型请求远程数据
        		border:false">
				<thead>                                               
					<tr>        
						<th data-options="field:'loginName'" width="10%">登陆名</th>
					    <th data-options="field:'phone'" width="10%">手机号</th>
						<th data-options="field:'email'" width="10%">邮箱</th>
						<th data-options="field:'name'" width="5%">姓名</th>
						<th data-options="field:'birthday'" width="8%">出生日期</th>
						<th data-options="field:'sex',formatter:function(value,row,index){if(value==0){return '男';}else if(value==1){return '女';}}" width="5%">性别</th>
						<th data-options="field:'userType',formatter:function(value,row,index){if(value==0){return '普通用户';}else if(value==1){return '管理员';}else if(value==2){return '超级管理员';}}" width="5%">用户类别</th>
						<th data-options="field:'status',formatter:function(value,row,index){if(value==0){return '正常';}else if(value==1){return '停用';}else if(value==2){return '已删除';}}" width="5%">状态</th>
						<th data-options="field:'createTime'" formatter="formatter_time" width="10%">创建时间</th>
						<th data-options="field:'createdBy'" width="5%">创建人</th>
						<th data-options="field:'updateTime'" formatter="formatter_time" width="10%">修改时间</th>
						<th data-options="field:'updatedBy'" width="5%">修改人</th>
						<th data-options="field:'action'" formatter="formatter_button"  width="12%">操作</th>
					</tr>
				</thead>
		</table>
	</div>
	
    <!-- 页面表格操作菜单布局 -->  
	<div id="tb" style="height:auto">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		<!-- 页面搜索布局 -->
		<div id="searchPanel" class="easyui-panel" style="width:100%;padding:5px;" data-options="border:false,collapsible:true,collapsed:false">
		        <form id="searchForm" method="post" action="dataload">
					<div id="searchDiv" class="list_searchDiv">
						登陆名：<input class="easyui-textbox" style="width:150px;" name="loginName">&nbsp;&nbsp;
						姓名：<input class="easyui-textbox" style="width:150px;" name="name">&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="glyphicon-search" id="dataQuery" onclick="search_on()">搜索</a>
						<a href="javascript:void(0);" class="easyui-linkbutton"  iconCls="icon-clear"  id="clearQuery"   onclick="clean_on();">重置</a>
					</div>
				</form>
	     </div>
	     <!-- 页面工具栏操作按钮布局 -->
	     <div id="toolbar" class="list_toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add_on()">新增</a>
		</div>
	</div>
</div>
<!-- 弹出框布局 --> 
<div id="openWindow" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#footBar'"></div>
<div id="footBar" style="height:auto">
	<a href="javascript:void(0)" id="saveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:false" onclick="save_on()">保存</a>
	<a href="javascript:void(0)" id="closeBtn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="close_on()">关闭</a>
</div>
<div id="openWindowView" class="easyui-dialog" closed="true" data-options="iconCls:'icon-save',modal:true,buttons:'#footBarView'"></div>
<div id="footBarView" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false" onclick="closeWindowView_on()">关闭</a>
</div>
</body>
</html>