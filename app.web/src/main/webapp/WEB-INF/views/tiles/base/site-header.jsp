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
<spring:url value="/" var="homeUrl" htmlEscape="true"/>
<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/enquirymenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>


<style>    
* { margin: 0; padding: 0; }

html { height: 100%; font-size: 62.5% }

body { height: 100%; background-color: #FFFFFF; font: 1.2em Verdana, Arial, Helvetica, sans-serif; }


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

<script type="text/javascript">
    function ChangeColor(tableRow, highLight)
    {
    if (highLight)
    {
      tableRow.style.backgroundColor = '#dcfac9';
    }
    else
    {
      tableRow.style.backgroundColor = 'white';
    }
  }

  function DoNav(theUrl)
  {
  document.location.href = theUrl;
  }
  </script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table border="0" id="indextb">
  <tr>
    <td width="222"></td>
    <td width="304"></td>
    <td width="140">
  </td>
    <td width="548" colspan="2">
    <form action="j_spring_security_check" method="post">
    	<label style="font-size: 12px;"><font color="#004364">Job Seeker Login</font> &nbsp;&nbsp;&nbsp;&nbsp;</label>
	      <input type="text" name="j_username" placeholder="Enter your user id"/>
	      <input type="password" placeholder="Enter your Password" name="j_password" />
	      <input type="submit" value="Login"/>
				<c:choose>
				    <c:when test="${empty message}">
				      <div class="message">${emptySring}</div>
				    </c:when>
				    <c:otherwise>
				       <div class="message">${message}</div>
				    </c:otherwise>
				</c:choose>
    </form>
    </td>
  </tr>
  <tr>
    <td><img src="resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td><img name="" src="resources/images/joblogo1.png" width="145" height="60" alt="" /><img name="" src="resources/images/joblogo3.png" width="147" height="60" alt="" /></td>
    <td colspan="3"><div class="wrap" align="center">
      <nav>
        <ul class="menu">
          <li> <a class="fNiv" href="${homeUrl}">Home</a> </li>
          <li> <a class="fNiv" href="register/">Register</a> </li>
          <li> <a class="fNiv" href="#">Login</a> </li>
          <li> <a class="fNiv" id="enquiry" href="mypage/enquiry/">Enquiry</a></li>
          </ul>
        <div class="clearfix"></div>
        </nav>
    </div></td>
  </tr>
  <tr>
    <td height="27" colspan="5" class="menutd"><div class="wrap1" align="center">
    <table id="submenu" border="0">
      <tr>
      <td>
    <nav>
      <ul class="menu">
      
        <li>
          <a class="fNiv">Central Govt Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="#">State Govt Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="#">Private Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="#">IT Jobs</a> </li>
    
        <li>
          <a class="fNiv">Banking Jobs</a>
          </li>
         <li>
          <a class="fNiv">Railway Jobs</a>
          </li>
          <li>
          <a class="fNiv">Finance Jobs</a>
          </li>
          <li>
          <a class="fNiv">Marketing Jobs</a>
          </li>
                
      </ul>
       <div class="wrap1" ></div>
    </nav>
    </td></tr></table>
    </div>
    </td>
    </tr>
    </table>
</body>
</html>