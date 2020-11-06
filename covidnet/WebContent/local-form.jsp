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
		<c:if test="${local != null}">
			<form action="update-local" method="post">
        </c:if>
        <c:if test="${local == null}">
			<form action="insert-local" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${local != null}">
            			Edit Local
            		</c:if>
            		<c:if test="${local == null}">
            			Add New local
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${local != null}">
        			<input type="hidden" name="id" value="<c:out value='${local.id}' />" />
        		</c:if>            
            <tr>
                <th>local Name: </th>
                <td>
                	<input type="text" name="nome" size="45"
                			value="<c:out value='${local.nome}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Local Address: </th>
                <td>
                	<input type="text" name="endereco" size="45"
                			value="<c:out value='${local.endereco}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Available Beds: </th>
                <td>
                	<input type="text" name="camas_disponiveis" size="15"
                			value="<c:out value='${local.camas_disponiveis}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Occupied beds: </th>
                <td>
                	<input type="text" name="camas_ocupadas" size="15"
                			value="<c:out value='${local.camas_ocupadas}' />"
                	/>
                </td>
            </tr>
          
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>