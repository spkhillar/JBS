<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="app.jsp"></jsp:include>
<script type="text/javascript">

$(document).ready(function(){
	 $("#demo_drop1").jui_dropdown({
		    launcher_id: 'launcher1',
		    launcher_container_id: 'launcher1_container',
		    menu_id: 'menu1',
		    containerClass: 'container1',
		    menuClass: 'menu1',
		    launchOnMouseEnter: true,
		    launcherUIShowText: true,
		    launcherUISecondaryIconClass: 'ui-icon-gear',
		    onSelect: function(event, data) {
		      console.log('index: ' + data.index + ' (id: ' + data.id + ')');
		    }
		  });
		 
});
</script>
<style type="text/css">
#jui_dropdown_demo {
  height: 400px;
}
 
#jui_dropdown_demo button {
  padding: 3px !important;
}
 
#jui_dropdown_demo ul li {
  background: none;
  display: inline-block;
  list-style: none;
}
 
/* SELECTED OPTION INDICATOR ------------------------------------------------ */
#opt_selected {
  margin-top: 20px;
  font-size: 20px;
}
 
/* DEMO_DROPDOWN 1 ---------------------------------------------------------- */
.container1 {
  margin: 20px 30px 10px 30px ;
  display: inline-block;
  width:200px;
}
 
.menu1 {
  position: absolute;
  width: 240px !important;
  margin-top: 3px !important;
}
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="demo_drop1">
  <div id="launcher1_container">
    <button id="launcher1"><c:out value="${webUser.firstName} ${webUser.lastName}"></c:out></button>
  </div>
  <ul id="menu1">
    <li id="opt_1.1">
    	<a href="${contextPath}/normal/user/retrieveuser">My Profile</a>
    </li>
    <li>
    	<a href="${contextPath}/normal/user/changepassword">Change Password</a>
    </li>
    <li id="opt_1.3">
    	<a href="#">Upgrade</a>
    </li>
    <li id="opt_1.4">
    	<a href="${contextPath}/j_spring_security_logout">Logout</a>
    </li>
  </ul>
</div>
 </body>

</html>
