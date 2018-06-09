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

class InscricaoCommandPost implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            request.setAttribute("idUser", request.getParameter("idUser"));
            String codigoEvento = request.getParameter("id");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            EventoAmigoDao.getInstace().addEvento(codigoEvento, idUsuario);
            response.sendRedirect("inscricao.html?id=" + request.getParameter("id")+"&idUser="+request.getParameter("idUser"));

        }

    }
}
