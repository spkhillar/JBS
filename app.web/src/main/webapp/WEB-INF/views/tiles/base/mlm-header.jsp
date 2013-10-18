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

html { height: 100%; font-size: 62.5% }

body { height: 100%; background-color: #FFFFFF; font: 1.2em Verdana, Arial, Helvetica, sans-serif; }


#indextb tr td #jobtb tr .joblist form fieldset label {
	text-align: left;
}
#indextb tr td #infotb .footer td img {
	text-align: center;
}
#indextb tr td table {
	text-align: center;
}
		
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
    <div id="menu1">
      <ul id="menu">
      <li>
       <a class="fNiv" href="${homeUrl}">Home</a>
      </li>
        <li>
          <a class="fNiv">Incentive</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="configlink1" href="${contextPath}/reseller/view/creditpoints">Current </a> 
             </li>
            <li><a class="configlink2" href="${contextPath}/reseller/view/redeem">Reedem History</a></li>
           </ul>
          </li>
        
        <li>
           <a class="fNiv">Payment Intimator</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="configlink1" href="${contextPath}/reseller/paymentintimator">Create</a> 
             </li>
            <li><a class="configlink2" href="${contextPath}/reseller/deposits">View Deposits</a></li>
           </ul>
        </li>
        
       	 <li>
           <a class="fNiv">Push Balance</a>
          <ul>
            <li class="arrow"></li>
            <li>
              <a class="configlink1" href="${contextPath}/reseller/credit/transfer">Initiate Fund Transfer</a> 
             </li>
            <li><a class="configlink2" href="${contextPath}/reseller/credit/transfer/list">Fund Transfer History</a></li>
           </ul>
          </li>
        
        <li>
          <a class="fNiv" id="paymentlink">Add Reseller</a>  
          	 <c:if test="${creditPointCount eq '2'}">
	              <ul>
	              <li>
	              	 <a class="fNiv" href="${contextPath}/reseller/register/mlm">Reseller 1</a>
	              </li>
	              <li>
	              	 <a class="fNiv" href="${contextPath}/reseller/register/mlm">Reseller 2</a>
	              </li>
	              </ul>
	         </c:if>
	         <c:if test="${creditPointCount eq '1'}">
	              <ul>
	              <li>
	              	 <a class="fNiv" href="${contextPath}/reseller/register/mlm">Reseller</a>
	              </li>
	              </ul>
	         </c:if>
          </li>
	            
        <li>
          <a class="fNiv">Genealogy</a>
          </li>
        </ul>
    </div>
    </td>
    </tr>
    <tr>
    <td colspan="4">
    	<div style="text-align: right">
    	<ul>
    	  <li><b>Reseller ID:</b><span class="texture"><c:out value="${webUser.mlmId}"></c:out></span> |
    	  <b>Deposit Balance:</b><span class="texture"><c:out value="${webUser.currentBalance}"></c:out></span> |
    	  <b>Commission Balance:</b><span class="texture"><c:out value="${webUser.currentComissionBalance}"></c:out></span>
    	  </li>
    	 </ul> 
    	</div>
    </td>
    </tr>
    </table>
    
</body>
</html>