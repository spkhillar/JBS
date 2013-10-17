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
	$("#Back").button();
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

function back(){
	$('#firstDiv').hide();
	$('#secondDiv').show();
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
		
		$('#firstDiv').hide();
		$('#secondDiv').hide();
		$('#thirdDiv').hide();
		$('#fourthDiv').show();
		var date = new Date();
		replaceTableVerifyTransferDetails('transactiondate',(date.getDate() + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear()));
		replaceTableVerifyTransferDetails('fromreseller',$('#loggedInMlmId').val());
		replaceTableVerifyTransferDetails('toreseller',mlmIdValue);
		replaceTableVerifyTransferDetails('transactionamt',depositAmount+commissionAmount);
		
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

function replaceTableVerifyTransferDetails(find, replace)
{
    $("#verifyTransferDetails td:contains('" + find + "')").html(replace);
}
</script>
<style>
input[type="text"],input[type="number"],select,input[type="password"],textarea
	{
	padding: 5px;
	border: 1px solid green;
	/*Applying CSS3 gradient*/
	background: -moz-linear-gradient(center top, #FFFFFF, #EEEEEE 1px, #FFFFFF 20px);
	background: -webkit-gradient(linear, left top, left 20, from(#FFFFFF),
		color-stop(5%, #EEEEEE) to(#FFFFFF));
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FBFBFB',
		endColorstr='#FFFFFF');
	/*Applying CSS 3radius*/
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	/*Applying CSS3 box shadow*/
	-moz-box-shadow: 0 0 2px #DDDDDD;
	-webkit-box-shadow: 0 0 2px #DDDDDD;
	box-shadow: 0 3px 2px #DDDDDD;
}

input[type="text, number"]:hover {
	border: 1px solid #cccccc;
}

input[type="text, number"]:focus {
	box-shadow: 0 0 2px #FFFE00;
}
</style>
</head>
<body>
<div id="mainContentDiv">
<br/> <br/>

	<div id="firstDiv">
	   <div id="step1"></div>
	  <hr color="blue"><br/>
		<table border="0" id="resellerIdInfo">
			<tr>
				<td width="36%">Reseller Id</td>
				<td width="64%"> <input type="text" id="mlmId"/> </td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="button" id="firstButton" value="Next" onclick="javascript:step1();"/>
			</td>
			</tr>
		</table>
		
	</div>
	<div id="secondDiv" hidden="true">
	<div id="step2"></div>
	<hr color="blue"><br/>
		<table width="25%" border="0" id="tableCreditDetails">
			<tr>
				<td width="32%" class="firstColBold">Reseller Id</td>
				<td width="68%">mlmid</td>
			</tr>
			<tr>
				<td class="firstColBold">First Name</td>
				<td>firstname</td>
			</tr>
			<tr>
				<td class="firstColBold">Last Name</strong></td>
				<td>lastname</td>
			</tr>
			<tr>
				<td class="firstColBold">Phone</strong></td>
				<td>phonenum</td>
			</tr>
			<tr>
				<td class="firstColBold">Email</strong></td>
				<td>emailid</td>
			</tr>
			<tr>
			<td>
			  <strong>
			  <input type="button" id="secondButton" value="Previous" onclick="javascript:prev1();"/>
			  </strong></td>
			<td>
			<input type="button" id="thirdButton" value="Next" onclick="javascript:step2();"/>
			</td>
			</tr>
		</table>
		
		
	</div>
	<div id="thirdDiv" hidden="true">
	<div id="step3"></div>
	<hr color="blue"><br/>
		<table width="74%" border="0" id="creditTransferDetails">
			<tr>
				<td width="27%">Deposit Balance</td>
				<td width="10%">(${webUser.currentBalance})</td>
				<td width="45%"><input type="text" id="depositbalance" value="0"/> </td>
			</tr>
			<tr>
				<td width="27%">Commission Balance</td>
				<td width="10%">(${webUser.currentComissionBalance})</td>
				<td width="45%"><input type="text" id="commissionbalance" value="0"/> </td>
			</tr>
			<tr>
			<td colspan="3">
				<input type="button" id="Back" value="Back" onclick="javascript:back();"/>
				<input type="button" id="fourthButton" value="Transfer" onclick="javascript:submitCredit();"/>	
			</td>
			</tr>
		</table>
		
	</div>
	<div id="fourthDiv" hidden="true">
	 <div id="step4"></div>
	<hr color="blue"><br/>
	     
		<table width="74%" border="0" id="verifyTransferDetails">
		<tr>
		<td colspan="2">
		    <div class="successLogo"></div>
		    <div class="transfersuccessmessage">Successfully Transferred </div>  
		</td>
		</tr>
			<tr>
				<td width="34%" class="firstColBold">Transaction Date</td>
				<td width="66%">transactiondate</td>
			
			</tr>
			<tr>
				<td width="34%" class="firstColBold">From Reseller Id</td>
				<td width="66%">fromreseller</td>
			
			</tr>
			<tr>
				<td width="34%" class="firstColBold">To Reseller Id</td>
				<td width="66%">toreseller</td>
				
			</tr>
			<tr>
				<td width="34%" class="firstColBold">Transferred Amount</td>
				<td width="66%">transactionamt</td>
				
			</tr>
			
		</table>
		
	</div>
</div>
<input type="hidden" value="${webUser.currentBalance}" id="depositBal"/>
<input type="hidden" value="${webUser.currentComissionBalance}" id="commissionBal"/>
<input type="hidden" value="${webUser.mlmId}" id="loggedInMlmId"/>
</body>
</html>