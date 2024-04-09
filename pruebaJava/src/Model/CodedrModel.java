package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Codedr;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodedrModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Codedr objCoder = (Codedr) obj;

        try {
            String sql ="INSERT INTO codedr (nombre,apellidos,documento,cv) VALUES (?,?,?,?);";
            PreparedStatement prepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setString(1,objCoder.getNombre());
            prepare.setString(2,objCoder.getApellidos());
            prepare.setString(3,objCoder.getDocumento());
            prepare.setString(4,objCoder.getCv());

            prepare.execute();
            ResultSet objResult = prepare.getGeneratedKeys();

            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"El coder fue agregado correctamente");
        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public List<Object> findAll() {

        List<Object>listCodedr = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT FROM codedr;";

            PreparedStatement prepare =objConnection.prepareStatement(sql);
            ResultSet objResult = prepare .executeQuery();

            while (objResult.next()){
                Codedr objCodedr = new Codedr();

             objCodedr.setId(objResult.getInt("id"));
             objCodedr.setNombre(objResult.getString("nombre"));
             objCodedr.setApellidos(objResult.getString("apellidos"));
             objCodedr.setDocumento(objResult.getString("documento"));
             objCodedr.setCv(objResult.getString("cv"));

             listCodedr.add(objCodedr);
            }

        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return listCodedr;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Codedr objCodedr = (Codedr) obj;
        boolean isUpdate = false;

        try {
            String sql = "UPDATE codedr SET nombre = ?, apellidos = ?, documento = ?, cv = ?;";
            PreparedStatement prepare = objConnection.prepareStatement(sql);

            prepare.setString(1,objCodedr.getNombre());
            prepare.setString(2,objCodedr.getApellidos());
            prepare.setString(3,objCodedr.getDocumento());
            prepare.setString(4,objCodedr.getCv());

            int totalRowAffected = prepare.executeUpdate();
            if (totalRowAffected >0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"el registro  fue actualizado correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Codedr objCodedr = (Codedr) obj;
        boolean isDeleted = false;

        try {
            String sql ="DELETE FROM codedr WHERE id =?";
            PreparedStatement prepare = objConnection.prepareStatement(sql);
            prepare.setInt(1,objCodedr.getId());
            int tatalAcffetedRow = prepare.executeUpdate();

            if (tatalAcffetedRow >0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Coder eliminado correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR>"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}
