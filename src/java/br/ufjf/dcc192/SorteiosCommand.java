package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class SorteiosCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/sorteios.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                request.setAttribute("eventos", EventoDao.getInstace().listAll());
                request.setAttribute("usuario", request.getParameter("usuario"));
                dispachante.forward(request, response);
         
        }

    }

}
