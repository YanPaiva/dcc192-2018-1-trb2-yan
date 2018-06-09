<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<h1>O melhor amigo Oculto do ano</h1>

<form method="Post" action="novoEvento.html">
    <label>Código:</label><input type="text" name="codigo" value="" size="50" />
    <label>Titulo:</label><input type="text" name="titulo" value="" size="50" />
    <label>Valor mínimo:</label><input type="number" min="0" name="minimo" value="" size="50" />
    <label>Data do Sorteio:</label><input type="date" name="dataEvento" value="" size="50" />
    <label>Data do Evento:</label><input type="date" name="dataSorteio" value="" size="50" />
    <input type="submit" value="Criar Evento"/>
</form>   

<%@include file="jspf/rodape.jspf" %>
