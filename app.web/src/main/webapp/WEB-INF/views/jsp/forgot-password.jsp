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

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceHeadMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>


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
tr.pwdhead{
 background-color: silver;
 border-collapse: collapse;
 border-top-style: solid;
}
</style>
<script type="text/javascript">

	 $('#radio1').click(function(){
		  $('#pwdtb').hide(); 
	 });
	

</script>

</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table id="passwordtb">
<tr>
<td>
<div id="forgottb">
<table width="933" height="89" border="0" id="forgottb">
  <tr>
    <td height="23" colspan="2" scope="col">Please select the option for login problem</td>
  </tr>
  <tr>
    <td width="266" height="26"><p>
      <input type="radio" name="radio" id="radio1" value="radio" onselect="showPwdTB()"/>
      I forgot my password</p></td>
    <td width="326"><input type="radio" name="radio" id="radio2" value="radio" onselect="showUserIDTB()"/>
    <span class="s">I forgot my userid</span></td>
  </tr>
  <tr>
    <td height="30" colspan="2"><p>You can now easily retrieve your password if you have forgotten. Please provide your valid security details mentioned during registration and submit. The password will be sent to your valid registered email id and mobile number</p>
      <hr />
     <form:form name="registrationForm" commandName="registration" id="registrationForm" method="POST" action="${contextPath}/manage/forgotpwd/password">
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
     
      <table width="404" border="0" align="center" id="pwdtb">
        <tr>
        <td width="204">Enter your userid</td>
        <td width="184"><form:input path="user.userName" /></td>
        </tr>
      <tr>
        <td>Enter Security Question</td>
        <td><form:select path="securityQuestion" items="${securityQuestions}" ></form:select></td>
      </tr>
      <tr>
        <td>Enter your security answer</td>
        <td><form:input path="securityAnswer" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" name="button" id="button" value="Submit" /></td>
        </tr>
      </table>
           </form:form>
      <p>&nbsp;</p>
       <form:form name="registrationForm" commandName="registration" id="registrationForm" method="POST" action="${contextPath}/manage/forgotpwd/username">
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
      <table width="751" border="0" align="center" id="useridtb" >
        <tr>
          <td width="204">Enter your first name</td>
          <td width="147"><form:input path="user.firstName" ></form:input></td>
          <td width="221">Enter your last name</td>
          <td width="151"><form:input path="user.lastName" ></form:input></td>
        </tr>
        <tr>
          <td>Enter your Email id</td>
          <td><form:input path="user.email" /></td>
          <td>Enter Mobile number</td>
          <td><form:input path="user.phone" ></form:input></td>
        </tr>
        <tr>
          <td>Enter your Security Question</td>
          <td><form:select path="securityQuestion" items="${securityQuestions}" ></form:select></td>
          <td>Enter your Security Answer</td>
          <td><form:input path="securityAnswer" /></td>
        </tr>
        <tr>
          <td colspan="4"><input type="submit" name="button2" id="button2" value="Submit" /></td>
        </tr>
      </table>
	</form:form>
    <p>&nbsp;</p></td>
  </tr>
</table>
  </div>
  </td>
  </tr>
</table>

</body>
</html>