<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Prontuário de paciente</title>
</head>
<body>
	<center>
		<h1>Prontuário de paciente</h1>
        <h2>

        	<a href="list-patient">Listar todos os pacientes</a>
        	
        </h2>
	</center>
    <div align="center">
<%-- 		<c:if test="${patient != null}">
			
        </c:if>
        <c:if test="${patient == null}">
			<form action="insert-patient" method="post">
        </c:if> --%>
        <form action="update-patient" method="post">
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		Editar prontuário de paciente
            		<%-- <c:if test="${patient != null}">
            			Editar paciente
            		</c:if>
            		<c:if test="${patient == null}">
            			Adicionar novo paciente
            		</c:if> --%>
            	</h2>
            </caption>
        		<c:if test="${patient != null}">
        			<input type="hidden" name="id" value="<c:out value='${patient.id}' />" />
        		</c:if>            
            <tr>
                <th>Nome: </th>
                <td>
                	<input type="text" name="nome" size="45"
                			value="<c:out value='${patient.nome}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${patient.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>CPF: </th>
                <td>
                	<input type="text" name="cpf" size="15"
                			value="<c:out value='${patient.cpf}' />"
                	/>
                </td>
            </tr>
            
              <tr>
                <th>Gravidade: </th>
                <td>
                	<input type="text" name="gravidade" size="15"
                			value="<c:out value='${patient.gravidade}' />"
                	/>
                </td>
            </tr>
              <tr>
                <th>Prontuário: </th>
                <td>
                	<input type="text" name="id_prontuario" size="45"
                			value="<c:out value='${patient.id_prontuario}' />"
                	/>
                </td>
            </tr>
            	<tr>
                <th>Local de Atendimento: </th>
                <td>
                	<select name="id_localDeAtendimento">
            			<c:forEach var="local" items="${listaLocais}">
            				<c:if test="${patient.id_localDeAtendimento == local.id}">
            					<option selected value="${local.id}">
            						${local.nome}
            					</option>
            				</c:if>
            				<c:if test="${patient.id_localDeAtendimento != local.id}">
            					<option value="${local.id}">
            						${local.nome}
            					</option>
            				</c:if>
            			</c:forEach>
        			</select>
                	<%-- <input type="text" name="id_localDeAtendimento" size="45"
                			value="<c:out value='${patient.id_localDeAtendimento}' />"
                	/> --%>
                </td>
            </tr>
               <tr>
                <th>Sintomas: </th>
                <td>
                	<input type="text" name="sintomas" size="45"
                			value="<c:out value='${patient.sintomas}' />"
                	/>
                </td>
            </tr>
               <tr>
                <th>Telefone: </th>
                <td>
                	<input type="text" name="telefone" size="45"
                			value="<c:out value='${patient.telefone}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Salvar" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
