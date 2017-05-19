<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link href="${pageContext.request.contextPath}/static/css/jquery-ui.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>
<title>博客主页</title>
<style type="text/css">
	body{
		padding-top:10px;
		padding-bottom:40px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
</style>
<script type="text/javascript">

		function a(){
			var userIp="${pageContext.request.remoteAddr}";
			$.post("${pageContext.request.contextPath}/fans/findByIp.action",
				{
					'userIp':userIp
				},function(result){
					if(result>0){
						$('#gz').val("取消关注");
					}else{
						$('#gz').val("关注");
					}
				},"json");
		}
		$(function(){
			a();
			document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
			$("#dialog").hide();
		});
		function guanzhu(){
		
			if($('#gz').val()=="关注"){
				var id=$("#hid").val();
				var fans=$("#hfans").val();
				var flag=$('#gz').val();
				$.post("${pageContext.request.contextPath}/blogger/updateAttention.action",
					{
						'bloggerId':id,
						'fans':parseInt(fans)+1,
						'flag':flag
					},function(result){
							if(result>0){
								$('#gz').val("取消关注");
							}
					},"json");
			}else if($('#gz').val()=="取消关注"){
				var id=$("#hid").val();
				var fans=$("#hfans").val();
				var flag=$('#gz').val();
				$.post("${pageContext.request.contextPath}/blogger/updateAttention.action",
					{
						'bloggerId':id,
						'fans':parseInt(fans)-1,
						'flag':flag
					},function(result){
							if(result>0){
								$('#gz').val("关注");
							}
					},"json");
			}
		}
		
	function loadimage(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}
	
	function submitData(){
		var id=$("#hid").val();
		var wordHit=$("#hword").val();
		var aaa= $("#aaa").val();
		var content = $("#content").val();
		var imageCode = $("#imageCode").val();
		if(content == null || content == "") {
			alert("请输入留言内容");
		} else if( imageCode == null || imageCode == "") {
			alert("请填写验证码");
		} else {
			$.post(
				"${pageContext.request.contextPath}/blogger/updateWord.action",
				{
					"content":content,
					"imageCode":imageCode,
					"bloggerId":id,
					"wordHit":wordHit
				},
				function(result) {
					if(result>0) {
						alert("留言成功！");
						window.location.reload();
					} else {
						alert("留言失败！");
					}
				},"json");
		}
	}
	
	function dianzan(value1,value2){
			$.post("${pageContext.request.contextPath}/blog/update.action",
			{
				'id':value1,
				'goodhit':value2+1,
				'blogType.id':null
			},
			function(result){
					if(result>0){
						window.location.reload();
					}else{
					
					}
			},
			"json");
	};
	
	function sixin(){
		$("#dialog").dialog(
			{ 
				buttons: { 
					"发送": function() 
						{ 
							//alert($("#sxtext").val());	
							//alert($("#hid").val());
							$.post("${pageContext.request.contextPath}/chat/insert.action",
									{
										content:$("#sxtext").val(),
										bloggerId:$("#hid").val()
									},
									function(result) {
										if (result>0) {
											alert("留言成功！");
										} else {
											alert("留言失败！");
										}
									},"json");
						}, 
					"取消": function()
						{ $(this).dialog("close"); } 
				},
				 position: ["left", "top"]
			 });
	}
</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="blog"><strong>xx的博客</strong></div>
			</div>
			<div class="col-md-8">
				<iframe style="float:right" width="420" scrolling="no" height="60" frameborder="0"
					allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			</div>
		</div>
		
		<div class="row" style="padding-top: 10px">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
				  <div class="container-fluid">				    
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				      	<li class="active"><a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">博主首页</a></li>
				      </ul>
				      <form class="navbar-form navbar-right" role="search">
				        <div class="form-group">
				          <input type="text" class="form-control" placeholder="请输入要查询的关键字">
				        </div>
				        <button type="submit" class="btn btn-default">搜索</button>
				      </form>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			</div>
		</div>
		
		<div class="row">	
		  <div class="col-md-3">
		  	<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
					博主信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="gz" type="button" value="" onclick="guanzhu()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="sx" type="button" value="发私信" onclick="sixin()"/>
				</div>
				<div class="user_image">
					<img src="${pageContext.request.contextPath}/static/userImages/${requestScope.nowBlogger.imagename}"/>
				</div>
				<div class="nickName">${requestScope.nowBlogger.nickname }</div>
				<div class="userSign">${requestScope.nowBlogger.sign }</div>
				<input id="hid" type="hidden" value="${requestScope.nowBlogger.id}"/>
				<input id="hfans" type="hidden" value="${requestScope.nowBlogger.fans}"/>
				<input id="hword" type="hidden" value="${requestScope.nowBlogger.wordHit}"/>
				<input id="hname" type="hidden" value="${requestScope.nowBlogger.nickname }"/>
			</div>	
			<div id="dialog" title="发送私信">
			 	<table>
			 		<tr>
			 			<td><input type="text" id="sxtext"/></td>
			 		</tr>
			 	</table>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					文章分类
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${requestScope.nowBlogType }" var="blogType">
								<li><span><a href="${pageContext.request.contextPath }/blog/findByType.action?type=${blogType.typename }">${blogType.typename }（${blogType.blogCount }）</a></span></li>		
							</c:forEach>					
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					文章存档
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${requestScope.blogDate}" var="blog">							
								<li><span><a href="#">${blog.releaseDateStr }（${blog.blogCount }）</a></span></li>						
							</c:forEach>						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img
						src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png" />&nbsp;留言
				</div>
				<div class="publish_comment">
					<div>
						<textarea style="width: 100%" rows="3" id="content" name="content"
							placeholder="来说两句吧..."></textarea>
					</div>
					<div class="verCode">
						验证码：<input type="text" value="" name="imageCode" id="imageCode"
							size="10" onkeydown="if(event.keyCode==13)form1.submit()" />&nbsp;
							<img onclick="javascript:loadimage();" title="换一张试试" name="randImage"
							id="randImage" src="/image.jsp" width="60" height="20" border="1"
							align="absmiddle">
					</div>
					<div class="publishButton">
						<button class="btn btn-primary" type="button" onclick="submitData()">发表留言</button>
					</div>
					
				</div>
			</div>
		 	
		  </div>
		  	  
		  <div class="col-md-9">
		  	<div class="data_list">
		  		<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
				</div>	
				<div class="datas">
					<ul>
						<c:forEach var="blog" items="${requestScope.nowBlog }">							
							<li style="margin-bottom: 30px">
							  	<span class="title">
							  		<img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
							  		<a href="${pageContext.request.contextPath }/blog/findBlogById.action?id=${blog.id}">${blog.title }</a>
							  	</span>
							  	<span class="summary">${blog.summary }</span>
							  	<span class="img">
							  		<c:forEach items="${blog.imageList }" var="image">
										${image }							  		&nbsp;&nbsp;
							  		</c:forEach>
								</span>
							  	<span class="info">
							  		<font color="#999">2016-07-03 10:39</font> &nbsp;&nbsp;
							  		<font color="#33a5ba"><a href="${pageContext.request.contextPath }/blog/findBlogById.action?id=${blog.id}">阅读</a><font color="#999">(${blog.clickhit})</font>&nbsp;&nbsp;</font>
							  		<font color="#33a5ba"><a href="${pageContext.request.contextPath }/blog/findBlogById.action?id=${blog.id}">评论</a><font color="#999">(${blog.replyhit})</font>&nbsp;&nbsp;</font>  
							  		<font color="#33a5ba"><a onclick="dianzan(${blog.id},${blog.goodhit})">点赞</a>(<span id="zan"><font color="#999">${blog.goodhit}</font></span>)&nbsp;&nbsp;</font> 
							  		<font color="#33a5ba"><a href="${pageContext.request.contextPath }/blog/daShang.action?id=${blog.id}&bloggerId=${blog.bloggerId}" onclick="dashang()">打赏</a><font color="#999">(${blog.payhit})</font>&nbsp;&nbsp;</font>  	
							  	</span>
							</li>
							<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />													
						</c:forEach>	
					</ul>
				</div>  		
		  	</div>
		  </div>
		  
		</div>
		
		<div class="row">
			<div class="col-md-12" >
				<div class="footer" align="center" style="padding-top: 120px" >
					<font>Copyright © 2012-2016 xx的SSM个人博客系统 版权所有</font>  
				</div>
			</div>			
		</div>
	
	</div>
</body>
</html>
