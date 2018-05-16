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
			<a href="merchantLogin.jsp">已有账号，前往登陆</a><br>
			<a href="findPs.jsp">忘记密码？</a>
			<h4>注册成为商家</h4>
			<span>${info1 }</span>
			<form action="merchant/register" method="post" enctype="multipart/form-data">
				<table border="0px" cellpadding="3px">
					<tr>
						<td><p>手机号(用户名):</p></td>
						<td><input Onfocus="name1()" Onblur="name2()" type="text" name="username"></td>
						<td><span>${info }</span><span id='span' style="display:none;">请输入合法的手机号！</span></td>
					</tr>
					<tr>
						<td><p>密码:</p></td>
						<td><input type="text" name="password"></td>
						
					</tr>
					<tr>
						<td><p>验证信息(数字):</p></td>
						<td><input type="text" name="cid"></td>
						<td><span>找回密码时使用，请牢记</span></td>
					</tr>
					<tr>
						<td><p>请上传营业执照:</p></td>
						<td><input type="file" name="file"></td>
						
					</tr>
					<tr>
						<td></td>
						<td><input style="width:50px;height:30px;" type="submit" value="注册"></td>
					</tr>
				
				</table>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript">
	function $(id){
		return document.getElementById(id);
	}
	
	function name2(){
		var inp = $('mid').getElementsByTagName('input');
		if(!(/^1[3|4|5|8]\\d{9}$/.test(inp[0].value))){
			$("span").style.display = 'block';
		}
	}
	function name1(){
		var inp = $('mid').getElementsByTagName('input');
		$("span").style.display = "none";
	}
	
	
	
</script>
</html>