<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="app.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript">

	$(document).ready(function () {

		$('#dropdown').hover(
		
			function () {

				//change the background of parent menu				
				$('#dropdown li a.parent').addClass('hover');
				
				//display the submenu
				$('#dropdown ul.children').show();
				
			},
		
			function () {

				//change the background of parent menu
				$('#dropdown li a.parent').removeClass('hover');			

				//display the submenu
				$('#dropdown ul.children').hide();
				
			}
		
		);
		
	});
	

	</script>
<style type="text/css">
	
	</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul id="dropdown">
	<li><a href="#" class="parent"><c:out value="${currentLoggedInUser}"></c:out></a>	
		<ul class="children">
			<li><a href="${contextPath}/admin/changepassword/${currentLoggedInUserId}">Change Password</a></li>
			<li><a href="${contextPath}/j_spring_security_logout">Logout</a></li>
		</ul>
	</li>
</ul>
</body>
<form:hidden path="user.id" />
</html>