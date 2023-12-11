import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    private Listener listener;

    public  JPanel principalPanel,buttonPanel;
    public JButton ordenes,pacientes,generarMensual;  //Ordenes: Crear orden(y despues ingresar datos de examenes), Consultar orden(por numero de factura)
    //Generar mensual: Todos los examenes realizados en el mes



    public GUI(){
        initGUI();

        this.setTitle("Laboratorio JVES");
        this.setSize(800,800);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initGUI(){
        principalPanel = new JPanel();
        buttonPanel = new JPanel();
        ordenes = new JButton("Ordenes Medicas");
        pacientes = new JButton("Pacientes");
        generarMensual = new JButton("Generar extracto mensual");

        principalPanel.setLayout(new BorderLayout());
        buttonPanel.add(ordenes);
        buttonPanel.add(pacientes);
        buttonPanel.add(generarMensual);
        principalPanel.add(buttonPanel,BorderLayout.SOUTH);
        getContentPane().add(principalPanel);

    }

    public void panelPrincipal(){
        principalPanel = new JPanel();
        ordenes = new JButton();
        pacientes = new JButton();
        generarMensual = new JButton();

        principalPanel.setLayout(new BorderLayout());
        principalPanel.add(ordenes);
        principalPanel.add(pacientes);
        principalPanel.add(generarMensual);
    }

    public static void main(String[] args) {
        databaseManagement.initConnection();
        EventQueue.invokeLater(()-> {GUI miProjectGUI = new GUI();
            });

    }

    private class Listener implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}