<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/style.css">
<div>
<h2>use somente letras maiusculas nos campos de cadastro e login</h2>
<form method="Post" action="cadastrar.html">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>E-mail: </h4></td>
                <td><input type="text" name="txtemail" value="" size="50" pattern="[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$" /></td>
            </tr>
            <tr>
                <td><h4>nome: </h4></td>
                <td><input type="text" name="txtnome" value="" size="50" pattern="[A-Z\s]+$"/></td>
            </tr>
            
            <tr>
                <td><h4>Senha: </h4></td>
                <td><input type="password" name="txtsenha" value="" size="50" pattern="[A-Z0-9\s]+$"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Cadastrar" name="btncadastrar" /></td>
                    <td><input type="submit" value="cancelar" name="btncancelar"/></td>
            </tr>        
        </tbody>
        
    </table>

</form>
</div>