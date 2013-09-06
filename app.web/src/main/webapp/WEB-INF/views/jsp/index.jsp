<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<jsp:include page="../tiles/base/app.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JOBSbySMS-Home Page</title>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceHeadMenuCssUrl}"/>
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
          <li> <a class="fNiv" href="${contextPath}/nitin_swadhin/">Home</a> </li>
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
    </div></td>
  </tr>
  
  <tr>
    <td height="680" colspan="5"><table id="jobtb">
      <tr>
       <td height="260" class="joblist">
     <table width="100%" id="govttb">
	 <tr>
	 <td class="jobheading">Private Sector Jobs</td>
	 </tr>
      <tr>
        <td class="pvtinfo">
         <div id="indexjobinfo">
           <ul>
         <c:forEach var="privateJob" 

items="${privateJobList}" varStatus="status">
         	<li><strong><c:out 

value="${privateJob.companyName}"></c:out>, 

<c:out 

value="${privateJob.designation}"></c:out>, 

<c:out value="${privateJob.location}"></c:out>
         	 (<c:out 

value="${privateJob.experiance}"></c:out> yrs)

</strong> | </li> <a href="javascript:void(0);" onclick="javascript:loadJobDetails(${privateJob.id});">View Details</a>
         </c:forEach>
       </ul>
        </div>
           </td>
      </tr>
      </table>
      </td>
       <td class="joblist"><table width="100%" id="privatetb">
         <tr >
           <td class="jobheading">Public Sector Jobs</td>
           </tr>
         <tr>
           <td class="pvtinfo">
           <c:forEach var="publicJob" items="${publicJobList}" varStatus="status">
           <div id="indexjobinfo" title="View Detail">
         <ul>
	           	<li><strong>
	           	<c:out value="${publicJob.companyName}"></c:out>, <c:out value="${publicJob.designation}">
	           	</c:out>, <c:out value="${publicJob.location}"></c:out>
	         	 (<c:out value="${publicJob.experiance}"></c:out> yrs)</strong> | </li>
	         	  <a href="javascript:void(0);" onclick="javascript:loadJobDetails(${publicJob.id});">View Details</a>
	      </ul>
        </div>
        </c:forEach> 
         
    </div>
             </td>
           </tr>
       </table></td>
       </tr>
    </table>
    <table width="93%" height="312" border="0" id="infotb">
  <tr>
    <td width="56%" height="100"><table width="557" border="0" align="center" id="jobsearch">
      <tr>
        <td colspan="2" class="cationinfo">Job Search</td>
        </tr>
      <tr>
        <td class="cationinfo">Key Skills</td>
        <td class="cationinfo">Functional area</td>
        </tr>
      <tr>
        <td width="183" height="22"><input type="text" name="skills" id="skills" /></td>
        <td width="364"><select name="selectfunctionalarea" id="selectfunctionalarea">
          <option value="IT">Application Mantainance/Software/Programming/Design</option>
        </select></td>
        </tr>
      <tr>
        <td height="14" class="cationinfo">Location</td>
        <td height="14" class="cationinfo">Experience</td>
        </tr>
      <tr>
        <td height="38"><input type="text" name="location" id="location" /></td>
        <td height="38"><select name="experience" id="Experience">
        </select></td>
        </tr>
      <tr>
        <td height="38" colspan="2"><input type="submit" name="button" id="button" value="Search" /></td>
        </tr>
</table>
    </td>
    <td width="44%" colspan="4" rowspan="2"><img src="resources/images/packages.png" width="480" height="308" /></td>
    </tr>
  <tr>
    <td height="152" ><table width="537" border="0" align="center" id="hiringlogo">
      <tr>
        <td colspan="6" class="cationinfo">Hiring Now</td>
        </tr>
      <tr>
        <td width="53"><img name="" src="resources/images/saillogo.jpg" width="91" height="76" alt="" /></td>
        <td width="89"><img name="" src="resources/images/sbilogo.png" width="91" height="76" alt="" /></td>
        <td width="89"><img name="" src="resources/images/canarabanklogo.png" width="91" height="76" alt="" /></td>
        <td width="89"><img name="" src="resources/images/pnblogo.png" width="91" height="76" alt="" /></td>
        <td width="89"><img name="" src="resources/images/irctclogo.jpg" width="91" height="76" alt="" /></td>
        <td width="102"><img name="" src="resources/images/ibpslogo.jpg" width="91" height="76" alt="" /></td>
      </tr>
      <tr>
        <td height="18" colspan="6">&nbsp;</td>
      </tr>
    </table></td>
    </tr>
    </table>
    <p align="center">All Rights Reserved &COPY; 2013 JOBSbySMS</p>
</table>
    
  
<br/>
     
   <div id="jobdetailsdiv" title="Job Details">
   </div>
    
    
</body>
</html>
