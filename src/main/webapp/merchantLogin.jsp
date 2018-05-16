<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MerchantLogin</title>
<base href="<%=basePath%>">

<style type="text/css">
	html,body,div,li,ul,ol,img,p,span{margin:0;padding:0;}
	a{list-style: none;}
	#mid{width:100%;height:100%;}
	#mid div{width:480px;min-height:100px;margin:100px auto;}
	input {width:200px;height:20px;}
	span{font-size:12px;color:red;}
	td p{float:right;}
	
</style>
</head>
<body>
	<div id="mid">
		<div>
			<a href="merchantRegister.jsp">没有账号，前往注册！</a><br>
			<a href="findPs.jsp">忘记密码？</a>
			<h4>商家登陆</h4>
			
			<form action="merchant/login" method="post">
				<table border="0px" cellpadding="5px">
					<tr>
						<td><p>用户名:</p></td>
						<td><input type="text" name="username"></td>
						<td></td>
					</tr>
					<tr>
						<td><p>密码:</p></td>
						<td><input type="text" name="password"></td>
						<td></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input style="width:50px;height:30px;" type="submit" value="登陆"></td>
					</tr>
					<tr>
						<td></td>
						<td><span>${info }</span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>