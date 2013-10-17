<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<jsp:include page="../tiles/base/app.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/js/forgot-password.js" var="resourceForgotPasswordJSUrl"/>

<script type="text/javascript" src="${resourceForgotPasswordJSUrl}"></script>

<style type="text/css">    
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
tr.pwdhead{
 background-color: silver;
 border-collapse: collapse;
 border-top-style: solid;
}


</style>
<script type="text/javascript">
$(document).ready(function(){
	
 $('#radio1').change(function(){
	 $('#pwdtb').show();
	 $('#useridtb').hide();
	 
  });
  
  $('#radio2').change(function(){
	 $('#useridtb').show();
	 $('#pwdtb').hide();
	 
  });
  
  
  var changePasswordOption=$('#changePassword').val();
  console.log("radio.."+changePasswordOption);
     if(changePasswordOption==null || changePasswordOption=="" ){
    	 $('#retrievePasswordDiv').show();
     }else if(changePasswordOption=="1"){
    	 $('#retrievePasswordDiv').show();
    	 $("#radio1").prop("checked", true);
		 $('#pwdtb').show();
	 } else if(changePasswordOption=="2"){
		 $('#retrievePasswordDiv').show();
		 $('#radio2').prop('checked',true);
		 $('#useridtb').show();
	 } else if(changePasswordOption=="3"){
		 $('#retrievePasswordDiv').hide();
		 $('#newPasswordDiv').show();
	 } else if(changePasswordOption=="4"){
		 $('#retrievePasswordDiv').hide();
		 $('#newPasswordDiv').hide();
		 $('#usernameDiv').show();
	 } 
     
     $("#registrationForm").validate( {
   	    success : "valid",
   	    ignoreTitle : true,
   	    rules : {
   			"user.userName" : {
   		        required : true
   		     }
   	    }
     });
     
     $("#forgotUserIdForm").validate( {
    	    success : "valid",
    	    ignoreTitle : true,
    	    rules : {
    			"user.firstName" : {
    		        required : true,
    		        lettersonly:true
    		     },"user.email" : {
    		        required : true,
    		        email:true
    		     },"user.phone" : {
    		        required : true,
    		        number:true
    		     }
    	    }
      });
     
     jQuery.validator.addMethod("lettersonly", function(value, element) {
   	  return this.optional(element) || /^[a-z]+$/i.test(value);
   	}, "Letters only please."); 

	 
});


</script>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="retrievePasswordDiv" hidden="true">
<table id="passwordtb">
<tr>
<td>
<div id="forgottb">
<table width="933" height="89" border="0" id="forgottb">
  <tr>
    <td height="23" colspan="2" scope="col">
    	<h2>Please select the option for login problem</h2>
    </td>
  </tr>
  <tr>
    <td width="266" height="26">
    <p>
    	<input type="radio" name="radio" id="radio1" value="radio">
    	I forgot my password
    </p>
    	</td>
    <td width="326">
    	<input type="radio" name="radio" id="radio2" value="radio">
    	<span class="s">I forgot my userid</span>
    </td>
  </tr>
  <tr>
  <td>
  <div id="messages">
       <spring:hasBindErrors name="registration">
        <div class="formerror">
            <ul>
            <c:forEach var="error" items="${errors.allErrors}">
                <li>${error.defaultMessage}</li>
            </c:forEach>
            </ul>
        </div>
  	  </spring:hasBindErrors>
	</div>
  </td>
  </tr>
  <tr>
    <td height="30" colspan="2">
    <p> 
    	You can now easily retrieve your password if you have forgotten. 
    	Please provide your valid security details mentioned during registration and submit. 
    </p>
    
      <hr />
     <form:form name="registrationForm" commandName="registration" id="registrationForm" method="POST" action="${contextPath}/manage/forgotpwd/password">
      <table width="751" border="0" align="center" id="pwdtb" title="Recover Password" hidden="true">
      <tr>
      <td>
       </td>
      </tr>
        <tr>
        <td width="204">Enter your userid<em>*</em></td>
        <td width="184">
        <c:choose>
         <c:when test="${currentLoggedInUserId eq null}">
       <form:input path="user.userName" />
       </c:when>
        </c:choose>
        </td>
        </tr>
      <tr>
        <td>Enter Security Question<em>*</em></td>
        <td><form:select path="securityQuestion" items="${securityQuestions}" ></form:select></td>
      </tr>
      <tr>
        <td>Enter your security answer<em>*</em></td>
        <td><form:input path="securityAnswer" /></td>
      </tr>
      <tr>
        <td colspan="2">
      	  <button id="passwordBtn">Submit</button>
	  </td>
      
        </tr>
      </table>
           </form:form>
      <p>&nbsp;</p>
       <form:form name="forgotUserIdForm" commandName="registration" id="forgotUserIdForm" method="POST" action="${contextPath}/manage/forgotpwd/username">
     
      <table width="751" border="0" align="center" id="useridtb" title="Recover Password" hidden="true">
      <tr>
      <td colspan="2">
      
      </td>
      </tr>
        <tr>
          <td width="204">Enter your first name<em>*</em></td>
          <td width="184"><form:input path="user.firstName" id="userFirstName"></form:input></td>
          <td width="221">Enter your last name</td>
          <td width="151"><form:input path="user.lastName" id="userLastName"></form:input></td>
        </tr>
        <tr>
          <td>Enter your Email id<em>*</em></td>
          <td><form:input path="user.email" id="userEmail" /></td>
          <td>Enter Mobile number<em>*</em></td>
          <td><form:input path="user.phone" id="userPhone"></form:input></td>
        </tr>
        <tr>
          <td>Enter your Security Question</td>
          <td><form:select path="securityQuestion" items="${securityQuestions}" ></form:select></td>
          <td>Enter your Security Answer</td>
          <td><form:input path="securityAnswer" /></td>
        </tr>
        <tr>
          <td colspan="4"> 
          <button id="passwordBtn1">Submit</button></td>
        </tr>
      </table>
      <form:hidden path="changePassword" />
	</form:form>
    <p>&nbsp;</p></td>
  </tr>
</table>
  </div>
  </td>
  </tr>
</table>
</div>
<div id="newPasswordDiv" class="forgotpasswordresult">
<br>
<br>
 <div class="successLogo"></div>
 <div class="transfersuccessmessage">Successfully changed </div>  
<p></p>
 <center>
 <h3>Your new password: ${changePassword}</h3>
  </center>
</div>
<div id="usernameDiv" class="forgotpasswordresult">
<br>
<br>
 <div class="successLogo"></div>
 <div class="transfersuccessmessage">Successfully retrieved </div>  
<p></p>
 <center>
 <h3>Your Username: ${username}</h3>
  </center>
</div>
</body>
</html>