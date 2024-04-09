package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Vacante objVacante = (Vacante) obj;
        try {
            String sql = "INSERT INTO vacante (titulo,descripcion,duracion,estado) VALUES (?,?,?,?);";

            PreparedStatement prepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            prepare.setString(1,objVacante.getTitulo());
            prepare.setString(2,objVacante.getDescripcion());
            prepare.setString(3,objVacante.getDuracion());
            prepare.setString(4,objVacante.getEstado());

            prepare.execute();
            ResultSet objResult = prepare.getGeneratedKeys();

            while (objResult.next()){
                objVacante.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"La vacante fue agregada correctamente");

        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return objVacante;
    }

    @Override
    public List<Object> findAll() {

        List <Object>listVacante = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante;";

            PreparedStatement prepare = objConnection.prepareStatement(sql);

            ResultSet objResult = prepare.executeQuery();
            while (objResult.next()){
                Vacante objVacante = new Vacante();

                objVacante.setId(objResult.getInt("id"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));

                listVacante.add(objVacante);
            }
        }catch (SQLException e){
            System.out.println("ERROR >"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacante;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        boolean isUpdate = false;

        try {
            String sql = "UPDATE vacante SET titulo = ?, descripcion = ?, duracion = ?, estado = ?;";
            PreparedStatement prepare = objConnection.prepareStatement(sql);

            prepare.setString(1,objVacante.getTitulo());
            prepare.setString(2,objVacante.getDescripcion());
            prepare.setString(3,objVacante.getDuracion());
            prepare.setString(4,objVacante.getEstado());

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
        Vacante objVacante = (Vacante) obj;

        boolean isDeleted = false;

                try{
                    String sql = "DELETE FROM vacante WHERE id =?;";
                    PreparedStatement prepare = objConnection.prepareStatement(sql);
                    prepare.setInt(1,objVacante.getId());

                    prepare.executeUpdate();
                    int totalAffectedRows = prepare.executeUpdate();

                    if (totalAffectedRows >0){
                        isDeleted = true;
                        JOptionPane.showMessageDialog(null,"Vacante eliminada correctamente");
                    }

                }catch (SQLException e){
                    System.out.println("ERROR >"+e.getMessage());
                }
                ConfigDB.closeConnection();

        return isDeleted;
    }
}
