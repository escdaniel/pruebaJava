package Controller;

import Entity.Contratacion;
import Model.ContratacionModel;

import javax.swing.*;



public class ContratacionControler {
    public static void insert() {
        String fecha_aplicacion = JOptionPane.showInputDialog("Ingrese la fecha_aplicacion ");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la contratacion");
        Float salario = Float.valueOf(JOptionPane.showInputDialog("ingrese el salario de la contratacion"));

        intanceModel().insert(new Contratacion(fecha_aplicacion, estado, salario));

    }
    public static ContratacionModel intanceModel(){
        return new ContratacionModel();
    }
}