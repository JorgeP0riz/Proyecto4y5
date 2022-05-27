package Proyecto4.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LeerArchivo extends JFrame {
    private Panel panel;

    public LeerArchivo() {
        this.setTitle("Practico4");
        init();
    }

    private void init() {
        panel = new Panel();
        añadirPanelPrincipal();
        this.setResizable(false);
        cerrar();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void añadirPanelPrincipal() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.revalidate();
        repaint();
    }

    private void cerrar() {
        try {
            this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar la aplicación?", "Alerta", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Se cerrara el programa", "Gracias", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
