<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="app.jsp"></jsp:include>
<head>

<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/enquirymenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>

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
          <a class="fNiv" href="${contextPath}/">Home</a>
          </li>
        
        <li>
          <a class="fNiv" href="${contextPath}/normal/user/retrieveuser/${currentLoggedInUserId}">My Profile</a>
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
</body>
</html>