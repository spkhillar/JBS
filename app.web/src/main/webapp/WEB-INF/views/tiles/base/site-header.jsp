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


html { height: 100%; font-size: 62.5% }



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
    <th scope="col"><a href="http://www.jobsbysms.com" title="Premium Website for Job Opportunities,Business Network etc.."><div id="site_title"></div></a></th>
    <th scope="col"><div id="site_title1"></div></th>
    <td scope="col" colspan="2" class="siteheadercells">
     <form action="${contextPath}/j_spring_security_check" method="post">
    	  <input type="text" name="j_username" placeholder="Enter your username" style="float: left"/>
    	  <input type="password" placeholder="Enter your Password" name="j_password" style="text-align:center; margin-left: 6px"/>
	      <input type="submit" value="Login" style="width:20%; height:28px; float: right"/> 
	      <br><label style="font-size: 12px;color: blue; font-style: normal;">
	      <br><a href="${contextPath}/manage/forgotpassword" style="float:left">Forgot Password</a>
	      </label>
	      
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