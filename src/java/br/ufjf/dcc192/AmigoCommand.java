package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class AmigoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            request.setAttribute("idUser", request.getParameter("idUser"));
            Participante p = ParticipanteDao.getInstace().getParticipante(Integer.parseInt(request.getParameter("idUser")));
            p = ParticipanteDao.getInstace().getParticipante(p.getSorteado().getId());
            request.setAttribute("amigo", p.getNome());
            
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/amigo.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                dispachante.forward(request, response);
         
        }

    }

}
