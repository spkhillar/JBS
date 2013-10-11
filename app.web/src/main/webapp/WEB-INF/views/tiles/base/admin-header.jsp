<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
<jsp:include page="app.jsp"></jsp:include>
<spring:url value="/" var="homeUrl" htmlEscape="true"/>


<style type="text/css">    
* { margin: 0; padding: 0; }


		
</style>

<script type="text/javascript">
    function ChangeColor(tableRow, highLight)
    {
    if (highLight)
    {
      tableRow.style.backgroundColor = '#dcfac9';
    }
    else
    {
      tableRow.style.backgroundColor = 'white';
    }
  }

  function DoNav(theUrl)
  {
  document.location.href = theUrl;
  }
  </script>
  
 </head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table border="0" id="indextb">
  <tr>
    <th scope="col"></th>
    <th scope="col"></th>
    <td scope="col" colspan="2" class="siteheadercells"> </td>
  </tr>
    <tr>
    <td class="siteheadercells"><div id="site_title"></div></td>
    <td class="siteheadercells"><div id="site_title1"></div></td>
     <td class="siteheadercells"><div id="site_title2"></div></td>
    <td ><jsp:include page="admin-settings.jsp"></jsp:include>
 
</td>
  </tr>
 <tr>
    <td height="27" colspan="4" class="menutd">
    <div class="wrap1">
    <table id="submenu">
      <tr>
      <td>
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
              <a class="configlink1" href="${contextPath}/commission/list">Network Configuration</a> 
             </li>
            <li><a class="configlink2" href="${contextPath}/systemconfiguration/view">System Configuration</a></li>
             <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
            	<li><a class="configlink2" href="${contextPath}/admin/register/admin">Create System Admin</a></li>
            </sec:authorize>
            </ul>
          </li>
        
        <li>
          <a class="fNiv" >Manage Notification</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="notifylink1" href="${contextPath}/admin/view/deposit">Approval Notification</a> </li>
            <li>
              <a class="notifylink2" href="${contextPath}/admin/view/redeem">Redeem Notification</a> </li>
            <li></li>
            </ul>
          </li>
        
       <!--  <li>
          <a class="fNiv">Genealogy</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="treelink1">Users</a>
              
              </li>
            <li>
              <a class="treelink2" href="${contextPath}/admin/view/reseller">MLM</a></li>
            <li>
            	<a class="treelink3">Premium Users</a>
            </li>
            
            </ul>
          </li>
        -->
        <li>
          <a class="fNiv" id="paymentlink" href="${contextPath}/admin/view/payment">Payment</a> </li>
        
        <li>
          <a class="fNiv">Account</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="accountlink1" >Credits or Payments</a> 
            </li>
            <li>
            	<a class="accountlink2" href="${contextPath}/accounts/view/creditpoints">Incentives</a>
            </li>
            <li>
            	<a class="accountlink3">Premium Deposit</a>
            </li>
            <li></li>
            </ul>
          </li>
         
        <li><a class="fNiv">Jobs</a>
          <ul>
            <li class="arrow"></li>
            <li><a id="joblink" href="${contextPath}/admin/job/new">Add Job</a> </li>
            <li><a id="viewjoblink" href="${contextPath}/admin/job/list">View Jobs</a></li>
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
      <div class="wrap1"></div>
      </nav>
    </td></tr></table>
    </div>
    </td>
    </tr>
    </table>
    
</body>
</html>