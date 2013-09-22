<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/deposit/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Username', 'Amount Deposited','Transaction Date', 'Payment Mode','Payment Intimator Type'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'userByUserId.userName',
						index : 'userByUserId.userName',
						width : 60
					}, {
						name : 'amountDeposited',
						index : 'amountDeposited',
						width : 60
					}, {
						name : 'transactedDate',
						index : 'transactedDate',
						width : 60
					}, {
						name : 'modeOfPayment',
						index : 'modeOfPayment',
						width : 60
					},{
						name : 'depositIntimatorType',
						index : 'depositIntimatorType',
						width : 60
					}
					
					
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
					sortorder : "asc",
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
	
	
</script>
</head>
<body>

<div id="depositListDiv">
 <h4 style="padding: 5px">Home | Account | Credits or Payments </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
</body>
</html>