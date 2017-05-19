<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.2.js"></script>
<title>博客主页</title>

<script type="text/javascript">
	$(function(){
		$("#login").onclick=function(){
			alert(11);
		};
	});
</script>
</head>

<body>
	
	<input id="btn" type="button" value="111"/>
	
	<script type="text/javascript">
		$("#btn").click(function(){
			alert(111);
		});
	</script>
</body>
</html>
