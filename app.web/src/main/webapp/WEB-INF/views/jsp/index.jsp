<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<spring:url value="/resources/css/indexhome.css" var="resourceIndexCssUrl"/>
<spring:url value="/resources/css/mainmenu.css" var="resourceMainMenuCssUrl"/>
<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJqUrl"/>
<spring:url value="/resources/js/stmenu.js" var="resourceMenuUrl"/>
<spring:url value="/resources/js/stcode.js" var="resourceStCodeUrl"/>

<script type="text/javascript" src="${resourceJqUrl}"></script>
<script type="text/javascript" src="${resourceMenuUrl}"></script>
<script type="text/javascript" src="${resourceStCodeUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceIndexCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceMainMenuCssUrl}"/>

<style>
#bodytb tr td #logintb tr td {
	color: #00F;
}


#tabs {
	font-size: 90%;
	margin: 20px 0;
	text-align: left;
}
#tabs ul {
	float: left;
	background:#09F;
	width: 500px;
	padding-top: 4px;
	box-shadow: #036 4px 4px 4px;
	border-radius: 6px 6px 6px 6px;

}
#tabs li {
	margin-left: 8px;
	list-style: none;
}
* html #tabs li {
	display: inline;
}
#tabs li, #tabs li a {
	float: left;


}
#tabs ul li.active {
	border-top:2px thin;
		
    
	
}
#tabs ul li.active a {
	color:#FFF;

}
#tabs div {
	
	clear: both;
	padding: 15px;
	min-height: 200px;
}
#tabs div h3 {
	margin-bottom: 12px;
}
#tabs div p {
	line-height: 150%;
}
#tabs ul li a {
	text-decoration: none;
	padding: 8px;
	color: #000;
	font-weight: bold;
}
.thumbs {
	float:left;
	border:#000 solid 1px;
	margin-bottom:20px;
	margin-right:20px;
}

</style>

    
    <script type="text/javascript">
$(document).ready(function(){
$('#tabs div').hide();
$('#tabs div:first').show();
$('#tabs ul li:first').addClass('active');
$('#tabs ul li a').click(function(){ 
$('#tabs ul li').removeClass('active');
$(this).parent().addClass('active'); 
var currentTab = $(this).attr('href'); 
$('#tabs div').hide();
$(currentTab).show();
return false;
});
});
</script>
</head>
<body>

<table border="0"  id="logotb">
 <tr>
 
 <td width="24%" height="79"><img name="" src="resources/images/JBS_LOGO.png" width="231" height="45" alt="" id="logo"/></td>
 <td width="38%"><img src="resources/images/job2.jpg" alt="job2" width="364" height="77" id="wows1_1" title="job2"/></td>
 <td width="38%" align="center"><img src="resources/images/job1.jpg" alt="job1" width="290" height="69" id="wows1_0" title="job1"/></td>
 </tr>

 
</table>
<table  border="0" width="80%" align="center" id="menutb">
<thead>
<th height="43">
  <span>
  <script id="sothink_widgets:dwwidget_dhtmlmenu7_15_2013.pgt" type="text/javascript">
<!--
stm_bm(["menu1849",980,"","resources/images/blank.gif",0,"","",0,0,250,0,1000,1,0,0,"","100%",67108955,0,1,2,"default","hand","",1,25],this);
stm_bp("p0",[0,4,0,0,0,0,18,0,100,"",-2,"",-2,50,0,0,"#799BD8","transparent","resources/images/tclback.gif",3,0,0,"#000000"]);
stm_ai("p0i0",[0,"HOME","","",-1,-1,0,"index.jsp","_self","","","","resources/images/tclarrow.gif",18,7,0,"","",0,0,0,0,1,"#FFFFF7",1,"#B5BED6",1,"","resources/images/tclbackup.gif",2,3,0,0,"#FFFFF7","#000000","#666666","#FFFFFF","bold 10pt Arial","bold 8pt Arial",0,0,"","","","",0,0,0]);
stm_aix("p0i2","p0i0",[0,"REGISTER","","",-1,-1,0,"register/"]);
stm_aix("p0i3","p0i0",[0,"LOGIN","","",-1,-1,0,"mypage/login/"]);
stm_aix("p0i4","p0i0",[0,"ENQUIRY","","",-1,-1,0,"mypage/enquiry/"]);
stm_aix("p0i5","p0i0",[0,"CONTACT US","","",-1,-1,0,"mypage/contact/"]);
stm_aix("p0i6","p0i0",[0,"ABOUT US","","",-1,-1,0,"mypage/aboutus/"]);
stm_ep();
stm_em();
//-->
</script>
  </span>
  
  </thead></th>
</table>
<br />
<table  border="0" id="bodytb">
  <tr>
    <td width="25%" height="30">Keywords
      <label for="textsearchkey"  class="tb1"></label>
      <br />
    <input type="text" name="textsearchkey" id="textsearchkey" class="tb1"/></td>
    <td width="25%">Locations<br />
    <input type="text" name="textsearchkey2" id="textsearchloc"  class="tb1"/><br /></td>
    <td width="8%" rowspan="3">&nbsp;</td>
    <td width="42%" rowspan="3">
    <form action="j_spring_security_check" method="post">
    <table width="303" border="0" align="right" id="logintb">
    
      <tr>
        <td colspan="2" align="center"><h4>Jobseeker Login</h4><hr /></td>
      </tr>
      <tr>
        <td width="150">Username or Email</td>
        <td width="182"><label for="txt_user"></label>
          <input type="text" id="j_username" name="j_username" class="tb1"/></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><label for="txt_pwd"></label>
          <input type="password" id="j_password" name="j_password" class="tb1" /></td>
      </tr>
      <tr>
        <td colspan="2">Forgot Password?</td>
      </tr>
      <tr>
        <td height="33"><input type="submit" value="Login"></input></td>
        <td height="33">&nbsp;</td>
      </tr>
      
    </table>
    </form>
    </td>
    </tr>
     <tr>
    <td height="29">Experience
      <select name="selectexp" id="selectexp"  class="tb1"></select>
     </td>
    <td><a href="#">Search</a></td>
     </tr>
</table>
<table width="93%" id="jobtb">
<tr>
<td>

<div id="container">
  <div id="tabs">
  <table width="100%">
  <tr>
  <td height="117">
    <ul>
      <li><a href="#tab-1">Public Sector Jobs</a></li>
      <li><a href="#tab-2">Private Sector Jobs</a></li>
      <li><a href="#tab-3">International Jobs</a></li>
      </ul>   </td>
    <td width="295" align="right"><img name="" src="resources/images/Ad_mlm.png" width="198" height="115" alt="" /></td>
    </tr>
    </table>
    <div id="tab-1">
      <h3>Public Sector Jobs</h3>
      <table id="tab-1content" border="0">
       <tr>
       	<td>
        <table  border="0" id="publicjobtb">
        <thead>
           <th class="jobheader" width="279"  >Indian Institute of Public Administration</th>
             <th width="108" height="16"></th>
             <th width="184"></th>
             <th width="184"></th>
             <th width="187"></th>
           </thead>
           <tr class="subjobheader">
             <td width="279" ><h5>1. Deputy Manager, New Delhi, 5-10 Yrs Experience</h5></td>
             <td width="108" height="16"></td>
             <td width="184"></td>
             <td width="184"></td>
             <td width="187"></td>
           </tr>
        </table>
        </td>
       <tr>
      </table>
    </div>
    <div id="tab-2">
      <h3>Private Sector Jobs</h3>
       <table id="tab-2content" border="0" >
        <tr>
       	<td><table width="100%" border="1" id="publicjobtb">
         <thead>
           <th class="jobheader">Infosys</th>
             <th width="254" height="16"></th>
             <th width="254"></th>
             <th width="254"></th
             ><th width="254"></th>
           </th>
           </thead>
           <tr class="subjobheader">
             <td width="254" ><h5></h5></td>
             <td width="254" height="20"></td>
             <td width="254"></td>
             <td width="254"></td>
             <td width="254"></td>
           </tr>
        </table></td>
       <tr>
      </table>
    </div>
    <div id="tab-3">
      <h3>International Jobs</h3>
       <table id="tab-3content" border="0" >
        <tr>
       	<td><table width="100%" border="1" id="publicjobtb">
        <thead>
           <th class="jobheader">Administration Jobs - IT Technician</th>
             <th width="254" height="16"></th>
             <th width="254"></th>
             <th width="254"></th>
             <th width="254"></th>
           </th>
           </thead>
           <tr>
             <td width="254" ></td>
             <td width="254" height="35"></td>
             <td width="254"></td>
             <td width="254"></td>
             <td width="254"></td>
           </tr>
        </table></td>
       <tr>
      </table>
    </div>
    </div>
</div>
</td>
</tr>
</table>
</body>
</html>
