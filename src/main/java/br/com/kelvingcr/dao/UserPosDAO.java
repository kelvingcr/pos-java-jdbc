package br.com.kelvingcr.dao;

import br.com.kelvingcr.conexaojdbc.SingleConnection;
import br.com.kelvingcr.model.Userposjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDAO {

    private Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Userposjava userposjava) {
        String sql = "insert into userpostjava (nome, email) VALUES (?, ?)";
        try {
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, userposjava.getNome());
            insert.setString(2, userposjava.getEmail());
            insert.execute();
            connection.commit(); //salva no banco
        } catch (SQLException e) {
            try {
                connection.rollback(); // reverte a operação
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<Userposjava> listar() {
        List<Userposjava> list = new ArrayList<>();
        String sql = "select * from userpostjava";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Userposjava userposjava = new Userposjava(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getString("email")
                );
                list.add(userposjava);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Userposjava buscar(Long id) {
        Userposjava obj = new Userposjava();
        String sql = "select * from userpostjava where id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                obj.setId(resultado.getLong("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setEmail(resultado.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void atualizarUsuario(Userposjava obj) {
        String sql = "UPDATE userpostjava SET nome = ? where id = " + obj.getId();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, obj.getNome());
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public void deletar(Long id){
        String sql = "DELETE from userpostjava where id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
