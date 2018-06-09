package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CadastrarCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            
                Participante p = new Participante();
                p.setEmail(request.getParameter("txtemail"));
                p.setNome(request.getParameter("txtnome"));
                p.setSenha(request.getParameter("txtsenha"));
                ParticipanteDao.getInstace().addParticipante(p);
                response.sendRedirect("index.html");
          
        }

    }

}
