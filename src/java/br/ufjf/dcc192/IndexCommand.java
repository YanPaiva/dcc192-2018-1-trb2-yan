package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class IndexCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Participante logando = new Participante();
            logando = ParticipanteDao.getInstace().
                    getParticipante(request.getParameter("txtlogin"),
                            request.getParameter("txtsenha"));
            if (logando != null) {
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/bemVindo.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                request.setAttribute("usuario", logando);
                dispachante.forward(request, response);
            }else{
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                dispachante.forward(request, response);
            }

        }

    }

}
