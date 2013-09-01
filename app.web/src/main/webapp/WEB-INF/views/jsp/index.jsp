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
<title>JOBSbySMS-Home Page</title>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>

<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>
<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJq2Url"/>
<spring:url value="/resources/js/jquery.easing.js" var="resourceEasingUrl"/>
<spring:url value="/resources/js/jquery.touchSwipe.min.js" var="resourceTouchSwipeUrl"/>
<spring:url value="/resources/js/script.js" var="resourceScriptUrl"/>



<script type="text/javascript" src="${resourceJq2Url}"></script>
<script type="text/javascript" src="${resourceEasingUrl}"></script>
<script type="text/javascript" src="${resourceTouchSwipeUrl}"></script>
<script type="text/javascript" src="${resourceScriptUrl}"></script>

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
</style>


</head>

<body>
<table border="0" id="indextb">
  <tr>
    <td><img src="resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td><div class="wrap" align="center">
    <nav>
      <ul class="menu">
        <li>
          <a class="fNiv" href="${contextPath}/">Home</a>
          </li>
        
        <li>
          <a class="fNiv" href="register/">Register</a>
          </li>
        
        <li>
          <a class="fNiv" href="#">Login</a>
          </li>
        
        <li>
          <a class="fNiv" id="enquiry" href="mypage/enquiry/">Enquiry</a> </li>
        
        <li>
          <a class="fNiv">Contact Us</a>
          </li>
        
        <li><a class="fNiv">About Us</a>
           </li>
      </ul>
      <div class="clearfix"></div>
      </nav>
    </div></td>
  </tr>
  <tr>
  <td colspan="6"><div id="loginbox" style="float:right; font-size: 12px;">
  <form action="j_spring_security_check" method="post">
  <font color="blue">Existing User</font> &nbsp; <input type="text" name="j_username" placeholder="Enter your user id"/> &nbsp; <input type="password" placeholder="Enter your Password" name="j_password" />
  <input type="submit" value="Login"/>
  </form></div></td>
  
  </tr>
  <tr>
    <td height="27" colspan="2" class="menutd"><div class="wrap1" align="center">
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
    <td height="22" colspan="2"><table id="jobtb">
      <tr bgcolor="#DCDAFC">
       <td height="260" class="joblist">
     <table width="149" id="govttb">
	 <tr bgcolor="#0099CC"><td bgcolor="#D1E6E7">Latest Government Jobs</td></tr>
      <tr>
        <td height="231" class="pvtinfo">
        <ul>
          <li>Assistant Manager, State Bank of India, New Delhi,Experience: 7-10 yrs.</li><a href="#">View Details</a>
          <li>Station Manager, Railway Recruitment Board, Bhubaneswar,Experience: 5-7 yrs.</li><a href="#">View Details</a>
          <li>Assistant Professor, Indian Institite of Technology, Bhubaneswar,Experience: 6-8 yrs.</li><a href="#">View Details</a>
          <li>Research and Development Engineer, Indian Institute of Technology, Bhubaneswar,Experience: 5-8 yrs.</li><a href="#">View Details</a>
       </ul>
       <a href="governmentjobs.jsp">View More Job</a>
      </td>
      </tr>
      </table>
      </td>
       <td class="joblist"><table id="privatetb">
         <tr bgcolor="#0099CC">
           <td bgcolor="#D1E6E7">Private Sector Jobs</td>
           </tr>
         <tr>
           <td height="247" class="pvtinfo"><ul>
             <li>Senior Java Developer, Accenture India, New Delhi,Experience: 5-8 yrs.</li><a href="#">View Details</a>
             <li>Sr. Technical Consultant, Adobe Systems, Noida,Experience: 5-7 yrs.</li><a href="#">View Details</a>
             <li>SEO Consultant,Google India, Hyderabad,Experience: 6-8 yrs.</li><a href="#">View Details</a>
             <li>Oracle Apps Consultant,Oracle India, Bangalore,Experience: 5-8 yrs</li><a href="#">View Details</a>
             </ul>
             <a href="privatesectorjobs.jsp">View More Job</a>
             </td>
           </tr>
       </table></td>
       </tr>
    </table>
    <table width="86%" height="525" border="0" id="infotb">
  <tr>
    <td height="100" colspan="3"><table width="626" border="0" align="center" id="jobsearch">
      <tr>
        <td colspan="4" class="cationinfo">Job Search</td>
      </tr>
      <tr>
        <td>Key Skills</td>
        <td><input type="text" name="skills" id="skills" /></td>
        <td>Location</td>
        <td><label for="textfield2"></label>
          <input type="text" name="location" id="location" /></td>
      </tr>
      <tr>
        <td width="137" height="23">Functional area</td>
        <td width="172"><select name="selectfunctionalarea" id="selectfunctionalarea">
        </select></td>
        <td width="94">Experience</td>
        <td width="205"><label for="select"></label>
          <select name="experience" id="Experience">
          </select></td>
      </tr>
      <tr>
        <td height="38" colspan="2"><label for="checkbox3">
          <input type="submit" name="button" id="button" value="Search" />
        </label></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
    </td>
    <td width="6%" height="100"><img src="resources/images/sbilogo.png" width="98" height="81" longdesc="http://www.onlinesbi.com" /></td>
    <td width="17%"><img src="resources/images/canarabanklogo.png" width="98" height="81" /></td>
    <td width="7%"><img src="resources/images/pnblogo.png" width="98" height="81" /></td>
    <td width="28%"><img src="resources/images/irctclogo.jpg" width="98" height="81" /></td>
  </tr>
  <tr>
    <td colspan="4" ><img name="" src="resources/images/packages.png" width="500" height="380" alt="" /></td>
    <td colspan="3"><table width="512" height="366" border="0" align="right" id="adtable">
      <tr>
        <td width="313" height="31" colspan="4" class="cationinfo">Advertisement</td>
      </tr>
      <tr>
        <td colspan="4" class="adimg"><img src="resources/images/advert.png" width="256" height="197" /></td>
      </tr>
      </table></td>
  </tr>
  <tr class="footer">
    <td width="1%" height="37" >&nbsp;</td>
    <td width="1%">&nbsp;</td>
    <td width="40%">&nbsp;</td>
    <td colspan="4">&nbsp;</td>
  </tr>
    </table>
</table>
    
  
<br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
