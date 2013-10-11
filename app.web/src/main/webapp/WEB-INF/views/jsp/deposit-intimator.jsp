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
	var currentDepId= $("#depositIntimator\\.id").val();
	if(currentDepId == 0){
    	$("#depositIntimator\\.transactedDate").datepicker({dateFormat: "dd/mm/yy" });
    	$("#depositIntimator\\.chequeDate").datepicker({dateFormat: "dd/mm/yy" });
	}
    $("#initDeposit").button();
});
function initiateDeposit(){
	var isValid = $("#depositIntimator").valid();
	console.log('Form Valid...',isValid);
	if(isValid){
			$("#depositIntimator").attr("action",webContextPath+"/reseller/paymentintimator");
		}
	}

$(document).ready(function(){
	
	$("#depositIntimator").validate( {
	    success : "valid",
	    ignoreTitle : true,
	    
	    rules : {
	    	 "depositIntimator.transactedDate" : {
  		        required : true
  		      },    
  		      
  		    "depositIntimator.amountDeposited" : {
  		    	required : true,
  		    	 number:true
  		    },
	    	    		
	    	"receiverResellerId" : {
	    		required:function(element){
	    			return $("#paymentMode option:selected").val()=="MANUAL"
	    			  }
	    		  		
	    	}, 
	    	"cashReceipt" : {
	    		required:function(element){
	    			return $("#paymentMode option:selected").val()=="DEPOSIT"
	    			  }
	    		  		
	    	},
  		     "depositIntimator.cashDepositedBankName": {
  		    	lettersonly: true,
  		    	required:function(element){
	    			return $("#paymentMode option:selected").val()=="DEPOSIT"
	    		}
	    			
 		    },
 		      "depositIntimator.transactionNumber":{
 		    	 required:function(element){
 	    			return $("#paymentMode option:selected").val()=="ONLINE"
 	    		},
  		    	 number:true,
  		    	 alphanumeric:true
 		    },
 		   "depositIntimator.chequeNumber" : {
 		    	number:true,
 		    	 required:function(element){
  	    			return $("#paymentMode option:selected").val()=="CHEQUE"
 			   }
 		   },
 		  "depositIntimator.chequeDate" : {
		    	 required:function(element){
	    			return $("#paymentMode option:selected").val()=="CHEQUE"
			   }
		   },
		   "depositIntimator.chequeDrawnOnBank" : {
			     lettersonly:true,
		    	 required:function(element){
	    			return $("#paymentMode option:selected").val()=="CHEQUE"
			   }
		   },
		   "depositIntimator.chequeDrawnBranch" : {
			    lettersonly: true,
		    	 required:function(element){
	    			return $("#paymentMode option:selected").val()=="CHEQUE"
			   }
		   },
	    },
	    
	       messages: {
	          receiverResellerId : "Select the reseller Id",
	          "depositIntimator.chequeNumber" : {
	        	  required: "Enter the Cheque number"
	          },
	    	 "depositIntimator.cashDepositedBankName" : {
	    		  required: "Enter the Bank Name"
	    	 },
	    	 "depositIntimator.chequeDrawnOnBank" : {
	    		 
	    		  required: "Enter the Bank Name"
	    	 },
	    	 "depositIntimator.chequeDrawnBranch" : {
	    		  
	    		  required: "Enter the Branch Name"
	    	 }
	     }
	         
	});
	   
});
 
	   

jQuery.validator.addMethod("lettersonly", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z ]+$/i.test(value);
	}, "Alphabets & Space are valid characters."); 

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z0-9]+$/i.test(value);
	}, "Alphabets and Numbers only applicable"
	
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
<table border="0" style="margin:auto; width:1100px">
  <tr>
    <td scope="col" width="48"><strong id="h3">Payment Intimator</strong><br/>
    <hr color="red"/>
    </td>
  </tr>
  <tr>
    <td>
    <table width="527" border="0" id="transactionTable" class="paymentTable">
      <tr>
        <td width="253" scope="col">Payment Mode<em>*</em></td>
        <td width="375" scope="col"><label for="select"></label>
          <form:select path="paymentMode" id="paymentMode" disabled="${readonly}">
          <form:option  value="" >Select Payment Option</form:option> 
          <form:options  items="${paymentModes}" />
          </form:select>
          
          </td>
        </tr>
      <tr>
        <td width="159">Transaction Date<em>*</em></td>
        <td width="25">
          <form:input size="30" path="depositIntimator.transactedDate"  readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Transaction Amount<em>*</em></td>
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
   <td><strong>Cash Deposit in Hand<em>*</em></strong><br/>
   <hr color="red"/>
   </td>
  </tr>
  <tr>
    <td>
    <table width="261" border="0" id="resellerTable" id="resellerTable" class="paymentTable">
      <tr>
        <td width="253"> Receiver Reseller ID<em>*</em></td>
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
        <td width="253" scope="col">Receipt Copy<em>*</em></td>
        <td width="375" scope="col"><input type="file" name="cashReceipt" id="cashReceipt" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Bank Name<em>*</em></td>
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
        <td width="245">Transaction Number<em>*</em></td>
        <td width="367"><form:input size="30" path="depositIntimator.transactionNumber" readonly="${readonly}"/></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td><strong>Details for Cheque Transfer<em>*</em></strong><br/>
    <hr color="red"/>
    </td>
  </tr>
  <tr>
    <td>
    <table width="200" border="0" id="chequeTable" class="paymentTable" >
      <tr>
        <td width="253">Cheque Number<em>*</em></td>
        <td width="374"><form:input size="30" path="depositIntimator.chequeNumber" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Cheque Date<em>*</em></td>
        <td><form:input size="30" path="depositIntimator.chequeDate" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Drawn on bank<em>*</em></td>
        <td><form:input size="30" path="depositIntimator.chequeDrawnOnBank" readonly="${readonly}"/></td>
      </tr>
      <tr>
        <td>Drawn on branch<em>*</em></td>
        <td><form:input size="30" path="depositIntimator.chequeDrawnBranch" readonly="${readonly}"/></td>
      </tr>
    </table>
    </td>
  </tr>
  <c:if test="${operation eq 'view' }">
   <tr>
    <td><strong>Approve or Reject Memo</strong><br/>
    <hr color="red"/>
    </td>
  </tr>
  <tr>
    <td>
    <table width="200" border="0" id="memoTable" class="paymentTable" >
      <tr>
        <td width="253">Memo</td>
        <td width="374"><form:textarea  path="depositIntimator.memo" cols="45" rows="5"/></td>
      </tr>
      </table>
      </td>
  </tr>
  </c:if>
  <tr>
  <td>
 	<c:if test="${operation eq 'create' }">
  		<button id="initDeposit" onclick="initiateDeposit();">Submit</button>
 	 </c:if>
  	</td>
  </tr>
</table>
<form:hidden path="depositIntimator.id" />
</form:form>
</body>
</html>