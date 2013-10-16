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

<style>
#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
}
#govttb2 tr .pvtinfo strong {
	font-size: 12px;
}
#userjobinfo table tr th {
	text-align: left;
}
</style>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
     <div >
       <c:forEach var="job" items="${jobList}" varStatus="status">
        <div>
         <table width="100%" border="0" id="userjobinfo">
          <tr>
              <td width="101" scope="col">Designation</td>
              <td width="252" scope="col"><c:out value="${job.designation}"></c:out>  - Experience : <c:out value="${job.experiance}"></c:out> yrs</td>
              <td width="88" scope="col">Posted Date</td>
              <td width="155" scope="col"><fmt:formatDate pattern="dd-MM-yyyy" value="${job.postedAt}"/></td>
            </tr>
            <tr>
              <td>Key Skills</td>
              <td colspan="4"><c:out value="${job.keyword}"></c:out></td>
            </tr>
            <tr>
              <td>Salary</td>
              <td colspan="4">Rs. <c:out value="${job.salary}"></c:out> p.a.</td>
            </tr>
            <tr>
              <td>Company</td>
              <td width="252"><c:out value="${job.companyName}"></c:out></td>
              <td width="88">Industry</td>
              <td><c:out value="${job.industry}"></c:out></td>
              <td align="right"><a href="javascript:void(0);" onClick="javascript:loadJobDetails(${job.id});">View Details</a></td>
            </tr>
            
          </table>
          <br>
         
         </div>
          </c:forEach>
        </div>
     
<br/>
    <!-- Add content to modal -->
</body>

   <div id="jobdetailsdiv" title="Job Details">
   </div>
    
</html>
