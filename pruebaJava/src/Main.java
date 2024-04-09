import Controller.CodedrController;
import Controller.VacanteControler;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Vacante
                    2. Administrar Coder
                    3. Administrar contratacion
                    4. salir
                                      
                    Ingrese una opcion:
                    """));
            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Vacante
                                2. Crear vacante
                                3. Borrar vacante
                                4. Actualizar vacante
                                5. salir
                                                  
                                Ingrese una opcion:
                                """));
                        switch (option2) {
                            case 1:
                                VacanteControler.getAll();
                                break;
                            case 2:
                                VacanteControler.insert();
                                break;
                            case 3:
                                VacanteControler.delete();
                                break;
                            case 4:
                                VacanteControler.update();
                                break;
                        }

                    } while (option2 != 5);
                    break;
            }
            switch (option) {
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar coders
                                2. Crear coder
                                3. Borrar coder
                                4. Actualizar coders
                                5. salir
                                                  
                                Ingrese una opcion:
                                """));

                        switch (option2) {
                            case 1:
                                CodedrController.getAll();
                                break;
                            case 2:
                                CodedrController.insert();
                                break;
                            case 3:
                                CodedrController.delete();
                                break;
                            case 4:
                                CodedrController.update();
                                break;
                        }

                    } while (option2 != 5);
                    break;

            }
            switch (option) {
                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar contratacion
                                2. Crear contratacion
                                3. Borrar contratacion
                                4. Actualizar contratacion
                                5. salir
                                                  
                                Ingrese una opcion:
                                """));

                        switch (option2) {
                            case 2:
                                CodedrController.insert();
                                break;

                        }
                        }while (option2 != 5);
            }
        }while (option != 4);

    }
}

