function loadSuccess_on(result) {
	$.parser.parse($('.easyui-linkbutton').parent());
	if (result) {
		if (!result.success) {
			$.messager.show({
				title : 'Error111',
				msg : result.msg
			});
		}
	}
}

// 点击搜索
function search_on() {
	$('#grid').datagrid({
		queryParams : $.serializeObject($('#searchForm'))
	});
}

// 重置
function clean_on() {
	$("#searchForm").form('clear');
	$('#grid').datagrid('reload', {});
}

function formatter_time(value, row, index) {
	var str="";
	if(value){
		var date=new Date(value);
		var year = date.getFullYear();
		var month = (date.getMonth() + 1)< 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var d = date.getDate()< 10 ? "0" + date.getDate() : date.getDate();
		var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
		str=year + "年" + month + "月" + d + "日 " + hour + ":" + minute + ":" + second;
	}
	return str;
}

function formatter_button(value, row, index) {
	var str = '';
	       str += '&nbsp;&nbsp;';
	       str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-search\',plain:true" onclick="view_on(\'{0}\')">查看</a>', row.mediaId);
	       str += '&nbsp;&nbsp;';
	       str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="edit_on(\'{0}\')">修改</a>', row.id);
           str += '&nbsp;&nbsp;';
           str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-cancel\',plain:true" onclick="del_on(\'{0}\');" >删除</a>', row.mediaId);
   	return str;
}

// 将form表单元素的值序列化成对象
$.serializeObject = function(form) {
    var o = {};
    $.each(form.serializeArray(), function(index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};

// 增加formatString功能,使用方法：$.formatString('字符串{0}','字符串{1}字符串','第一个变量','第二个变量');
$.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};