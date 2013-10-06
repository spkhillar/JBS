<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<link rel="shortcut icon" href="resources/images/favico.png"/>

<spring:url value="/resources/css/common.css" var="resourceCssUrl"/>
<spring:url value="/resources/css/cupertino/jquery-ui-1.10.2.custom.min.css" var="resourceJqUiCssUrl"/>
<spring:url value="/resources/css/ui.jqgrid.css" var="resourceJqGridCssUrl"/>
<spring:url value="/resources/css/menu.css" var="resourceMenuCssUrl"/>
<spring:url value="/resources/css/jquery.jui_dropdown.css" var="resourceJqJuiDropDownCssUrl"/>
<spring:url value="/resources/css/jquery.toastmessage.css" var="resourceJqToastMessageCssUrl"/>
<!-- Index Page CSS -->
<spring:url value="/resources/css/style1.css" var="resourceStyle1CssUrl"/>
<spring:url value="/resources/css/indexpage.css" var="resourceIndexPageCssUrl"/>
<spring:url value="/resources/css/headmenu.css" var="resourceHeadMenuCssUrl"/>

<spring:url value="/resources/css/resellerview.css" var="resourceResellerViewCssUrl"/>
<spring:url value="/resources/css/msgBoxLight.css" var="resourceMessageBoxCssUrl"/>
<spring:url value="/resources/css/roothome.css" var="resourceRootHomeCssUrl"/>


<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJqUrl"/>
<spring:url value="/resources/js/jquery.validate.min.js" var="resourceJqvUrl"/>
<spring:url value="/resources/js/application.js" var="resourceAppJsUrl"/>
<spring:url value="/resources/js/jquery-ui-1.10.2.custom.js" var="resourceJqUiUrl"/>
<spring:url value="/resources/js/grid.locale-en.js" var="resourceJqGridLocaleUrl"/>
<spring:url value="/resources/js/jquery.jqGrid.min.js" var="resourceJqGridUrl"/>
<spring:url value="/resources/js/jquery-ui-timepicker-addon.js" var="dateTimePicKerJs"/>
<spring:url value="/resources/js/sliderAccess.js" var="sliderAccessJS"/>
<spring:url value="/resources/js/jMenu.jquery.js" var="resourceJMenuUrl"/>
<spring:url value="/resources/js/jquery.dropdown.js" var="resourceDropDownJSUrl"/>
<spring:url value="/resources/js/jquery.jui_dropdown.min.js" var="resourceJqJuiDropDownJsUrl"/>
<spring:url value="/resources/js/splitter.js" var="resourceJqSplitterJsUrl"/>
<spring:url value="/resources/js/jquery.msgBox.js" var="resourceJqMessageBoxJsUrl"/>
<spring:url value="/resources/js/jquery.toastmessage.js" var="resourceJqToastMessageJsUrl"/>

<script type="text/javascript" src="${resourceJqUrl}"></script>
<script type="text/javascript" src="${resourceAppJsUrl}"></script>
<script type="text/javascript" src="${resourceJqvUrl}"></script>
<script type="text/javascript" src="${resourceJqUiUrl}"></script>
<script type="text/javascript" src="${resourceJqGridLocaleUrl}"></script>
<script type="text/javascript" src="${resourceJqGridUrl}"></script>
<script type="text/javascript" src="${dateTimePicKerJs}"></script>
<script type="text/javascript" src="${sliderAccessJS}"></script>
<script type="text/javascript" src="${resourceJMenuUrl}"></script>
<script type="text/javascript" src="${resourceJqJuiDropDownJsUrl}"></script>
<script type="text/javascript" src="${resourceJqSplitterJsUrl}"></script>
<script type="text/javascript" src="${resourceJqMessageBoxJsUrl}"></script>
<script type="text/javascript" src="${resourceJqToastMessageJsUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceJqUiCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceJqGridCssUrl}" />
<link rel="stylesheet" type="text/css" href="${resourceHeadMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceIndexPageCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceStyle1CssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceJqJuiDropDownCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceResellerViewCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceMessageBoxCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceRootHomeCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceJqToastMessageCssUrl}"/>

<script type="text/javascript">
webContextPath="${pageContext.request.contextPath}";
</script>
</head>
<body>
</body>
</html>