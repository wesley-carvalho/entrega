package br.senac.dsw.servlet;

import br.senac.dsw.dao.ProdutoDao;
import br.senac.dsw.entity.Produto;
import br.senac.dsw.test.ProdutoTest;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/index.html":
            case "/menu_principal":
                List<Produto> produtos = null;
                try {
                    produtos = ProdutoDao.listar();
                } catch (Exception e) {
                    produtos = ProdutoTest.InstanceProdutos();
                    e.printStackTrace();
                } finally {
                    request.setAttribute("produtos", produtos);

                    rd = request.getRequestDispatcher("/WEB-INF/menu_principal.jsp");
                    rd.forward(request, response);
                }
                break;
            case "/success":
                rd = request.getRequestDispatcher("/WEB-INF/success.jsp");
                rd.forward(request, response);
                break;
            case "/error":
                rd = request.getRequestDispatcher("/WEB-INF/error.jsp");
                rd.forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
