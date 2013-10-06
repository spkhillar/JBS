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
					rowList : [ 20, 30, 40,30 ],
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
		//var value = '<a href="'+webContextPath+'/admin/job/find/'+ rowObject.id +'">'+ cellvalue +'</a>';
		  var value = '<a href="javascript:void(0);" onclick="javascript:loadRedeemDetails('+rowObject.id+')">'+ cellvalue +'</a>';
		
		return value;
	}
	
	/*function loadRedeemDetails(resellerId){
		//console.log('..webContextPath+"/mypage/jobdetail"',webContextPath+"/mypage/jobdetail");
		
		//console.log('...'+jobId+'...');
		 $.ajax({
			    url: webContextPath+"/admin/view/approval/notification/"+depositorIntimatorId,
			    dataType:'html',
			    success: function(data){
			      //construct the data however, update the HTML of the popup div 
			      $('#viewDepositdiv').html(data);
			      $('#viewDepositdiv').dialog({
			  		modal: 'true',
			  		height:700,
			  		width:850,
			  		closeOnEscape: true,
			  		buttons: [ { text: "Approve", click: 
				  			function() {
				  				$( this ).dialog( "close" ); 
				  					initiateActionOnDepositIntimatorRecord(depositorIntimatorId,1);
				  				} 
			  			},
			  				{ text: "Reject", click: function() 
			  				{
			  					$( this ).dialog( "close" ); 
			  					initiateActionOnDepositIntimatorRecord(depositorIntimatorId,0);
			  				} 
			  			}]
			      }).show();
			    }
			  });
	}
	
	function initiateActionOnDepositIntimatorRecord(depositorIntimatorId,type){
		 $.ajax({
			    url: webContextPath+"/admin/approve/notification/"+depositorIntimatorId+"/"+type,
			    success: function(data){
			    	$("#grid").trigger('reloadGrid');
			    }
			    
		 });
	}
	*/
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