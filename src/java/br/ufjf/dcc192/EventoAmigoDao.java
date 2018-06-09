package br.ufjf.dcc192;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoAmigoDao {

    private static EventoAmigoDao instancia;
    private static Connection conexao;

    public static EventoAmigoDao getInstace() {
        if (instancia == null) {
            instancia = new EventoAmigoDao();
        }
        return instancia;
    }

    public EventoAmigoDao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-1",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoAmigoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Participante> listDisponiveis() {

        List<Participante> todosAmigos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from AMIGO where id not in (select idamigo from amigoEvento)");
            while (resultado.next()) {
                Participante amigos = new Participante();
                amigos.setNome(resultado.getString("nome"));
                amigos.setId(resultado.getInt("id"));
                todosAmigos.add(amigos);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todosAmigos;

    }

    public List<Participante> listParticipantes(String idevento) {

        List<Participante> todosAmigos = new ArrayList<>();
        try {
            Participante p;
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from AMIGoevento inner join amigo on id = idamigo where idevento = '" + idevento + " '");
            while (resultado.next()) {
                Participante amigos = new Participante();
                amigos.setNome(resultado.getString("nome"));
                amigos.setId(resultado.getInt("id"));
                Evento e = new Evento();
                e.setId(idevento);
                amigos.setAmigoOculto(e);
                if (null != resultado.getString("amigoselecionado")) {
                    p = new Participante();
                    ResultSet resultado2 = comando.executeQuery("Select * from amigo where id=" + resultado.getInt("AMIGOSELECIONADO"));
                    if (resultado2.next()) {
                        p.setNome(resultado2.getString("nome"));
                        p.setId(resultado2.getInt("id"));
                        amigos.setSorteado(p);
                    }
                }
                todosAmigos.add(amigos);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todosAmigos;

    }

    void delete(String id) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Evento WHERE Codigo=%S",
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoAmigoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addEvento(String codigo, int id) {
        try {
            Statement comando = conexao.createStatement();

            comando.executeUpdate("INSERT INTO AMIGOEVENTO(IDEVENTO,IDAMIGO) VALUES('" + codigo + "'," + id + ")");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoAmigoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
