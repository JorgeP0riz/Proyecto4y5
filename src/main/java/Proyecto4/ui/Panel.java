package Proyecto4.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Panel extends JPanel {

    private JButton btnLista;
    private JButton btnEliminar;
    private DefaultTableModel modelotabla;
    private JTable tabla;
    private JScrollPane scroll;
    private Object columnas[];


    public Panel() {
        loadComponents();
        this.setVisible(true);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(550, 550);
    }

    private void loadComponents() {
        columnas = null;
        modelotabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelotabla);
        scroll = new JScrollPane(tabla);
        this.add(scroll);
        scroll.setVisible(false);
        this.setLayout(null);
        btnLista = new JButton("Lista");
        btnLista.setBounds(165, 475, 80, 40);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(255, 475, 80, 40);
        this.add(btnLista);
        this.add(btnEliminar);
        iniciarTabla();
        cargarLista();
    }

    private void iniciarTabla() {
        this.remove(scroll);
        scroll.setVisible(true);
        columnas = new Object[]{"Nombre y Apellido", "Edad"};
        modelotabla = new DefaultTableModel(columnas, 0);
    }

    private void cargarLista() {
        btnLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnLista)) {
                    leerTxt();
                }
            }
        });
    }

    public void leerTxt() {
        String expreg = "^([A-Za-z])([A-Za-z]+)\s+([A-Za-z])([A-Za-z]+)\s+(\\d+)$";
        BufferedReader leer = null;
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo", "txt");
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Escoge el archivo txt");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                File archivo = new File(String.valueOf(chooser.getSelectedFile()));
                leer = new BufferedReader(new FileReader(archivo));
                String temp = null;
                while ((temp = leer.readLine()) != null) {
                    String aux = temp;
                    Pattern r = Pattern.compile(expreg);
                    Matcher m = r.matcher(aux);
                    while (m.find()) {
                        Object[] fila = {m.group(1).toUpperCase() + m.group(2).toLowerCase() + " " + m.group(3).toUpperCase() + m.group(4).toLowerCase(), m.group(5)};
                        modelotabla.addRow(fila);
                    }
                    tabla = new JTable(modelotabla);
                    scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scroll.setBounds(15, 5, 500, 450);
                    this.add(scroll);
                    ListSelectionModel modelo = tabla.getSelectionModel();
                    modelo.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!modelo.isSelectionEmpty()) {
                                btnEliminar.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int selectedRow = modelo.getMinSelectionIndex();
                                        if (selectedRow != -1)
                                            modelotabla.removeRow(selectedRow);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
        }
    }

}
