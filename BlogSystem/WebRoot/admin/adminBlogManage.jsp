<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>博客管理页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
.searchbox{
	margin:-3
}
</style>
<script type="text/javascript">
	function formatBlogTitle(val,row) {
		if(val == null) {
			return "<font color=red>该博客已删除</font>";
		} else {
			return "<a href='${pageContext.request.contextPath }/blog/findBlogById.action?id="+val.id+"' target='_blank'>"+val.title+"</a>";
		}
	}

	$(function(){
	
			$('#dg').datagrid({    
			    url:'${pageContext.request.contextPath}/blog/selectPage.action', 
			    fitColumns:true,
			    nowrapL:true,
			    idField:'id',
			    rownumbers:true,
			    pagination:true,
			    pageSize:2,
			    pageList:[2,5,10,20],
			    
			    queryParams: {
					keyWord: '%%'
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						//alert('删除按钮');
						var array=$("#dg").datagrid("getSelections");
						//alert(array.length);
						if(array.length>0){
							var ids=new Array();
							for(var i=0;i<array.length;i++){
								ids[i]=array[i].id;
							}
							$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    						if (r){    
							        $.ajax({
							        	url:"${pageContext.request.contextPath}/blog/deleteList.action",
							        	type:"post",
							        	traditional:true,
							        	data:{pks:ids},
							        	success:function(html){			
							        		$("#dg").datagrid("reload");
							        		$("#dg").datagrid("clearSelections");
							        	},
							        	error:function(XMLHttpRequest, textStatus, errorThrown){
							        		$.messager.alert('删除错误','请联系管理员！','error');
							        	},
							        	dataType:'json'
							        });  
							     }
							});
						}else{
					     	alert("请选择要删除的记录");
						}
					}
				},'-',{
					text:"<input type='text' id='title' name='title'/>",					
				},'-',{
					iconCls: 'icon-refresh',
					text:'刷新',	
					handler: function(){
						$('#title').searchbox("setValue","");
						$('#dg').datagrid('load',{
						keyWord:'%'+""+'%'
					});
					}			
				}],
	
				columns : [ [{
					checkbox:true,
				}, {
				field : 'id',
				title : '编号',
				width : 100
			}, {
				field : 'title',
				title : '标题',
				width : 100,
				formatter: function(val,row,index){
					if(val == null) {
						return "<font color=red>该博客已删除</font>";
					} else {
						return "<a href='${pageContext.request.contextPath }/blog/findBlogById.action?id="+row.id+"' target='_blank'>"+val+"</a>";
					}
				}	
			}, {
				field : 'releasedate',
				title : '发布日期',
				width : 100
			},{
				field : 'blogType',
				title : '博客类型',
				width : 100,
				formatter: function(val,row,index){
					return val.typename;
				}	
			} ] ]
		});
		
		$('#title').searchbox({ 
			searcher:function(value,name){ 
				//alert(value + "," + name); 
				$("#dg").datagrid('load',{
					keyWord: '%'+value+'%'				
				});		
			}, 			
			prompt:'请输入博客标题' 
		}); 

	});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</body>
</html>
