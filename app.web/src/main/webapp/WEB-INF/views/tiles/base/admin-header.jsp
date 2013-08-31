<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="app.jsp"></jsp:include>
<head>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<spring:url value="/" var="homeUrl" htmlEscape="true"/>
<spring:url value="/resources/css/adminhome.css" var="resourceAdminHomeCssUrl"/>
<spring:url value="/resources/css/admindesign.css" var="resourceAdminDesignCssUrl"/>
<spring:url value="/resources/css/menu.css" var="resourceMenuCssUrl"/>

<spring:url value="/resources/js/menuinfo.js" var="resourceMenuInfoUrl"/>

<script type="text/javascript" src="${resourceMenuInfoUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceMenuCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceAdminHomeCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceAdminDesignCssUrl}"/>
</head>
<body>


<table id="menutab" align="center" width="80%">
<tr>
  <td >&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td class="logoheader">&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td class="logoheader">&nbsp;</td>
</tr>
<tr>
  <td width="84%" ><img name="" src="/resources/images/JBS_LOGO.png" width="150" height="30" alt="" /></td>
  <td width="1%">&nbsp;</td>
  <td width="2%">&nbsp;</td>
  <td width="6%" class="logoheader"><img name="" src="resources/images/messages-icon.png" width="30" height="30" alt="" /><br />
    Messages</td>
  <td width="1%">&nbsp;</td>
  <td width="1%">&nbsp;</td>
  <td width="1%">&nbsp;</td>
  <td width="4%" class="logoheader"><img name="" src="resources/images/logout.jpg" width="30" height="30" alt="" /><br />
     <a href="${contextPath}/j_spring_security_logout">Log Out</a> </td>
</tr>

<tr>
<td height="132" colspan="8" align="center">
  <div class="wrap" align="center">
    
    <nav>
      <ul class="menu">
      <li>
       <a class="fNiv" href="${homeUrl}">Home</a>
      </li>
        <li>
          <a class="fNiv">Configuration</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="configlink1">Network Configuration</a> </li>
            <li><a class="configlink2">System Configuration</a></li>
            </ul>
          </li>
        
        <li>
          <a class="fNiv">Manage Notification</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="notifylink1">Approval Notification</a> </li>
            <li>
              <a class="notifylink2">Redeem Notification</a> </li>
            <li></li>
            </ul>
          </li>
        
        <li>
          <a class="fNiv">Genealogy</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="treelink1">Users</a>
              
              </li>
            <li>
              <a class="treelink2">MLM</a></li>
            <li><a class="treelink3">Premium Users</a></li>
            
            </ul>
          </li>
        
        <li>
          <a class="fNiv" id="paymentlink">Payment</a> </li>
        
        <li>
          <a class="fNiv">Account</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="accountlink1">Credits or Payments</a> </li>
            <li><a class="accountlink2">Incentives</a></li>
            <li><a class="accountlink3">Premium Deposit</a></li>
            <li></li>
            </ul>
          </li>
        
        <li><a class="fNiv">Jobs</a>
          <ul>
            <li class="arrow"></li>
            <li><a id="joblink" href="${contextPath}/admin/job/new">Add Job</a> </li>
            <li><a id="editjoblink">Edit Job</a></li>
            <li><a>Delete Job</a></li>
            </ul>
          </li>
        
        <li> <a class="fNiv" id="adlink">Ad Management</a> </li>
        <li> <a class="fNiv">Support Center</a> 
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="supportlink1">Email</a> </li>
            <li><a class="supportlink2">SMS</a></li>
            <li><a class="supportlink3">Enquiry</a></li>
            <li><a class="supportlink4">Complaints</a></li>
            <li><a class="supportlink5">Tickets</a></li>
            </ul>
          </li>
        </ul>
      <div class="clearfix"></div>
      </nav>
    </div>
</td>
    <td></td>
    
    </tr>
    </table>
<br />
</body>
</html>