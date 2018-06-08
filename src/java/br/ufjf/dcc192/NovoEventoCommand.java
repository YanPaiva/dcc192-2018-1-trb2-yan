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

class NovoEventoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            if ("/novoEvento.html".equals(request.getServletPath())) {
                request.setAttribute("usuario", request.getParameter("usuario"));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/novoEvento.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                dispachante.forward(request, response);

            } else {
                try {
                    String codigo = request.getParameter("codigo");
                    String titulo = request.getParameter("titulo");
                    double minimo = Double.parseDouble(request.getParameter("minimo"));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dataEvento = sdf.parse(request.getParameter("dataEvento"));
                    Date dataSorteio = sdf.parse(request.getParameter("dataSorteio"));
                    Evento e = new Evento(codigo,titulo,minimo,dataEvento,dataSorteio);
                    EventoDao.getInstace().addEvento(e);
                    request.setAttribute("usuario", request.getParameter("usuario"));
                    
                    response.sendRedirect("sorteios.html");
                } catch (ParseException ex) {
                    Logger.getLogger(NovoEventoCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
