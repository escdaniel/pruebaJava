package Controller;

import Entity.Codedr;
import Model.CodedrModel;
import Utils.Utils;

import javax.swing.*;
import java.util.List;



public class CodedrController {
    public static void insert () {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del coder");
        String documento = JOptionPane.showInputDialog("Ingrese el documento del coder");
        String cv = JOptionPane.showInputDialog("Ingrese el cv del coder");

        instanceModel().insert(new Codedr(nombre,apellidos,documento,cv));
    }
    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null,list);

    }

    public static String getAll(List<Object> list){

        String listString = "Lista de registros: \n";

        for (Object temp: list){
            Codedr objCodedr = (Codedr) temp;
            listString += objCodedr.toString() +"\n";
        }
        return listString;
    }
    public static CodedrModel instanceModel(){
        return new CodedrModel();
    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Codedr objSelected = (Codedr) JOptionPane.showInputDialog(
                null,
                "Seleccione un coder",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        instanceModel().delete(objSelected);
    }
    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Codedr objSelected = (Codedr) JOptionPane.showInputDialog(
                null,
                "selecciona un coder para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        objSelected.setNombre(JOptionPane.showInputDialog(null,"Ingrese el nuevo nombre el coder",objSelected.getNombre()));
        objSelected.setApellidos(JOptionPane.showInputDialog(null,"Ingrese los nuevos apellidosdel coder",objSelected.getApellidos()));
        objSelected.setDocumento(JOptionPane.showInputDialog(null,"Ingrese el nuevo documento del coder",objSelected.getDocumento()));
        objSelected.setCv(JOptionPane.showInputDialog(null,"Ingrese la nueva cv del coder",objSelected.getCv()));

        instanceModel().update(objSelected);
    }
}
