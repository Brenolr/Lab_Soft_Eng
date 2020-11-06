<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerência de Solicitações</title>
</head>
<body>
	<center>
		<h1>Gerência de Solicitações</h1>
        <h2>
        	<a href="new-transfer">Solicitar nova transferência</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-transfer">Listar solicitações</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${transfer != null}">
			<form action="update-transfer" method="post">
        </c:if>
        <c:if test="${transfer == null}">
			<form action="insert-transfer" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${transfer != null}">
            			Editar solicitação
            		</c:if>
            		<c:if test="${transfer == null}">
            			Adicionar nova transferência
            		</c:if>
            	</h2>
            </caption>
        	<c:if test="${transfer != null}">
        			<input type="hidden" name="id" value="<c:out value='${transfer.id}' />" />
        	</c:if>    
            <tr>
                <th>ID do paciente </th>
                <td>
                	<c:if test="${transfer == null}">
	                	<select name="id_paciente">
	            			<c:forEach var="paciente" items="${listaPacientes}">
	            				<c:if test="${transfer.id_paciente == paciente.id}">
	            					<option selected value="${paciente.id}">
	            						${paciente.nome}
	            					</option>
	            				</c:if>
	            				<c:if test="${transfer.id_paciente != paciente.id}">
	            					<option value="${paciente.id}">
	            						${paciente.nome}
	            					</option>
	            				</c:if>
	            			</c:forEach>
	        			</select>
					</c:if>
					<c:if test="${transfer != null}">
						<input disabled type="text" name="id_paciente" size="15"
	                			value="<c:out value='${transfer.id_paciente}' />"
	                	/>
					</c:if>
                </td>
            </tr>

            <tr>
                <th>Local de origem </th>
                <td>
                	<c:if test="${transfer == null}">
	                	<select name="id_local_origem">
	            			<c:forEach var="local" items="${listaLocais}">
	            				<c:if test="${transfer.id_local_origem == local.id}">
	            					<option selected value="${local.id}">
	            						${local.nome}
	            					</option>
	            				</c:if>
	            				<c:if test="${transfer.id_local_origem != local.id}">
	            					<option value="${local.id}">
	            						${local.nome}
	            					</option>
	            				</c:if>
	            			</c:forEach>
	        			</select>
					</c:if>
					<c:if test="${transfer != null}">
						<input disabled type="text" name="id_local_origem" size="15"
	                			value="<c:out value='${transfer.id_local_origem}' />"
	                	/>
					</c:if>
    
                </td>
            </tr>
            <tr>
                <th>Local de destino </th>
                <td>
                <c:if test="${transfer == null}">
                	<input disabled type="text" name="id_local_destino" size="15"
                			value="<c:out value='${transfer.id_local_destino}' />"
                	/>
                </c:if>
                 <c:if test="${transfer != null}">
                 	<select name="id_local_destino">
            			<c:forEach var="local" items="${listaLocais}">
            				<c:if test="${transfer.id_local_destino == local.id}">
            					<option selected value="${local.id}">
            						${local.nome}
            					</option>
            				</c:if>
            				<c:if test="${transfer.id_local_destino != local.id}">
            					<option value="${local.id}">
            						${local.nome}
            					</option>
            				</c:if>
            			</c:forEach>
        			</select>
                 </c:if>
                	
                </td>
            </tr>
            <c:if test="${transfer != null}">
	            <tr>
	                <th>Data e hora de criação </th>
	                <td>
	                	<input disabled type="text" name="data_e_hora" size="45"
	                			value="<c:out value='${transfer.data_e_hora}' />"
	                	/>
	                </td>
	            </tr>
	            <tr>
	             	<th>Status </th>
		            <td>
		            	<select name="aberto">
		            		<c:if test="${transfer.isAberto() == true}">
		            			<option selected>Aberto</option>
		            			<option>Fechado</option>
		            		</c:if>
		            		<c:if test="${transfer.isAberto() == false}">
		            			<option >Aberto</option>
		            			<option selected>Fechado</option>
		            		</c:if>
		            	</select>
		            </td>
	            </tr>
            </c:if>
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
