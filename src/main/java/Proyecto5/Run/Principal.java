package Proyecto5.Run;

import Proyecto5.ui.Frame;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       new Frame();
    }
}
