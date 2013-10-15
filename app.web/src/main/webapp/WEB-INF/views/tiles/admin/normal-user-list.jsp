<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/user/normal";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id','Username','Created On','First Name', 'Last Name','Email','Phone','Date of Birth','City','State','Pin'],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					},{
						name : 'userName',
						index : 'userName',
						width : 60,
						
					},{
						name : 'createdAt',
						index : 'createdAt',
						width : 60,
						
					},{
						name : 'firstName',
						index : 'firstName',
						width : 60,
						
					},{
						name : 'lastName',
						index : 'lastName',
						width : 60
					},{
						name : 'email',
						index : 'email',
						width : 60,
						
					},{
						name : 'phone',
						index : 'phone',
						width : 60,
						
					},{
						name : 'dateOfBirth',
						index : 'dateOfBirth',
						width : 60
					},{
						name : 'address.city',
						index : 'address.city',
						width : 60,
						
					},{
						name : 'address.state',
						index : 'address.state',
						width : 60,
						
					}, {
						name : 'address.pin',
						index : 'address.pin',
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
					sortname : 'createdAt',
					viewrecords : true,
					sortorder : "desc",
					caption : "Users",
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
 <h4 style="padding: 5px">Home | Users | Resellers </h4><br/>
 <hr color="red"/>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>

</html>