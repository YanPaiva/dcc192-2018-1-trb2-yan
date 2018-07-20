<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div>
<form method="Post" action="novoEvento.html">
    <table border="1">
        <tbody>
            <tr>
                <td><label>Código:</label><input type="text" name="codigo" value="" size="50" pattern="[A-Z0-9\s]+$"/>
    </td>
                <td><label>Titulo:</label><input type="text" name="titulo" value="" size="50" pattern="[A-Z0-9\s]+$"/>
    </td>
            </tr>
            <tr>
                <td><label>Valor mínimo:</label><input type="number" min="0" name="minimo" value="" size="50" />
    </td>
                <td><label>Data do Sorteio:</label><input type="date" name="dataEvento" value="" size="50" />
    </td>
            </tr>
            <tr>
                <td><label>Data do Evento:</label><input type="date" name="dataSorteio" value="" size="50" />
    </td>
                <td><input type="submit" value="Criar Evento"/></td>
            </tr>
        </tbody>
    </table>

    
</form>   
</div>

<%@include file="jspf/rodape.jspf" %>
