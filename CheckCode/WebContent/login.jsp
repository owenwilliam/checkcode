<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>验证码测试</title>

		<script type="text/javascript">
		
		/*	刷新验证码	*/
		function change_yanzhengma() 
		{
			document.getElementById("checkcode_img").src = "checkcode.jsp?" + new Date().getTime();
		}

		function checkLoginInfo() 
		{
			if (form1.userName.value == "" || form1.userName.value == null) 
			{
				alert("用户名不能为空");
				form1.userName.focus();
				return false;
			} 
			else if (form1.userCode.value == "" || form1.userCode.value == null)
			{
				alert("验证码不能为空");
				form1.yanzhengma.focus();
				return false;
			}
	
			return true;
		}
</script>


	</head>

	<body>
		<center>
			<form action="checkCodeServlet" method="post" name="form1">
				<br/><br/><br/><br/><br/><br/>
			
			
				请输入用户名：<input type="text" name="userName" id="userName"/>
				
				<br/><br/>
				
				<img alt="点击刷新" src="checkcode.jsp" border="0" id="checkcode_img" onClick="change_yanzhengma();" />
				<br/>
				请输入验证码：<input type="text" name="userCode" id="userCode"/>
				
				<br/><br/>
				
				<input type="submit" value="确认登录">
				
				<br/><br/>
				
				<!-- 保存登录失败时显示给用户的提示信息 -->
				<font color="red">
					${sessionScope.loginError } <%session.removeAttribute("loginError"); %>
				</font>
				
			</form>
		</center>
	</body>
</html>