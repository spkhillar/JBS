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
<style>
.formfields{

 border-color: blue;
 border-radius: 1px 1px 1px 1px;
 width:100%;
 height:50%;

}

#jobtbinfo,#jobs_tb{
 
border-radius: 10px 10px 10px 10px;
}

</style>

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
		
	});
	function postJob(){
		var isValid = $("#jobForm").valid();
		console.log('Form Valid...',isValid);
		if(isValid){
			$("#jobForm").attr("action",webContextPath+"/admin/job/post");
			$("#jobForm").submit();
		}
		
	}
</script>
</head>
<body>
<form:form name="jobForm" commandName="jobForm" id="jobForm" enctype="multipart/form-data" method="POST">
	<table width="100%" id="jobs_tb" style="border: 0">
		<tr>
			<td>Post New Job
		</tr>
		<tr>
		  <td><table width="96%"  border="0" align="center" id="jobtbinfo" style="font-size: 12px;">
								<tr>
									<td height="23">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td width="117" height="56"><em>*</em>Job Title</td>
									<td width="315">
									<form:input path="job.jobTitle" cssClass="formfields"/>
									</td>
									<td width="101">Job Type</td>
									<td width="180">
									<form:select path="job.jobType" items="${jobTypes}" cssClass="formfields"></form:select>
									</td>
									<td width="122">Job Code</td>
									<td width="256">
									<form:input path="job.jobCode" cssClass="formfields"/>
									</td>
									<td width="103">&nbsp;</td>
								</tr>
								<tr>
									<td height="62"><em>*</em>Company Name</td>
							    <td><form:input path="job.companyName" cssClass="formfields"/></td>
									<td><em>*</em>Company URL</td>
									<td><form:input path="job.companyUrl" cssClass="formfields"/></td>
									<td><em>*</em>Date</td>
									<td><form:input path="job.postedAt" cssClass="formfields" /></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td height="48"><em>*</em>Qualification</td>
							    <td><form:input path="job.qualification" cssClass="formfields" /></td>
									<td><em>*</em>Salary</td>
									<td><form:input path="job.salary"cssClass="formfields" /></td>
									<td>Catagory</td>
									<td><form:select path="job.category" items="${jobCategories}" cssClass="formfields"></form:select>
									</td>
									<td>Sub Catagory</td>
									</tr>
								<tr>
									<td height="62"><em>*</em>Designation</td>
									<td><form:select path="designation" items="${jobDesignations}" cssClass="formfields" ></form:select>
									</td>
									<td>Others</td>
									<td><form:input path="otherDesignation" cssClass="formfields"/></td>
									<td>Functional Area</td>
									<td><form:select path="job.industry" items="${jobsFunctionalAreaList}" ></form:select>
									<td><form:select path="job.subCategory" items="${jobSubCategories}" ></form:select></td>
								</tr>
								<tr>
									<td height="46"><em>*</em>Experience</td>
							    <td><form:select path="job.experiance" items="${workExperianceList}" ></form:select></td>
									<td><em>*</em>Location</td>
									<td><form:input path="job.location"/></td>
									<td>&nbsp;</td>
									<td>Company Image</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td height="52">Age Limit</td>
							    <td><form:input path="job.ageLimit"/></td>
									<td height="52"><em>*</em>Skills</td>
							    <td><form:textarea path="job.skill"/></td>
									<td height="52">Keyword</td>
							    <td><form:textarea path="job.keyword"/></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td height="75"><em>*</em>Description</td>
									<td colspan="5"><form:textarea path="job.jobDescription"
											cols="45" rows="5"/>
									</td>
									<td><img name="" src="images/add.jpg" width="76"
										height="73" alt="" /></td>
								</tr>
								<tr>
								<td>
								<button id="save" onClick="postJob();">Submit</button>
								</td>
								</tr>
							</table></td>
						</tr>
			</table>
<form:hidden path="newJob"/>
	<form:hidden path="job.id"/>
	</form:form>
</body>
</html>