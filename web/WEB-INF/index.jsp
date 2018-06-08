<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<p>Bem vindo</p>
<form method="Post" action="bemvindo.html">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>E-mail: </h4></td>
                <td><input type="text" name="txtlogin" value="" size="50" /></td>
            </tr>
            <tr>
                <td><h4>Senha: </h4></td>
                <td><input type="password" name="txtsenha" value="" size="50"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Entrar"/></td>
                    </form>
                   <form method="post" action="cadastrar.html">
                        <td><input type="submit" value="Cadastrar"/></a></td>
                   </form>
                   </tr>        
        </tbody>
        
    </table>

<%@include file="jspf/rodape.jspf" %>
