<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var lastsel="";
		var actionUrl = webContextPath + "/systemconfiguration/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Key', 'Value'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'key',
						index : 'key',
						width : 60
					}, {
						name : 'value',
						index : 'value',
						editable: true,
						editrules : {
							required : true
						},
						width : 60
					}
								],
					postData : {},
					rowNum : 20,
					rowList : [ 20, 30, 40,30 ],
					height : 200,
					width : 1050,
					rownumbers : true,
					pager : '#pager',
					sortname : 'key',
					viewrecords : true,
					sortorder : "asc",
					caption : "System Configuration",
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
					},
					onSelectRow: function(id){
						console.log(lastsel,'...done...',id);
						if(id && id!==lastsel){
							console.log('...inside...');
							$('#grid').jqGrid('restoreRow',lastsel);
							$('#grid').jqGrid('editRow',id,true);
							lastsel=id;
						}
					},
					editurl: webContextPath + "/systemconfiguration/update"
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

<div id="systemConfigDiv">
 <h4 style="padding: 5px">Home | Configuration | System Configuration</h4><br/>
 <hr color="red"/>
		<table id='grid' align="center"></table>
		<div id='pager'></div>
	</div>
</body>
</html>