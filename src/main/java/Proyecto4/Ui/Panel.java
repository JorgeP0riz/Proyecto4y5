package Proyecto4.Ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private Logger logger = LogManager.getRootLogger();

    private JButton btnLista;
    private JButton btnEliminar;
    private DefaultTableModel modelotabla;
    private JTable tabla;
    private JScrollPane scroll;
    private Object columnas[];

    public Panel() {
        cargarComponentes();
        this.setVisible(true);
        logger.info("Se cargan los componentes del panel");
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(550, 550);
    }

    private void cargarComponentes() {
        columnas = null;
        modelotabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelotabla);
        scroll = new JScrollPane(tabla);
        this.add(scroll);
        scroll.setVisible(false);
        this.setLayout(null);
        btnLista = new JButton("Lista");
        btnLista.setBounds(125, 475, 80, 40);
        btnEliminar = new JButton("Borrar");
        btnEliminar.setBounds(355, 475, 80, 40);
        this.add(btnLista);
        this.add(btnEliminar);
        iniciarTabla();
        cargarLista();
    }

    private void iniciarTabla() {
        this.remove(scroll);
        scroll.setVisible(true);
        columnas = new Object[]{"ID", "Nombre y Apellido", "Numero Telefono"};
        modelotabla = new DefaultTableModel(columnas, 0);
        logger.info("Se inicia la tabla con las columnas: "+ columnas);
    }

    private void cargarLista() {
        btnLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnLista)) {
                    leerArchivoTxt();
                }
            }
        });
    }

    public void leerArchivoTxt() {
        String expreg = "^(\\d+)\s+([A-Za-z])([A-Za-z]+)\s+([A-Za-z])([A-Za-z]+)\s+(\\d+)$";
        BufferedReader leer = null;
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo", "txt");
            logger.info("Se crea un filtro para reconocer los Archivos Txt"+ filtro);
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Escoge el archivo txt");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                File archivo = new File(String.valueOf(chooser.getSelectedFile()));
                logger.debug("Encontrar el archivo como un String: " +archivo);
                leer = new BufferedReader(new FileReader(archivo));
                logger.info("Leer el Archivo es :" +leer);
                String temp = null;
                while ((temp = leer.readLine()) != null) {
                    String aux = temp;
                    Pattern r = Pattern.compile(expreg);
                    Matcher m = r.matcher(aux);
                    while (m.find()) {
                        Object[] fila = {m.group(1), m.group(2).toUpperCase() + m.group(3).toLowerCase() + " " + m.group(4).toUpperCase() + m.group(5).toLowerCase(), m.group(6)};
                        logger.info("se añade la lista de perosnas: " + fila);
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
