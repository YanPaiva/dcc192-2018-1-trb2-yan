<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<p>Bem vindo</p>
<form method="POST">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>E-mail: </h4></td>
                <td><input type="text" name="txtemail" value="" size="50" /></td>
            </tr>
            <tr>
                <td><h4>nome: </h4></td>
                <td><input type="text" name="txtnome" value="" size="50" /></td>
            </tr>
            
            <tr>
                <td><h4>Senha: </h4></td>
                <td><input type="password" name="txtsenha" value="" size="50"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Cadastrar" name="btncadastrar" /></td>
                    <td><input type="submit" value="cancelar" name="btncancelar"/></td>
            </tr>        
        </tbody>
        
    </table>

</form>
<%@include file="jspf/rodape.jspf" %>
