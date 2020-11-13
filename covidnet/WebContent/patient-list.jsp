<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Lista de Pacientes</title>
	   	<style><%@include file="assets/css/header.css"%></style>
   	<style><%@include file="assets/css/footer.css"%></style>
   	   	<style><%@include file="assets/css/global.css"%></style>
   	    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, user-scalable=no"
    />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<!-- Header -->
    <site-header></site-header>

		<h1>Lista de Pacientes</h1>
        <h2>
        	<a href="new-patient">Adicionar novo paciente</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-patient">Listar todos os pacientes</a>
        	
        </h2>
<section id="form-section">
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Cpf</th>
            </tr>
            <c:forEach var="patient" items="${listPatient}">
                <tr>
                    <td><c:out value="${patient.id}" /></td>
                    <td><c:out value="${patient.nome}" /></td>
                    <td><c:out value="${patient.email}" /></td>
                    <td><c:out value="${patient.cpf}" /></td>
                    <td>
                    	<a href="edit-patient?id=<c:out value='${patient.id}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete-patient?id=<c:out value='${patient.id}' />">Remover</a>                    	
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
