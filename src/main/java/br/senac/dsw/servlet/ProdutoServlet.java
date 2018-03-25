package br.senac.dsw.servlet;

import br.senac.dsw.dao.CategoriaDao;
import br.senac.dsw.dao.ProdutoDao;
import br.senac.dsw.entity.Produto;
import br.senac.dsw.test.CategoriaTest;
import br.senac.dsw.test.ProdutoTest;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/cadastrar_produtos": {                
                try {
                    request.setAttribute("categorias", CategoriaDao.listar());                    
                } catch (Exception e) {
                    request.setAttribute("categorias", CategoriaTest.InstanceCategorias());
                    e.printStackTrace();
                } finally {
                    rd = request.getRequestDispatcher("/WEB-INF/cadastrar_produtos.jsp");
                    rd.forward(request, response);
                }
            }

            break;
            case "/listar_produtos":                
                try {
                    request.setAttribute("produtos", ProdutoDao.listar());                    
                } catch (Exception e) {
                    request.setAttribute("produtos", ProdutoTest.InstanceProdutos());                    
                    e.printStackTrace();                    
                } finally {
                    rd = request.getRequestDispatcher("/WEB-INF/listar_produtos.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        Integer prodID;
        Produto produto;

        switch (context) {
            case "/produto_cadastrar":
                produto = new Produto();

                produto.setNome(request.getParameter("nome"));
                produto.setCategoria(request.getParameter("categoria"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setPreco_compra(Double.parseDouble(request.getParameter("preco_compra")));
                produto.setPreco_venda(Double.parseDouble(request.getParameter("preco_venda")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

                try {
                    ProdutoDao.cadastrar(produto);

                    response.sendRedirect(request.getContextPath() + "/success");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/produto_atualizar":
                produto = new Produto();

                produto.setId(Integer.parseInt(request.getParameter("id")));
                produto.setNome(request.getParameter("nome"));
                produto.setCategoria(request.getParameter("categoria"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setPreco_compra(Double.parseDouble(request.getParameter("preco_compra")));
                produto.setPreco_venda(Double.parseDouble(request.getParameter("preco_venda")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

                try {
                    ProdutoDao.atualizar(produto);

                    response.sendRedirect(request.getContextPath() + "/success");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/produto_alterar":
                prodID = Integer.parseInt(request.getParameter("id"));

                try {
                    request.setAttribute("produto", ProdutoDao.buscar(prodID));
                    request.setAttribute("categorias", CategoriaDao.listar());
                } catch (Exception e) {
                    request.setAttribute("produto", ProdutoTest.InstanceProdutos().get(prodID));
                    request.setAttribute("categorias", CategoriaTest.InstanceCategorias());
                    
                    e.printStackTrace();                    
                } finally{
                    rd = request.getRequestDispatcher("/WEB-INF/alterar_produto.jsp");
                    rd.forward(request, response);
                }

                break;
            case "/produto_exibir":
                prodID = Integer.parseInt(request.getParameter("id"));

                try {
                    request.setAttribute("produto", ProdutoDao.buscar(prodID));
                } catch (Exception e) {
                    request.setAttribute("produto", ProdutoTest.InstanceProdutos().get(prodID));
                    e.printStackTrace();                    
                } finally{
                    rd = request.getRequestDispatcher("/WEB-INF/exibir_produto.jsp");
                    rd.forward(request, response);
                }

                break;
            case "/produto_excluir":
                prodID = Integer.parseInt(request.getParameter("id"));

                try {
                    ProdutoDao.excluir(prodID);

                    response.sendRedirect(request.getContextPath() + "/success");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            default:
                break;
        }
    }
}
