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
<style type="text/css">

.example {
			color: #FFF;
			cursor: pointer;
			padding: 2px;
			border-radius: 4px;
			background: #888;
			float: left;
		}
		
		.example:after {
			font-family: Consolas, Courier New, Arial, sans-serif;
			margin-left: 6px;
			color: #08c;
		}
		
				
		.example.dropdown-open {
			background: blue;
			color: #FFF;
		}
		
		.example.dropdown-open:after {
			color: #FFF;
		}
</style>

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

</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<span class="example" data-dropdown="#dropdown-5">Welcome ${currentLoggedInUser}</span>
 <div id="dropdown-5" class="dropdown dropdown-tip has-icons">
		<ul class="dropdown-menu">
			<li class="createtree"><a href="#">Create Tree</a></li>
			<li class="cpassword"><a href="${contextPath}/admin/changepassword")>Change Password</a></li>
			<li class="dropdown-divider"></li>
			<li class="logout"><a href="${contextPath}/j_spring_security_logout">Log Out</a></li>
			
		</ul>
	</div>
	<form:hidden path="user.id" />
 </body>

</html>