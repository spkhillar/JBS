<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/commission/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Level', 'Percentage', 'Capping'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'level',
						index : 'level',
						width : 60,
						formatter:myHyperLinkFormatter
					}, {
						name : 'percentage',
						index : 'Percentage',
						width : 60
					}, {
						name : 'capping',
						index : 'capping',
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
					sortname : 'level',
					viewrecords : true,
					sortorder : "desc",
					caption : "Commission Structure",
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
		var value = '<a href="'+webContextPath+'/admin/job/find/'+ rowObject.id +'">'+ cellvalue +'</a>';
	   return value;
	}
</script>
</head>
<body>

<div id="commissionListDiv">
 <h4 style="padding: 5px">Home | Configuration | Network Configuration | Commission Structure </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
</div>
</body>
</html>