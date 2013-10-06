<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

	$(document).ready(function() {
		$("#resellerRedeemForm").validate({
			success : "valid",
			ignoreTitle : true,
			rules : {
				"points" : {
					required : true,
					number : true,
					min:10,
					maxPointsCheck : true
				},
				"modeDetails" : {
					required : true
				}
			}
		});
	});
	
	jQuery.validator.addMethod('maxPointsCheck', function(inputValue) {
		var totalPoints = $("#totalPoints").val();
		if(inputValue <= totalPoints){
			return true;
		}
		return false;
	}, "Redeem Points should be less than total points.");

</script>
</head>
<body>
<c:choose>
<c:when test="${operation eq 'create'}">
<c:set var="readonly" value="false"/>
</c:when>
<c:otherwise>
<c:set var="readonly" value="true"/>
</c:otherwise>
</c:choose>
<form:form id="resellerRedeemForm" name="resellerRedeemForm" modelAttribute="resellerRedeemForm">
 <table style="border: 0">
   <c:if test="${operation eq 'create'}">
	<tr>
    <td>Total Points</td>
    <td><c:out value="${userTotalPoints}"></c:out> </td>
   </tr>
   </c:if>
    <tr>
    <td>Points to Redeem</td>
    <td><form:input path="points" disabled="${readonly}"/></td>
   </tr>
   <tr>
    <td>Mode of Redemption</td>
    <td><form:select path="modeOfRedemption" items="${modeOfRedemptionList}" disabled="${readonly}" ></form:select></td>
   </tr>
   <tr>
    <td>Redemption Details</td>
    <td><form:textarea path="modeDetails" rows="5" cols="30" disabled="${readonly}"/></td>
   </tr>
 </table>
 </form:form>
<input id="totalPoints" name="totalPoints" type="hidden" value="${userTotalPoints}">
</body>
</html>