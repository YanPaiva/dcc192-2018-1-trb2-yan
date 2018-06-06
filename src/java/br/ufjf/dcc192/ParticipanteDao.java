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

public class ParticipanteDao {

    private static ParticipanteDao instancia;
    private static Connection conexao;

    public static ParticipanteDao getInstace() {
        if (instancia == null) {
            instancia = new ParticipanteDao();
        }
        return instancia;
    }

    public ParticipanteDao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-1",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Participante> listAll() {
        List<Participante> todosAmigos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,nome from amigoOculto");
            while (resultado.next()) {
                Participante amigos = new Participante();
                amigos.setNome(resultado.getString("nome"));
                amigos.setId(resultado.getLong("id"));
                todosAmigos.add(amigos);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todosAmigos;

    }

    void create(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO amigo(nome) VALUES('%S')",
                    titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void delete(Long id) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM amigo WHERE id=%d",
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Participante getParticipante(String email, String senha) {
        Participante usuario = new Participante();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(String.format("Select * FROM amigo WHERE email=%s AND senha=%s",
                    email, senha));
            comando.close(); 
            usuario.setNome(resultado.getString("nome"));
            usuario.setId(resultado.getLong("id"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setSenha(resultado.getString("senha"));
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(usuario.getId() != null)
           return usuario;
       return null;
    }

}
