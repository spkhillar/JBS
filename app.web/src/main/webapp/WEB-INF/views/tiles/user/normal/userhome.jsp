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
<spring:url value="/resources/css/smartpaginator.css" var="resourceCssSmartPaginatorUrl"/>
<spring:url value="/resources/js/smartpaginator.js" var="resourceJsSmartPaginatorUrl"/>
<spring:url value="/resources/css/userpage.css" var="resourceUserPageCssUrl"/>
<script type="text/javascript" src="${resourceJsSmartPaginatorUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceCssSmartPaginatorUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceUserPageCssUrl}"/>

<style>
#govttb2 tr .pvtinfo {
	font-weight: normal;
	font-size: 10px;
}
#govttb2 tr .pvtinfo strong {
	font-size: 12px;
}
.green
{
    background-color: #3399FF;
}
.green.normal
{
    background-color: #3399FF;
    color: White;
    border: solid 1px #3399FF;
}
.green.active
{
    background-color: #344C00;
    color: #F8EB00;
    border: solid 1px #5f9000;
}
.green .btn
{
    background-color: #3399FF;
    color: White;
    border: solid 1px #3399FF;
}

.pager{
    background-color: #3399FF;
    border: 1px solid #3399FF;
    color: #FFFFFF;
}




</style>

<script type="text/javascript">

$(document).ready(function(){
	var matchingRecordCount = 0;
	 $.ajax({
		    url: webContextPath+"/admin/job/currentuser",
		    async:false,
		    success: function(data){
		    	matchingRecordCount = parseInt(data);
		    },
		    error:function(jqXHR,textStatus,errorThrown){
		    	
		    }
		  });
	$('#smart-paginator').smartpaginator({
		
			totalrecords : matchingRecordCount,
			recordsperpage : smartPaginateRecordsPerPage,
			initval:1,
			length : 4,
			next : 'Next',
			prev : 'Prev',
			first : 'First',
			last : 'Last',
			theme : 'green',
			controlsalways : true,
			onchange : selectPage

		});
	selectPage(1);
	});


function selectPage(newPageValue) {
	 $.ajax({
	    url: webContextPath+"/normal/user/joblist/"+newPageValue+"/"+ smartPaginateRecordsPerPage ,
	    dataType:'html',
	    success: function(data){
	      //construct the data however, update the HTML of the popup div 
	      $('#currentUserJobListDiv').html(data);
	    }
	});
}
</script>

</head>

<body>
     <div id="usernamediv" style="width:100%;margin: auto;">
     <h3>Welcome ${currentLoggedInUser} </h3>
     </div>
     <table id="userjobtable">
     <tr>
     <td>
    <table  border="0" id="profiletable">
  <tr>
    <td width="129"><strong>Profile Summary</strong></td>
    <td width="475">&nbsp;</td>
    
  </tr>
  <tr>
    <td>Experience</td>
    <td>${currentLoggedInUserExperience} Years of Experience</td>
    
  </tr>
   <tr>
    <td>Key Skills</td>
    <td>${currentLoggedInUserSkill}</td>
   
  </tr>
  <tr>
    <td>Functional Area</td>
    <td>${currentLoggedInUserFunctionalArea}</td>
    
  </tr>
  
  <tr>
    <td>Email Id</td>
    <td>${currentLoggedInUserEmail}</td>
    <td>Mobile</td>
    <td>${currentLoggedInUserMobile}</td>
   </tr>
</table>
     </td>
     </tr>
     <tr>
     <td>
     <div id="outer">
       <div id="inner">
          <div class="t">
			    <table id="adjobtb">
			     <tr>
			     <td>
			        <div id="userdiv1"></div>
			        <div id="userdiv2"></div>
			        <div id="userdiv3"></div>
			        <div id="userdiv4"></div>
			        <div id="userdiv5"></div>
			    </td>
			    </tr>
			     </table>     
        </div>
        <div class="t">
		   <table id="jobdivtb">
		   <tr>
		   <td><h2>Preferred Jobs listed below</h2></td>
		   </tr>
		     <tr>
		     <td>
		         <div id="currentUserJobListDiv"></div>
			    </td>
			    </tr>
			    <tr>
		    <td><div id="smart-paginator" style="margin: auto;"></div></td>
		    </tr>
		   </table>
		   </div>
</div>    
    </td>
    </tr>
    </table>
	
</body>
</html>
