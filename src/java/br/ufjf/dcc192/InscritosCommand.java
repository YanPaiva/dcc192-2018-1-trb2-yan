package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class InscritosCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
               
               request.setAttribute("idUser", request.getParameter("idUser"));
               request.setAttribute("id", request.getParameter("id"));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/inscritos.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                List<Participante> p =  EventoAmigoDao.getInstace().listParticipantes(request.getParameter("id"));
                Evento e = p.get(0).getAmigoOculto();
                if(p.get(0).getSorteado() == null){
                    e.sorteia();
                }
                p = EventoAmigoDao.getInstace().listParticipantes(request.getParameter("id"));
                
                request.setAttribute("usuarios", p);
                dispachante.forward(request, response);

          
    }

}
}