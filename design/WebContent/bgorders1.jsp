<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="/design/css/css1.css" type="text/css" rel="stylesheet" />
<link href="/design/css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="/design/images/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(/design/images/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(/design/images/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(/design/images/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：订单管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="80%" align="left" valign="middle">
	         <form method="get" action="${ctx }/dorders/selectorders">
	         <span>订单详情：</span>
	         <input type="text" name="selectorders" value="" class="text-word">
	         <input name="" type="submit" value="查询" class="text-but">
	         </form>
         </td>
         <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${ctx }/dorders/findfinish?state=1" target="mainFrame" onFocus="this.blur()" class="add">已完成订单</a></td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${ctx }/dorders/findfinish?state=0" target="mainFrame" onFocus="this.blur()" class="add">未完成订单</a></td>	
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">邮箱</th>
        <th align="center" valign="middle" class="borderright">收货人</th>
        <th align="center" valign="middle" class="borderright">收货地址</th>
        <th align="center" valign="middle" class="borderright">商品名称</th>
        <th align="center" valign="middle" class="borderright">单价</th>
        <th align="center" valign="middle" class="borderright">数量</th>
        <th align="center" valign="middle" class="borderright">日期</th>
        <th align="center" valign="middle" class="borderright">状态</th>
        <th align="center" valign="middle" class="borderright">联系方式</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <%int count = 1; %>
      <c:forEach items="${list7 }" var="list">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom"><%=count %></td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.useraddress }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.consignee }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.region }${list.addresss }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.name }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.price }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.count }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.date }</td>
         <td align="center" valign="middle" class="borderright borderbottom">${state }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${list.phone }</td>
        <td align="center" valign="middle" class="borderbottom"><a href="${ctx }/dorders/del?useraddress=${list.useraddress}&date=${list.date}" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr> 
      <%count++; %>
      </c:forEach> 
    </table></td>
    </tr>
</table>
</body>
</html>