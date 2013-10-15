<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/payment/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Username', 'Amount','Date'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'redeemHistory.user.userName',
						index : 'redeemHistory.user.userName',
						width : 60,
						formatter:myHyperLinkFormatter
					}, {
						name : 'amount',
						index : 'amount',
						width : 60
					}, {
						name : 'createdAt',
						index : 'createdAt',
						width : 60
					},				
					  ],
					postData : {},
					rowNum : 20,
					rowList : [ 20, 30, 40],
					height : 500,
					width : 1050,
					rownumbers : true,
					pager : '#pager',
					sortname : 'id',
					viewrecords : true,
					sortorder : "desc",
					caption : "Payment Information List",
					emptyrecords : "Empty records",
					loadonce : false,
					hidegrid : false,
					loadComplete : function() {
					},
					jsonReader : {
						root : "rows",
						page : "page",
						total : "total",
						records : "records",
						repeatitems : false,
						cell : "cell",
						id : "id"
					}
				});

		$("#grid").jqGrid('navGrid', '#pager', {
			edit : false,
			add : false,
			del : false,
			search : false,
			refreshtext : "Refresh",
			refreshtitle : "Refresh"
		}, {}, {}, {}, { //search
			sopt : [],
			closeOnEscape : true,
			multipleSearch : false,
			closeAfterSearch : false
		});
	});
	
	function myHyperLinkFormatter (cellvalue, options, rowObject)
	{
		  var value = '<a href="javascript:void(0);" onclick="javascript:viewPaymentDetails('+rowObject.redeemHistory.id+')">'+ cellvalue +'</a>';
		 return value;
	}
	
	function viewPaymentDetails(id){
		 $.ajax({
			    url: webContextPath+"/admin/view/redeem/notification/"+id,
			    dataType:'html',
			    success: function(data){
			      //construct the data however, update the HTML of the popup div 
			      $('#viewDepositdiv').html(data);
			      $('#viewDepositdiv').dialog({
			  		modal: 'true',
			  		height:350,
			  		width:400,
			  		closeOnEscape: true,
			  		buttons: [ { text: "Pay", click: function() {
				  				$( this ).dialog( "close" ); 
				  				initiateActionOnPaymentRecord(id);
				  				} 
			  				},
			  				{ text: "Cancel", click: function(){
			  					$( this ).dialog( "close" ); 
			  					initiateActionOnPaymentRecord(id);
			  				} 
			  			}]
			      }).show();
			    }
			  });
	}
	
	function initiateActionOnPaymentRecord(id){
		 $.ajax({
			    url: webContextPath+"/admin/update/payment/"+id,
			    success: function(data){
			    	showToastSuccessMessage("Record updated sucessfully.");
			    	$("#grid").trigger('reloadGrid');
			    },
			    error:function(jqXHR,textStatus,errorThrown){
			    	showToastErrorMessage("Record updating failed.");
			    }
			    
		 });
	}
	
</script>
</head>
<body>

<div id="depositListDiv">
 <h4 style="padding: 5px">Home | Payments </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
<div id="viewDepositdiv" title="Redeem Notification">
  </div>	
</body>
</html>