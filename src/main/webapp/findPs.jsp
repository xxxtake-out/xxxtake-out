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
<title>Insert title here</title>
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
			<a href="merchantLogin.jsp">前往登陆</a>
			<h4>找回密码</h4>
			
			<form action="merchant/findp" method="post" >
				<table border="0px" cellpadding="3px">
					<tr>
						<td><p>请输入用户名：</p></td>
						<td><input type="text" name="username"></td>
						
					</tr>
					<tr>
						<td><p>请输入验证信息：</p></td>
						<td><input type="text" name="cid"></td>
						<td><span>${info2}</span></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input style="width:50px;height:30px;" type="submit" value="确定"></td>
					</tr>
				
				</table>
			</form>
			${pas}
		</div>
	</div>

</body>
</html>