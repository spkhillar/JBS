<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var lastsel="";
		var actionUrl = webContextPath + "/commission/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Level', 'Description','Percentage', 'Capping'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'level',
						index : 'level',
						width : 60,
						editable: true,
						editrules : {
							required : true,
							integer:true
						}
					}, {
						name : 'description',
						index : 'description',
						width : 60,
						editable: true,
						editrules : {
							required : true,
						}
					}, {
						name : 'percentage',
						index : 'Percentage',
						width : 60,
						editable: true,
						editrules : {
							required : true,
							number:true
						}
					}, {
						name : 'cap',
						index : 'cap',
						width : 60,
						editable: true,
						edittype:"select",
							editoptions:{value:"true:true;false:false"}
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
					sortorder : "asc",
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
					},
					onSelectRow: function(id){
						if(id && id!==lastsel){
							$('#grid').jqGrid('restoreRow',lastsel);
							$('#grid').jqGrid('editRow',id,true);
							lastsel=id;
						}
					},
					editurl: webContextPath + "/commission/update"
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

<div id="commissionListDiv">
 <h4 style="padding: 5px">Home | Configuration | Network Configuration | Commission Structure </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
</body>
</html>