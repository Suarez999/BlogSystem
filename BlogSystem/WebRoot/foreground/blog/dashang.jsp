<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>赞赏</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.8.2.js"></script>
<style type="text/css">
	body{
		padding-top:30px;
		padding-bottom:40px;
		padding-left:60px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
	#div3{
		margin-top: 50px;
	}
	button{
		height: 60px;
		width:100px;
		
	}
</style>
</head>
<body>
	<div align="left">
		<img height="80" width="100"  src="${pageContext.request.contextPath }/static/images/shang.jpeg"/>
		<h3 color="red" size="5">SSM博客系统 ● 赞赏</h3>
		
	</div>
	<div align="center">
		<img height="80" width="100" src="${pageContext.request.contextPath }/static/userImages/${requestScope.nowBlogger.imagename}"/>
		<h3>${requestScope.nowBlogger.nickname}</h3>
		<p>${requestScope.nowBlogger.sign }</p>
		<input id="hid" type="hidden" value="${requestScope.blogId}"/>
	</div>
	<div id="div3" align="center" > 
		<h3>点击赞赏给我支持</h3>
		<button value="3" id="aa">3</button><button value="4">4</button><button value="5">5</button><br/>
		<button value="6">6</button><button value="7">7</button><button value="8">8</button><br/>
	</div>
	
	<script type="text/javascript">
		$(function(){
			var blogId=$("#hid").val();
			$(":button").click(function(){
					var money=$(this).val();
					$.post("${pageContext.request.contextPath}/blog/updatePay.action",
						{
							'paymoney':money,
							'blogId':blogId
						},function(result){
							if(result>0){
								alert("成功打赏"+money+"元！");
							}else{
								alert("打赏失败，请重试！");
							}
						},"json");
				}
			);
			
		});
	</script>
</body>
</html>