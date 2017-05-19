<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>私信管理页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function deleteWord() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的私信");
			return;
		}
		var idsStr = [];
		for(var i = 0; i < selectedRows.length; i++) {
			idsStr.push(selectedRows[i].id);
		}
		var ids = idsStr.join(","); //1,2,3,4
		$.messager.confirm("系统提示", "<font color=red>您确定要删除选中的这"+selectedRows.length+"条私信么？</font>", function(r) {
			if(r) {
				$.post("${pageContext.request.contextPath}/chat/deleteList.action",
						{ids: ids}, function(result){
							if(result>0) {
								$.messager.alert("系统提示", "私信删除成功！");
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("系统提示", "私信删除失败！");
							}
						}, "json");
			}
		});
	}
	
</script>

</head>
<body style="margin: 1px; font-family: microsoft yahei">
	<table id="dg" title="私信管理" class="easyui-datagrid" fitColumns="true" pagination="true"
		url="${pageContext.request.contextPath}/chat/findAll.action?bloggerId=${sessionScope.blogger.id}" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="20" align="center">编号</th>
				<th field="userIp" width="50" align="center">用户的IP</th> 
				<th field="content" width="200" align="center">私信内容</th> 
				<th field="chatDate" width="50" align="center">私信日期</th>
			</tr>
		</thead>
	</table>
	<div id="tb"> 
		<div>
			<a href="javascript:deleteWord()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">删除</a> 	
			<a href="javascript:reload()" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>	
		</div>
	</div>
</body>
</html>