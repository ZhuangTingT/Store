<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
	<form action="/Store/servlet/AlterGoods" method="post">
		id:<input type="text" id="id" name="id" value="${goods.id}" readonly><br>
		name:<input type="text" id="name" name="name" value="${goods.name}"><br>
		type:<input type="text" id="type" name="type" value="${goods.type}"><br>
	 	price:<input type="text" id="price" name="price" value="${goods.price}"><br>
	 	<input type="submit" value="修改"><br>
	</form>
  </body>
</html>
