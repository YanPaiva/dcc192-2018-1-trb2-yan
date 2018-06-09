<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<table>
    <th>Id</th>
    <th>Nome</th>
    <th>Sorteios</th>
    <c:forEach var="usuario" items="${usuarios}">
        <tr>
            <td>${usuario.getId()}</td>
            <td>${usuario.getNome()}</td>
            <c:if test="${usuario.getSorteado() == null}">
                <td>?<td>
            </c:if>
             <c:if test="${usuario.getSorteado() != null}">
             <td><a href="amigo.html" >veja seu amigo oculto </a><td>
            </c:if>       
            
        </tr>
</c:forEach>
</table>
    



<%@include file="jspf/rodape.jspf" %>
