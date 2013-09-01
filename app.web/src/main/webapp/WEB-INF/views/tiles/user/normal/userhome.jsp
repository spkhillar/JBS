<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JOBSbySMS-Enquiry</title>

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
     <div >
     <table id="govttb2">
     <tr>
     <td>
     <h3>Welcome ${currentLoggedInUser}. Preferred Jobs listed below</h3></td>
     </tr>
       <tr bgcolor="#0099CC">
         <td colspan="6" bgcolor="#D1E6E7"> Government Jobs</td>
       </tr>
       
        <c:forEach var="job" items="${jobList}" varStatus="status">
       <tr>
         <td colspan="6" class="pvtinfo"><strong>
         <c:out value="${job.designation}"></c:out> - <c:out value="${job.location}"></c:out> (<c:out value="${job.experiance}"></c:out> yrs)</strong> | Posted date: <fmt:formatDate pattern="yyyy-MM-dd" value="${job.postedAt}"/>
         <ul><li><c:out value="${job.jobDescription}"></c:out></li></ul>
          <p><strong>Salary Range:</strong> Rs. <c:out value="${job.salary}"></c:out> p.a.  | <strong>Industry:</strong> <c:out value="${job.industry}"></c:out><br />
          Company:<c:out value="${job.companyName}">|</c:out> </p><a href="#" onclick="">View Details</a></td>
       </tr>
       </c:forEach>
       </table>
     <div></div>
     </div>


</body>
</html>
