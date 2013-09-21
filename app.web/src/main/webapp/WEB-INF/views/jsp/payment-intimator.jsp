<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<jsp:include page="../tiles/base/app.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form:form name="depositIntimator" commandName="depositIntimator" method="POST">
<table border="0" width="80%" style="margin:auto">
  <tr>
    <td scope="col" widtd="48"><strong>Payment Intimator</strong></td>
  </tr>
  <tr>
    <td><table widtd="527" border="0">
      <tr>
        <td width="253" scope="col">Payment Mode</td>
        <td width="375" scope="col"><label for="select"></label>
          <form:select path=""> </form:select></td>
        </tr>
      <tr>
        <td widtd="159">Transaction Date</td>
        <td widtd="25"><label for="textfield"></label>
          <input size=30 type="text" name="textfield" id="textfield" /></td>
      </tr>
      <tr>
        <td>Transaction Amount</td>
        <td><input size=30 type="text" name="textfield2" id="textfield2" /></td>
      </tr>
      <tr>
        <td>Description</td>
        <td><label for="textarea"></label>
          <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><strong>Cash Deposit in Hand</strong></td>
  </tr>
  <tr>
    <td><table widtd="261" border="0">
      <tr>
        <td width="253"> Recevier MLM ID</td>
        <td width="370"><input size=30 type="text" name="textfield3" id="textfield3" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><strong>Cash Deposit in Bank</strong></td>
  </tr>
  <tr>
    <td><table width="644" border="0" widtd="200">
      <tr>
        <td width="253" scope="col">Receipt Copy</td>
        <td width="375" scope="col"><input size=30 type="text" name="textfield9" id="textfield9" /></td>
      </tr>
      <tr>
        <td>Bank Name</td>
        <td><input size=30 type="text" name="textfield4" id="textfield4" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><strong>Details for NEFT/RTGS/Online Transfer</strong></td>
  </tr>
  <tr>
    <td><table width="640" border="0" widtd="200">
      <tr>
        <td width="245">Transaction Number</td>
        <td width="367"><input size=30 type="text" name="textfield5" id="textfield5" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><strong>Details for Cheque Transfer</strong></td>
  </tr>
  <tr>
    <td><table widtd="200" border="0">
      <tr>
        <td width="253">Cheque Number</td>
        <td width="374"><input size=30 type="text" name="textfield6" id="textfield6" /></td>
      </tr>
      <tr>
        <td>Cheque Date</td>
        <td><input size=30 type="text" name="textfield7" id="textfield7" /></td>
      </tr>
      <tr>
        <td>Drawn on bank</td>
        <td><input size=30 type="text" name="textfield8" id="textfield8" /></td>
      </tr>
      <tr>
        <td>Drawn on branch</td>
        <td><input size=30 type="text" name="textfield10" id="textfield10" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form:form>
</body>
</html>