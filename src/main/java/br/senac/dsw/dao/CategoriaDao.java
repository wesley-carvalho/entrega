package br.senac.dsw.dao;

import br.senac.dsw.entity.Categoria;
import br.senac.dsw.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategoriaDao {

    public static List<Categoria> listar()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM CATEGORIA";

        List<Categoria> categorias = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (categorias == null) {
                    categorias = new LinkedList<>();
                }
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("id"));
                categoria.setNome(result.getString("nome"));                

                categorias.add(categoria);
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

        return categorias;
    }
}
