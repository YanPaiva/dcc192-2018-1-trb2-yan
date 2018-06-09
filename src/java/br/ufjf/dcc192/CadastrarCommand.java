package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CadastrarCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/cadastrar.jsp");
            request.setAttribute("titulo",
                    "Novo Usuario");
            dispachante.forward(request, response);

        }

    }

}
