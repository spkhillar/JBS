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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JOBSbySMS-Job Information</title>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>

<spring:url value="/resources/css/style.min.css" var="resourceStyleMinCssUrl"/>
<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJq2Url"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceStyleMinCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>

<style type="text/css">
#jobdetail {
	color: #000;
}
</style>
</head>

<body>
<div>
<table width="53%" height="504"  border="0" align="center" id="jobdetail" style="overflow-y:scroll">
    <tr>
    <td width="70" height="28" bgcolor="#C9D1FA" >Designation</td>
     <td width="600" bgcolor="#E2E7EB"><c:out value="${currentJob.designation}"></c:out> </td>
  </tr>
  <tr>
    <td width="70" height="28" bgcolor="#C9D1FA" >Job Code</td>
     <td width="600" bgcolor="#E2E7EB"><c:out value="${currentJob.jobCode}"></c:out> </td>
  </tr>
  
  <tr>
   <td height="35" bgcolor="#C9D1FA" >Job Description
   </td>
   <td bgcolor="#E2E7EB">
     <span style="white-space:pre"><c:out value="${currentJob.jobDescription}"></c:out></span>
     </td>
   </tr>
  <tr>
    <td height="37" bgcolor="#C9D1FA" >Experience</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.experiance}"></c:out> (Years)
    </td>
  </tr>
  <tr>
    <td height="38" bgcolor="#C9D1FA">Industry Type</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.industry}"></c:out>
    </td>
  </tr>
  <tr>
    <td height="32" bgcolor="#C9D1FA">Job Type</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.jobType}"></c:out>
    </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Skill</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.skill}"></c:out>
    </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Category</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.category}"></c:out>
     </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Salary</td>
    <td bgcolor="#E2E7EB"> 
    <c:out value="${currentJob.salary}"></c:out> (Per-Annum)
    </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Age Limit</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.ageLimit}"></c:out> (Years)
     </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Sub Category</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.subCategory}"></c:out>
    </td>
  </tr>
   <tr>
    <td height="37" bgcolor="#C9D1FA" >Qualification</td>
    <td bgcolor="#E2E7EB"> 
      	<c:out value="${currentJob.qualification}"></c:out>
      </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Location</td>
    <td bgcolor="#E2E7EB">
    <c:out value="${currentJob.location}"></c:out>
     </td>
  </tr>
  <tr>
    <td height="32" bgcolor="#C9D1FA" >Company</td>
    <td bgcolor="#E2E7EB">
   <a href="${currentJob.companyUrl}" target="_blank"><c:out value="${currentJob.companyName}"></c:out></a>
    </td>
  </tr>
  <tr>
    <td height="33" bgcolor="#C9D1FA">Job Posted</td>
    <td bgcolor="#E2E7EB">
     <fmt:formatDate pattern="dd-MM-yyyy" value="${currentJob.postedAt}"/>
    </td>
  </tr>
  </table>  
  </div>
</body>
</html>
