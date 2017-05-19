<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
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
	var $nickName="${sessionScope.blogger.nickname}";
	var $id="${sessionScope.blogger.id}";
	if($nickName!=""&&$nickName!=null){
		var $div=$("<form id='success' class='navbar-form navbar-right'><div><span><font size='5' color='green'>欢迎您,"+$nickName+"</font></span></div> </form>");
		var $div2=$("<form id='myblog' class='navbar-form navbar-right'><div><span><font size='5' color='green'><a href='${pageContext.request.contextPath}/blog/main.jsp?id="+$id+"'>我的博客管理</a></font></span></div> </form>");
		$("ul:first").append($div2);
		
		$("ul:first").append($div);
	}else{
		var $form=$("<form id='loginForm' class='navbar-form navbar-right'><div id='loginFor' class='form-group'>用户名：<input id='loginName' type='text'/>密码：<input id='loginPwd' type='password'/></div><button id='login'  class='btn btn-default'>登录</button></form>");
		var $a=$("<a class='navbar-form navbar-right' href='${pageContext.request.contextPath}/register.jsp'><u><font size='5' >注册</font></u></a>");
			$("ul:first").append($a);
			$("ul:first").append($form);
			
		}
	}
	$(function(){
		a();
	});
	
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
</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="blog"><strong>SSM博客系统</strong></div>
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
				      <ul class="nav navbar-nav" >
				     	 <li><a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">博客首页</a></li>
				      	 <c:forEach items="${applicationScope.blogTypeList }" var="type">
							 <li><a class="navbar-brand" href="${pageContext.request.contextPath }/blog/findByType.action?type=${type.typename }">${type.typename }</a></li>    
				        </c:forEach>
				      </ul>
				      <!--  <form id="loginForm" class="navbar-form navbar-right">
					       <div id="loginFor"class="form-group">
					         	用户名：<input id="loginName" type="text"/>
					         	密码：<input id="loginPwd" type="text"/>
					        </div>
					        <button id="login"  class="btn btn-default">登录</button>
				      </form>
				      -->
				      <form class="navbar-form navbar-right" role="search" method="post" action="${pageContext.request.contextPath }/blog/findByKeyword.action">
				        <div class="form-group">
				          <input name="keyword" type="text" class="form-control" placeholder="请输入要查询的关键字">
				        </div>
				        <button type="submit" class="btn btn-default">搜索</button>
				      </form>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			</div>
		</div>
		
		<div class="row">	
		  <div class="col-md-3" height="120">
	
			<div class="data_list">
				
				<h2 class="famous-blogs-h2 f-yahei">
				<a href="http://blog.163.com/blogger.html">名博</a>
				</h2>
				<ul>
					<c:forEach items="${requestScope.top5Blogger }" var="blogger">
						<li>
							<a href="${pageContext.request.contextPath }/blogger/findById.action?id=${blogger.id}">
							<img src="${pageContext.request.contextPath }/static/userImages/${blogger.imagename}" width="60" height="60">
							</a>
							<h3 class="famous-blogs-h3">
							<a href="${pageContext.request.contextPath }/blogger/findById.action?id=${blogger.id}">${blogger.nickname }</a>
							</h3>
						</li>
					</c:forEach>
				</ul>
			</div>	
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>						
						<c:forEach items="${requestScope.linkList }" var="link">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>											
					</ul>
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
						<c:forEach var="blog" items="${requestScope.blogList }">							
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
	
	<script type="text/javascript">
		$("ul:first").on("click","#login",function(){
			var name=$("#loginName").val();
			var pwd=$("#loginPwd").val();
			//alert(name+pwd);
			$.ajax({
			  type:"POST",
		      url:"${pageContext.request.contextPath}/blogger/login.action",
		      async:false,
		      data:{
		      		"nickname":name,
		      		"password":pwd
		      		},
		      success:function(backData,textStatus,ajax){
		      	//alert("登录成功");
		      },
		      error:function(backData,textStatus,ajax){
		      	alert("登录失败，用户名或密码错误!");
		      }
			});
						//window.location.reload();
						
		});
	</script>
</body>
</html>
