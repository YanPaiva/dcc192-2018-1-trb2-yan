<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>Por favor coloque novamente sua senha!</p>
<h2>use somente letras maiusculas nos campos de cadastro e login</h2>
<form method="Post" action="item-editar.html">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>E-mail: </h4></td>
                <td><input type="text" name="txtlogin" value="<%=request.getParameter("email")%>" size="50" readonly="readonly"  /></td>
            </tr>
            <tr>

                <td><h4>Senha: </h4></td>
                <td><input type="password" name="txtsenha" value="" size="50" pattern="[A-Z0-9\s]+$"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Entrar"/></td>
                </form>
            </tr>        
        </tbody>

    </table>

    <%@include file="jspf/rodape.jspf" %>
