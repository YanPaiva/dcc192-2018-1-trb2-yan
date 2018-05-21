package br.ufjf.dcc192;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AmigoDAO {

    private static AmigoDAO instancia;
    private static Connection conexao;

    public static AmigoDAO getInstace() {
        if (instancia == null) {
            instancia = new AmigoDAO();
        }
        return instancia;
    }

    public AmigoDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-1"
                                , "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Amigo> listAll() {
        List<Amigo> todosAmigos = new ArrayList<>();
        try {
            Statement comando =  conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,nome from amigoOculto");
            while(resultado.next()){
                Amigo amigos = new Amigo();
                amigos.setNome(resultado.getString("nome"));
                amigos.setId(resultado.getLong("id"));
                todosAmigos.add(amigos);
                
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return todosAmigos;

    }

    void create(String titulo) {
        try{
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO amigo(nome) VALUES('%S')", 
                    titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void delete(Long id) {
        try{
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM amigo WHERE id=%d", 
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
