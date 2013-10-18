<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/deposit/records/3";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Amount Deposited','Transaction Date', 'Reseller Id',"First Name","Last Name"],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'amountDeposited',
						index : 'amountDeposited',
						width : 60
					}, {
						name : 'transactedDate',
						index : 'transactedDate',
						width : 60
					}, {
						name : 'userByUserId.mlmAccountId',
						index : 'userByUserId.mlmAccountId',
						width : 60
					}, {
						name : 'userByUserId.firstName',
						index : 'userByUserId.firstName',
						width : 60
					}, {
						name : 'userByUserId.lastName',
						index : 'userByUserId.lastName',
						width : 60
					}
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
					caption : "Push Balance History",
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
 <h4 style="padding: 5px">Home | Push Balance | Push Balance History </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
<div id="viewDepositdiv" title="Deposit Notification" style="margin:auto; width:80%">
  </div>	
</body>
</html>