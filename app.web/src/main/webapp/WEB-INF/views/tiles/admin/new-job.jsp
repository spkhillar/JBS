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
	<table id="jobs_tb" style="border: 0">
		<tr>
			<td>Jobs Information
		</tr>
		<tr>
			<td height="359">
			<table border="0" id="jobposttb">
					<tr>
						<td width="5%">&nbsp;</td>
						<td width="6%">&nbsp;</td>
						<td width="16%">&nbsp;</td>
						<td width="16%">&nbsp;</td>
						<td width="16%">&nbsp;</td>
						<td width="16%">&nbsp;</td>
						<td width="21%">&nbsp;</td>
						<td width="4%">&nbsp;</td>
					</tr>
					<tr>
						<td height="23">&nbsp;</td>
						<td colspan="8" rowspan="7"><table width="85%" border="0"
								align="center" id="jobtbinfo">
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
									<td width="99"><em>*</em>Job Title</td>
									<td width="143">
									<form:input path="job.jobTitle"/>
									</td>
									<td width="170">Job Type</td>
									<td width="143">
									<form:select path="job.jobType" items="${jobTypes}" ></form:select>
									</td>
									<td width="127">Job Code</td>
									<td width="151">
									<form:input path="job.jobCode"/>
									</td>
									<td width="74">&nbsp;</td>
								</tr>
								<tr>
									<td><em>*</em>Company Name</td>
									<td><form:input path="job.companyName"/></td>
									<td><em>*</em>Company URL</td>
									<td><form:input path="job.companyUrl"/></td>
									<td><em>*</em>Date</td>
									<td><form:input path="job.postedAt" /></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><em>*</em>Qualification</td>
									<td><form:input path="job.qualification" /></td>
									<td><em>*</em>Salary</td>
									<td><form:input path="job.salary"/></td>
									<td>Catagory</td>
									<td><form:select path="job.category" items="${jobCategories}" ></form:select>
									</td>
									<td>Sub Catagory</td>
									<td>
									<form:select path="job.subCategory" items="${jobSubCategories}" ></form:select>
									</td>
								</tr>
								<tr>
									<td><em>*</em>Designation</td>
									<td><form:select path="designation" items="${jobDesignations}" ></form:select>
									</td>
									<td>Others</td>
									<td><form:input path="otherDesignation"/></td>
									<td>Functional Area</td>
									<td><form:select path="job.industry" items="${jobsFunctionalAreaList}" ></form:select>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><em>*</em>Experience</td>
									<td><form:select path="job.experiance" items="${workExperianceList}" ></form:select></td>
									<td><em>*</em>Location</td>
									<td><form:input path="job.location"/></td>
									<td>&nbsp;</td>
									<td>Company Image</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td height="26">Age Limit</td>
									<td><form:input path="job.ageLimit"/></td>
									<td height="26"><em>*</em>Skills</td>
									<td><form:textarea path="job.skill"/></td>
									<td height="26">Keyword</td>
									<td><form:textarea path="job.keyword"/></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td height="104"><em>*</em>Description</td>
									<td colspan="5"><form:textarea path="job.jobDescription"
											cols="45" rows="5"/>
									</td>
									<td><img name="" src="images/add.jpg" width="76"
										height="73" alt="" /></td>
								</tr>
								<tr>
								<td>
								<button id="save" onclick="postJob();">Submit</button>
								</td>
								</tr>
							</table></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="65">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
		</tr>
	</table>
	<form:hidden path="newJob"/>
	<form:hidden path="job.id"/>
	</form:form>
</body>
</html>