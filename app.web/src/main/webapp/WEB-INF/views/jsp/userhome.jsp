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
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/enquirymenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<spring:url value="/resources/js/jquery.js" var="resourceJq2Url"/>




<script type="text/javascript" src="${resourceJq2Url}"></script>


<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>

<style>

#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
	text-align: justify;
}
#govttb2 tr .pvtinfo strong {
	font-size: 18px;
	text-align: justify;
}
#govttb2 tr .pvtinfo #govttb3 {
	text-align: left;
}
#govttb2 tr .pvtinfo div {
	font-weight: bold;
}
#govttb2 tr .pvtinfo h1 {
	color:#76gu;
}
</style>

</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table height="159" border="0" id="indextb">
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
    <td height="17" colspan="6" class="menutd"><div class="wrap" align="center">
    
    <nav>
      <ul class="menu">
        <li>
          <a class="fNiv" href="/nitin_swadhin/">Home</a>
          </li>
        
        <li>
          <a class="fNiv" href="register/retrieveuser/${currentLoggedInUserId}">My Profile</a>
          </li>
        
        <li>
          <a class="fNiv">News</a>
          </li>
        
        <li>
          <a class="fNiv"  href="#">Recommended Jobs</a> </li>
        
        <li>
          <a class="fNiv">Recruiters</a>
          </li>
        
        <li><a class="fNiv">Upgrade</a>
           </li>
      </ul>
      <div class="clearfix"></div>
      </nav>
    </div></td>
  </tr>
</table>
  <tr>
    <td height="22" colspan="6">
     <div >
     <table width="80%" id="govttb2">
       <tr bgcolor="#FFFFFF">
         <td height="36" colspan="4">Welcome ${currentLoggedInUser} Get Instant Jobs Now on Your Mobile </td>
         <td height="36" colspan="4"><img name="" src="resources/images/subscribe.jpg" width="138" height="39" alt="" /></td>
         <td width="14%">&nbsp;</td>
       </tr>
       <tr>
         <td height="23" colspan="4" class="pvtinfo"><h1>Profile Summary</h1></td>
         <td colspan="4"  class="pvtinfo">&nbsp;</td>
         <td rowspan="4" class="pvtinfo"><p><img name="" src="resources/images/dummy_image.png" width="109" height="114" alt="" align="right"/></p>
          <p>&nbsp;</p></td>
       </tr>
       
       <tr bgcolor="#FFFFFF">
         <td class="pvtinfo"><div align="left">Designation</div></td>
         <td colspan="3" class="pvtinfo"><div align="left">Project Manager</div></td>
         <td width="8%" class="pvtinfo">&nbsp;</td>
         <td colspan="3" class="pvtinfo">&nbsp;</td>
        </tr>
       <tr bgcolor="#FFFFFF">
         <td width="11%" height="28" class="pvtinfo"><div align="left">Work Experience</div></td>
         <td colspan="3" class="pvtinfo"><div align="left">5-10 Years</div></td>
         <td class="pvtinfo">&nbsp;</td>
         <td colspan="3" class="pvtinfo">&nbsp;</td>
        </tr>
       <tr bgcolor="#FFFFFF">
         <td height="33" class="pvtinfo"><div align="left">Key Skills</div></td>
         <td colspan="3" class="pvtinfo">&nbsp;</td>
         <td class="pvtinfo">&nbsp;</td>
         <td width="9%" class="pvtinfo">&nbsp;</td>
         <td width="4%" class="pvtinfo">&nbsp;</td>
         <td width="29%" class="pvtinfo">&nbsp;</td>
        
       </tr>
       
       <tr>
         <td colspan="4" class="pvtinfo">&nbsp;</td>
         <td colspan="4" class="pvtinfo">&nbsp;</td>
         <td class="pvtinfo">&nbsp;</td>
       </tr>
       <tr>
         <td colspan="9" class="pvtinfo">News!!!</td>
       </tr>
       <tr>
         <td colspan="8" class="pvtinfo">&nbsp;</td>
         <td class="pvtinfo"><p>&nbsp;</p>
           <p>&nbsp;</p>
          <p>&nbsp;</p></td>
       </tr>
       <tr>
         <td class="pvtinfo"><p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p></td>
         <td colspan="3" class="pvtinfo">&nbsp;</td>
         <td colspan="4" class="pvtinfo">&nbsp;</td>
         <td class="pvtinfo">&nbsp;</td>
       </tr>
       </table>
     <div></div>
     </div>
<br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
