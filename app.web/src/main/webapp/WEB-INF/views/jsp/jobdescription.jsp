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
   <td height="35" bgcolor="#C9D1FA" >Job Description</td>
   <td bgcolor="#E2E7EB"><p align="justify">IARI Vacancy Details:
       <br />
       Total No of Posts: 01
       <br />
       </p>
     <p align="justify">Name of the Post: Senior Research Fellow <br />
      </p>
     <p align="justify">Age Limit: Candidates age should be 35 years for men and 40 years for women.<br />
      </p>
     <p align="justify">Selection Process: Candidates will be selected based on their performance in Interview. </p>
     <p align="justify"><br />
      How to Apply:</p>
     <p align="justify"> Interested Candidates may attend walk in interview along with the biodata with full particulars i.e. qualifications, experience, NOC from the previous employer/ experience certificate, publications etc.. along with original/ attested copies of the certificates on 10-09-2013 at 10:30 AM, at the Division of Biochemistry, IARI, Pusa Institute, New Delhi – 110012.      </p>
     <p align="justify">Date & Time of Interview: 10-09-2013 at 10:30 AM
       <br />
     </p>
     <p align="justify">Venue: <br />
       The Division of Biochemistry, IARI, Pusa Institute, New Delhi -110012.
       
       <br />
       Fore more details regarding age limit, educational qualifications, selections, pay scale and other click on following link……
       
       Read more:<br />
       IARI Recruitment 2013 – Walk in for Sr Research Fellow <br />
     </p>
     <p align="justify">&nbsp;</p>
     </td>
   </tr>
  <tr>
    <td height="37" bgcolor="#C9D1FA" >Experience</td>
    <td bgcolor="#E2E7EB"><c:out value="${currentJob.experiance}"></c:out></td>
  </tr>
  <tr>
    <td height="38" bgcolor="#C9D1FA">Industry Type</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="32" bgcolor="#C9D1FA">Role</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Functional Area</td>
    <td bgcolor="#E2E7EB">Research</td>
  </tr>
  <tr>
    <td height="37" bgcolor="#C9D1FA" >Education</td>
    <td bgcolor="#E2E7EB">Educational Qualification: Candidates should possess M. Sc. with specialization in Plant Biochemistry/ Plant Molecular Biology and Biotechnology. </td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Location</td>
    <td bgcolor="#E2E7EB">Venue: <br />
The Division of Biochemistry, IARI, Pusa Institute, New Delhi -110012. </td>
  </tr>
  <tr>
    <td height="32" bgcolor="#C9D1FA" >Web Site</td>
    <td bgcolor="#E2E7EB">Posts | FreeJobAlert.com http://www.freejobalert.com/iari-recruitment/17750/#ixzz2dnhczEWb</td>
  </tr>
  <tr>
    <td height="33" bgcolor="#C9D1FA">Job Posted</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  </table>  
  </div>
</body>
</html>
