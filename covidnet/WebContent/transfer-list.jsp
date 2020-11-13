<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerência de Solicitações</title>
   	<style><%@include file="assets/css/header.css"%></style>
   	<style><%@include file="assets/css/footer.css"%></style>
 	<style><%@include file="assets/css/global.css"%></style>
 	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<!-- Header -->
    <site-header></site-header>
	<center>
		<h1>Gerência de Solicitações</h1>
        <h2>
        	<a href="new-transfer">Solicitar nova transferência</a>
        	&nbsp;&nbsp;&nbsp;
        </h2>
    <center>
    
	<section id="form-section">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de solicitações</h2></caption>
            <tr>
                <th>ID</th>
                <th>ID Paciente</th>
                <th>ID local de origem</th>
                <th>ID local de destino</th>
          
            </tr>
            <c:forEach var="transfer" items="${listTransfer}">
                <tr>
                    <td><c:out value="${transfer.id}" /></td>
                    <td><c:out value="${transfer.id_paciente}" /></td>
                    <td><c:out value="${transfer.id_local_origem}" /></td>
                    <td>
                    <c:if test="${transfer.id_local_destino == 0}">
                    	Indeterminado
                    </c:if>
                    <c:if test="${transfer.id_local_destino != 0}">
                    	<c:out value="${transfer.id_local_destino}" />
                    </c:if>
                    	
                    </td>
                    
                    <td>
                    	<a href="edit-transfer?id=<c:out value='${transfer.id}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete-transfer?id=<c:out value='${transfer.id}' />">Remover</a>                    	
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
