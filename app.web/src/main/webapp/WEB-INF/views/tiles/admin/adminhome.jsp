<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JOBSbySMS-Administration</title>
<style type="text/css">
#adminDiv table tr th {
	color: #8080FF;
}
#adminDiv table tr th {
	color: #FFF;
}
</style>
</head>
<body>
	
	<div id="adminDiv" style="width: 80%; height: 500px; margin:auto">
	<h1> Welcome ${currentLoggedInUser}</h1>
	<hr color="blue">
	<table width="678" height="141" border="1" align="center">
	  <tr bgcolor="#A82B0B">
	    <th width="125" height="23" style="text-align: left" scope="col">User Information</th>
	    <th width="179" scope="col">&nbsp;</th>
	    <th width="152" scope="col">&nbsp;</th>
	    <th width="194" scope="col">&nbsp;</th>
      </tr>
	  <tr>
	    <td height="23" style="text-align: left"> Site User : </td>
	    <td>Reseller :</td>
	    <td>Premium Users :</td>
	    <td>&nbsp;</td>
      </tr>
	  <tr>
	    <td style="text-align: left">&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
      </tr>
	  </table>
	</div>
</body>
</html>