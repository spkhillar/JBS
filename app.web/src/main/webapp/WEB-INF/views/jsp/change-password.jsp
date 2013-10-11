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
	
$("#registrationForm").validate( {
	    success : "valid",
	    ignoreTitle : true,
	    rules : {
			"user.password" : {
		        required : true,
		        minlength: 6,
		        maxlength: 20,
		        alphanumeric: true
		        
		   },"newPassword" : {
		        required : true,
		        minlength: 6,
		        maxlength: 20,
		        alphanumeric: true
		        
		   },"confirmPassword" : {
		        required : true,
		        equalTo: "#newPassword"
		   }
		   
	    }

});

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z0-9_]+$/i.test(value);
	}, "Letters, numbers or underscores only please."); 


});
</script>
</head>
<body>
<table id="passwordtb">
<tr>
<td>
<div id="changetb">
<table width="933" height="89" border="0" id="changetb">
  <tr>
    <td height="30" colspan="2"><h2>Change Password</h2>
      <hr color="red"/>
      <form:form name="registrationForm" commandName="registration" id="registrationForm" method="POST" action="${contextPath}/manage/changepassword">
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
      <table width="40%" border="0" align="center" id="pwdtb">
        <tr>
        <td width="50">Enter Old Password</td>
        <td width="50"><form:password path="user.password" /></td>
        </tr>
      <tr>
        <td>Enter New Password</td>
        <td><form:password path="newPassword" /></td>
      </tr>
      <tr>
        <td>Confirm New Password</td>
        <td><form:password path="confirmPassword" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" name="changePwdBtn" id="changePwdBtn" value="Change Password" /></td>
        </tr>
      </table>
            </form:form>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
  </tr>
</table>
  </div>
  </td>
  </tr>
</table>



</body>
</html>