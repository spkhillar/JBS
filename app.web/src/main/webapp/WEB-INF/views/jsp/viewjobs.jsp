<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JOBSbySMS- Job Information</title>
<style>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/enquirymenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<spring:url value="/resources/js/jquery.js" var="resourceJq2Url"/>
#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
}
#govttb2 tr .pvtinfo strong {
	font-size: 12px;
}
</style>

<script type="text/javascript" src="${resourceJq2Url}"></script>


<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table  border="0" id="indextb">
  <tr>
    <td width="17%" height="34"><img src="resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td width="24%" height="34">&nbsp;</td>
    <td width="14%" height="34">&nbsp;</td>
    <td width="31%" height="34">&nbsp;</td>
    <td width="8%" height="34">&nbsp;</td>
    <td width="6%" height="34"><img name="" src="resources/images/logout.jpg" width="32" height="32" alt="" align="center"/><br/>
    <a href="${contextPath}/j_spring_security_logout">Log Out</a>
    </td>
  </tr>

  <tr>
    <td height="17" class="menutd"><a href="index.jsp" class="menulink">Home</a></td>
    <td class="menutd"><a href="newuser.jsp" class="menulink">Register</a></td>
    <td class="menutd"><a href="#" class="menulink">Login</a></td>
    <td class="menutd"><a href="#" class="menulink">Enquiry</a></td>
    <td class="menutd"><a href="#" class="menulink">Contact Us</a></td>
    <td class="menutd"><a href="#" class="menulink">About Us</a></td>
  </tr>
  </table>
     <div >
     <table id="govttb2">
       <tr bgcolor="#0099CC">
         <td colspan="6" bgcolor="#D1E6E7"> Government Jobs</td>
       </tr>
       

       
        <c:forEach var="job" items="${jobList}" varStatus="status">
        
       <tr>
         <td colspan="6" class="pvtinfo"><strong><c:out value="${job.designation}"></c:out> - <c:out value="${job.location}"></c:out> (<c:out value="${job.experiance}"></c:out> yrs)</strong> | Posted date: <fmt:formatDate pattern="yyyy-MM-dd" value="${job.postedAt}"/>
         <ul><li><c:out value="${job.jobDescription}"></c:out></li></ul>
          <p><strong>Salary Range:</strong> Rs. <c:out value="${job.salary}"></c:out> p.a.  | <strong>Industry:</strong> <c:out value="${job.industry}"></c:out><br />
          Company:<c:out value="${job.companyName}">|</c:out> </p><a href="#" onclick="">View Details</a></td>
       </tr>
       </c:forEach>
       </table>
     <div></div>
     </div>
     
<br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
