package br.ufjf.dcc192;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class InscricaoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
                request.setAttribute("usuario", request.getParameter("usuario"));
                request.setAttribute("id", request.getParameter("id"));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/inscricao.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                request.setAttribute("usuarios", EventoAmigoDao.getInstace().listDisponiveis(request.getParameter("id")));
                dispachante.forward(request, response);

          
    }

}
}