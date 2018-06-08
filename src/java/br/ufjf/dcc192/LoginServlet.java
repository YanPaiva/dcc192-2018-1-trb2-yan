/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YanNotebook
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/index.html", "/bemvindo.html",
    "/cadastrar.html", "/informarsenha.html", "/sorteios.html","/novoEvento.html",
    "/adicionarNovoEvento.html", "/cadastroRealizado.html"
})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.IndexCommand");
        rotas.put("/bemvindo.html", "br.ufjf.dcc192.BemVindoCommand");
        rotas.put("/cadastrar.html", "br.ufjf.dcc192.CadastrarCommand");
        rotas.put("/informarsenha.html", "br.ufjf.dcc192.InformarsenhaCommand");
        rotas.put("/sorteios.html", "br.ufjf.dcc192.SorteiosCommand");
        rotas.put("/novoEvento.html", "br.ufjf.dcc192.NovoEventoCommand");
       
    
        String clazzName = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/bemvindo.html", "br.ufjf.dcc192.BemVindoCommand");
        rotas.put("/cadastrar.html", "br.ufjf.dcc192.CadastrarCommand");
        rotas.put("/informarsenha.html", "br.ufjf.dcc192.BemVindoCommand");
        rotas.put("/adicionarNovoEvento.html", "br.ufjf.dcc192.NovoEventoCommand");
        rotas.put("/cadastroRealizado.html", "br.ufjf.dcc192.CadastrarCommand");
        
    
        String clazzName = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
