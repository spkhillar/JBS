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

<spring:url value="/resources/js/jquery.js" var="resourceJq2Url"/>
<spring:url value="/resources/js/jquery.easing.js" var="resourceEasingUrl"/>
<spring:url value="/resources/js/jquery.touchSwipe.min.js" var="resourceTouchSwipeUrl"/>
<spring:url value="/resources/js/script.js" var="resourceScriptUrl"/>



<script type="text/javascript" src="${resourceJq2Url}"></script>
<script type="text/javascript" src="${resourceEasingUrl}"></script>
<script type="text/javascript" src="${resourceTouchSwipeUrl}"></script>
<script type="text/javascript" src="${resourceScriptUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceEnquiryCssUrl}"/>
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
    <td height="27" colspan="2" class="menutd"><div class="wrap" align="center">
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
      </ul>
    </nav>
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
           <td height="216" class="pvtinfo"><ul>
          	<li>Senior Java Developer, Accenture India, New Delhi,Experience: 5-8 yrs.</li><a href="#">View Details</a>
      	  	<li>Sr. Technical Consultant, Adobe Systems, Noida,Experience: 5-7 yrs.</li><a href="#">View Details</a>
          	<li>SEO Consultant,Google India, Hyderabad,Experience: 6-8 yrs.</li><a href="#">View Details</a>
          	<li>Oracle Apps Consultant,Oracle India, Bangalore,Experience: 5-8 yrs</li><a href="#">View Details</a>
       		</ul>
            <a href="privatesectorjobs.jsp">View More Job</a>
       </td>
         </tr>
       </table></td>
       <td  class="joblist"><table  id="abroadtb">
         <tr bgcolor="#0099CC">
           <td bgcolor="#D1E6E7" >International Jobs</td>
         </tr>
         <tr>
           <td height="231" class="pvtinfo"><ul>
          	 <li>Assistant Manager, State Bank of India, New Delhi,Experience: 7-10 yrs </li><a href="#">View Details</a>
      	 	 <li>Station Manager, Railway Recruitment, Bhubaneswar,Experience: 5-7 yrs</li><a href="#">View Details</a>
          	<li>Assistant Professor, Indian Institite of Technology, Bhubaneswar,Experience: 6-8 yrs</li><a href="#">View Details</a>
          	<li>Research and Development Engineer, Indian Institute of TEchnology, Bhubaneswar,Experience: 5-8 yrs</li><a href="#">View Details</a>
       		</ul>
            <a href="Internationaljobs.jsp">View More Job</a>
       </td>
         </tr>
       </table></td>
       </tr>
    </table>
    <table width="88%" height="482" border="0" id="infotb">
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
    <td width="46%" height="100"><form action="j_spring_security_check" method="post">
      <table width="412" border="0" id="logintb">
        <tr>
          <td colspan="2" class="cationinfo">Login to your Profile and view recommended Jobs</td>
          </tr>
        <tr>
          <td>Username</td>
          <td><label for="textfield"></label>
            <input type="text" name="j_username" id="j_username" /></td>
          </tr>
        <tr>
          <td width="140" height="23">Password</td>
          <td width="262"><label for="textfield"></label>
            <input type="password" name="j_password" id="j_password" />
            <br /></td>
          </tr>
        <tr>
          <td height="29"><label for="checkbox2">Forgot Password?</label></td>
          <td><input type="submit" value="login"/>  </td>
          </tr>
      </table></form></td>
  </tr>
  <tr>
    <td colspan="3" rowspan="2"><img name="" src="resources/images/packages.png" width="559" height="400" alt="" /></td>
    <td height="47">HIRING NOW</td>
  </tr>
  <tr class="footer">
    <td height="281"><img name="" src="resources/images/bank-logos.gif" width="300" height="300" alt="" /></td>
  </tr>
  <tr class="footer">
    <td width="16%" height="37" >&nbsp;</td>
    <td width="16%">&nbsp;</td>
    <td width="22%">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
    </table>
</table>
    
  
<br/>
     <div id="pvtjobs"></div>
    
</body>
</html>
