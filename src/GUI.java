import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    private Listener listener;
    public JTextArea nombreExamen,entidad,cedula,fechaNacimiento,pos,telefono,celular,correo,nombreContacto,celularContacto;
    public JLabel lblnroConsecutivo,lblFechaIngreso,lblFechaSolicitud,lblNombreMedico,lblNumeroOrden,lblConsultaCedula;
    public JTextField txtnroConsecutivo,txtFechaIngreso,txtFechaSolicitud,txtNombreMedico,txtNumeroOrden,txtConsultaCedula,txtConsultaTarjetaProfesional;
    public JLabel lblCedula,lblEntidad,lblPos,lblNombreExamen,lblTelefono,lblFechaNacimiento,lblCelular,lblCorreo,lblOtraPersona,lblTelOtraPersona,lblConsultaTarjetaProfesional;
    public JButton crearMedico, consultarMedico;
    public JTextField txtCedula,txtEntidad,txtPos,txtTelefono,txtCelular,txtCorreo,txtFechaNacimiento,txtNombreExamen,txtOtraPersona,txtTelOtraPersona;
    public  JPanel principalPanel,buttonPanel, panelSegundario,panelInferior;
    public JButton ordenes,pacientes,generarMensual,crearOrden,consultarOrden,crearPaciente,consultarPaciente,salir,medicos;
    public JLabel lblTarjetaProfesional,lblRegistroNombreMedico,lblRegistroApellidosMedico,lblTelefonoMedico,lblDireccionMedico,lblEspecialidad,lblTarjetaProfesinal;
    public JTextField txtTarjetaProfesional,txtRegistroNombreMedico,txtRegistroApellidosMedico,txtTelefonoMedico,txtDireccionMedico,txtEspecialidad;
    public JButton totalAPagar,consultarPorFactura,resultadosMedico;
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
        medicos = new JButton("Medicos");
        salir = new JButton("Salir");
        panelInferior = new JPanel();
        listener = new Listener();
        principalPanel = new JPanel();
        panelSegundario = new JPanel();
        buttonPanel = new JPanel();
        ordenes = new JButton("Ordenes Medicas");
        pacientes = new JButton("Pacientes");
        generarMensual = new JButton("Generar extracto mensual");

        ordenes.setEnabled(true);
        pacientes.setEnabled(true);
        generarMensual.setEnabled(true);

        principalPanel.addMouseListener(listener);

        medicos.addActionListener(listener);
        salir.addActionListener(listener);
        ordenes.addMouseListener(listener);
        ordenes.addActionListener(listener);
        pacientes.addMouseListener(listener);
        pacientes.addActionListener(listener);
        generarMensual.addMouseListener(listener);
        generarMensual.addActionListener(listener);

        principalPanel.setLayout(new BorderLayout());
       // panelFormularios.setLayout(new GridLayout(4,4));
        buttonPanel.add(medicos);
        buttonPanel.add(ordenes);
        buttonPanel.add(pacientes);
        buttonPanel.add(generarMensual);
        principalPanel.add(buttonPanel,BorderLayout.NORTH);
        principalPanel.add(panelSegundario,BorderLayout.CENTER);
        principalPanel.add(panelInferior,BorderLayout.SOUTH);

        getContentPane().add(principalPanel);
    }

    public void revalidar(){
        panelInferior.repaint();
        panelInferior.revalidate();
        panelSegundario.repaint();
        panelSegundario.revalidate();
        principalPanel.revalidate();
        principalPanel.repaint();
    }
    public void panelPacientes(){
        crearPaciente = new JButton("Crear paciente");
        consultarPaciente = new JButton("Consultar Paciente");

        crearPaciente.addActionListener(listener);
        consultarPaciente.addActionListener(listener);

        vaciarPanelsegundario();
        panelInferior.add(salir);
        panelSegundario.add(consultarPaciente);
        panelSegundario.add(crearPaciente);
        ordenes.setEnabled(true);
        pacientes.setEnabled(false);
        generarMensual.setEnabled(true);
        revalidar();
    }

    public void panelOrdenes(){
        revalidar();
        consultarOrden = new JButton("Consultar Orden");
        crearOrden = new JButton("Crear Orden");

        crearOrden.addActionListener(listener);
        consultarOrden.addActionListener(listener);
        crearOrden.addMouseListener(listener);
        consultarOrden.addMouseListener(listener);

        vaciarPanelsegundario();
        panelInferior.add(salir);
        panelSegundario.add(crearOrden);
        panelSegundario.add(consultarOrden);
        ordenes.setEnabled(false);
        pacientes.setEnabled(true);
        generarMensual.setEnabled(true);
        medicos.setEnabled(true);
        revalidar();

    }
    public void vaciarPanelsegundario(){
        panelInferior.removeAll();
        panelInferior.revalidate();
        panelInferior.repaint();
        panelSegundario.removeAll();
        panelSegundario.revalidate();
        panelSegundario.repaint();

    }
    public void panelMedicos(){
        crearMedico = new JButton("Crear medico");
        consultarMedico = new JButton("Consultar medico");

        crearMedico.addActionListener(listener);
        consultarMedico.addActionListener(listener);

        vaciarPanelsegundario();

        panelSegundario.add(crearMedico);
        panelSegundario.add(consultarMedico);
        ordenes.setEnabled(true);
        pacientes.setEnabled(true);
        generarMensual.setEnabled(true);
        medicos.setEnabled(false);
        revalidar();

    }
    public void recopilarDatosPaciente(){

    }

    public void panelCrearOrden(){
        vaciarPanelsegundario();
        panelInferior.add(salir);
        revalidar();
        JPanel panelFormularioOrdenes = new JPanel(new GridLayout(5,2));

        lblnroConsecutivo = new JLabel("Consecutivo: ");
        txtnroConsecutivo = new JTextField(10);

        lblFechaSolicitud = new JLabel("Fecha de Solicitud: ");
        txtFechaSolicitud = new JTextField(10);

        lblFechaIngreso = new JLabel("Fecha Ingresoo: ");
        txtFechaIngreso = new JTextField(10);

        lblNombreMedico = new JLabel("Nombre del medico: ");
        txtNombreMedico = new JTextField(10);

        lblNumeroOrden = new JLabel("Nombre del medico: ");
        txtNumeroOrden = new JTextField(10);

        panelFormularioOrdenes.add(lblnroConsecutivo);
        panelFormularioOrdenes.add(txtnroConsecutivo);

        panelFormularioOrdenes.add(lblFechaSolicitud);
        panelFormularioOrdenes.add(txtFechaSolicitud);

        panelFormularioOrdenes.add(lblFechaIngreso);
        panelFormularioOrdenes.add(txtFechaIngreso);

        panelFormularioOrdenes.add(lblNombreMedico);
        panelFormularioOrdenes.add(txtNombreMedico);

        panelFormularioOrdenes.add(lblNumeroOrden);
        panelFormularioOrdenes.add(txtNumeroOrden);

        JButton siguiente = new JButton("Siguiente");
        JPanel botonSiguiente = new JPanel();
        botonSiguiente.add(siguiente);

        panelInferior.add(botonSiguiente);
        panelSegundario.add(panelFormularioOrdenes);

        revalidar();
    }
    public void crearPaciente(){
        panelInferior.add(salir);
        vaciarPanelsegundario();
        JPanel panelFormularioPaciente = new JPanel(new GridLayout(5, 2));

        // Crear etiquetas y campos de texto para los datos
        lblNombreExamen = new JLabel("  Nombre de Examen:");
        txtNombreExamen = new JTextField(10);

        lblEntidad = new JLabel("  Entidad - Particular:");
        txtEntidad = new JTextField(10);

        lblCedula = new JLabel("  Cédula:");
        txtCedula = new JTextField(10);

        lblFechaNacimiento = new JLabel("  Fecha de Nacimiento:");
        txtFechaNacimiento = new JTextField(10);

        lblPos = new JLabel("  POS:");
        txtPos = new JTextField(10);

        lblTelefono = new JLabel("  Teléfono:");
        txtTelefono = new JTextField(10);

        lblCelular = new JLabel("  Celular:");
        txtCelular = new JTextField(10);

        lblCorreo = new JLabel("  Correo:");
        txtCorreo = new JTextField(10);

        lblOtraPersona = new JLabel("  Otra Persona:");
        txtOtraPersona = new JTextField(10);

        lblTelOtraPersona = new JLabel("  Teléfono Otra Persona:");
        txtTelOtraPersona = new JTextField(10);

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

        panelInferior.add(panelBotonAceptar);
        panelSegundario.add(panelFormularioPaciente);

        revalidar();
       // principalPanel.add(panelFormularios,BorderLayout.CENTER);
    }

    public void consultarOrden(){
        panelInferior.add(salir);
        vaciarPanelsegundario();
        JPanel panelConsultarOrden = new JPanel(new GridLayout(5,2));

        lblConsultaCedula = new JLabel("Ingrese numero de Cedula: ");
        txtConsultaCedula = new JTextField(10);

        panelConsultarOrden.add(lblConsultaCedula);
        panelConsultarOrden.add(txtConsultaCedula);

        JButton Consultar = new JButton("Consultar");
        JPanel panelBotonConsultar = new JPanel();
        panelBotonConsultar.add(Consultar);

        panelInferior.add(panelBotonConsultar);
        panelSegundario.add(panelConsultarOrden);

        revalidar();
    }

    public void consultarPaciente(){
        panelInferior.add(salir);
        vaciarPanelsegundario();
        JPanel panelConsultarpaciente = new JPanel(new GridLayout(5,2));

        lblConsultaCedula = new JLabel("Ingrese numero de Cedula: ");
        txtConsultaCedula = new JTextField(10);

        panelConsultarpaciente.add(lblConsultaCedula);
        panelConsultarpaciente.add(txtConsultaCedula);

        JButton Consultar = new JButton("Consultar");
        JPanel panelBotonConsultar = new JPanel();
        panelBotonConsultar.add(Consultar);

        panelInferior.add(panelBotonConsultar);
        panelSegundario.add(panelConsultarpaciente);

        revalidar();
    }

    public void consultarMedico(){
        panelInferior.add(salir);
        vaciarPanelsegundario();
        JPanel panelConsultarMedico = new JPanel(new GridLayout(5,2));

        lblConsultaTarjetaProfesional = new JLabel("Ingrese numero de Cedula: ");
        txtConsultaTarjetaProfesional = new JTextField(10);

        panelConsultarMedico.add(lblConsultaTarjetaProfesional);
        panelConsultarMedico.add(txtConsultaTarjetaProfesional);

        JButton Consultar = new JButton("Consultar");
        JPanel panelBotonConsultar = new JPanel();
        panelBotonConsultar.add(Consultar);

        panelInferior.add(panelBotonConsultar);
        panelSegundario.add(panelConsultarMedico);

        revalidar();
    }
    public void agregarMedico() {
        panelInferior.add(salir);
        vaciarPanelsegundario();

        JPanel panelAgregarMedico = new JPanel(new GridLayout(5, 2));

        lblTarjetaProfesional = new JLabel("Ingrese No. TP: ");
        txtTarjetaProfesional = new JTextField(10);

        lblRegistroNombreMedico = new JLabel("Ingrese el nombre del medico: ");
        txtRegistroNombreMedico = new JTextField(10);

        lblRegistroApellidosMedico = new JLabel("Ingrese apellidos: ");
        txtRegistroApellidosMedico = new JTextField(10);

        lblTelefonoMedico = new JLabel("Ingrese Numero de telefono: ");
        txtTelefonoMedico = new JTextField(10);

        lblDireccionMedico = new JLabel("Direccion: ");
        txtDireccionMedico = new JTextField(10);

        lblEspecialidad = new JLabel("Especialidad: ");
        txtEspecialidad = new JTextField(10);

        panelAgregarMedico.add(lblTarjetaProfesional);
        panelAgregarMedico.add(txtTarjetaProfesional);

        panelAgregarMedico.add(lblRegistroNombreMedico);
        panelAgregarMedico.add(txtRegistroNombreMedico);

        panelAgregarMedico.add(lblRegistroApellidosMedico);
        panelAgregarMedico.add(txtRegistroApellidosMedico);

        panelAgregarMedico.add(lblTelefonoMedico);
        panelAgregarMedico.add(txtTelefonoMedico);

        panelAgregarMedico.add(lblDireccionMedico);
        panelAgregarMedico.add(txtDireccionMedico);

        panelAgregarMedico.add(lblEspecialidad);
        panelAgregarMedico.add(txtEspecialidad);

        JButton aceptarConsultarMedico = new JButton("Aceptar");
        JPanel botonConsultarMedico = new JPanel();
        botonConsultarMedico.add(aceptarConsultarMedico);

        panelInferior.add(botonConsultarMedico); // Agrega el panel del botón
        panelSegundario.add(panelAgregarMedico);
        revalidar();
    }
    public void PanelExtractoMensual(){
        vaciarPanelsegundario();
        totalAPagar = new JButton("Descargar total a pagar");
        consultarPorFactura = new JButton("Consultar por factura");
        resultadosMedico = new JButton("Descargar Consolidado medico");

        totalAPagar.addActionListener(listener);
        consultarPorFactura.addActionListener(listener);


        panelSegundario.add(totalAPagar);
        panelSegundario.add(consultarPorFactura);
        panelSegundario.add(resultadosMedico);

        revalidar();
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
        if (e.getSource()==GUI.this.crearOrden){
            System.out.println("Panel");
            panelCrearOrden();
        }
        if (e.getSource()==GUI.this.consultarOrden){
            consultarOrden();
        }
        if (e.getSource()==GUI.this.pacientes){
            System.out.println("Crear");
            panelPacientes();
        }
        if (e.getSource()==GUI.this.crearPaciente){
            System.out.println("Panel paciente");
            crearPaciente();
        }
        if (e.getSource()==GUI.this.consultarPaciente){
            consultarPaciente();
        }
        if (e.getSource()==GUI.this.medicos){
            panelMedicos();
        }
        if (e.getSource()==GUI.this.consultarMedico){
            consultarMedico();
        }
        if (e.getSource()==GUI.this.crearMedico){
            agregarMedico();
        }
        if (e.getSource()==GUI.this.generarMensual){
            PanelExtractoMensual();
        }

        if (e.getSource()==GUI.this.salir){

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