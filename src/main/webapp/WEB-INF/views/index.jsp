<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>

	
	<blockquote>
        <h1> My Spring Boot + JPA Final(USER and Board and Reply)!!!!</h1>
		<h4>
			Spring Final <cite title="Source Title">Wow!</cite>
		</h4>
  <h4>
    1. 주요기능 <p>
      &nbsp;&nbsp; 1) 회원관리(로그인 / 로그아웃) - Users Table <br>
      &nbsp;&nbsp; 2) 자유게시판(등록, 수정, 삭제, 상세보기 ,전체검색) - FreeBoard Table<P>
      &nbsp;&nbsp; 3) 댓글(등록, 검색) - Reply Table<P>
      
    2. 주요 기술 및 환경<p>
      &nbsp;&nbsp;1) Spring WEB MVC구조  <br>
      &nbsp;&nbsp;2) Spring AOP  - Session유무 체크 <br>
      &nbsp;&nbsp;&nbsp;&nbsp; : FreeBoard에 대한 접근은  인증된 사용자만 가능<br>
       &nbsp;&nbsp;3) Spring Data JPA <br>
	  &nbsp;&nbsp;4) @ControllerAdvice - 예외처리 <br>
      &nbsp;&nbsp;5) Action Tag include - Layout Template  <br>
      &nbsp;&nbsp;6) Bootscrap UI <br>
      &nbsp;&nbsp;7) MySQL <br>
      &nbsp;&nbsp;8) 게시판에 paging처리<br>
      
  </h4>
  
</blockquote>
	
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
</body>
</html>