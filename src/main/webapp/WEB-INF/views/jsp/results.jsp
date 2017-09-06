<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>Type</th>
                <th>House Number</th>
                <th>Street</th>
                <th>City</th>
                <th>Postal Code</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${banks}" var="bank">
            		<tr>
	                	<td>${bank.type}</td>
	                <td>${bank.address.housenumber}</td>
	                <td>${bank.address.street}</td>
	                <td>${bank.address.city}</td>
	                <td>${bank.address.postalcode}</td>
            		</tr>
            	</c:forEach>
        </tbody>
    </table>
</body>
</html>