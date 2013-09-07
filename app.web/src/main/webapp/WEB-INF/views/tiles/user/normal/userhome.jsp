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
<title>JOBSbySMS-Enquiry</title>
<spring:url value="/resources/css/smartpaginator.css" var="resourceCssSmartPaginatorUrl"/>
<spring:url value="/resources/js/smartpaginator.js" var="resourceJsSmartPaginatorUrl"/>

<script type="text/javascript" src="${resourceJsSmartPaginatorUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceCssSmartPaginatorUrl}"/>

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
			recordsperpage : 2,
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
	    url: webContextPath+"/normal/user/joblist/"+newPageValue+"/2",
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
     <h3>Welcome ${currentLoggedInUser}. Preferred Jobs listed below</h3>
    <div id="currentUserJobListDiv"></div>
	<div id="smart-paginator"></div>
</body>
</html>
