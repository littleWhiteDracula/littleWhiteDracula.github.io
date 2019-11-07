<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">

商品列表：
<table width="100%" border=1>
<tr>
	<td>ID</td>
	<td>username</td>
	<td>brithday</td>
	<td>sex</td>
	<td>address</td>
	<td>其他操作</td>
</tr>
<c:forEach items="${userList }" var="user">
<tr>
	<td>${user.id}</td>
	<td>${user.username}</td>
	<td><fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${user.sex}</td>
	<td>${user.address }</td>
	
	<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${user.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>