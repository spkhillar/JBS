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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register on JobsbySMS.com</title>
<link rel="shortcut icon" href="resources/images/favico.png"/>
<style>
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
}

 body
            {
                margin: 0;
                padding: 0;
            }
            #wrapper
            {
                width: 80%;
                height: 80%;
            }
            #popup
            {
                display: none;
                width: 50%;
                height: auto;
                overflow: auto;
                left: 35%;
                top: 20%;
                position: absolute;
                z-index: 2000;
                border: 2px solid #d57111;
                background: #f9f9f9;
                padding-bottom: 20px
            }
            #main
            {
                width: 600px;
                height: 150px;
                margin-top: 200px;
                margin-left: 250px;
                margin-right: auto;
                padding: 30px;
                border: 1px solid #ddd;
                font-size: 25px;
                color: #555;
                line-height: 35px;
                letter-spacing: 2px;
                padding-left: 250px;
            }
            #main input
            {
                width: 350px;
                height: 50px;
                background: transparent;
                border: 1px solid #222;
                background: deepskyblue;
                color: #fff;
                font-size: 20px;
                line-height: 35px;
                letter-spacing: 2px;
            }
            #main input:hover
            {
                cursor: pointer;
                background: dodgerblue;
            }
            #overlay
            {
                display: none;
                width: 80%;
                height: 700px;
                left: 0;
                top: 0;
                position: absolute;
                z-index: 1000;
                background: opaque;
               
            }
            #popup input
            {
                float: right;
                margin-right: 30px;
                border: none;
                background: transparent;
                width: 100px;
                height: 30px;
                background: #d57111;
                color: #fff;
            }
            #popup input:hover
            {
                cursor: pointer;
                background: #444;
            }
</style>

<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJqUrl"/>
<spring:url value="/resources/js/userregister.js" var="resourceUserRegisterJqUrl"/>
<spring:url value="/resources/css/newuser.css" var="resourceNewUserCssUrl"/>


<script type="text/javascript" src="${resourceJqUrl}"></script>
<script type="text/javascript" src="${resourceUserRegisterJqUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceNewUserCssUrl}"/>
<script>
	qualificationRowIndex = parseInt("<c:out value="${qualificationCount}" />");
</script>

</head>

<body>
<form:form name="registration" commandName="registration" id="registrationForm" enctype="multipart/form-data" method="POST" action="/register/newuser">
<table  border="0" id="usertbdesign" align="center">
<tr bgcolor="#FFFFFF" class="menuhd">
  <td class="header" align="center" >&nbsp;</td>
  <td width="28%" class="header"><img name="" src="../resources/images/JBS_LOGO.png" id="logo" alt="" /></td>
  <td width="1%" class="header"  >&nbsp;</td>
  <td width="28%" class="header" ></td>
  <td width="23%" class="header"  ><a href="#"></a></td>
  <td width="18%" class="header" ><a href="/nitin_swadhin/">Already registered?Sign in</a></td>
  <td class="header"  >&nbsp;</td>
</tr>
<tr id="he">
  <td height="57" colspan="7" align="center" bgcolor="#0066CC" >Create a Profile now. Register to JOBSbySMS and recieve job alerts on your mobile</td>
</tr>
<tr bgcolor="#FFFFFF" class="header2">
  <td colspan="7"><h4>Create Login Details</h4></td>
  </tr>
<tr class="header">
  <td width="1%" height="26">&nbsp;</td>
  <td colspan="5" rowspan="3"><table width="101%" border="0" id="logininfotb">
    <tr>
      <td width="36%">Username</td>
      <td width="64%"> <form:input path="user.userName" /></td>
    </tr>
    <tr>
      <td width="36%">Enter your Email id</td>
      <td width="64%"> <form:input path="user.email" /></td>
    </tr>
    <tr>
      <td>Create a Password for your account</td>
      <td> <form:password path="user.password" /></td>
    </tr>
    <tr>
      <td height="27">Confirm the Password</td>
      <td> <form:password path="confirmPassword" /></td>
    </tr>
     <tr>
      <td height="27">Select your security Question</td>
      <td> <form:select path="securityQuestion" items="${securityQuestions}" ></form:select>
      </td>
    </tr>
    <tr>
      <td height="27">Answer</td>
      <td> <form:input path="securityAnswer" /></td>
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
        <td width="270">First Name</td>
        <td width="480"> <form:input path="user.firstName" ></form:input></td>
      </tr>
      <tr>
        <td>Last Name</td>
        <td><form:input path="user.lastName" ></form:input></td>
      </tr>
      <tr>
        <td>Address Line1</td>
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
        <td>City</td>
        <td>
          <form:input path="user.address.city" ></form:input></td>
      </tr>
      <tr>
        <td>Mobile Number</td>
        <td><form:input path="user.phone" ></form:input></td>
      </tr>
      <tr>
        <td>Pin code</td>
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
      <td>Key Skills</td>
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
        <td width="212">Board/University</td>
        <td width="189">Year of Passing</td>
        <td width="234">Percentage/CGPA</td>
      </tr>
      
     <c:choose>
  <c:when test="${currentLoggedInUserId eq null}">
      <tr>
      <td>
      	<input type="text" name="user.qualifications[0].certification" />
      </td>
      <td>
      	<input type="text" name="user.qualifications[0].boardOrUniversity" />
      </td>
      <td>
       <input type="text" name="user.qualifications[0].yearOfPassing" />
      </td>
      <td>
       <input type="text" name="user.qualifications[0].percentage" />
      </td>
      </tr>
  </c:when>
  <c:otherwise>
	  <c:forEach var="qualification" items="${qualifications}" varStatus="status">
	  <tr>
	   <td>
      	<input type="text" name="user.qualifications[${status.index}].certification" value="${qualification.certification}"/>
      </td>
      <td>
      	<input type="text" name="user.qualifications[${status.index}].boardOrUniversity" value="${qualification.boardOrUniversity}"/>
      </td>
      <td>
       <input type="text" name="user.qualifications[${status.index}].yearOfPassing" value="${qualification.yearOfPassing}"/>
      </td>
      <td>
       <input type="text" name="user.qualifications[${status.index}].percentage" value="${qualification.percentage}"/>
      </td>
	  </tr>
	  </c:forEach>
	  
  </c:otherwise>
  </c:choose>
  </table>
    <br /><input type="button" value="Add Another Certification" id="add"/></td>
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
  <form:checkbox path="notifySms" value="false"/>
    Notifications from JobsbySMS</h5></td>
  <td colspan="4" bgcolor="#FFFFFF"><h5>
    <input type="checkbox" name="terms" id="terms" />
    I have read and understood and agree to the <a href="#" id="showpopup">Terms &amp; Conditions</a> governing the use of JobsbySMS.com</h5>
  </td>
  <td >
  
  </td>
</tr>
<tr class="header2">
  <td >&nbsp;</td>
  <c:choose>
  <c:when test="${currentLoggedInUserId eq null}">
	  <td colspan="5" align="center" bgcolor="#FFFFFF"><input type="submit" name="submitbutton" id="submitbutton" value="Join to JobsbySMS" /></td>
  </c:when>
  <c:otherwise>
	  <td colspan="5" align="center" bgcolor="#FFFFFF"><input type="submit" name="submitbutton" id="submitbutton" value="Submit" /></td>
  </c:otherwise>
  </c:choose>
  <td ></td>
</tr>
</table>
</form:form>
<div id="wrapper">
            <div id="popup">
                <div align="left">
                   <textarea cols="80" rows="10" scrollable="both" align="center" readonly="readonly"></textarea>                    
                </div>
                <input type="submit" value="CLOSE" id="hidepopup" /> 
            </div>
            <div id="overlay"></div>
           </div>
        <script>
            $(document).ready(function(){
                            $("a#showpopup").click(function(){
                                $("div#overlay").fadeIn('500');       
                                $("div#popup").delay('200');
                                $("div#popup").fadeIn('500');         
                           });                            
                        
                        
                    $("div#overlay").click(function(){                       
                                $("div#popup").fadeOut('500');      
                                $("div#overlay").delay('200');
                                $("div#overlay").fadeOut('500');   
                    });
                    
                    $("input#hidepopup").click(function(){                       
                                $("div#popup").fadeOut('500');      
                                $("div#overlay").delay('200');
                                $("div#overlay").fadeOut('500');   
                    });
                });
        </script>
</body>
</html>
