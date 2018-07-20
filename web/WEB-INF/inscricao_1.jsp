<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<table>
    <th>Id</th>
    <th>Nome</th>
    <c:forEach var="user" items="${usuarios}">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getNome()}</td>
            <td>
                <form method="post" action="inscricao.html?id=${id}">
                 <input type="hidden" name="idUsuario" value="${user.getId()}">
                 <input type="hidden" name="idUser" value="${idUser}">
                 <input type="submit" value="Adicionar ao evento"/>
                
            </form>
        </td>
    </tr>
</c:forEach>
</table>
</div>
    



<%@include file="jspf/rodape.jspf" %>
