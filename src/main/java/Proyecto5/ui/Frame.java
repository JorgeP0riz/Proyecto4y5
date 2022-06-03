package Proyecto5.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class Frame extends JFrame {

    private Imagen img;
    private Panel panelImagen;

    public Frame() {
        init1();
    }

    public void init1() {
        //setSize(500, 500);
        setTitle("Practico 5");
        setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem mnSeleccionar = new JMenuItem("Cargar imagen");

        mnSeleccionar.addActionListener(e -> {

            FileNameExtensionFilter jpg = new FileNameExtensionFilter("Imagenes JPG", "jpg");
            FileNameExtensionFilter png = new FileNameExtensionFilter("Imagenes PNG", "png");

            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            fc.setAcceptAllFileFilterUsed(false);
            fc.addChoosableFileFilter(jpg);
            fc.addChoosableFileFilter(png);

            int respuesta = fc.showOpenDialog(null);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                this.img = new Imagen(fc.getSelectedFile().getPath());
                Dimension imgDimension = new Dimension(img.getAncho(), img.getAlto());
                panelImagen.setImg(img);
                panelImagen.setPreferredSize(imgDimension);
                panelImagen.setSize(imgDimension);
                this.setPreferredSize(imgDimension);
                this.setSize(imgDimension);
            }
        });

        menuBar.add(menuArchivo);
        menuArchivo.add(mnSeleccionar);
        this.setJMenuBar(menuBar);
        panelImagen = new Panel(this.getWidth(), this.getHeight());
        this.add(panelImagen, BorderLayout.CENTER);
        this.addMouseListener(panelImagen);
        this.addKeyListener(panelImagen);
        this.pack();
    }
}
