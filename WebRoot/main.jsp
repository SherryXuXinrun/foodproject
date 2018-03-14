<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有Food</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	
  </head>
  
  <body>
    <header>
       <div class="account">
         <c:choose>
	       <c:when test="${customer.name ==null}">
	         <a href="reg.jsp">注册</a>
	         <a href="login.jsp">登录</a>
	       </c:when>
	       <c:otherwise>
	         <c:out value="${customer.name}"></c:out>, 欢迎您!
	       </c:otherwise>
	     </c:choose>
		    
       </div>
       <div class="logo"></div>
		    
    </header>
    
    <main>
	    <s:form action="food/food_queryFoods" method="post">
	      
	      <div>
	         <s:submit value="查 询" cssClass="search-go"></s:submit>
	         <input class="search" type="text" name="keyWords" placeholder="请输入关键词">
	      </div>
	
	      <table>
	        <tr>  
	          <th>序号</th>  
	          <th>名称</th>
	          <th>单价</th> 
	          <th>操作</th>  
	          <th>操作</th>
	        </tr> 
	        <c:forEach var="food" items="${foodList}" varStatus="status">
	          <tr>
	            <td><c:out value="${status.index+1}"></c:out></td>
	            <td><a href="food/food_showDetail?food.foodid=${food.foodid}"><c:out value="${food.foodname}"></c:out></a></td>
	            <td><c:out value="${food.unitprice}"></c:out></td>
	            <td><a href="food/food_showEdit?food.foodid=${food.foodid}">编辑</a></td>
	            <td><a href="food/food_deleteFood?food.foodid=${food.foodid}">删除</a></td>
	            <td><a href="order/order_addOrder?food.foodid=${food.foodid}&customer.name=${customer.name}">来一份</a></td>
	          </tr>
	        </c:forEach>
	      </table>
	    </s:form>
	</main>
  </body>
</html>
