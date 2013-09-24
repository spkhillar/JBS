<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<script>
$(document).ready(function(){
    $("#depositIntimator\\.transactedDate").datepicker({dateFormat: "dd/mm/yy" });
    $("#depositIntimator\\.chequeDate").datepicker({dateFormat: "dd/mm/yy" });
    $("#initDeposit").button();
});
function initiateDeposit(){
	var isValid = $("#depositIntimator").valid();
	console.log('Form Valid...',isValid);
	if(isValid){
			$("#depositIntimator").attr("action",webContextPath+"/reseller/paymentintimator");
		}
	}
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
<form:form name="depositIntimator" id="depositIntimator" commandName="depositIntimator" enctype="multipart/form-data" method="POST">
<table border="0" width="80%" style="margin:auto">
  <tr>
    <td scope="col" width="48"><strong id="h3">Payment Intimator</strong><br/>
    <hr color="red"/>
    </td>
  </tr>
  <tr>
    <td>
    <table width="527" border="0" id="transactionTable" class="paymentTable">
      <tr>
        <td width="253" scope="col">Payment Mode</td>
        <td width="375" scope="col"><label for="select"></label>
          <form:select path="paymentMode" id="paymentMode" disabled="${readonly}">
          <form:option  value="0" >Select Payment Option</form:option> 
          <form:options  items="${paymentModes}" />
          </form:select>
          
          </td>
        </tr>
      <tr>
        <td width="159">Transaction Date</td>
        <td width="25">
          <form:input size="30" path="depositIntimator.transactedDate"  readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Transaction Amount</td>
        <td><form:input size="30" path="depositIntimator.amountDeposited" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Description</td>
        <td><label for="textarea"></label>
          <form:textarea path="depositIntimator.description" cols="45" rows="5" readonly="${readonly}"/></td>
      </tr>
     </table>
     
    </td>
  </tr>
  <tr>
   <td><strong>Cash Deposit in Hand</strong><br/>
   <hr color="red"/>
   </td>
  </tr>
  <tr>
    <td>
    <table width="261" border="0" id="resellerTable" id="resellerTable" class="paymentTable">
      <tr>
        <td width="253"> Receiver Reseller ID</td>
        <td width="370"><form:input size="30" path="receiverResellerId" readonly="${readonly}"/></td>
      </tr>
    </table>
    
    </td>
  </tr>
  <tr>
    <td><strong>Cash Deposit in Bank</strong><br/>
    <hr color="red"/></td>
  </tr>
  <tr>
    <td>
    <table width="644" border="0" width="200" id="receiptTable" class="paymentTable" >
      <tr>
        <td width="253" scope="col">Receipt Copy</td>
        <td width="375" scope="col"><input type="file" name="cashReceipt" id="cashReceipt" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Bank Name</td>
        <td><form:input size="30" path="depositIntimator.cashDepositedBankName" readonly="${readonly}"/></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td><strong>Details for NEFT/RTGS/Online Transfer</strong><br/>
    <hr color="red"/></td>
  </tr>
  <tr>
    <td>
    <table width="640" border="0" width="200" id="onlineTable" class="paymentTable">
      <tr>
        <td width="245">Transaction Number</td>
        <td width="367"><form:input size="30" path="depositIntimator.transactionNumber" readonly="${readonly}"/></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td><strong>Details for Cheque Transfer</strong><br/>
    <hr color="red"/>
    </td>
  </tr>
  <tr>
    <td>
    <table width="200" border="0" id="chequeTable" class="paymentTable" >
      <tr>
        <td width="253">Cheque Number</td>
        <td width="374"><form:input size="30" path="depositIntimator.chequeNumber" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Cheque Date</td>
        <td><form:input size="30" path="depositIntimator.chequeDate" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Drawn on bank</td>
        <td><form:input size="30" path="depositIntimator.chequeDrawnOnBank" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Drawn on branch</td>
        <td><form:input size="30" path="depositIntimator.chequeDrawnBranch" readonly="${readonly}"/></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
  <td>
 	<c:if test="${operation eq 'create' }">
  		<button id="initDeposit" onclick="initiateDeposit();">Submit</button>
 	 </c:if>
  	</td>
  </tr>
</table>
</form:form>
</body>
</html>