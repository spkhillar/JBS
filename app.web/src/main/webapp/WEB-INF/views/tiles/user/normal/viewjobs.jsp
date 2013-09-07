<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

<title>JOBSbySMS- Job Information</title>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<%-- <spring:url value="/resources/js/jquery.popupoverlay.js" var="resourcePopupboxUrl"/>
<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJq2Url"/>
<spring:url value="/resources/js/jquery-1.8.2.min.js" var="resourceJq8Url"/> --%>

<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>

<%-- <script type="text/javascript" src="${resourceJq2Url}"></script>
<script type="text/javascript" src="${resourceJq8Url}"></script>

<script type="text/javascript" src="${resourcePopupboxUrl}"></script> --%>
<script type="text/javascript">

$(document).ready(function(){
  //$('#my_modal').dialog();
  
  
  
});


</script>
<style>
#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
}
#govttb2 tr .pvtinfo strong {
	font-size: 12px;
}
</style>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
     <div >
      <h3>Welcome ${currentLoggedInUser}. Preferred Jobs listed below</h3>
       <c:forEach var="job" items="${jobList}" varStatus="status">
         <div id="userjobinfo">
         <c:out value="${job.designation}">
         </c:out> - <c:out value="${job.location}"></c:out> (<c:out value="${job.experiance}"></c:out> yrs)
         | Posted date: <fmt:formatDate pattern="dd-MM-yyyy" value="${job.postedAt}"/>
         <ul>
         <li>
         <c:out value="${job.keyword}"></c:out>
         </li>
         </ul>
          <p>
          <strong>Salary Range:</strong> Rs. <c:out value="${job.salary}"></c:out> p.a.  | 
          <strong>Industry:</strong> <c:out value="${job.industry}"></c:out><br />
          Company:<c:out value="${job.companyName}">|</c:out> 
          </p>
          <span class="my_modal_open">
          <a href="javascript:void(0);" onclick="javascript:loadJobDetails(${job.id});">View Details</a>
          </span>
          </div>
          </c:forEach>
        </div>
     
<br/>
    <!-- Add content to modal -->
</body>

   <div id="jobdetailsdiv" title="Job Details">
   </div>
    
</html>
