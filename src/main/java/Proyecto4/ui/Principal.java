package Proyecto4.ui;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new LeerArchivo().setVisible(true);
    }
}
