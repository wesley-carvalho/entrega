package br.senac.dsw.dao;

import br.senac.dsw.entity.Produto;
import br.senac.dsw.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDao {

    public static void cadastrar(Produto produto)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO PRODUTO (nome, descricao, preco_compra, preco_venda, "
                + "quantidade, dt_cadastro, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setDouble(3, produto.getPreco_compra());
            preparedStatement.setDouble(4, produto.getPreco_venda());
            preparedStatement.setInt(5, produto.getQuantidade());
            preparedStatement.setTimestamp(6, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setString(7, produto.getCategoria());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(Produto produto)
            throws ClassNotFoundException, SQLException {
        String sql = "UPDATE PRODUTO SET nome=?, descricao=?, preco_compra=?, "
                + "preco_venda=?, quantidade=?, categoria=? WHERE (PRODUTO.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setDouble(3, produto.getPreco_compra());
            preparedStatement.setDouble(4, produto.getPreco_venda());
            preparedStatement.setInt(5, produto.getQuantidade());
            preparedStatement.setString(6, produto.getCategoria());
            preparedStatement.setInt(7, produto.getId()); 

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Produto> listar()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM PRODUTO";

        List<Produto> produtos = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (produtos == null) {
                    produtos = new LinkedList<>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setDescricao(result.getString("descricao"));
                produto.setPreco_compra(result.getDouble("preco_compra"));
                produto.setPreco_venda(result.getDouble("preco_venda"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDt_cadastro(result.getDate("dt_cadastro"));

                produtos.add(produto);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return produtos;
    }

    public static Produto buscar(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE (PRODUTO.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setDescricao(result.getString("descricao"));
                produto.setPreco_compra(result.getDouble("preco_compra"));
                produto.setPreco_venda(result.getDouble("preco_venda"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDt_cadastro(result.getDate("dt_cadastro"));

                return produto;
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return null;
    }

    public static void excluir(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM PRODUTO WHERE (PRODUTO.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
