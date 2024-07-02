package tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener{
    private JTextField nombrePlayerField, moneyPlayerField;
    private JLabel moneyPlayer, labelNamePlayer;
    private JButton agregarBoton, borrarBoton, reiniciarBoton;
    private JTable tablaInformacion;
    private DefaultTableModel modeloTabla;
    private JScrollPane scroll;
    Controlador usuario = new Controlador();


    public Inicio() {

        //Tabla
        String columna[] = {"Nombre", "Dinero", "Puntaje"};
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(columna);

        scroll = new JScrollPane();
        tablaInformacion = new JTable(modeloTabla);
        tablaInformacion.setBounds(280, 50, 500, 300);
        scroll.setBounds(280, 50, 500, 300);
        scroll.setViewportView(tablaInformacion);
        add(scroll);

        //



        setLayout(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Puntaje");

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        // Nombre Jugador
        nombrePlayerField = new JTextField();
        nombrePlayerField.setBounds(50, 100, 100, 20);
        add(nombrePlayerField);

        labelNamePlayer = new JLabel("Nombre Jugador:");
        labelNamePlayer.setBounds(50, 40, 100, 90);
        add(labelNamePlayer);

        // Dinero Jugador
        moneyPlayerField = new JTextField();
        moneyPlayerField.setBounds(50, 180, 100, 20);
        add(moneyPlayerField);

        moneyPlayer = new JLabel("Dinero Jugador:");
        moneyPlayer.setBounds(50, 120, 90, 80);
        add(moneyPlayer);

        // Boton Aceptar, borrar y limpiar
        agregarBoton = new JButton("Agregar");
        agregarBoton.setBounds(50, 500, 100, 25);
        add(agregarBoton);
        

        borrarBoton = new JButton("Borrar");
        borrarBoton.setBounds(160, 500, 100, 25);
        add(borrarBoton);

        reiniciarBoton = new JButton("Reiniciar");
        reiniciarBoton.setBounds(270, 500, 100, 25);
        add(reiniciarBoton);   

        agregarBoton.addActionListener(this);
        reiniciarBoton.addActionListener(this);
        borrarBoton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == agregarBoton)
        {
            if(nombrePlayerField.getText().trim().isEmpty() && moneyPlayerField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puede darle 'agregar' si los campos estan vacios.");
            } else {
                String nombre = nombrePlayerField.getText();
                int dinero = Integer.parseInt(moneyPlayerField.getText());
                int puntaje = 0;
                
                Usuarios user = new Usuarios(nombre, dinero, puntaje);
    
    
                usuario.agregarJugador(user);
                Object[] players = new Object[3];
                for(int i = 0; i < usuario.size(); i++) // Revisa el tamaño del ArrayList Usuario y obtiene la informacion recorriendolo.
                {
                    players[0] = usuario.getPlayer(i).getNombre();
                    players[1] = usuario.getPlayer(i).getDineroJugador();
                    players[2] = usuario.getPlayer(i).getPuntaje();
                }
                modeloTabla.addRow(players);
            }
            
        } 
        if(e.getSource() == borrarBoton){

                int selectedRow = tablaInformacion.getSelectedRow();

                if(selectedRow != -1){
                    modeloTabla.removeRow(selectedRow); // Elimina la tabla seleccionada mediante el identador (i) seleccionado
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila por favor.");
                }

            }
        if(e.getSource() == reiniciarBoton){
            int[] seleccionarFila = tablaInformacion.getSelectedRows();

            for(int i = 0; i > seleccionarFila.length; i++){
                modeloTabla.removeRow(i); // Elimina la tabla seleccionada mediante el identador (i) seleccionado
            }
        }
    }

    public static void main(String Arg[]){

        Inicio ventanaJ = new Inicio();
        ventanaJ.setBounds(0, 0, 800 ,600);
        ventanaJ.setVisible(true);
        ventanaJ.setResizable(false);
        ventanaJ.setLocationRelativeTo(null);
    }
}