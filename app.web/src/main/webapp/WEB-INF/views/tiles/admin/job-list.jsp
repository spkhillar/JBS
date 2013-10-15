<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../tiles/base/app.jsp" />
<script type='text/javascript'>

	$(function() {
		var actionUrl = webContextPath + "/admin/job/records";
		$("#grid").jqGrid(
				{
					url : actionUrl,
					datatype : 'json',
					mtype : 'GET',
					colNames : [ 'Id', 'Job Title', 'Job Type', 'Job Code',
							'Posted At', "Functional Area", "Company Name", "Desgination", "Category","Sub Category" ],
					colModel : [ {
						name : 'id',
						index : 'id',
						width : 55,
						hidden : true
					}, {
						name : 'jobTitle',
						index : 'jobTitle',
						width : 200,
						formatter:myHyperLinkFormatter
					}, {
						name : 'jobType',
						index : 'jobType',
						width : 100
					}, {
						name : 'jobCode',
						index : 'jobCode',
						width : 100
					}, {
						name : 'postedAt',
						index : 'postedAt',
						width : 150
					}, {
						name : 'industry',
						index : 'industry',
						width : 250
					}, {
						name : 'companyName',
						index : 'companyName',
						width : 100
					}, {
						name : 'designation',
						index : 'designation',
						width : 100
					}, {
						name : 'category',
						index : 'category',
						width : 100,
					}, {
						name : 'subCategory',
						index : 'subCategory',
						width : 100,
					} ],
					postData : {},
					rowNum : 20,
					rowList : [ 20, 30, 40],
					height : 400,
					width :1070,
					rownumbers : true,
					pager : '#pager',
					sortname : 'postedAt',
					viewrecords : true,
					sortorder : "desc",
					caption : "Jobs",
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

<div id="jobListDiv">
 <h4 style="padding: 5px">Home | Jobs | View Jobs </h4><br/><br/>
 <hr color="red"/>
	<div id='jqgrid'>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
</div>
</body>
</html>