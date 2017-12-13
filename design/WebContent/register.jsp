<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<script type="text/javascript" src="/design/js/jquery-2.2.2.js"></script>
<link href="/design/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/design/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/design/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="/design/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/design/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="/design/js/simpleCart.min.js"> </script>
<!-- slide -->
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-md-4 world">
					
				</div>
				<div class="col-md-4 logo">
					<a href="/design/index.jsp"><img src="/design/images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-md-4 header-left">		
					<p class="log"><a href="/design/login.jsp"  >登录</a>
						<span>or</span><a  href="/design/register.jsp"  >注册</a></p>
					<p class="log">当前用户:<a href="/design/vipOrder.jsp">${u.address }</a></p>
					<div class="cart box_1">
						<a href="checkout.jsp">
						<h3> <div class="total">
							<!-- <span class="simpleCart_total"></span></div> -->
							<img src="/design/images/cart.png" alt=""/></h3>
						</a>
						<p><a href="${ctx }/cart/checkcart">查看购物车</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-md-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
		  <div class="col-md-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="#">Home</a></li>	
				      <li><a  href="#">全部商品</a>
				      	
					</li>
				    <li class="grid"><a  href="#">商品类型</a>
					  	
			    </li>
				<li><a href="${ctx }/page/time">最新商品</a></li>				
				<li><a class="color6" href="${ctx }/page/getbycount">热门商品</a></li>
			  </ul> 
			</div>
				<div class="col-md-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
					  <script type="text/javascript" src="/design/js/modernizr.custom.min.js"></script>    
					<link href="/design/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="/design/js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>	
				<script>
					function checkusername(){
						var regname=/^[\w\u3E00-\u9FA5]+$/g;
						var fname=document.getElementById("username");
						var ftname=document.getElementById("susername");
						if(fname.value==""|| fname.value.length<1||fname.value.length>2){
							ftname.className="frred";
							ftname.innerHTML="× 请输入1-2位用户名，可包含汉字、数字、字母、下划线";
						}
						else{
							if(fname.value.match(regname)){
							ftname.className="fgren";
							ftname.innerHTML="√用户名可用!"
						}
							else{
								ftname.className="frred";
								ftname.innerHTML="× 用户名格式输入错误，请检查！";
							}}
					}
					function checkname(){
						var regname=/^[\w\u3E00-\u9FA5]+$/g;
						var fname=document.getElementById("name");
						var ftname=document.getElementById("sname");
						if(fname.value==""|| fname.value.length<1||fname.value.length>2){
							ftname.className="frred";
							ftname.innerHTML="× 请输入1-2位用户名，可包含汉字、数字、字母、下划线";
						}
						else{
							if(fname.value.match(regname)){
							ftname.className="fgren";
							ftname.innerHTML="√用户名可用!"
						}
							else{
								ftname.className="frred";
								ftname.innerHTML="× 用户名格式输入错误，请检查！";
							}}
					}
					
					
					function checkpassword(){
						var fpwd=document.getElementById("password");
						var ftpwd=document.getElementById("spassword");
						if(fpwd.value==""||fpwd.value.length<4||fpwd.value.length>20){
							ftpwd.className="frred";
							ftpwd.innerHTML="× 请输入4-20位用户密码！";
						}
						else{
							ftpwd.className="fgren";
							ftpwd.innerHTML="√密码可用！"
						}
						}
					function checkpassword1(){
						var fpwd=document.getElementById("password");
						var frpwd=document.getElementById("password1");
						var ftrpwd=document.getElementById("spassword1");
						if(frpwd.value=="")
						{
						ftrpwd.className="frred";
						ftrpwd.innerHTML="× 请输入您的重复密码！"
						}
						else{
						if(frpwd.value!=fpwd.value)
						{
						ftrpwd.className="frred";
						ftrpwd.innerHTML="× 俩次密码输入不一致，请重新输入！";
						}
						else
						{
						ftrpwd.className="fgren";
						ftrpwd.innerHTML=" √ 密码输入正确";
						}
						}
						}
						
				</script>
				
	<!---->		
		</div>
	</div>
</div>
<!--//header-->

<div class="container">
	<div class="register">
		<h1>Register</h1>
		  	  <form action="${ctx }/user/add" method="post"> 
				 <div class="col-md-6  register-top-grid">
					
					<div class="mation">
						<span>姓氏</span>
						<input type="text" name="username" id="username" onblur="checkusername()"/> 
						<span id="susername" class="frbule"></span>
						<span>名字</span>
						<input type="text" name="name" id="name" onblur="checkname()"/> 
						 <span id="sname" class="frbule"></span>
						 <span>邮箱</span>
						 <input type="text" name="address" id="address" onblur="checkaddress1()"/> 
						 <span id="saddress" class="frbule"></span>
						<span id="error" class="frbule"></span>
						 <div id="usertx"></div>
					</div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>注册</label>
					   </a>
					 </div>
				     <div class=" col-md-6 register-bottom-grid">
						   
							<div class="mation">
								<span>密码</span>
								<input type="text" name="password" id="password" onblur="checkpassword()"/>
								<span id="spassword" class="frbule"></span>
								<span>确定密码</span>
								<input type="text" name="password1" id="password1" onblur="checkpassword1()"/>
								<span id="spassword1" class="frbule"></span>
							</div>
					 </div>
					 <div class="clearfix"> </div>
					 <input type="submit" value="submit">
					   <div class="clearfix"> </div>
					 
				</form>
		   </div>
</div>

<!--footer-->
<div class="footer">
	<div class="container">
		<div class="footer-top">
			<div class="col-md-4 top-footer1">
				<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="SUBSCRIBE">
					</form>
			</div>
			<div class="clearfix"> </div>	
		</div>	
	</div>
	<div class="footer-bottom">
		<div class="container">
				<div class="col-md-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus  dui. </li>
						<li>orci, ornareidquet</li>
						<li> ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
<script type="text/javascript">
	function checkaddress1(){
		$.post("user/checkaddress",{"address":$("#address").val()},function(result){
			if(result=="true") {  
	               document.getElementById("error").innerHTML = "邮箱可以使用！";  
	           } else {  
	               document.getElementById("error").innerHTML = "邮箱已存在！";  
	           }
		  });
		
		var regemail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(;\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*$/;
		var femail=document.getElementById("address");
		var ftemail=document.getElementById("saddress");
		if(femail.value==""){
			ftemail.className="frred";
			ftemail.innerHTML="× 电子邮箱不能为空！";
		}
		else{
			if(femail.value.match(regemail)){
			ftemail.className="fgren";
			ftemail.innerHTML="√ 邮箱格式正确！";
			
		}
		else{
			ftemail.className="frred";
			ftemail.innerHTML="× 邮箱格式输入错误，请检查！";
		}
		}
	}
</script>
</html>