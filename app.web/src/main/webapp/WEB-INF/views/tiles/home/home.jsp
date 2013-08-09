<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
<head>
<spring:url value="/resources/css/jquery.jqplot.min.css" var="resourceJqplotCssUrl"/>

<spring:url value="/resources/js/jqplot.barRenderer.min.js" var="barRendererUrl"/>
<spring:url value="/resources/js/jqplot.categoryAxisRenderer.min.js" var="categoryAxisRendererUrl"/>
<spring:url value="/resources/js/jqplot.pointLabels.min.js" var="pointLabelsUrl"/>
<spring:url value="/resources/js/jquery.jqplot.min.js" var="jqplotUrl"/>

<link href="${resourceJqplotCssUrl}" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${jqplotUrl}"></script>
<script type="text/javascript" src="${barRendererUrl}"></script>
<script type="text/javascript" src="${categoryAxisRendererUrl}"></script>
<script type="text/javascript" src="${pointLabelsUrl}"></script>

<script type="text/javascript">

	$().ready(function() {

		var jsonurl = webContextPath + "/rest/webHomeData";
		var homePageData = populateDataForHomeScreen(jsonurl);
		drawGraph(homePageData.chartData);
	});

	function populateDataForHomeScreen(url) {
		var ret = null;
		$.ajax({
			// have to use synchronous here, else the function 
			// will return before the data is fetched
			async : false,
			url : url,
			success : function(data) {
				ret = data;
			}
		});
		return ret;
	}
	function drawGraph(input) {
		$.jqplot.config.enablePlugins = true;
		var ticks = [ 'Field1', 'Field2', 'Field3',
				'Field4' ];
		plot1 = $.jqplot('chartdiv', [ input ], {
			// Only animate if we're not using excanvas (not in IE 7 or IE 8)..
			title : "Analysis Chart",
			seriesDefaults : {
				renderer : $.jqplot.BarRenderer,
				pointLabels : {
					show : true
				}
			},
			axes : {
				xaxis : {
					renderer : $.jqplot.CategoryAxisRenderer,
					ticks : ticks
				}
			},
			seriesColors : [ "#FF9D19" ],
			highlighter : {
				show : false
			}
		});

	}
</script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div style="height: 700px;">
	<div id="chartdiv" style="height:200px;width:600px; margin-left:130px;">
	</div>
	</div>
</body>
</html>
