<%@page import="br.ufjf.dcc192.Participante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<table>
    <th>codigo do evento</th>
    <th>titulo do evento</th>
    <th>preço minimo do evento</th>
    <th>data do evento</th>
    <th>data do sorteio</th>
        <c:forEach var="evento" items="${eventos}">
        <tr>
            <td>${evento.getId()}</td>
            <td>${evento.getTitulo()}</td>
            <td>${evento.getMinimo()}</td>
            <td>${evento.getDataAtual()}</td>
            <td>${evento.getDataEvento()}</td>
            <c:if test="${usuario.getAmigoOculto()==null}">
            <td>
                <form method="post" action="inscrição.html">
                    <input type="hidden" name="id" value="${evento.getId()}">
                    <input type="submit" value="PARTICIPAR"/>
                </form>            
            </td>
            </c:if>
        </tr>
    </c:forEach>
</table>




<%@include file="jspf/rodape.jspf" %>
