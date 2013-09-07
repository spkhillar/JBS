<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" href="resources/images/favico.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
td{
	padding:5px;
}
</style>
<spring:url value="/resources/css/addjobtable.css" var="resourceAddJobCssUrl"/>

<link rel="stylesheet" type="text/css" href="${resourceAddJobCssUrl}"/>
<script type="text/javascript">
	
	$(document).ready(function() {	
		$("#job\\.postedAt").datepicker({dateFormat: "dd/mm/yy" });
		$("#save").button();
		$("#jobForm").validate( {
		    success : "valid",
		    ignoreTitle : true,
		    rules : {
				"job.jobTitle" : {
			        required : true
			   },
				"job.companyName" : {
			        required : true
			   },
				"job.companyUrl" : {
			        url : true
			   },
				"job.postedAt" : {
			        required : true
			   },
				"job.qualification" : {
			        required : true
			   },
				"job.salary" : {
			        required : true
			   },
				"designation" : {
			        required : true
			   },
				"job.experiance" : {
			        required : true
			   },
				"job.location" : {
			        required : true
			   },
				"job.skill" : {
			        required : true
			   },
				"job.jobDescription" : {
			        required : true
			   }
		    }
		});
		
		handleSelectedQualification();
	});
	function postJob(){
		var isValid = $("#jobForm").valid();
		console.log('Form Valid...',isValid);
		$("#selectedDegreeList > option").each(function(index, option) {
		    $(this).attr("selected",true);   
		});
		if(isValid){
			$("#jobForm").attr("action",webContextPath+"/admin/job/post");
			$("#jobForm").submit();
		}
		
	}
	
	function handleSelectedQualification(){
		$("#btnRight").button();
		$("#btnLeft").button();
		 $('#btnRight').click(function(e) {
		        var selectedOpts = $('#degreeList option:selected');
		        if (selectedOpts.length == 0) {
		            alert("Nothing to move.");
		            e.preventDefault();
		        }

		        $('#selectedDegreeList').append($(selectedOpts).clone());
		        $(selectedOpts).remove();
		        e.preventDefault();
		    });

		    $('#btnLeft').click(function(e) {
		        var selectedOpts = $('#selectedDegreeList option:selected');
		        if (selectedOpts.length == 0) {
		            alert("Nothing to move.");
		            e.preventDefault();
		        }

		        $('#degreeList').append($(selectedOpts).clone());
		        $(selectedOpts).remove();
		        e.preventDefault();
		    });
	}
	
</script>
</head>

<body>
<form:form name="jobForm" commandName="jobForm" id="jobForm" enctype="multipart/form-data" method="POST">
<table id="addjob" border="0" align="center">
  <tr>
    <td scope="col">  
    <td colspan="3" scope="col">  
  </tr>
  <tr>
    <td width="182" scope="col">Job Title</th>
    <td scope="col"><form:input path="job.jobTitle" cssClass="formfields"/></td>
    <td>Company Name</td>
    <td ><label for="textfield4"></label>
    <form:input path="job.companyName" cssClass="formfields"/></td>
  </tr>
  <tr>
    <td>Job Type</td>
    <td><label for="textfield"></label>
     <form:select path="job.jobType" items="${jobTypes}" cssClass="formfields"></form:select>
    </td>
     <td>Company URL</td>
    <td ><label for="textfield5"></label>
    <form:input path="job.companyUrl" cssClass="formfields"/></td>
  </tr>
  <tr>
    <td>Job Code</td>
    <td><label for="textfield2"></label>
    <form:input path="job.jobCode" cssClass="formfields"/></td>
    <td>Company Job URL</td>
    <td ><label for="textfield6"></label>
    <form:input path="companyJobUrl" cssClass="formfields"/></td>
  </tr>
  <tr>
    <td>Posted Date</td>
    <td><label for="textfield3"></label>
    <form:input path="job.postedAt" cssClass="formfields"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Category</td>
    <td><label for="textfield7"></label>
   <form:select path="job.category" items="${jobCategories}" cssClass="formfields"></form:select>
   </td>
   <td>Age Limit</td>
    <td colspan="3"><label for="textfield11"></label>
   <form:input path="job.ageLimit" cssClass="formfields" /></td>
  </tr>
  <tr>
    <td>Sub Category</td>
    <td><label for="textfield8"></label>
   <form:select path="job.subCategory" items="${jobSubCategories}" cssClass="formfields"></form:select>
   </td>
     <td>Location</td>
    <td colspan="3"><label for="textfield12"></label>
    <form:input path="job.location" cssClass="formfields" /></td>
  </tr>
  <tr>
    <td>Functional Area</td>
    <td colspan="3"><label for="textfield9"></label>
    <form:select path="job.industry" items="${jobsFunctionalAreaList}" ></form:select></td>
  </tr>
  <tr class="blank">
    <td>&nbsp;</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>Salary</td>
    <td><form:input path="job.salary" cssClass="formfields" />
    </td>
 <td>Experience</td>
    <td colspan="3"><label for="textfield11"></label>
   <form:input path="job.experiance" cssClass="formfields" /></td>  
   </tr>
   <tr>
    <td>Designation</td>
    <td>
      <form:select path="designation" items="${jobDesignations}" cssClass="formfields" ></form:select>
	</td>
    <td>Others</td>
    <td><form:input path="otherDesignation" cssClass="formfields"/></td>
		
  </tr>
  <tr>
    <td>Skills</td>
    <td colspan="3"><label for="textfield14"></label>
    <form:textarea path="job.skill"/></td>
  </tr>
  <tr>
    <td>Job Introduction</td>
    <td colspan="3"><label for="textarea"></label>
     <form:textarea path="job.keyword"/></td>
  </tr>
  <tr>
    <td>Job Description</td>
    <td colspan="3"><label for="textfield15">
      <form:textarea path="job.jobDescription"/>
    </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td class="qualificationLable">Qualification</td>
    <td width="352"><label for="select"></label>
      <form:select path="degreeList" multiple="multiple" style="width:100%;" size="20" items="${availableDegreeList}"></form:select>
      </td>
    <td width="10" class="degreeSelector">
      <input type="button" name="btnRight" id="btnRight" value="&gt;&gt;" />
            <br>
         <input type="button" name="btnLeft" id="btnLeft" value="&lt;&lt;"/>
     </td>
    <td width="493"><label for="select"></label>
        <form:select path="selectedDegreeList" multiple="multiple" style="width:70%;float:left;" size="20" items="${savedDegreeList}"></form:select>
      </td>
  </tr>
  <tr >
	<td colspan="3">
		<button id="save" onClick="postJob();">Submit</button>
	</td>
 </tr>
 <tr>
 <td colspan="3">
 &nbsp;
 </td>
 </tr>
</table>
<form:hidden path="newJob"/>
	<form:hidden path="job.id"/>
</form:form>
</body>
</html>
