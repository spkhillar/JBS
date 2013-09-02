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
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="53%" height="504"  border="1" align="center" id="jobdetail">
<tr>
    <td width="114"><img src="../resources/images/JBS_LOGO.png" id="logo"></img></td>
    
    </tr>
  <tr>
    <td height="28" bgcolor="#C9D1FA" >Designation</td>
     <td width="550" bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  
  <tr>
   <td height="35" bgcolor="#C9D1FA" >Job Description</td>
   <td bgcolor="#E2E7EB"><p>&nbsp;</p>
     <p>&nbsp;</p>
    <p>&nbsp;</p></td>
   </tr>
  <tr>
    <td height="37" bgcolor="#C9D1FA" >Experience</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
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
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="37" bgcolor="#C9D1FA" >Education</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="34" bgcolor="#C9D1FA" >Location</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="32" bgcolor="#C9D1FA" >Web Site</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td height="33" bgcolor="#C9D1FA">Job Posted</td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#C9D1FA" ><input type="submit" name="button" class="button small pop2" value="Apply"  /></td>
    <td bgcolor="#E2E7EB">&nbsp;</td>
  </tr>
  </table>  
</body>
</html>
