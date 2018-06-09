<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<table>
    <th>Id</th>
    <th>Nome</th>
    <th>Sorteios</th>
    <c:forEach var="user" items="${usuarios}">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getNome()}</td>
            <c:if test="${user.getSorteado() == null}">
                <td>?<td>
            </c:if>
                </td>>
                    <c:if test="${user.getSorteado() != null}">
                <c:if test="${user.getId() == param.idUser}">
             <td><a href="amigo.html" >veja seu amigo oculto </a><td>
                </c:if>
                <c:if test="${user.getId() != param.idUser}">
             <td>???<td>
                </c:if>
            </c:if>       
            
        </tr>
</c:forEach>
</table>



<%@include file="jspf/rodape.jspf" %>
