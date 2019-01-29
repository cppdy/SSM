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

//新增
function add_on() {	
	var url = 'addPage';
	//如采用默认宽度和高度,参数设置为undefined
	var width=850;
	var height=520;
	$('#saveBtn').show();
	$.showOpenWindow($('#openWindow'),'新增页面', 'icon-add', url, width, height, true,false, false);
}

//提交保存
function save_on() {
	var fm = $('#detailIframe')[0].contentWindow.$('#detailForm');
	fm.form('submit', {
		onSubmit : function() {
			 progressLoad();
             var isValid = fm.form('validate');
             if (!isValid) {
                 progressClose();
             }
             return isValid;
		},
		success : function(data) {
			progressClose();
			var result = $.parseJSON(data);
			if (result.success) {
				$.messager.show( {
					title : '提示',
					msg : result.msg,
					showType:'show'
				});
				$('#openWindow').dialog('close');        				
				$('#grid').datagrid('reload');
				
			} else {
				$.messager.show( {
						title : '错误',
						msg : result.msg,
						width:'300px',
						height:'150px',
						timeout:0,
						showType:'show'
				});
			}
		}
	});
}

//删除
function del_on(pkid) {
    if (pkid != undefined) {
    	$.messager.confirm('询问', '您是否要删除用户信息吗？', function(b) {
            if (b) {
                progressLoad();
                $.post('delete', {
                	id : pkid
                }, function(result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        $.messager.alert('提示', result.msg, 'info');
                        $('#grid').datagrid('reload');   
                    }else{
                        $.messager.alert('提示', result.msg, 'info');
                    }
                    progressClose();
                }, 'text');
            }
        });
    } else {
		$.messager.alert('提示', '删除的记录为空或不存在！');
	}
}

// 编辑
function edit_on(pkid) {
    if (pkid != undefined) {
     // 选中记录
     $('#grid').datagrid('getSelected', pkid);
   	 var url = 'editPage?id=' + pkid;
		// 如采用默认宽度和高度,参数设置为undefined
	   	var width=850;
		var height=520;
		$('#saveBtn').show();
		$.showOpenWindow($('#openWindow'),'编辑页面', 'icon-edit', url, width, height, true,false, false);  	 
    } else {
		$.messager.alert('提示', '编辑的记录为空或不存在！');
	}
}

//查看
function view_on(pkid) {
  if (pkid != undefined) {
   // 选中记录
   $('#grid').datagrid('getSelected', pkid);
 	 var url = 'viewPage?id=' + pkid;
		// 如采用默认宽度和高度,参数设置为undefined
		var width=850;
		var height=520;
		$('#saveBtn').show();
		$.showOpenWindow($('#openWindowView'),'查看页面', 'icon-search', url, width, height, true, false, false);  	 
  } else {
		$.messager.alert('提示', '查看的记录为空或不存在！');
	}
}

//关闭窗口
function close_on() {
	$('#openWindow').dialog('close');
}

//关闭窗口
function closeWindowView_on() {
	$('#openWindowView').dialog('close');
	search_on();
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
	       str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-search\',plain:true" onclick="view_on(\'{0}\')">查看</a>', row.id);
	       str += '&nbsp;&nbsp;';
	       str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="edit_on(\'{0}\')">修改</a>', row.id);
           str += '&nbsp;&nbsp;';
           str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-cancel\',plain:true" onclick="del_on(\'{0}\');" >删除</a>', row.id);
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

$.showOpenWindow = function showOpenWindow(optWindow, title, iconCls, href,width, height, modal, minimizable, maximizable) {
	var winWidth = (width === undefined ? 600 : width);
	var winHeight = (height === undefined ? 400 : height);
	if ($.showOpenWindow.handler == undefined) {
		// 避免重复弹出
		$.showOpenWindow.handler = optWindow.dialog({
				title : title,
				iconCls : iconCls,
				width : winWidth,
				height : winHeight,
				top : ($(window).height() - winHeight) * 0.5,
				left : ($(window).width() - winWidth) * 0.5,
				content : '<iframe scrolling="yes" frameborder="0" id="detailIframe" src="'+href+'" style="width:100%;height:98%;"></iframe>',
				modal : modal === undefined ? true : modal,
				minimizable : minimizable === undefined ? false : minimizable,
				maximizable : maximizable === undefined ? false : maximizable,
				shadow : true,
				cache : false,
				closed : false,
				draggable : true,
				collapsible : false,
				resizable : false,
				loadingMessage : '正在加载数据，请稍等片刻......',
				onClose : function() {
					$.showOpenWindow.handler = undefined;
				}
			});
	}
}

// 页面加载加载进度条启用
function progressLoad(){  
    $("<div class=\"datagrid-mask\" style=\"position:absolute;z-index: 9999;\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");  
    $("<div class=\"datagrid-mask-msg\" style=\"position:absolute;z-index: 9999;\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});  
}

// 页面加载加载进度条关闭
function progressClose(){
    $(".datagrid-mask").remove();  
    $(".datagrid-mask-msg").remove();
}