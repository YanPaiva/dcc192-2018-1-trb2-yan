package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BemVindoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String senha = request.getParameter("txtsenha");
            String login = request.getParameter("txtlogin");
            
            if (null!=senha && !"".equals(senha)) {
                Participante logando = new Participante();
                logando = ParticipanteDao.getInstace().
                        getParticipante(login,
                                senha);
                if (logando != null) {
                    RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/bemVindo.jsp");
                    request.setAttribute("titulo",
                            "Logado com Sucesso");
                    request.setAttribute("usuario", logando);
                    dispachante.forward(request, response);
                } else {
                    RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
                    request.setAttribute("titulo",
                            "Pagina inicial");
                    dispachante.forward(request, response);
                }
            } else if(login != null){
                response.sendRedirect("informarsenha.html?email=" + login);
            }else{
                    RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/bemVindo.jsp");
                    request.setAttribute("titulo",
                            "Pagina inicial");
                    dispachante.forward(request, response);
            }
        }

    }

}
