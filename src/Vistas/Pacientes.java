package Vistas;
import java.sql.Connection;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;

import Conexion.Informacion;
import Controladores.ControladorCitas;
import Controladores.ControladorInicio;
import Controladores.ControladorPacientes;
import Controladores.ControladorPrescripciones;
import Controladores.ControladorTratamientos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.SystemColor;

public class Pacientes extends JFrame implements Informacion{
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public JTextField nombrePaciente;
	public JTextField textFieldTelefono;
	public JTextField textFieldDireccion;
	public JTextField textFieldAlergias;
	public JLabel lblInicio;
	public JLabel puntoInicialPacientes;
	public JLabel lblElDientitoFeliz;
	public JLabel lblPacientes_1;
	public JLabel lblCitas;
	public JLabel lblPacientes;
	public JLabel lblNombre;
	public JLabel telefonoPaciente;
	public JLabel direccionPaciente;
	public JLabel generoPaciente; 
	@SuppressWarnings("rawtypes")
	public JComboBox comboBoxGenero;
	public JDateChooser nacimientoPaciente;
	public JLabel alergiasPaciente;
	public JLabel lblNacimiento;
	public JLabel lblListaPacientes;
	public JButton btnGuardar;
	public JButton btnEditar;
	public JButton btnBorrar;
	public JButton btnLimpiar;
	public JScrollPane scrollPane_1;
	public JScrollPane scrollPane_2;
	public Connection con = null;
	public Statement St= null;
	public ResultSet rs = null;
	public ResultSet rsl= null;
	public int key=0;
	public int id=0;
	public JTable tablaPacientes;
	public JScrollPane scrollPane;
	public JLabel lblNewLabel;
	public JLabel lblTratamientos;
	public JLabel lblPrescripciones;
	private JLabel lblConsultas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorPacientes();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pacientes() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 564);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 254, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 243, 564);
		panel.setBackground(new Color(114, 209, 237));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblInicio = new JLabel("Inicio");
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorInicio();
			}
		});
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblInicio.setBounds(86, 435, 69, 45);
		panel.add(lblInicio);
		
		puntoInicialPacientes = new JLabel("");
		puntoInicialPacientes.setIcon(new ImageIcon(Pacientes.class.getResource("/imagenes/PuntosDienteImagen.png")));
		puntoInicialPacientes.setBounds(1, 38, 75, 93);
		panel.add(puntoInicialPacientes);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 0, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		lblPacientes_1 = new JLabel("Pacientes");
		lblPacientes_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes_1.setForeground(Color.WHITE);
		lblPacientes_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPacientes_1.setBounds(86, 72, 112, 45);
		panel.add(lblPacientes_1);
		
		lblCitas = new JLabel("Citas");
		lblCitas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorCitas();
			}
		});
		lblCitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCitas.setForeground(Color.WHITE);
		lblCitas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblCitas.setBounds(86, 379, 69, 45);
		panel.add(lblCitas);
		
		lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorTratamientos();
			}
		});
		lblTratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamientos.setForeground(Color.WHITE);
		lblTratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblTratamientos.setBounds(44, 323, 154, 45);
		panel.add(lblTratamientos);
		
		lblPrescripciones = new JLabel("Prescripciones");
		lblPrescripciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorPrescripciones();
			}
		});
		lblPrescripciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrescripciones.setForeground(Color.WHITE);
		lblPrescripciones.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblPrescripciones.setBounds(41, 267, 176, 45);
		panel.add(lblPrescripciones);
		
		lblConsultas = new JLabel("Consultas");
		lblConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Consulta().setVisible(true);
			}
		});
		lblConsultas.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsultas.setForeground(Color.WHITE);
		lblConsultas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblConsultas.setBounds(66, 211, 123, 45);
		panel.add(lblConsultas);
		
		lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(new Color(114, 209, 237));
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		lblPacientes.setBounds(251, 0, 160, 58);
		contentPane.add(lblPacientes);
		
		nombrePaciente = new JTextField();
		nombrePaciente.setHorizontalAlignment(SwingConstants.LEFT);
		nombrePaciente.setColumns(10);
		nombrePaciente.setBounds(253, 91, 313, 26);
		contentPane.add(nombrePaciente);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(new Color(114, 209, 237));
		lblNombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNombre.setBounds(253, 63, 89, 26);
		contentPane.add(lblNombre);
		
		telefonoPaciente = new JLabel("Telefono");
		telefonoPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		telefonoPaciente.setForeground(new Color(114, 209, 237));
		telefonoPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		telefonoPaciente.setBounds(253, 128, 103, 26);
		contentPane.add(telefonoPaciente);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(253, 151, 313, 26);
		contentPane.add(textFieldTelefono);
		
		direccionPaciente = new JLabel("Direccion");
		direccionPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		direccionPaciente.setForeground(new Color(114, 209, 237));
		direccionPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		direccionPaciente.setBounds(588, 63, 112, 26);
		contentPane.add(direccionPaciente);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(585, 91, 143, 86);
		contentPane.add(scrollPane_2);
		
		textFieldDireccion = new JTextField();
		scrollPane_2.setViewportView(textFieldDireccion);
		textFieldDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDireccion.setColumns(10);
		
		generoPaciente = new JLabel("Genero");
		generoPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		generoPaciente.setForeground(new Color(114, 209, 237));
		generoPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		generoPaciente.setBounds(742, 128, 89, 26);
		contentPane.add(generoPaciente);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setForeground(Color.BLACK);
		comboBoxGenero.setBackground(new Color(255, 255, 255));
		comboBoxGenero.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"", "Hombre ", "Mujer", "Sin especificar"}));
		comboBoxGenero.setBounds(742, 151, 142, 26);
		contentPane.add(comboBoxGenero);
		
		nacimientoPaciente = new JDateChooser();
		nacimientoPaciente.setBounds(742, 91, 142, 26);
		contentPane.add(nacimientoPaciente);
		
		alergiasPaciente = new JLabel("Alergias");
		alergiasPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		alergiasPaciente.setForeground(new Color(114, 209, 237));
		alergiasPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		alergiasPaciente.setBounds(914, 63, 89, 26);
		contentPane.add(alergiasPaciente);
		
		lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNacimiento.setForeground(new Color(114, 209, 237));
		lblNacimiento.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNacimiento.setBounds(742, 63, 123, 26);
		contentPane.add(lblNacimiento);
		
		lblListaPacientes = new JLabel("Lista Pacientes");
		lblListaPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaPacientes.setForeground(new Color(114, 209, 237));
		lblListaPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		lblListaPacientes.setBounds(562, 250, 248, 44);
		contentPane.add(lblListaPacientes);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 191, 255));
		btnGuardar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		btnGuardar.setBounds(341, 205, 130, 34);
		contentPane.add(btnGuardar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(0, 191, 255));
		btnEditar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnEditar.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditar.setBounds(496, 205, 130, 34);
		contentPane.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 191, 255));
		btnBorrar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnBorrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnBorrar.setBounds(647, 205, 130, 34);
		contentPane.add(btnBorrar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(914, 99, 158, 81);
		contentPane.add(scrollPane_1);
		
		textFieldAlergias = new JTextField();
		scrollPane_1.setViewportView(textFieldAlergias);
		textFieldAlergias.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAlergias.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 191, 255));
		btnLimpiar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnLimpiar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpiar.setBounds(787, 205, 130, 34);
		contentPane.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 293, 837, 271);
		contentPane.add(scrollPane);
		
		tablaPacientes = new JTable(); 
		tablaPacientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
					"ID", "Nombre", "Telefono", "Direccion", "Fecha nacimiento", "Genero", "Alergias"
			}
		));
		scrollPane.setViewportView(tablaPacientes);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Pacientes.class.getResource("/imagenes/cancelar.png")));
		lblNewLabel.setBounds(1075, 0, 25, 29);
		contentPane.add(lblNewLabel);
		
	}
}
