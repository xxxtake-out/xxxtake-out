<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchant Index</title>

<base href="<%=basePath%>">
<style type="text/css">
	html,body,div,li,ul,ol,img,p,span{margin:0;padding:0;}
	a{list-style: none;}
	#box{width:100%;height:100%;}
	#top{width:100%;min-height:100px;}
	#top-mid{width:500px;min-height:100px;margin:50px auto;}
	#top-mid p{font-size: 12px;float:right;}
	#top-mid span{font-size:12px;color:red;}
	#info{width:100%;min-height:100px;}
	#info #info-mid{width:900px;min-height:100px;margin:50px auto;}
	#info #info-mid input{width:100px;border:none;outline: none;}
	#info #info-mid img{width:62px;height:23px;}
	#order{width:100%;min-height:100px;}
	#order-info{width:900px;min-height:100px;margin:50px auto;}
</style>
</head>
<body>
	<div id="box">
		<div id="top">
			<div id="top-mid">
				<h2>${name } &nbsp;,你好！</h2>
				<h3>商品上架</h3>
				<form action="merchant/upload" method="post" enctype="multipart/form-data">
					<table border="0" cellspacing="5px">
						<tr>
							<td><p>请输入商品名：</p></td>
							<td><input type="text" name="pname"></td>
							
						</tr>
						<tr>
							<td><p>请填写价格(整数)：</p></td>
							<td><input type="text" name="price"></td>
							
						</tr>
						<tr>
							<td><p>请选择分类：</p></td>
							<td>
								<input type="radio" name="kid" value="1"> &nbsp;食品
								<input type="radio" name="kid" value="2"> &nbsp;小吃
								<input type="radio" name="kid" value="3"> &nbsp;零食
								<input type="radio" name="kid" value="4"> &nbsp;快餐
							</td>
							
						</tr>
						<tr>
							<td><p>请上传商品图片：</p></td>
							<td><input type="file" name="file"></td>
							
						</tr>
						<tr>
							<td><p></p></td>
							<td><input type="submit" value="上传"><span>${info }</span></td>
							
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="info">
			<div id="info-mid">
			<c:choose>
				<c:when test="${list eq null }">
					<h3>您还没有商品！</h3>
				</c:when>
				<c:otherwise>
					<span>1----食品</span>
					<span>2----小吃</span>
					<span>3----零食</span>
					<span>4----快餐</span>
					<table border="1px" cellpadding="10px" style="border-collapse:collapse;">
						<tr>
							<th>商品图片</th>
							<th>商品名</th>
							<th>商品价格(RMB)</th>
							<th>商品种类</th>
							<th>浏览量</th>
							<th>是否删除该商品</th>
							<th>确认</th>
						</tr>
						<c:forEach var="menu" items="${list.list }" >
							
							<form id="form1" action="merchant/updata" method="post" >
								<tr>
									<td><img src="cid/${menu.hid }.png"/></td>
									<td><input type="text" name="pname" placeholder="${menu.pname }"/>
									<input type="hidden" name="pid" value="${menu.pid }"/></td>
									<td><input type="text" name="price" placeholder="${menu.price }"/></td>
									<td><input type="text" name="kid" placeholder="${menu.kid }"/></td>
									<td>${menu.pageview }</td>
									<td><a href="merchant/delete?pid=${menu.pid }">删除</a></td>
									<td><button onclick="updata">确认</button></td>
								</tr>
							</form>
								
						</c:forEach>
						<span style="color:red">交易总额：${allprice }￥</span>&nbsp;&nbsp;&nbsp;<span style="color:red">交易量：${allcount }</span>
					</table>
					<form id="form2" action="merchant/index" method="post">
						<input type="hidden" name="page" id="page">
						
						<a href="merchant/index?page=${list.page>1?list.page-1:list.page}">上一页</a>${list.page }/${list.count }
						<a href="merchant/index?page=${list.page==list.count?list.page:list.page+1}">下一页</a>
					</form>
					
				</c:otherwise>
			</c:choose>
			
				
			</div>
		</div>
		<div id="order">
			<div id="order-info">
				<table id="table" border="1px" cellpadding="10px" style="border-collapse:collapse;">
					<tr id="tr">
						<th>点餐用户</th>
						<th>电话</th>
						<th>地址</th>
						<th>商品名</th>
						<th>商品价格</th>
						<th>备注</th>
						<th style="color:red">商家备注</th>
						<th>取消</th>
						<th>确认</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function $(id){
		return document.getElementById(id);
	}
	
	function updata(){
	
		$('form1').submit();
	} 
	function sendAjax(){
		
		//创建一个XMLHttpRequest对象
		var xhr = new XMLHttpRequest();
		//发送请求
		//第一个参数，提交方式POST和GET
		//第二个参数 请求的路劲
		//第三个参数 书否为异步请求 true  false
		xhr.open("post", "merchant/order", true);
		xhr.send();
		
		xhr.onreadystatechange = function(){
			var div = $("table")
			var t = $("tr")
			var trs = document.getElementsByClassName("trs");
			var s = trs.length;
			if(xhr.readyState == 4 && xhr.status ==200){
				//接收服务器传递过来的数据
				var json = xhr.responseText;
				json = eval(json)
				for (var i= s; i >0; i--) {
					
					$("table").removeChild(trs[i-1])
				}
				//对数据的处理
				for (var i = 0; i < json.length; i++) {
					
					var tr1 = document.createElement("tr");
					tr1.setAttribute("class", "trs")
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					var td5 = document.createElement("td");
					var td6 = document.createElement("td");
					var td9 = document.createElement("td");
					var td7 = document.createElement("td");
					var td8 = document.createElement("td");
					td1.innerHTML = json[i].username;
					td2.innerHTML = json[i].phonenumber;
					td3.innerHTML = json[i].addr;
					td4.innerHTML = json[i].pname;
					td5.innerHTML = json[i].price;
					td6.innerHTML = json[i].comment;
					td9.innerHTML = "<input Onfocus='stop()' Onblur='start()' style='border:none;outline:none;width:50px;' type='text' name='oid'><input type='hidden' name='mid' value="+json[i].mid+"><input type='hidden' name='pid' value="+json[i].pid+"><input type='hidden' name='uid' value="+json[i].uid+">";
					td7.innerHTML = "<a style='cursor:pointer' onclick='aaa(this,0)'>取消</a>";
					td8.innerHTML = "<a style='cursor:pointer' onclick='aaa(this,1)'>确认</a>";
					tr1.appendChild(td1);
					tr1.appendChild(td2);
					tr1.appendChild(td3);
					tr1.appendChild(td4);
					tr1.appendChild(td5);
					tr1.appendChild(td6);
					tr1.appendChild(td9);
					tr1.appendChild(td7);
					tr1.appendChild(td8);
					
					div.appendChild(tr1);
					
				}
			}
			
		};
	}
	
	var timeout = false; //启动及关闭按钮  
	function stop(){
		timeout = true;
	}
	
	function start(){
		timeout = false;
		time();
	}
	
	function time(){  
	  if(timeout) return;  
	  sendAjax();  
	  setTimeout(time,100); //time是指本身,延时递归调用自己,100为间隔调用时间,单位毫秒  
	} 
	time();
	function aaa(a,b){
		var inp = a.parentNode.parentNode.getElementsByTagName("input");
		
		a.setAttribute("href","merchant/clean?affirm="+b+"&pid="+inp[2].value+"&mid="+inp[1].value+"&oid="+inp[0].value+"&uid="+inp[3].value)
		
	}
	
	
</script>
</html>