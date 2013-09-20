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
    <th scope="col"><div id="site_title"></div></th>
    <th scope="col"><div id="site_title1"></div></th>
    <td scope="col" colspan="2" class="siteheadercells">
    <label style="font-size: 12px;">
    <font color="#004364">Login</font></label>
    <form action="${contextPath}/j_spring_security_check" method="post">
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
    <label><a href="${contextPath}/manage/forgotpassword">Forgot Password</a></label>
    </td>
  </tr>
    <tr>
    <td class="siteheadercells"></td>
    <td class="siteheadercells"></td>
    
    <td colspan="2"><div class="wrap">
      <nav>
        <ul class="menu">
          <li> <a class="fNiv" href="${homeUrl}">Home</a> </li>
          <li> <a class="fNiv" href="${contextPath}/register/">Register</a> </li>
          <li> <a class="fNiv" id="enquiry" href="${contextPath}/mypage/enquiry/">Enquiry</a></li>
          </ul>
        <div class="clearfix"></div>
        </nav>
    </div></td>
  </tr>
 <tr>
    <td height="27" colspan="4" class="menutd">
    <div class="wrap1" align="center">
    <table id="submenu">
      <tr>
      <td>
    <nav>
      <ul class="menu">
      
        <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/1">Central Govt Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/2">State Govt Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/3">Private Jobs</a>
          </li>
        
        <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/4">IT Jobs</a> </li>
    
        <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/5">Banking and Finance Jobs</a>
          </li>
         <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/6">Railway Jobs</a>
          </li>
          <li>
          <a class="fNiv" href="${contextPath}/admin/job/site/detail/8">Marketing Jobs</a>
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