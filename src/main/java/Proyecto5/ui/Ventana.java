package Proyecto5.ui;

import Proyecto5.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    private Imagen img;

    private JLabel lbEfectos = new JLabel("Filtro");
    private JButton btnTransformacionHorizontal = new JButton("Filtro Horizontal");
    private JButton btnTransformacionVertical = new JButton("Filtro Vertical");
    private JButton btnTransformacionPixelado = new JButton("Pixelar");
    private JButton btnTransformacionSuavizado = new JButton("Suavizar");
    private JButton btnTransformacionBlancoNegro = new JButton("Blanco y Negro");
    private JButton btnImagenOriginal = new JButton("Imagen Original");
    private JButton btnTransformacionTonosGrises = new JButton("Tonos Grises");
    private JButton btnTransformacionFiltroRojo = new JButton("Filtro Rojo");
    private JButton btnTransformacionFiltroVerde = new JButton("Filtro Verde");
    private JButton btnTransformacionFiltroAzul = new JButton("Filtro Azul");

    private Point punto1;
    private Point punto2;

    public Ventana(Imagen img) {
        this.img = img;
        this.punto1 = new Point(0,0);
        this.punto2 = new Point(img.getAncho(), img.getAlto());
        init1();
    }

    public Ventana(Imagen img, Point punto1, Point punto2) {
        this.img = img;
        this.punto1 = punto1;
        this.punto2 = punto2;
        init1();
    }

    public void init1() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(250, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setSize(this.getWidth(), this.getHeight());
        panel.setLayout(null);
        panel.setVisible(true);

        int x = 45;
        int y = 10;
        lbEfectos.setFont(new Font("Arial", Font.BOLD, 20));
        lbEfectos.setHorizontalAlignment(SwingConstants.CENTER);
        lbEfectos.setBounds(x, y, 150, 50);
        y += 50;
        btnTransformacionVertical.setBounds(x, y, 150, 30);
        y += 40;
        btnTransformacionHorizontal.setBounds(x, y, 150, 30);
        y += 40;
        btnTransformacionBlancoNegro.setBounds(x,y,150,30);
        y += 40;
        btnTransformacionTonosGrises.setBounds(x,y,150,30);
        y += 40;
        btnTransformacionFiltroRojo.setBounds(x,y,150,30);
        y += 40;
        btnTransformacionFiltroVerde.setBounds(x,y,150,30);
        y += 40;
        btnTransformacionFiltroAzul.setBounds(x,y,150,30);
        y += 40;

        btnTransformacionBlancoNegro.addActionListener(this);
        btnTransformacionHorizontal.addActionListener(this);
        btnTransformacionVertical.addActionListener(this);
        btnTransformacionTonosGrises.addActionListener(this);
        btnTransformacionFiltroRojo.addActionListener(this);
        btnTransformacionFiltroVerde.addActionListener(this);
        btnTransformacionFiltroAzul.addActionListener(this);

        panel.add(lbEfectos);
        panel.add(btnTransformacionVertical);
        panel.add(btnTransformacionHorizontal);
        panel.add(btnTransformacionBlancoNegro);
        panel.add(btnTransformacionTonosGrises);
        panel.add(btnTransformacionFiltroRojo);
        panel.add(btnTransformacionFiltroAzul);
        panel.add(btnTransformacionFiltroVerde);

        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnImagenOriginal) {

        } else if (e.getSource() == btnTransformacionVertical) {

            TransformarVertical transformacionVertical = new TransformarVertical(img);
            transformacionVertical.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionHorizontal) {

            TransformarHorizontal transformacionHorizontal = new TransformarHorizontal(img);
            transformacionHorizontal.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionPixelado){
            JOptionPane.showMessageDialog(null,"Este filtro está en construcción");
        } else if (e.getSource() == btnTransformacionSuavizado){
            JOptionPane.showMessageDialog(null,"Este filtro está en construcción");
        } else if (e.getSource() == btnTransformacionBlancoNegro){

            TransformarByN transformacionBlancoNegro = new TransformarByN(img);
            transformacionBlancoNegro.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionTonosGrises){

            TransformarGris transformacionTonosGris = new TransformarGris(img);
            transformacionTonosGris.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionFiltroRojo){

            TransformarRojo transformarFiltroRojo = new TransformarRojo(img);
            transformarFiltroRojo.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionFiltroVerde){

            TransformarVerde transformacionFiltroVerde = new TransformarVerde(img);
            transformacionFiltroVerde.transformar(punto1,punto2);

        } else if (e.getSource() == btnTransformacionFiltroAzul){

            TransformarAzul transformacionFiltroAzul = new TransformarAzul(img);
            transformacionFiltroAzul.transformar(punto1,punto2);

        }
    }
}
