<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Local Management Application</title>
</head>
<body>
	<center>
		<h1>Local Management</h1>
        <h2>
        	<a href="new-local">Add New Local</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-local">List All Locals</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Locals</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Available Beds</th>
                <th>Occupied Beds</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="local" items="${listLocal}">
                <tr>
                    <td><c:out value="${local.id}" /></td>
                    <td><c:out value="${local.nome}" /></td>
                    <td><c:out value="${local.endereco}" /></td>
                    <td><c:out value="${local.camas_disponiveis}" /></td>
                    <td><c:out value="${local.camas_ocupadas}" /></td>
                    <td>
                    	<a href="edit-local?id=<c:out value='${local.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete-local?id=<c:out value='${local.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>