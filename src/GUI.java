import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    private Listener listener;

    //Opcion para registrar paciente en sistemas:
    public JTextArea nombreExamen,entidad,cedula,fechaNacimiento,pos,telefono,celular,correo,nombreContacto,celularContacto;
    //


    public  JPanel principalPanel,buttonPanel,panelFormularios;
    public JButton ordenes,pacientes,generarMensual,crearOrden,consultarOrden;
    //Ordenes: Crear orden(y despues ingresar datos de examenes), Consultar orden(por numero de factura)
    //Generar mensual: Todos los examenes realizados en el mes
    public  JButton obtenerDatosOrden,ObtenerDatosConsulta,volverMenuPrincipal,obtenerDatosRegistroPaciente;


    public GUI(){
        initGUI();
        this.setTitle("Laboratorio JVES");
        this.setSize(600,250);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initGUI(){
        panelPrincipal();

    }

    public void panelPrincipal(){
        listener = new Listener();
        principalPanel = new JPanel();
        panelFormularios = new JPanel();
        buttonPanel = new JPanel();
        ordenes = new JButton("Ordenes Medicas");
        pacientes = new JButton("Pacientes");
        generarMensual = new JButton("Generar extracto mensual");

        principalPanel.addMouseListener(listener);

        ordenes.addMouseListener(listener);
        ordenes.addActionListener(listener);
        pacientes.addMouseListener(listener);
        pacientes.addActionListener(listener);
        generarMensual.addMouseListener(listener);
        generarMensual.addActionListener(listener);

        principalPanel.setLayout(new BorderLayout());
       // panelFormularios.setLayout(new GridLayout(4,4));
        buttonPanel.add(ordenes);
        buttonPanel.add(pacientes);
        buttonPanel.add(generarMensual);
        principalPanel.add(buttonPanel,BorderLayout.NORTH);
        principalPanel.add(panelFormularios,BorderLayout.CENTER);

        getContentPane().add(principalPanel);
    }

    public void panelPacientes(){

    }

    public void panelOrdenes(){
        consultarOrden = new JButton("Consultar Orden");
        crearOrden = new JButton("Crear Orden");
        //principalPanel.removeAll();
        crearOrden();
        principalPanel.revalidate();
        principalPanel.repaint();


    }

    public void crearOrden(){
        JPanel panelFormularioPaciente = new JPanel(new GridLayout(5, 2)); // 0 filas, 2 columnas

        // Crear etiquetas y campos de texto para los datos
        JLabel lblNombreExamen = new JLabel("  Nombre de Examen:");
        JTextField txtNombreExamen = new JTextField(10);

        JLabel lblEntidad = new JLabel("  Entidad - Particular:");
        JTextField txtEntidad = new JTextField(10);

        JLabel lblCedula = new JLabel("  Cédula:");
        JTextField txtCedula = new JTextField(10);

        JLabel lblFechaNacimiento = new JLabel("  Fecha de Nacimiento:");
        JTextField txtFechaNacimiento = new JTextField(10);

        JLabel lblPos = new JLabel("  POS:");
        JTextField txtPos = new JTextField(10);

        JLabel lblTelefono = new JLabel("  Teléfono:");
        JTextField txtTelefono = new JTextField(10);

        JLabel lblCelular = new JLabel("  Celular:");
        JTextField txtCelular = new JTextField(10);

        JLabel lblCorreo = new JLabel("  Correo:");
        JTextField txtCorreo = new JTextField(10);

        JLabel lblOtraPersona = new JLabel("  Otra Persona:");
        JTextField txtOtraPersona = new JTextField(10);

        JLabel lblTelOtraPersona = new JLabel("  Teléfono Otra Persona:");
        JTextField txtTelOtraPersona = new JTextField(10);

        // Agregar componentes al contenedor
        panelFormularioPaciente.add(lblNombreExamen);
        panelFormularioPaciente.add(txtNombreExamen);

        panelFormularioPaciente.add(lblEntidad);
        panelFormularioPaciente.add(txtEntidad);

        panelFormularioPaciente.add(lblCedula);
        panelFormularioPaciente.add(txtCedula);

        panelFormularioPaciente.add(lblFechaNacimiento);
        panelFormularioPaciente.add(txtFechaNacimiento);

        panelFormularioPaciente.add(lblPos);
        panelFormularioPaciente.add(txtPos);

        panelFormularioPaciente.add(lblTelefono);
        panelFormularioPaciente.add(txtTelefono);

        panelFormularioPaciente.add(lblCelular);
        panelFormularioPaciente.add(txtCelular);

        panelFormularioPaciente.add(lblCorreo);
        panelFormularioPaciente.add(txtCorreo);

        panelFormularioPaciente.add(lblOtraPersona);
        panelFormularioPaciente.add(txtOtraPersona);

        panelFormularioPaciente.add(lblTelOtraPersona);
        panelFormularioPaciente.add(txtTelOtraPersona);

        JButton aceptar = new JButton("Ingresar datos");
        JPanel panelBotonAceptar = new JPanel();
        panelBotonAceptar.add(aceptar);

        principalPanel.add(panelBotonAceptar,BorderLayout.SOUTH);
        panelFormularios.add(panelFormularioPaciente);
       // principalPanel.add(panelFormularios,BorderLayout.CENTER);
    }

    public void consultarOrden(){

    }

    public static void main(String[] args) {
        databaseManagement.initConnection();
        EventQueue.invokeLater(()-> {GUI miProjectGUI = new GUI();
            });

    }

    private class Listener implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==GUI.this.ordenes){
            System.out.println("entro");
            panelOrdenes();
        }
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