package Proyecto4.Run;

import Proyecto4.Ui.LeerArchivo;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new LeerArchivo().setVisible(true);
    }
}
