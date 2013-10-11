<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/view/userdetails";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'First Name', 'Last Name','Email','Phone','Created Date'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'user.firstName',
						index : 'user.firstName',
						width : 60,
						formatter:myHyperLinkFormatter
					},  {
						name : 'user.lastName',
						index : 'user.lastName',
						width : 60
					}, {
						name : 'user.email',
						index : 'user.email',
						width : 60
					},{
						name : 'user.phone',
						index : 'user.phone',
						width : 60
					},{
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
					sortname : 'createdAt',
					viewrecords : true,
					sortorder : "desc",
					caption : "User Information List",
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
		 // var value = '<a href="javascript:void(0);" onclick="javascript:viewPaymentDetails('+rowObject.redeemHistory.id+')">'+ cellvalue +'</a>';
		// return value;
	}
	
</script>
</head>
<body>

<div id="depositListDiv">
 <h4 style="padding: 5px">Home | Users</h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
<div id="viewDepositdiv" title="Redeem Notification">
  </div>	
</body>
</html>