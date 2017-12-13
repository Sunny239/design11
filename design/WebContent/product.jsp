 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Products</title>
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
						<a href="/design/checkout.jsp">
						<h3> <div class="total">
							<!-- <span class="simpleCart_total"></span></div> -->
							<img src="/design/images/cart.png" alt=""/></h3>
						</a>
						<p><a href="${ctx }/cart/checkcart">查看购物车t</a></p>

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
					  <li class=" grid"><a  href="/design/index.jsp">Home</a></li>	
				      <li><a href="${ctx }/page/get">全部商品</a>
				      	
					</li>
				    <li class="grid"><a  href="#">商品类型</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div width="5px" height="10px">
									<h4><a href="${ctx }/page/gettype?typeId=1">T恤</a></h4>									
								</div>							
							</div>
							<div class="col1">
								<div width="5px" height="10px">
									<h4><a href="${ctx }/page/gettype?typeId=2">衬衣</a></h4>									
								</div>							
							</div>
							<div class="col1">
								<div width="5px" height="10px">
									<h4><a href="${ctx }/page/gettype?typeId=3">裤</a></h4>								
								</div>												
							</div>
							
						  </div>
						</div>
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
	<!---->		
		</div>
	</div>
</div>
<!--content-->
<div class="products">
	<div class="container">
		<h1>Products</h1>
		
		<div class="content-top1">
			<c:forEach items="${page.list}" var="p">
				<div class="col-md-3 col-md2">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="${ctx }/product/getProduct?productId=${p.id}">
							<img class="img-responsive" src="/design/images/${p.img1 }" alt="" />
						</a>
						<h3><a href="/design/single.jsp">${p.name}</a></h3>
						<div class="price">
								<h5 class="item_price">${p.price}</h5>
								<a href="${ctx }/cart/add?productId=${p.id}" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
			
		
			<div class="clearfix"> </div>
			
		</div><br/><br/><br/>
		<div align="center">
		  		共有${page.totalCount }条数据，一共${page.totalPageNum }页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${ctx }/${action }?pageNum=1&typeId=<%=session.getAttribute("typeid")%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${ctx }/${action }?pageNum=${page.getPrePageNum() }&typeId=<%=session.getAttribute("typeid")%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${ctx }/${action }?pageNum=${page.getNextPageNum() }&typeId=<%=session.getAttribute("typeid")%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${ctx }/${action }?pageNum=${page.totalPageNum }&typeId=<%=session.getAttribute("typeid")%>">末页</a>	  
	  		</div>	
<!--//menu-->
<!--seller-->
				

<!--//seller-->
<!--tag-->
				
		
		<div class="clearfix"> </div>
	</div>
<!--//content-->
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
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
	</div>
</div>

<!--//footer-->
</body>
</html>