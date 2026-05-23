<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>
<link rel="StyleSheet" href="${path}/css/bootstrap.min.css">
<script src="${path}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	 // alert(1)
  })

</script>
</head>
<body>
	<div class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav">

				<li><a href="${pageContext.request.contextPath}/user/login">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/board/list">Board</a></li>
			</ul>
			<c:if test="${sessionScope.loginUser != null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">${loginUser}!</a></li>
					<li><a href="${pageContext.request.contextPath}/user/logout"
						class="btn btn-danger">Logout</a></li>
				</ul>
			</c:if>
		</div>
	</div>
	
	
	
	