<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Local Management Application</title>
	<style><%@include file="assets/css/header.css"%></style>
   	<style><%@include file="assets/css/footer.css"%></style>
	<style><%@include file="assets/css/global.css"%></style>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<!-- Header -->
    <site-header></site-header>

		<h1>Local Management</h1>
        <h2>
        	<a href="new-local">Add New Local</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-local">List All Locals</a>
        	
        </h2>
<section id="form-section">
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
        </section>
        <site-footer></site-footer>
    <script><%@include file="js/footer.js"%></script>
    <script><%@include file="js/header.js"%></script>
</body>
</html>