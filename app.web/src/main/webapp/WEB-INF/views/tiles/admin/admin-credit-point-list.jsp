<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/accounts/deposit/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id','Date','Particular','Username','Reseller ID','Debit','Commision Payed','Commission Incured'],
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
						name : 'particular',
						index : 'particular',
						width : 60,
						
					},{
						name : 'user.userName',
						index : 'user.userName',
						width : 60,
						
					},{
						name : 'user.mlmAccountId',
						index : 'user.mlmAccountId',
						width : 60,
						
					},{
						name : 'debit',
						index : 'debit',
						width : 60,
						
					}, {
						name : 'creditCommision',
						index : 'creditCommision',
						width : 60
					},{
						name : 'creditToRoot',
						index : 'creditToRoot',
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
					sortname : 'createdAt',
					viewrecords : true,
					sortorder : "desc",
					caption : "Commssion Payed",
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
 <h4 style="padding: 5px">Home | Account | Incentive </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
<div id="viewDepositdiv" title="Points or Commission History">
  </div>	
</body>

</html>