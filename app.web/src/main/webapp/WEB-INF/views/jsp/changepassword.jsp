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
</head>
<body>
<table id="passwordtb">
<tr>
<td>
<div id="changetb">
<table width="933" height="89" border="0" id="changetb">
  <tr>
    <td height="30" colspan="2"><p>Change Password</p>
      <hr color="red"/>
      <form>
      <table width="404" border="0" align="center" id="pwdtb">
        <tr>
        <td width="204">Enter Old Password</td>
        <td width="184"><input type="text" name="textfield" id="textfield" /></td>
        </tr>
      <tr>
        <td>Enter New Password</td>
        <td><input type="text" name="textfield3" id="textfield3" /></td>
      </tr>
      <tr>
        <td>Confirm New Password</td>
        <td><input type="text" name="textfield4" id="textfield4" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" name="button" id="button" value="Change Password" /></td>
        </tr>
      </table>
            </form>
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