<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../tiles/base/app.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceHeadMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>

<style>
* { margin: 0; padding: 0; }
#usertbdesign.menuhd td {
	font-size: 12px;
	font-weight: bold;
}
#usertbdesign.menuhd td {
	color: #000080;
}
#usertbdesign .header1 td {
	font-size: 24px;
}
#usertbdesign .he td {
	font-size: 24px;
	font-family: Candara;
	color: #FFF;
}
#usertbdesign .header2 td {
	font-size: 12px;
	font-weight: bold;
}
#usertbdesign {
	font-size: 14px;
	margin: auto;
}

 
</style>

<spring:url value="/resources/js/userregister.js" var="resourceUserRegisterJqUrl"/>
<spring:url value="/resources/css/newuser.css" var="resourceNewUserCssUrl"/>

<script type="text/javascript" src="${resourceUserRegisterJqUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceNewUserCssUrl}"/>
<script>
	qualificationRowIndex = parseInt("<c:out value="${qualificationCount}" />");
</script>
	
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form name="registrationForm" commandName="registration" id="registrationForm" enctype="multipart/form-data" method="POST">
<table  border="0" id="usertbdesign" align="center">
<c:if test="${currentLoggedInUserId eq null}">
<tr id="he">
  <td colspan="7" align="center" bgcolor="#0066CC" >Register to JOBSbySMS and receive job alerts on your mobile</td>
</tr>
</c:if>
<tr bgcolor="#FFFFFF" class="header2">
  <td colspan="7"><h4>Login Details</h4></td>
  </tr>
<tr class="header">
  <td width="1%" height="26">&nbsp;</td>
  <td colspan="5" rowspan="3">
  <table border="0" id="logininfotb">
    <tr>
      <td width="36%">Username<em>*</em></td>
      <td width="64%">
      <c:choose>
      <c:when test="${currentLoggedInUserId eq null}">
       <form:input path="user.userName" />
       </c:when>
       <c:otherwise>
       <form:input path="user.userName" disabled="true"/>
       </c:otherwise>
       </c:choose>
       </td>
    </tr>
    <tr>
      <td width="36%">Enter your Email id<em>*</em></td>
      <td width="64%"> <form:input path="user.email" /></td>
    </tr>
    <c:if test="${currentLoggedInUserId eq null}">
    <tr>
      <td>Create a Password for your account<em>*</em></td>
      <td> <form:password path="user.password" /></td>
    </tr>
    <tr>
      <td height="27">Confirm the Password<em>*</em></td>
      <td> <form:password path="confirmPassword" /></td>
    </tr>
    </c:if>
     <tr>
      <td height="27">Select your security Question</td>
      <td> <form:select path="securityQuestion" items="${securityQuestions}" ></form:select>
      </td>
    </tr>
    <tr>
      <td height="27">Answer<em>*</em></td>
      <td> <form:input path="securityAnswer" /></td>
    </tr>
     <tr>
      <td height="27">Date of Birth<em>*</em></td>
      <td> <form:input path="user.dateOfBirth" /></td>
    </tr>
  </table>
     <label for="text2"></label>
    </td>
  <td width="1%">&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td height="36">&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr bgcolor="#FFFFFF" class="header2">
  <td height="21" colspan="7"><h4>Address Information</h4></td>
  </tr>
<tr class="header">
  <td>&nbsp;</td>
  <td colspan="5" rowspan="8">
    <label for="funarea"></label>
    
    <table width="206" border="0" id="addressinfotb">
      <tr>
        <td width="270">First Name<em>*</em></td>
        <td width="480"> <form:input path="user.firstName" ></form:input></td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td><form:input path="user.lastName" ></form:input></td>
      </tr>
      <tr>
        <td>Address Line1<em>*</em></td>
        <td><form:input path="user.address.addressLine1" ></form:input> </td>
      </tr>
      <tr>
        <td>Address Line2</td>
        <td><form:input path="user.address.addressLine2" ></form:input> </td>
      </tr>
      <tr>
        <td>State</td>
        <td><form:select path="user.address.state" items="${states}" ></form:select> </td>
      </tr>
      <tr>
        <td>City<em>*</em></td>
        <td>
          <form:input path="user.address.city" ></form:input></td>
      </tr>
      <tr>
        <td>Mobile Number<em>*</em></td>
        <td><form:input path="user.phone" ></form:input></td>
      </tr>
      <tr>
        <td>Pin code<em>*</em></td>
        <td><form:input path="user.address.pin" ></form:input></td>
      </tr>
    </table></td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr class="header">
  <td height="21"><h4>&nbsp;</h4></td>
  <td><h4>&nbsp;</h4></td>
</tr>
<tr bgcolor="#FFFFFF" class="header2">
  <td colspan="7"><h4>
    <label for="othercity"></label>
    Current Employment Details</h4></td>
  </tr>
<tr class="header">
  <td>&nbsp;</td>
  <td colspan="5"><table width="695" border="0" id="workinfotb">
    <tr>
      <td width="274">Work Experience</td>
      <td width="476">
      <form:select path="user.skill.yearOfExperiance" items="${workExperianceList}" ></form:select>
      </td>
    </tr>
    <tr>
      <td>Key Skills<em>*</em></td>
      <td>
      <form:textarea path="user.skill.skills" />
      </td>
    </tr>
    <tr>
      <td>Which Functional area do you work in?</td>
      <td>
      <form:select path="user.skill.functionalArea" items="${jobsFunctionalAreaList}" ></form:select>
      </td>
    </tr>
  </table></td>
  <td>&nbsp;</td>
</tr>
<tr bgcolor="#FFFFFF" class="header2">
  <td colspan="7"><h4> Educational Qualification</h4></td>
  </tr>
<tr class="header">
  <td>&nbsp;</td>
  <td colspan="5"><table width="762" border="0" id="educationinfotb">
    <tr>
      <td width="261">Certification</td>
        <td width="212">Board/University<em>*</em></td>
        <td width="189">Year of Passing<em>*</em></td>
        <td width="234">Percentage/CGPA<em>*</em></td>
      </tr>
      
     <c:choose>
  <c:when test="${currentLoggedInUserId eq null}">
      <tr>
      <td>
      	<form:select path="degree" items="${degreeList}" ></form:select>
      </td>
      <td>
      	<input type="text" name="user.qualifications[0].boardOrUniversity"  required/>
      </td>
      <td>
       <input type="number" name="user.qualifications[0].yearOfPassing"  required/>
      </td>
      <td>
       <input type="number" name="user.qualifications[0].percentage"  required/>
      </td>
      </tr>
  </c:when>
  <c:otherwise>
	  <c:forEach var="qualification" items="${qualifications}" varStatus="status">
	  <tr>
	   <td>
      	<form:select path="degree" items="${degreeList}" ></form:select>
      </td>
      <td>
      	<input type="text" name="user.qualifications[${status.index}].boardOrUniversity" value="${qualification.boardOrUniversity}" autofocus required/>
      </td>
      <td>
       <input type="number" name="user.qualifications[${status.index}].yearOfPassing" value="${qualification.yearOfPassing}" autofocus required/>
      </td>
      <td>
       <input type="number" name="user.qualifications[${status.index}].percentage" value="${qualification.percentage}" autofocus required/>
      </td>
	  </tr>
	  </c:forEach>
	  
  </c:otherwise>
  </c:choose>
  </table>
  <td>&nbsp;</td>
</tr>
<tr bgcolor="#FFFFFF" class="header2">
  <td>&nbsp;</td>	
  <td colspan="2">Upload Your Detailed Resume Document</td>
  <td colspan="3"><h5>
    <input type="file" name="resume" id="resume" />
    <br />
    Supported Formats: doc, docx, rtf, pdf. Max file size: 300 Kb</h5></td>
  <td>&nbsp;</td>
  </tr>
<tr bgcolor="#330000" class="header2">
  <td colspan="7">&nbsp;</td>
  </tr>
<tr class="header2">
  <td bgcolor="#FFFFFF"><h4>&nbsp;</h4></td>
  <td colspan="5" bgcolor="#FFFFFF"><h4>SMS Mail &amp; Privacy Settings</h4></td>
  <td ><h4>&nbsp;</h4></td>
</tr>
<tr class="header2">
  <td >&nbsp;</td>
  <td bgcolor="#FFFFFF"><h5>
  <form:checkbox path="user.signedForNotification" />
    Notifications from JobsbySMS</h5></td>
  <td colspan="4" bgcolor="#FFFFFF"><h5>
  <form:checkbox path="terms"/>
    I have read and understood and agree to the
    <span class="my_modal_open">
    <a href="javascript:void(0);" onclick="javascript:loadTermsAndConditions();">Terms &amp; Conditions</a> governing the use of JobsbySMS.com</span></h5>
          
           
  </td>
  <td >
  
  </td>
</tr>
<tr class="header2">
  <td >&nbsp;</td>
  <c:choose>
  <c:when test="${currentLoggedInUserId eq null}">
	  <td colspan="5" align="center" bgcolor="#FFFFFF">
	  <button id="registerBtn" onclick="registerUser();">Join to JobsbySMS</button>
	  </td>
  </c:when>
  <c:otherwise>
	  <td colspan="5" align="center" bgcolor="#FFFFFF">
	  <button id="registerBtn" onclick="registerUser();">Update Profile</button>
	  </td>
  </c:otherwise>
  </c:choose>
  <td ></td>
</tr>
</table>

<form:hidden path="user.id" />
</form:form>

<div id="termsandconditiondiv" title="Terms and Conditions">
   </div>
</body>

</html>
