<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>博主注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.validate.js"></script>
<style type="text/css">
	body{
		padding-top:30px;
		padding-bottom:40px;
		padding-left:60px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
	.txt{
		line-height: 16px;
	}
	
	.txt-tips{
		color:#999;
	}
	
	button{
		color:red;
	}
	
	#form1 label.error{
		color:red;
	}
	
	#sub{
		height:40px;
		width:70px;
		color:green;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#form1").validate({
			rules:{
				username:"required",
				nickname:"required",
				password:{
					required:true,
					minlength:6,
					maxlength:18
				},
				passwordConfirm:{
					required:true,
					equalTo:"#password"
				},
				imageCode:"required"
			},
			messages:{
				username:"请填写用户名",
				nickname:"请填写昵称",
				password:{
					required:"请填写密码",
					minlength:jQuery.format("密码长度不少于{0}位"),
					maxlength:jQuery.format("密码长度不超过{0}位")
				},
				passwordConfirm:{
					required:"请再次确认密码",
					equalTo:"密码不一致"
				},
				imageCode:"请填写验证码"
			}
		});
	});
	
	function loadimage(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}
	
	$(function(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
	});
</script>
</head>
<body>
	<div align="left">
		<img height="80" width="100"  src="${pageContext.request.contextPath }/static/images/register.jpeg"/>
		<h3 color="red" size="5">SSM博客系统 ●博主注册</h3>
	</div>
	
	<div align="center">
		<form id="form1" action="${pageContext.request.contextPath }/blogger/insert.action" method="post">
			<table border="0" align="center">
			<tr>
				<th>博主姓名：</th>
				<td><input id="username" name="username" type="text"/></td>
			</tr>
			<tr>
				<th>博主昵称：</th>
				<td><input id="nickname" name="nickname" type="text"/></td>
			</tr>
			<tr>
				<th>密码：</th>
				<td><input id="password" name="password" type="password"/></td>
				<td>
					<div id="txt">
						<span class="txt-tips">6~18个字符，区分大小写</span><br/>
					</div>
				</td>
			</tr>
			<tr>
				<th>确认密码：</th>
				<td><input id="passwordConfirm" name="passwordConfirm" type="password"/></td>
				<td>
					<div id="txt">
						<span class="txt-tips">请再次填写密码</span><br/>
					</div>
				</td>
			</tr>
				<tr>
				<th>验证码：</th>
				<td>
					<input type="text" value="" name="imageCode" id="imageCode"
					onkeydown="if(event.keyCode==13)form1.submit()" />
					
				</td>
				<td>
					<img onclick="javascript:loadimage();" title="换一张试试" name="randImage"
					id="randImage" src="/image.jsp" width="60" height="20" border="1"
					align="absmiddle"><span><font color="red">${requestScope.msg}</font></span>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">	
					<input id="sub" type="submit" value="注册"/>
				</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>