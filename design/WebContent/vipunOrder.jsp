<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>17商城</title>
<link type="text/css" href="/design/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="/design/js/jquery.js"></script>
<script type="text/javascript" src="/design/js/js.js"></script>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
 $(function(){
	 $(".vipNav dd:first").show();
	 })
</script>
</head>

<body>
 <div class="mianCont">

  <div class="lsg">
   <h1 class="logo"><a href="/design/index.jsp"><img src="/design/images/logo.png" width="217" height="90" /></a></h1>
  </div><!--lsg/-->
  <div class="cont">
   <div class="contLeft" id="contLeft">
    <h3 class="leftTitle">会员中心</h3>
    <dl class="helpNav vipNav">
     <dt>我的主页</dt>
      <dd>
       <a href="${ctx }/orders/get?state=1">已处理订单</a>
       <a href="${ctx }/orders/get1?state=0" class="vipCur">未处理订单</a>
      </dd>
     <dt>账户设置</dt>
      <dd>
       <a href="/design/vipPwd.jsp">密码修改</a>
      </dd>      
      
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <div class="contRight">
    <h2 class="oredrName">
    我的订单
    </h2>
    <table class="vipOrder">
    <th colspan="2">商品名称</th><th>单价</th><th>数量</th><th>小计</th><th>日期</th><th>状态</th><th>商品详情</th><th>操作</th>
    <c:forEach items="${list }" var="list">
     <tr>
      <td><img src="/design/images/pi2.png" width="60" height="55"></a></td>
      <td>${list.name }</td>
      <td>￥${list.price }</td>
      <td>${list.count }</td>
      <td>${list.price*list.count }</td>
      <td>${list.date }</td>
      <td><strong>未付款</strong></a></td>
      <td><a href="${ctx }/product/getProduct?productId=${list.productid }">查看</a></td>
      <td><a href="${ctx }/orders/del?productId=${list.productid}&date=${list.date}&state=${list.state}"><img src="/design/images/trash.gif"/></a></td>
     </tr>
     </c:forEach>
    </table><!--vipOrder/-->
    <br />
   
    <br />
   </div><!--contRight/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--mianCont/-->
</body>
</html>