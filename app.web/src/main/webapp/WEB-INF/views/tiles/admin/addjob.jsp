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
<jsp:include page="../../tiles/base/app.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
input[type="text"],input[type="number"],select,textarea{
    
    padding: 5px;   
    border: 1px solid green;
    
    /*Applying CSS3 gradient*/
    background: -moz-linear-gradient(center top , #FFFFFF,  #EEEEEE 1px, #FFFFFF 20px);    
    background: -webkit-gradient(linear, left top, left 20, from(#FFFFFF), color-stop(5%, #EEEEEE) to(#FFFFFF));
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FBFBFB', endColorstr='#FFFFFF');
    
    /*Applying CSS 3radius*/   
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    
    /*Applying CSS3 box shadow*/
    -moz-box-shadow: 0 0 2px #DDDDDD;
    -webkit-box-shadow: 0 0 2px #DDDDDD;
    box-shadow: 0 0 2px #DDDDDD;

}
input[type="text"]:hover
{
    border:1px solid #cccccc;
}
input[type="text"]:focus
{
    box-shadow:0 0 2px #FFFE00;
}

</style>
<spring:url value="/resources/js/addjob.js" var="resourceAddJobJSUrl"/>
<script type="text/javascript" src="${resourceAddJobJSUrl}"></script>
</head>

<body>
<form:form name="jobForm" commandName="jobForm" id="jobForm" enctype="multipart/form-data" method="POST">
<table id="addjob" border="0" align="center" class="settings">
  <tr>
    
    <td colspan="6" scope="col"><h4 style="padding: 5px">Home | Jobs | Add Jobs </h4><br/>
    <hr color="red"></td>  
  </tr>
 
  <tr>
   <td>
     <table id="jobEntryTable">
     <tr>
    <td width="182" scope="col">Job Title<em>*</em></td>
    <td scope="col"><form:input path="job.jobTitle" cssClass="formfields"/></td>
    <td>Company Name<em>*</em></td>
    <td ><label for="textfield4"></label>
    <form:input path="job.companyName" cssClass="formfields"/></td>
    <tr>
    <td  width="182">Job Type<em>*</em></td>
    <td><label for="textfield"></label>
     <form:select path="job.jobType" items="${jobTypes}" cssClass="formfields"></form:select>
    </td>
     <td  width="182">Company URL</td>
    <td ><label for="textfield5"></label>
    <form:input path="job.companyUrl" cssClass="formfields" size="50"/></td>
  </tr>
  <tr>
    <td>Job Code</td>
    <td><label for="textfield2"></label>
    <form:input path="job.jobCode" cssClass="formfields"/></td>
    <td>Company Job URL</td>
    <td ><label for="textfield6"></label>
    <form:input path="job.companyJobUrl" cssClass="formfields" size="50"/></td>
  </tr>
  <tr>
    <td>Posted Date<em>*</em></td>
    <td><label for="textfield3"></label>
    <form:input path="job.postedAt" cssClass="formfields"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Category<em>*</em></td>
    <td><label for="textfield7"></label>
   <form:select path="job.category" items="${jobCategories}" cssClass="formfields"></form:select>
   </td>
   <td>Age Limit</td>
    <td colspan="3"><label for="textfield11"></label>
   <form:input path="job.ageLimit" cssClass="formfields" /></td>
  </tr>
  <tr>
    <td width="20%">Sub Category</td>
    <td><label for="textfield8"></label>
   <form:select path="job.subCategory" items="${jobSubCategories}" cssClass="formfields"></form:select>
   </td>
     <td>Location<em>*</em></td>
    <td colspan="3"><label for="textfield12"></label>
    <form:input path="job.location" cssClass="formfields" /></td>
  </tr>
  </table>
  </td>
  </tr>
  <tr>
   <td>
     <table id="jobRequirementTable">
       <tr>
    <td>Functional Area<em>*</em></td>
    <td colspan="3"><label for="textfield9"></label>
    <form:select path="job.industry" items="${jobsFunctionalAreaList}" ></form:select></td>
  </tr>
  <tr class="blank">
    <td>&nbsp;</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>Salary<em>*</em></td>
    <td><form:input path="job.salary" cssClass="formfields" />
    </td>
 <td>Experience</td>
    <td colspan="3"><label for="textfield11"></label>
   <form:select path="job.experiance" items="${workExperianceList}"/></td>  
   </tr>
  <tr>
    <td>Designation<em>*</em></td>
    <td>
      <form:select path="designation" items="${jobDesignations}" cssClass="formfields" ></form:select>
	</td>
    <td>Others</td>
    <td><form:input path="otherDesignation" cssClass="formfields"/></td>
  </tr>
  
  <tr>
    <td>Job Valid for (In days)</td>
    <td>
    	<form:input path="job.jobValidDuration" cssClass="formfields"/>
    </td>
    <td>Status</td>
    <td>
      <form:select path="job.enabled" cssClass="formfields" >
	      <form:option value="true">True</form:option>
	      <form:option value="false">False</form:option>
      </form:select>
	</td>
  </tr>
  <tr>
    <td width="20%">Skills</td>
    <td colspan="3"><label for="textfield14"></label>
    <form:textarea path="job.skill"/></td>
  </tr>
  </table>
  </td>
  </tr>
   <tr>
   <td>
     <table id="jobDescriptionTable">
  <tr>
    <td width="20%">Job Introduction</td>
    <td colspan="3"><label for="textarea"></label>
     <form:textarea path="job.keyword" style="width:100%;"/></td>
  </tr>
  <tr>
    <td >Job Description<em>*</em></td>
    <td colspan="3" style="height: 300px;"><label for="textfield15">
      <form:textarea path="job.jobDescription" style="width:100%; height:100%"/>
    </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td class="qualificationLable">Qualification<em>*</em></td>
    <td width="352"><label for="select"></label>
      <form:select path="degreeList" multiple="multiple" style="width:100%;" size="20" items="${availableDegreeList}"></form:select>
      </td>
    <td class="degreeSelector" align="justify">
      <input type="button" name="btnRight" id="btnRight" value="&gt;&gt;" />
            <br>
         <input type="button" name="btnLeft" id="btnLeft" value="&lt;&lt;"/>
     </td>
    <td width="493"><label for="select"></label>
        <form:select path="selectedDegreeList" multiple="multiple" style="width:70%;float:left;" size="20" items="${savedDegreeList}"></form:select>
      </td>
  </tr>
  </table>
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
