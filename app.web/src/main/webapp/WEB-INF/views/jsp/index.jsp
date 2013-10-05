<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
<jsp:include page="../tiles/base/app.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

<script type="text/javascript">

   
</script>

</head>

<body>
   <table id="indextb">
   <tr>
     <td>
      <table id="privatetb">
      <tr>
	 <td class="jobheading">Private Sector Jobs</td>
	 </tr>
      <tr>
        <td class="pvtinfo">
         <c:forEach var="privateJob" items="${privateJobList}" varStatus="status">
         <div id="indexjobinfo">
           <ul>
           	<li>
           	<strong>
         	
				<c:out value="${privateJob.companyName}"></c:out>, 
				
				<c:out value="${privateJob.designation}"></c:out>, 
				
				<c:out value="${privateJob.location}"></c:out>
				(<c:out value="${privateJob.experiance}"></c:out> years)

			</strong> | 
			<a href="javascript:void(0);" onclick="javascript:loadJobDetails(${privateJob.id});">View Details</a>
			</li> 
			
		 </ul>
        </div>
         </c:forEach>
           </td>
      </tr>
      </table>
      <table id="govttb">
      <tr >
           <td class="jobheading">Public Sector Jobs</td>
           </tr>
         <tr>
           <td class="pvtinfo">
           <c:forEach var="publicJob" items="${publicJobList}" varStatus="status">
           <div id="indexjobinfo" title="View Detail">
         <ul>
	           	<li>
	           	<strong>
	           		<c:out value="${publicJob.companyName}"></c:out>, 
	           		<c:out value="${publicJob.designation}"></c:out>, 
	           		<c:out value="${publicJob.location}"></c:out>
	         	 (<c:out value="${publicJob.experiance}"></c:out> yrs)
	         	</strong> | 
	         	<a href="javascript:void(0);" onclick="javascript:loadJobDetails(${publicJob.id});">View Details</a>
	         	 </li>
	        
	      </ul>
        </div>
        </c:forEach> 
         
    </div>
             </td>
           </tr>
      </table>
     
     </td>
   </tr>
    <tr>
  <td>
    <table width="93%" height="312" border="0" id="infotb">
    <tr>
    <td width="56%" height="100">
    <form:form name="registrationForm" commandName="registration" id="registrationForm" method="POST">
    <table width="557" border="0" align="center" id="jobsearch">
      <tr>
        <td colspan="2" class="cationinfo">Job Search</td>
        </tr>
      <tr>
        <td class="cationinfo">Key Skills</td>
        <td class="cationinfo">Functional area</td>
        </tr>
      <tr>
        <td width="183" height="22">
        	<input type="text" name="skills" id="skills" />
        </td>
        <td width="364">
        	<form:select path="user.skill.functionalArea" items="${jobsFunctionalAreaList}"></form:select>
        </td>
        </tr>
      <tr>
        <td height="14" class="cationinfo">Location</td>
        <td height="14" class="cationinfo">Experience</td>
        </tr>
      <tr>
        <td height="38">
        	<input type="text" name="location" id="location" />
        </td>
        <td height="38">
        	<form:select path="user.skill.yearOfExperiance" items="${workExperianceList}" ></form:select>
        </td>
        </tr>
      <tr>
        <td height="38" colspan="2">
        	<input type="submit" name="button" id="button" value="Search" />
        </td>
        </tr>
</table>
</form:form>
    </td>
    <td width="44%" colspan="4" rowspan="2">
    	<img src="resources/images/packages.png" width="480" height="308" />
    </td>
    </tr>
  <tr>
    <td height="152" >
    <table width="537" border="0" align="center" id="hiringlogo">
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
    </table>
    </td>
    </tr>
   </table>
    </td>
   </tr>
    </table>
    <p align="center">All Rights Reserved &COPY; 2013 JOBSbySMS</p>
</table>
<div id="applyJobDiv" title="Apply Job">
    <span>Inorder to apply this job, Please register/login to jobsbysms.com.</span>
   </div>
   <div id="jobdetailsdiv" title="Job Details">
   </div>
</body>    
</html>
    

