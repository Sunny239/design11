<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/design/css/demo.css" />
<link rel="stylesheet" href="/design/css/style1.css" />
<link rel="stylesheet" href="/design/css/fen.css" />
<link rel="stylesheet" href="/design/css/swiper.min.css" />
<link rel="stylesheet" href="/design/css/animate.css" />
<script type="text/javascript" src="/design/js/jquery-2.2.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>		
		<div class="order">
			<p class="p1">填写并确认订单</p>
			<div class="order_b1">
				<p class="title">收货人信息</p>

					<div class="new_add">
						<p class="p1">新增地址</p>
						<!-- <img src="/design/images/close.png" class="close"/> -->
						<form action="${ctx }/orders/shouhuodizhi" method="post">
							<p>
								<span class="tl"><font color="#D70000" style="margin-right: 5px;">*</font>收货人</span>
								<input type="text" name="consignee"/>
							</p>
							<p>
								<span class="tl"><font color="#D70000" style="margin-right: 5px;">*</font>所在地区</span>
								<input type="text" name="region"/>
							</p>
							<p>
								<span class="tl"><font color="#D70000" style="margin-right: 5px;">*</font>详细地址</span>
								<input type="text" style="width: 500px;" name="addresss"/>
							</p>
							<p>
								<span class="tl"><font color="#D70000" style="margin-right: 5px;">*</font>联系电话</span>
								<input type="tel" name="phone"/>
							</p>
							
							<p>
								<input type="checkbox" />
								<span class="tl" style="width: 90px;">设为常用地址</span>
							</p>
							<p class="add_btn"><input type="submit" value="保存">保存</p>
						</form>
					</div>
			</div>
		
			<!-- <script>
					$(function(){
						$("#add").click(function(){
							$(".old_add").hide();
							$(".new_add").fadeIn();
						});
						$(".add_btn").click(function(){
							$(".new_add").hide();
							$(".old_add").fadeIn();
						});
						$(".close").click(function(){
							$(".new_add").hide();
							$(".old_add").fadeIn();
						});
						
					});
				</script> -->
		</div>
	
	</body>
</html>