package Controller;

import Entity.Vacante;
import Model.VacanteModel;
import Utils.Utils;

import javax.swing.*;
import java.util.List;

public class VacanteControler {
    public static void insert(){
        String titulo = JOptionPane.showInputDialog("Ingresa el titulo de la vacante");
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion de la vacante");
        String duracion = JOptionPane.showInputDialog("Ingresa la duracion de la vacante");
        String estado = JOptionPane.showInputDialog("Ingresa el estado de la vacante");

        intanceModel().insert(new Vacante(titulo,descripcion,duracion,estado));
    }
    public static void getAll(){
        String list = getAll(intanceModel().findAll());
        JOptionPane.showMessageDialog(null,list);

    }
    public static String getAll(List<Object> list){

        String listString = "Lista de registros: \n";

        for (Object temp: list){
            Vacante objVacante = (Vacante) temp;
            listString += objVacante.toString() +"\n";
        }
        return listString;
    }
    public static VacanteModel intanceModel(){
        return new VacanteModel();
    }
    public static void delete(){
    Object[] options = Utils.listToArray(intanceModel().findAll());

    Vacante objSelected = (Vacante) JOptionPane.showInputDialog(
            null,
            "selecciona una vacante",
            "",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );
    intanceModel().delete(objSelected);
    }
    public static void update(){
        Object[] options = Utils.listToArray(intanceModel().findAll());
        Vacante objSelected = (Vacante) JOptionPane.showInputDialog(
                null,
                "selecciona una vacante para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        objSelected.setTitulo(JOptionPane.showInputDialog(null,"Ingrese eln nuevo vacante",objSelected.getTitulo()));
        objSelected.setDescripcion(JOptionPane.showInputDialog(null,"Ingrese la nueva descripcion de la vacante",objSelected.getTitulo()));
        objSelected.setDuracion(JOptionPane.showInputDialog(null,"Ingrese la nueva duracion de la vacante",objSelected.getTitulo()));
        objSelected.setEstado(JOptionPane.showInputDialog(null,"Ingrese el nuevo estado de la vacante",objSelected.getTitulo()));

        intanceModel().update(objSelected);
    }
}
