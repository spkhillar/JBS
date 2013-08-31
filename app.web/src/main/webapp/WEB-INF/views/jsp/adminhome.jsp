<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>JOBSbySMS-Administration</title>
<spring:url value="/resources/css/adminhome.css" var="resourceAdminHomeCssUrl"/>
<spring:url value="/resources/css/admindesign.css" var="resourceAdminDesignCssUrl"/>

<spring:url value="/resources/js/jquery-1.9.1.min.js" var="resourceJqUrl"/>
<spring:url value="/resources/js/jquery-ui-1.10.2.custom.js" var="resourceUserInterfaceUrl"/>
<spring:url value="/resources/js/jMenu.jquery.js" var="resourceJMenuUrl"/>
<spring:url value="/resources/js/menuinfo.js" var="resourceMenuInfoUrl"/>

<script type="text/javascript" src="${resourceJqUrl}"></script>
<script type="text/javascript" src="${resourceUserInterfaceUrl}"></script>
<script type="text/javascript" src="${resourceJMenuUrl}"></script>
<script type="text/javascript" src="${resourceMenuInfoUrl}"></script>

<link rel="stylesheet" type="text/css" href="${resourceAdminHomeCssUrl}"/>
<link rel="stylesheet" type="text/css" href="${resourceAdminDesignCssUrl}"/>

</head>

<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
  <td width="84%" ><img name="" src="resources/images/JBS_LOGO.png" width="150" height="30" alt="" /></td>
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
            <li><a id="joblink">Add Job</a> </li>
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
<div id="">
<table id="menupreferencetb">
<tr>
<td></td>
<td></td>
<td></td>
</tr>
</table>
</div>
<div id="menuinfotb">
<table id="netconfig_tb" border="0" hidden="true">
<tr>
<td height="288" ><p>Network Configuration</p>
  <table width="80%" height="191"  border="0" id="commissioninfotb" align="center" class="inner-tb">
    <tr>
      <td height="21" colspan="8" class="mlmheading">Commission Setup</td>
      </tr>
    <tr bgcolor="#003366">
      <td width="221" height="19">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td width="126">&nbsp;</td>
    </tr>
    <tr>
      <td height="22">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="22">Commission Level</td>
      <td colspan="6"><label for="textfield13"></label>
        <input type="text" name="textfield13" id="textfield13" /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">Commisssion Percentage</td>
      <td colspan="6"><input type="text" name="textfield14" id="textfield14" /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="45" colspan="8">&nbsp;</td>
    </tr>
  </table>
<td>
</tr>
</table>    
<table id="sysconfig_tb" border="0" hidden="true">
<tr>
<td height="209" ><p>System Configuration</p>
  <table width="80%" height="157"  border="0" id="systemconfigtb" align="center" class="inner-tb">
    <tr>
      <td width="20%" height="21" colspan="3" class="mlmheading">System Configuration Setup</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td width="16%" height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="47">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
<td>
</tr>
</table>  
<table id="approve_tb" border="0" hidden="true">
<tr>
<td height="185" ><p>Approval Notifications</p>
  <table width="80%" height="104"  border="0" id="approvalinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Approval Notifications</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>    
<table id="redeem_tb" border="0" hidden="true">
<tr>
<td height="226" ><p>Redeem Notifications</p>
  <table width="80%" height="162"  border="0" id="redeeminfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Redeem Information</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="51">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>    
<table id="users_tb" border="0" hidden="true">
<tr>
<td height="245" ><p>Users Information</p>
  <table width="80%" height="184"  border="0" id="webuserstb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Total Web Users</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="56">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="15">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p></tr>
</table>    
<table id="mlm_tb" border="0" hidden="true">
<tr>
<td height="320" >Pyramid - MLM
  <table width="80%" height="236"  border="0" id="mlmusertb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Total MLM Users</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="45">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="44">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="27">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="30">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
<td>
</tr>
</table>  
<table id="premiumusers_tb" border="0" hidden="true">
<tr>
<td ><p>Premium Users Information</p>
  <table width="80%" height="412"  border="0" id="premiumuser" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Total Premium Users</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="30">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="31">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>    
<table id="payments_tb" border="0" hidden="true">
<tr>
<td ><p>Payments Information</p>
  <table width="80%" height="355"  border="0" id="paymentsinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Payments Details</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>  
<table id="credit_tb" border="0" hidden="true">
<tr>
<td ><p>Credits & Payments</p>
  <table width="80%" height="355"  border="0" id="creditpaymenttb" align="center" class="inner-tb">
    <tr>
      <td width="19%" height="21" class="mlmheading">Payment Information</td>
      <td width="9%">&nbsp;</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="incentives_tb" border="0" hidden="true">
<tr>
<td ><p>Incentives Information</p>
  <table width="80%" height="355"  border="0" id="incentivesinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Incentives  Information</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="premiumdp_tb" border="0" hidden="true">
<tr>
<td ><p>Premium Deposits Information</p>
  <table width="80%" height="355"  border="0" id="premiumdepositinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Premium Deposits</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>

<table width="427" border="0" id="editjobtb" hidden="true">
<tr bgcolor="#A6C2FF">
<td width="86">Edit Job<td width="1187">
</tr>
<tr>
  <td colspan="2"><table  border="0" id="editjobinfo" class="inner-tb">
    <tr bgcolor="#006699">
      <td width="166">Job Code </td>
      <td width="193">Jobname</td>
      </tr>
    <tr>
      <td>1234</td>
      <td>jfksjfksjfks</td>
      </tr>
    <tr>
      <td>131231</td>
      <td>gjdkgjkdf</td>
      </tr>
    <tr>
      <td>34234</td>
      <td>bkdfjk</td>
      </tr>
  </table></tr>
</table>    
 <table id="ad_tb" border="0" hidden="true">
<tr>
<td ><p>Advertisement Information</p>
  <table width="80%" height="355"  border="0" id="adinfotb" align="center" class="inner-tb">
    <tr>
      <td height="21" colspan="8" bgcolor="#006699" class="mlmheading">Ad Management</td>
      </tr>
    <tr>
      <td width="16%" height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table> 
<table id="email_tb" border="0" hidden="true">
<tr>
<td ><p>Email  Information</p>
  <table width="80%" height="355"  border="0" id="emailinfotb" align="center" class="inner-tb">
    <tr>
      <td height="21" colspan="8" class="mlmheading">Mail Settings</td>
      </tr>
    <tr>
      <td width="16%" height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="sms_tb" border="0" hidden="true">
<tr>
<td ><p>SMS  Information</p>
  <table width="77%" height="212"  border="0" id="smsinfotb" align="center" class="inner-tb">
    <tr>
      <td height="21" colspan="3" class="mlmheading">SMS Information</td>
      <td width="6%">&nbsp;</td>
      <td width="4%">&nbsp;</td>
      <td width="4%">&nbsp;</td>
      <td width="36%">&nbsp;</td>
      <td width="3%">&nbsp;</td>
      <td width="10%">&nbsp;</td>
    </tr>
    <tr>
      <td width="9%" height="20">&nbsp;</td>
      <td width="17%">Select Users</td>
      <td colspan="2"><label for="select4"></label>
        <select name="select4" id="select4">
          <option>Users</option>
          <option>MLM</option>
          <option>Premium Users</option>
        </select></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>Enter Text</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="3" rowspan="2">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td><textarea name="textarea2" id="textarea2" cols="45" rows="5"></textarea></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="29">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>Max Characters (160 characters per SMS)</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="17">&nbsp;</td>
      <td colspan="7">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28">&nbsp;</td>
      <td colspan="7"><label for="textarea2"></label>
        <br /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="9">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="9">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="enquiry_tb" border="0" hidden="true">
<tr>
<td ><p>Enquiry Information</p>
  <table width="80%" height="355"  border="0" id="enquiryinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Enquiry Management</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="complaints_tb" border="0" hidden="true">
<tr>
<td ><p>Complaints Information</p>
  <table width="80%" height="355"  border="0" id="complaintinfotb" align="center">
    <tr>
      <td width="16%" height="21" class="mlmheading">Complaints </td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>   
<table id="tickets_tb" border="0" hidden="true">
<tr>
<td ><p>Issue Tickets Information</p>
  <table width="80%" height="355"  border="0" id="ticketinfotb" align="center" class="inner-tb">
    <tr>
      <td width="16%" height="21" class="mlmheading">Tickets</td>
      <td width="8%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="12%">&nbsp;</td>
      <td width="16%">&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="20">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="33">&nbsp;</td>
      <td colspan="6">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="28" colspan="8">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" colspan="8">&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
<td>
</tr>
</table>
</body>
</html>