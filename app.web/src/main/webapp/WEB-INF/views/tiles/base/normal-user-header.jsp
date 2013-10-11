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
<style>    
* { margin: 0; padding: 0; }

#indextb tr td #jobtb tr .joblist form fieldset label {
	text-align: left;
}
#indextb tr td #infotb .footer td img {
	text-align: center;
}
#indextb tr td table {
	text-align: center;
}


</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table border="0" id="indextb">
  <tr>
    <td width="30%">
     <a href="http://www.jobsbysms.com">
    	<div class="siteheadercells" id="site_title"></div>
     </a>
    </td>
    <td width="30%"></td>
    <td width="30%" height="34">
    	<div id="site_title1"></div>
    </td>
    <td width="30%" height="34"></td>
    <td width="30%" height="34" colspan="2">
    	<jsp:include page="usersettings.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td>
    	<div id="userhome">
    		<a href="${contextPath}/" >Home</a>
    	</div>
    </td>
    <td colspan="4"></td>
  </tr>
</table>
</body>
</html>