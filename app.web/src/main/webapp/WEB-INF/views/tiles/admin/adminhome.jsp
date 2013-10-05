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
	<div id="main">
  <div class="shell">
    <!-- Cols -->
    <div class="cols">
      <div class="cl">&nbsp;</div>
      <!-- Col -->
      <div class="col">
        <h3 class="tab"><span class="ico ico1">User Information</span></h3>
        <div class="entry">
          <h4>Website Users</h4>
          <p> </p>
          <h4>Reseller Users</h4>
          <p></p>
          <h4>Premium Users</h4>
          <p></p>
        </div>
      </div>
      <!-- End Col -->
      <!-- Col -->
      <div class="col">
        <h3 class="tab"><span class="ico ico2">Accounts Details</span></h3>
        <div class="entry">
          <h4>Total Income</h4>
           <p> </p>
          <h4>Commission Paid</h4>
           <p> </p>
         
         </div>
      </div>
      <!-- End Col -->
      <!-- Last Col -->
      <div class="col-right">
        <h3 class="tab"><span class="ico ico3">Notification</span></h3>
        <div class="entry">
          <h4>Approval Notification</h4>
          <p> </p>
          <h4>Redeem Notification</h4>
          <p> </p>
          
          </div>
      </div>
      <!-- End Last Col -->
      <div class="cl">&nbsp;</div>
    </div>
    <!-- End Cols -->
  </div>
</div>
	</div>
</body>
</html>