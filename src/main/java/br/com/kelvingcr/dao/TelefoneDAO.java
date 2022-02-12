package br.com.kelvingcr.dao;

import br.com.kelvingcr.conexaojdbc.SingleConnection;
import br.com.kelvingcr.model.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    private Connection connection;

    public TelefoneDAO(){
        connection = SingleConnection.getConnection();
    }

    public List<Telefone> buscarTelefoneDeUsuario(Long id) {
        List<Telefone> list = new ArrayList<>();
        String sql = "select * from telefoneuser where usuario_id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Telefone tel = new Telefone();
                tel.setId(resultSet.getLong(1));
                tel.setNumero(resultSet.getString(2));
                tel.setTipo(resultSet.getString(3));
                tel.setUsuario_id(resultSet.getString(4));
                list.add(tel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
