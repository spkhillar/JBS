<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JOBSbySMS- Job Information</title>
<style>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceUserHomeMenuCssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>

<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJq2Url"/>
#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
}
#govttb2 tr .pvtinfo strong {
	font-size: 12px;
}

#popup_box { 
	display:none; /* Hide the DIV */
	position:fixed;  
	_position:absolute; /* hack for internet explorer 6 */  
	height:300px;  
	width:600px;  
	background:#FFFFFF;  
	left: 300px;
	top: 150px;
	z-index:100; /* Layering ( on-top of others), if you have lots of layers: I just maximized, you can change it yourself */
	margin-left: 15px;  
	
	/* additional features, can be omitted */
	border:2px solid #ff0000;  	
	padding:15px;  
	font-size:15px;  
	-moz-box-shadow: 0 0 5px #ff0000;
	-webkit-box-shadow: 0 0 5px #ff0000;
	box-shadow: 0 0 5px #ff0000;
	
}

#container {
	background: #d2d2d2; /*Sample*/
	width:100%;
	height:100%;
}

a{  
cursor: pointer;  
text-decoration:none;  
} 

/* This is for the positioning of the Close Link */
#popupBoxClose {
	font-size:20px;  
	line-height:15px;  
	right:5px;  
	top:5px;  
	position:absolute;  
	color:#6fa5e2;  
	font-weight:500;  	
}
</style>

<script type="text/javascript">
$(document).ready( function() {
	
	// When site loaded, load the Popupbox First
	$('#b').click( function() {			
		loadPopupBox();
	});
	

	$('#popupBoxClose').click( function() {			
		unloadPopupBox();
	});
	
	$('#container').click( function() {
		unloadPopupBox();
	});

	function unloadPopupBox() {	// TO Unload the Popupbox
		$('#popup_box').fadeOut("slow");
		$("#container").css({ // this is just for style		
			"opacity": "1"  
		}); 
	}	
	
	function loadPopupBox() {	// To Load the Popupbox
		$('#popup_box').fadeIn("slow");
		$("#container").css({ // this is just for style
			"opacity": "0.3"  
		}); 		
	}
	/**********************************************************/
	
});
</script>

<script type="text/javascript" src="${resourceJq2Url}"></script>


<link rel="stylesheet" type="text/css" href="${resourceUserHomeMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table  border="0" id="indextb">
  <tr>
    <td width="17%" height="34"><img src="resources/images/JBS_LOGO.png" id="logo"></img></td>
    <td width="24%" height="34">&nbsp;</td>
    <td width="14%" height="34">&nbsp;</td>
    <td width="31%" height="34">&nbsp;</td>
    <td width="8%" height="34">&nbsp;</td>
    <td width="6%" height="34"><img name="" src="resources/images/logout.jpg" width="32" height="32" alt="" align="center"/><br/>
    <a href="${contextPath}/j_spring_security_logout">Log Out</a>
    </td>
  </tr>

  </table>
     <div >
     <table id="govttb2">
       <tr bgcolor="#0099CC">
         <td colspan="6" bgcolor="#D1E6E7"> Government Jobs</td>
       </tr>
       

       
        <c:forEach var="job" items="${jobList}" varStatus="status">
        
       <tr>
         <td colspan="6" class="pvtinfo"><strong><c:out value="${job.designation}"></c:out> - <c:out value="${job.location}"></c:out> (<c:out value="${job.experiance}"></c:out> yrs)</strong> | Posted date: <fmt:formatDate pattern="yyyy-MM-dd" value="${job.postedAt}"/>
         <ul><li><c:out value="${job.jobDescription}"></c:out></li></ul>
          <p><strong>Salary Range:</strong> Rs. <c:out value="${job.salary}"></c:out> p.a.  | <strong>Industry:</strong> <c:out value="${job.industry}"></c:out><br />
          Company:<c:out value="${job.companyName}">|</c:out> </p><a href="" onclick="loadPopupBox()" id="b">View Details</a></td>
       </tr>
       </c:forEach>
       </table>
     <div></div>
     </div>
     
<br/>
     <div id="popup_box">	<!-- OUR PopupBox DIV-->
	<table width="100%" border="0">
  <tr>
    <td><img src="images/JBS_LOGO.png" id="logo" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr >
    <td colspan="3" align="center"><img name="" src="images/DBconf.jpg"" width="200" height="150" alt="" /></td>
   
  </tr>
  <tr>
    <td colspan="3" align="center"><h3>JOBSbySMS.com Database Configuration is in Process. Sorry for the inconvenience</h3></td>
    
  </tr>
</table>

	<a id="popupBoxClose">Close</a>	
</div>
<div id="container"> <!-- Main Page -->
	
</div>

    
</body>
</html>
