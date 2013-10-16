<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script>
$(document).ready(function(){
	$("#firstButton").button();
	$("#secondButton").button();
	$("#thirdButton").button();
	$("#fourthButton").button();
});
function step1(){
	var valid = checkStep1Validity();
	if(valid){
		$('#firstDiv').hide();
		$('#secondDiv').show();
	}
}
function step2(){
	$('#firstDiv').hide();
	$('#secondDiv').hide();
	$('#thirdDiv').show();
}

function prev1(){
	$('#firstDiv').show();
	$('#secondDiv').hide();
	$('#thirdDiv').hide();
}
function submitCredit(){
	validateB4SubmitCredit();
	console.log('Done');
}

function checkStep1Validity(){
	var valid = true;
	var mlmIdValue = $("#mlmId").val();
	$( ".error" ).remove();
	if($.trim(mlmIdValue).length ==0){
		valid = false;
		$("#mlmId").after('<label class="error">MLM Id is required</label>');
		//showToastErrorMessage("Please enter Reseller Id.");
	}else{
	 $.ajax({
		    url: webContextPath+"/user/reseller/"+mlmIdValue,
		    async:false,
		    success: function(data){
		    	//redirect to the page where he can apply on company website
		    	if($.isEmptyObject(data)){
		    		valid = false;
		    		$("#mlmId").after('<label class="error">No Reseller found with the given reseller id.</label>');
		    	}else{
		    		replaceTableCreditDetailsCellContent('mlmid',data.mlmAccountId);
		    		replaceTableCreditDetailsCellContent('firstname',data.firstName);
		    		replaceTableCreditDetailsCellContent('lastname',data.lastName);
		    		replaceTableCreditDetailsCellContent('phonenum',data.phone);
		    		replaceTableCreditDetailsCellContent('emailid',data.email);
		    	}
		    },
		    error:function(jqXHR,textStatus,errorThrown){
		    	
		    }
		  });
	}
	return valid;
}

function replaceTableCreditDetailsCellContent(find, replace)
{
    $("#tableCreditDetails td:contains('" + find + "')").html(replace);
}

function validateB4SubmitCredit(){
	$( ".error" ).remove();
	var inputDepositBalance = $("#depositbalance").val();
	var inputCommissionBalance = $("#commissionbalance").val();
	var maxDepositBal = $("#depositBal").val();
	var maxCommissionBal = $("#commissionBal").val();
	var valid = true;
	console.log('inputDepositBalance=',inputDepositBalance,'.inputCommissionBalance=',inputCommissionBalance,'.maxDepositBal=',maxDepositBal,'.maxCommissionBal=',maxCommissionBal);
	/* if($.trim(inputDepositBalance).length == 0 && $.trim(inputCommissionBalance).length == 0){
		$("#depositbalance").after('<label class="error">Field is required.</label>');
		$("#commissionbalance").after('<label class="error">Field is required.</label>');
		valid = false;
	} */
	if(!checkForNumeric(inputDepositBalance)){
		$("#depositbalance").after('<label class="error">Field must contain only numbers.</label>');
		valid = false;	
	}
	if(!checkForNumeric(inputCommissionBalance)){
		$("#commissionbalance").after('<label class="error">Field must contain only numbers.</label>');	
		valid = false;
	}
	if(parseInt(inputDepositBalance) > parseInt(maxDepositBal)){
		$("#depositbalance").after('<label class="error">Value must less than '+maxDepositBal+' </label>');
		valid = false;
	}
	if(parseInt(inputCommissionBalance) > parseInt(maxCommissionBal)){
		$("#commissionbalance").after('<label class="error">Value must less than '+maxCommissionBal+' </label>');
		valid = false;
	}
	
	if(valid){
		var total = parseInt(inputDepositBalance)+parseInt(inputCommissionBalance);
		valid = checkTransferAmount(total);
	}
	
	if(valid){
		console.log('..initiate transfer..');
		initiateCreditTransfer(parseInt(inputDepositBalance),parseInt(inputCommissionBalance));
	}else{
		console.log('..error in initiating transfer..');
	}
}

function initiateCreditTransfer(depositAmount,commissionAmount){
	var mlmIdValue = $("#mlmId").val();
	var retValue="";
	$.ajax({
		type : "post",
		url : webContextPath + '/admin/credit/transfer/'+depositAmount+'/'+commissionAmount+'/'+mlmIdValue,
		async : false,
		success : function(data, textStatus) {
			console.log("...checkDepositAmount...",data);
			retValue = data;
		}
	});
	if(retValue == ""){
		return true;
	}else{
		showToastErrorMessage(retValue);
	}
}


function checkTransferAmount(value){
	var retValue="";
	$.ajax({
		type : "get",
		url : webContextPath + '/admin/verify/'+value,
		async : false,
		success : function(data, textStatus) {
			console.log("...checkDepositAmount...",data);
			retValue = data;
		}
	});
	if(retValue == ""){
		return true;
	}else{
		showToastErrorMessage(retValue);
	}
	return false;
}

function checkForNumeric(value){
	 return /^[0-9]+$/i.test(value);
}
</script>
</head>
<body>
<div class="mainContentDiv">
<br/> <br/>
	<div id="firstDiv">
		<table border="0">
			<tr>
				<td width="36%">MLM Id</td>
				<td width="64%"> <input type="text" id="mlmId"/> </td>
			</tr>
		</table>
		<input type="button" id="firstButton" value="Next" onclick="javascript:step1();"/>
	</div>
	<div id="secondDiv" hidden="true">
		<table border="0" id="tableCreditDetails" style="width: inherit;">
			<tr>
				<td width="36%">MLM Id</td>
				<td width="64%">mlmid</td>
			</tr>
			<tr>
				<td width="36%">First Name</td>
				<td width="64%">firstname</td>
			</tr>
			<tr>
				<td width="36%">Last Name</td>
				<td width="64%">lastname</td>
			</tr>
			<tr>
				<td width="36%">Phone</td>
				<td width="64%">phonenum</td>
			</tr>
			<tr>
				<td width="36%">Email</td>
				<td width="64%">emailid</td>
			</tr>
		</table>
		<input type="button" id="secondButton" value="Previous" onclick="javascript:prev1();"/>
		<input type="button" id="thirdButton" value="Next" onclick="javascript:step2();"/>
	</div>
	<div id="thirdDiv" hidden="true">
		<table border="0" id="creditTransferDetails">
			<tr>
				<td width="36%">Deposit Balance</td>
				<td width="20%">(${webUser.currentBalance})</td>
				<td width="44%"><input type="text" id="depositbalance" value="0"/> </td>
			</tr>
			<tr>
				<td width="36%">Commission Balance</td>
				<td width="20%">(${webUser.currentComissionBalance})</td>
				<td width="44%"><input type="text" id="commissionbalance" value="0"/> </td>
			</tr>
		</table>
		<input type="button" id="fourthButton" value="Submit" onclick="javascript:submitCredit();"/>
	</div>
</div>
<input type="hidden" value="${webUser.currentBalance}" id="depositBal"/>
<input type="hidden" value="${webUser.currentComissionBalance}" id="commissionBal"/>
</body>
</html>