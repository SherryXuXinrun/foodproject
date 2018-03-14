<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>

    <s:form action="customer/customer_reg" method="post">
      <s:textfield name="customer.name" label="用户名"></s:textfield>
      <s:textfield name="customer.password" label="密码"></s:textfield>
      <s:textfield name="customer.address" label="地址"></s:textfield>
      <s:submit value="提交"></s:submit>
      <s:reset value="重填"></s:reset>
    </s:form>
    <br>
  </body>
</html>
