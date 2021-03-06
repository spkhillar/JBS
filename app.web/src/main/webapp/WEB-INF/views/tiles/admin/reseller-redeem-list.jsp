<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/redeem/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Username', 'Points to Redeem','Mode of Redeemption', 'Date'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'user.userName',
						index : 'user.userName',
						width : 60,
						formatter:myHyperLinkFormatter
					}, {
						name : 'points',
						index : 'points',
						width : 60
					}, {
						name : 'modeOfRedemption',
						index : 'modeOfRedemption',
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
					caption : "Reseller Redeem Information List",
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
		  var value = '<a href="javascript:void(0);" onclick="javascript:loadRedeemDetails('+rowObject.id+')">'+ cellvalue +'</a>';
		return value;
	}
	
	function loadRedeemDetails(id){
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
			  		buttons: [ { text: "Approve", click: function() {
				  				$( this ).dialog( "close" ); 
				  					initiateActionOnRedeemRecord(id,1);
				  				} 
			  				},
			  				{ text: "Reject", click: function(){
			  					$( this ).dialog( "close" ); 
			  					initiateActionOnRedeemRecord(id,0);
			  				} 
			  			}]
			      }).show();
			    }
			  });
	}
	
	function initiateActionOnRedeemRecord(id,approval){
		 $.ajax({
			    url: webContextPath+"/admin/approve/redeem/notification/"+id+"/"+approval,
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
 <h4 style="padding: 5px">Home | Manage Notification | Redeem Notification </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
<div id="viewDepositdiv" title="Redeem Notification">
  </div>	
</body>
</html>