<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="jumbotron">
	<h1>Login</h1>
	<p>Login, AOP/HttpSession</p>
	<p>
		<a class="btn btn-primary btn-lg">Learn more</a>
	</p>
</div>

<c:choose>
	<c:when test="${empty loginUser}"><!-- 인증하면 loginUser 이름으로 값 저장!! 세선에... -->
		<form class="form-horizontal" method="post" action="/user/loginCheck">
			<fieldset>
				<legend>Login</legend>
				<div class="form-group">
					<label for="userId" class="col-lg-2 control-label">User Id</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="userId" name="userId"
							placeholder="userId">
					</div>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-lg-2 control-label">Password</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
			<legend>Login</legend>
			<blockquote>
				<p>My Shopping Mall!</p>

				<div class="alert alert-dismissible alert-warning">
					<button type="button" class="close" data-dismiss="alert">Ã</button>
					<h4>Welcome!</h4>
					<p>
						<a href="#" class="alert-link">${loginUser.userId} / ${loginUser.name}</a>.
					</p>
				</div>
			</blockquote>
	</c:otherwise>
</c:choose>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>	
