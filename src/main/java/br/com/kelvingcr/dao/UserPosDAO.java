package br.com.kelvingcr.dao;

import br.com.kelvingcr.conexaojdbc.SingleConnection;
import br.com.kelvingcr.model.Userposjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserPosDAO {

    private Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Userposjava userposjava){
        String sql = "insert into userpostjava (id, nome, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1, userposjava.getId());
            insert.setString(2, userposjava.getNome());
            insert.setString(3, userposjava.getEmail());
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

}
