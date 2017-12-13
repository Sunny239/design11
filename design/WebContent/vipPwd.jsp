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
	 $(".vipNav dd:eq(1)").show();
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
       <a href="/design/vipOrder.jsp">已处理订单</a>
       <a href="/design/vipunOrder.jsp">未处理订单</a>
      </dd>
     <dt>账户设置</dt>
      <dd>
       <a href="/design/vipPwd.jsp" class="vipCur">密码修改</a>
      </dd>
    
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <script>
   function checkpassword(){
		var fpwd=document.getElementById("xinpwd");
		var ftpwd=document.getElementById("sxinpwd");
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
		var fpwd=document.getElementById("xinpwd");
		var frpwd=document.getElementById("xinpwd2");
		var ftrpwd=document.getElementById("sxinpwd2");
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
   <div class="contRight">
   <h2 class="oredrName">
    修改密码
    </h2>
    <form action="${ctx }/user/editpwd" method="post">
    <div class="address" style="display:block">
    <div class="addList">
     <label>原密码:</label>
     <input type="password" name="yuanpwd" id="yuanpwd" onblur="checkyuanpassword()"/>
     <span id="ee"></span>
    </div><!--addList-->
    <div class="addList">
     <label>新密码:</label>
     <input type="password" class="vipPwd1" name="xinpwd" id="xinpwd" onblur="checkpassword()"/>
     <span id="sxinpwd"></span>
    </div><!--addList-->
    <div class="addList">
     <label>确认密码:</label>
     <input type="password" class="vipPwd2" name="xinpwd2" id="xinpwd2" onblur="checkpassword1()"/>
     <span id="sxinpwd2"></span>
    </div><!--addList-->
    <div class="addList2">
    <input type="submit" value="保存"/>
     <!-- <input type="image" src="/design/images/baocun.png" width="79" height="30" class="vipSub" /> -->
    </div><!--addList2/-->
   </div><!--address/-->
   </form>
   </div><!--contRight/-->
   <div class="clears"></div>
  </div><!--cont/-->
  
 </div><!--mianCont/-->
</body>
<script>
function checkyuanpassword(){
	$.post("user/checkpwd",{"yuanpwd":$("#yuanpwd").val()},function(result){
		if(result=="true") {  
               document.getElementById("ee").innerHTML = "密码正确！";  
           } else {  
               document.getElementById("ee").innerHTML = "密码错误！";  
           }
	  });
}
</script>
</html>