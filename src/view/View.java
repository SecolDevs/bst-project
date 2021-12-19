package view;

import javax.swing.*;

public class View {

    public int optionMenu() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu\n" +
                "[1] Agregar Auto\n" +
                "[2] Sacar Auto\n" +
                "[3] Buscar Auto Arbol\n" +
                "[4] Buscar Auto Cola\n" +
                "[5] Recorrer Toda Cola\n" +
                "[6] Recorrer Cola desde...\n" +
                "[7] Recorrer Arbol\n" +
                "[8] Salir\n", "Menu Inicio", JOptionPane.QUESTION_MESSAGE));

        if (option < 1 || option > 8)
            showMessageErr("Digito invalido");
        return option;
    }

    public void showMessageErr(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public String readString(String message, String title) {
        String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        return input;
    }

    public int confirmDialog(String message, String title) {
        int conf = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return conf;
    }

}
