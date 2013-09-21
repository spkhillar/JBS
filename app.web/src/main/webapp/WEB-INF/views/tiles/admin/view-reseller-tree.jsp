<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../tiles/base/app.jsp"></jsp:include>


<script type="text/javascript">

$(document).ready(function() {
$("#splitterContainer").splitter({
	minAsize:100,
	maxAsize:300,
	splitVertical:true,
	A:$('#leftPane'),
	B:$('#rightPane'),
	slave:$("#rightSplitterContainer"),
	closeableto:0
	});

$("#rightSplitterContainer").splitter({
	splitHorizontal:true,
	A:$('#rightTopPane'),
	B:$('#rightBottomPane'),
	closeableto:100
	});
});
</script>
</head>
<body>
<div id="mainContainer">
 	<div id="splitterContainer">
		<div id="leftPane">
			<p>This pane limited to a range of 100 to 300 pixels wide with the minAsize / maxAsize	properties of the plugin..</p>
			<p>&nbsp;</p>

		</div>
	<!-- #leftPane -->
	<div id="rightPane">
	<div style="height:5%;background:#bac8dc">Toolbar</div>
		<div id="rightSplitterContainer" style="height:95%">
			<div id="rightTopPane">
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
				<p>testing</p>
			</div>
			<!-- #rightTopPane-->
			<div id="rightBottomPane">
				<div>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
					<p>some content</p>
				</div>
			</div>
		</div>
			<!-- #rightBottomPane--></div>
		<!-- #rightSplitterContainer--></div>
	<!-- #rightPane --></div>
<!-- #splitterContainer -->

</body>
</html>