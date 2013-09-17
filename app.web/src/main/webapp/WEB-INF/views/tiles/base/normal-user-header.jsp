<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
<jsp:include page="app.jsp"></jsp:include>
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
<table border="0" id="indextb">
  <tr>
    <td width="25%">
    <div id="site_title"></div>
    </td>
    <td width="25%" height="34">&nbsp;</td>
    <td width="25%" height="34">&nbsp;</td>
    <td width="25%" height="34"></td>
    <td width="25%" height="34" colspan="2">
    	<jsp:include page="usersettings.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td><div id="userhome"><a href="${contextPath}/" >Home</a></div></td>
    <td colspan="4"></td>
  </tr>
</table>

</body>
</html>