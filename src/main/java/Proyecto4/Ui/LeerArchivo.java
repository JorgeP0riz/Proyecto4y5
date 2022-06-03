package Proyecto4.Ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class LeerArchivo extends JFrame {
    private Logger logger = LogManager.getRootLogger();
    private Panel panel;

    public LeerArchivo() {
        this.setTitle("Practico4");
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new Panel();
        añadirPanelPrincipal();
        this.setResizable(false);
        //cerrar();
        this.pack();
        this.setLocationRelativeTo(null);
        logger.info("Se inicia las cracteristicas del Frame");
    }

    private void añadirPanelPrincipal() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.revalidate();
        logger.info("Se agrega el panel al Frame");
        repaint();
    }

    /*private void cerrar() {
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
    }*/
}
