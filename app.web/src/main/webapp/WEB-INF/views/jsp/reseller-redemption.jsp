<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../tiles/base/app.jsp" />
<title>Insert title here</title>
</head>
<body>
 <table>
   <tr>
    <td>Total Points</td>
    <td><c:out value="${userTotalPoints}"></c:out> </td>
   </tr>
   <tr>
    <td>Points to Redeem</td>
    <td><input type="text"></td>
   </tr>
   <tr>
    <td>Mode of Redemption</td>
    <td><input type="text"></td>
   </tr>
   <tr>
    <td>Redemption Details</td>
    <td><textarea rows="5" cols="30"></textarea></td>
   </tr>
 </table>
</body>
</html>