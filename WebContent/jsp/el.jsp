<%@page import="review.emp.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<EmpDTO> list = new ArrayList<>();
list.add(new EmpDTO("10","홍길동"));
list.add(new EmpDTO("20","나기자"));
request.setAttribute("list",list);
%>

	<!-- 표현식 기본객체 -->	                                                     <!-- EL, EL객체. JSTL함수-->
	<%= request.getParameter("name").toUpperCase() %>                     ${fn:toUpperCase(param.name)}<br>
	<% if (list != null && list.size()>0) { %>
		<% for (EmpDTO dto : list) {%>
			<%=dto.getFirst_name() %><br>
		<% } %>	
	<% } %> <br>
	갯수 : <%= list.size() %>
	<br>
	
<c:if test="${not empty list}"> <!--  empty는 null체크와 사이즈 체크 다해줌 -->
	<c:forEach items="${requestScope.list}" var="dto"> <!--  requestScope. 는 생략가능-->
	${dto.getFirst_name()} == ${dto.first_name}
		</c:forEach> 
		</c:if>
		
		
		<br>
		EL length : ${fn:length(list)}
		<hr>
		헤더정보
		<%=request.getHeader("User-Agent") %>        <br><hr>            ${header["User-Agent"]}<br>
																         ${cookie.name}
		
		<%=request.getContextPath() %>                 <br>          ${pageContext.request.contextPath}
		
		
		
</body>
</html>