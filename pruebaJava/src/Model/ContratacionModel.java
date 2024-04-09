package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Contratacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContratacionModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Contratacion objContra = (Contratacion) obj;

        try {
            String sql = "INSERT INTO contratacion (fecha_aplicacion,estado,salario)VALUES(?,?,?);";

            PreparedStatement prepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setDate(1,objContra.getFecha_aplicacion());
            prepare.setString(2,objContra.getEstado());
            prepare.setFloat(3,objContra.getSalario());

            prepare.execute();
            ResultSet objResult = prepare.getGeneratedKeys();

            while (objResult.next()){
                objContra.setId(objResult.getInt(1));

            }
            JOptionPane.showMessageDialog(null,"La contratacion fue exitosa");

        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return objContra;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
