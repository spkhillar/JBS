<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/reseller/deposit/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id','Date','Points','Total'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					},{
						name : 'createdAt',
						index : 'createdAt',
						width : 60,
						
					},{
						name : 'point',
						index : 'point',
						width : 60,
						
					}, {
						name : 'total',
						index : 'total',
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
					sortname : 'total',
					viewrecords : true,
					sortorder : "desc",
					caption : "Reseller Points Information List",
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
	
		
	function initiateRedeemRequest(){
		
		$.ajax({
		    url: webContextPath+"/reseller/redeem/totalpoints",
		    dataType:'html',
		    success: function(data){
		      //construct the data however, update the HTML of the popup div 
		      $('#viewRedeemdiv').html(data);
		      $('#viewRedeemdiv').dialog({
		  		modal: 'true',
		  		height:300,
		  		width:450,
		  		closeOnEscape: true,
		  		buttons: [ { text: "Redeem", click: 
			  			function() {
			  				$( this ).dialog( "close" ); 
			  					
			  				} 
		  			},
		  				{ text: "Reject", click: function() 
		  				{
		  					$( this ).dialog( "close" ); 
		  					
		  				} 
		  			}]
		      }).show();
		    }
		    
		}); 
		
	}
	
	
</script>
</head>
<body>

<div id="depositListDiv">
 <h4 style="padding: 5px">Home | Incentive | Current Incentive </h4><br/>
 <button onclick="Javascript:initiateRedeemRequest()">Redeem Points</button>
 <hr color="red"/>
 	<table id='grid'></table>
		<div id='pager'></div>
	</div>
  
  <div id="viewRedeemdiv" title="Redeem Notification">
  </div>
</body>

</html>