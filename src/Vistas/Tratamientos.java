package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Informacion;
import Controladores.ControladorCitas;
import Controladores.ControladorInicio;
import Controladores.ControladorPacientes;
import Controladores.ControladorPrescripciones;
import Controladores.ControladorTratamientos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class Tratamientos extends JFrame implements Informacion{

	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblInicio;
	public JLabel puntoInicialPacientes;
	public JLabel lblElDientitoFeliz;
	public JLabel lblTratamientos;
	public JLabel lblCitas;
	public JButton btnGuardarTratamiento;
	public JButton btnEditarTratamiento;
	public JButton btnBorrarTratamiento;
	public JButton btnLimpiarTratamiento;
	public JLabel Tratamientos;
	public JTextField textFieldNombre;
	public JLabel lblNombre;
	public JLabel lblCosto;
	public JTextField textFieldCosto;
	public JLabel lblMedicinas;
	public JTextField textFieldMedicinas;
	public JLabel lblListaPacientes;
	public JTable tablaTratamientos;
	public JScrollPane scrollPane;
	public Connection con = null;
	public Statement St= null;
	public ResultSet rs = null;
	public ResultSet rsl= null;
	public int treatId= 1000;
	public int key=1000;
	public JLabel lblNewLabel;
	public JLabel lblPrescripciones;
	public JLabel lblPacientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorTratamientos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Tratamientos() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 243, 561);
		contentPane.add(panel);
		
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
		lblInicio.setBounds(74, 464, 69, 45);
		panel.add(lblInicio);
		
		puntoInicialPacientes = new JLabel("");
		puntoInicialPacientes.setIcon(new ImageIcon(Tratamientos.class.getResource("/imagenes/PuntosDienteImagen.png")));
		puntoInicialPacientes.setBounds(1, 38, 75, 93);
		panel.add(puntoInicialPacientes);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 0, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamientos.setForeground(Color.WHITE);
		lblTratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblTratamientos.setBounds(79, 72, 154, 45);
		panel.add(lblTratamientos);
		
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
		lblCitas.setBounds(74, 403, 69, 45);
		panel.add(lblCitas);
		
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
		lblPrescripciones.setBounds(25, 288, 190, 45);
		panel.add(lblPrescripciones);
		
		lblPacientes = new JLabel("Pacientes");
		lblPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ControladorPacientes();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(Color.WHITE);
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblPacientes.setBounds(47, 347, 121, 45);
		panel.add(lblPacientes);
		
		btnGuardarTratamiento = new JButton("Guardar");
		btnGuardarTratamiento.setForeground(new Color(0, 191, 255));
		btnGuardarTratamiento.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnGuardarTratamiento.setBackground(SystemColor.inactiveCaptionBorder);
		btnGuardarTratamiento.setBounds(336, 203, 130, 34);
		contentPane.add(btnGuardarTratamiento);
		
		btnEditarTratamiento = new JButton("Editar");
		btnEditarTratamiento.setForeground(new Color(0, 191, 255));
		btnEditarTratamiento.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnEditarTratamiento.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditarTratamiento.setBounds(490, 203, 130, 34);
		contentPane.add(btnEditarTratamiento);
		
		btnBorrarTratamiento = new JButton("Borrar");
		btnBorrarTratamiento.setForeground(new Color(0, 191, 255));
		btnBorrarTratamiento.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnBorrarTratamiento.setBackground(SystemColor.inactiveCaptionBorder);
		btnBorrarTratamiento.setBounds(641, 203, 130, 34);
		contentPane.add(btnBorrarTratamiento);
		
		btnLimpiarTratamiento = new JButton("Limpiar");
		btnLimpiarTratamiento.setForeground(new Color(0, 191, 255));
		btnLimpiarTratamiento.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnLimpiarTratamiento.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpiarTratamiento.setBounds(781, 203, 130, 34);
		contentPane.add(btnLimpiarTratamiento);
		
		Tratamientos = new JLabel("Tratamientos");
		Tratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		Tratamientos.setForeground(new Color(114, 209, 237));
		Tratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		Tratamientos.setBounds(252, 11, 220, 58);
		contentPane.add(Tratamientos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(379, 80, 203, 26);
		contentPane.add(textFieldNombre);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(new Color(114, 209, 237));
		lblNombre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNombre.setBounds(379, 55, 89, 26);
		contentPane.add(lblNombre);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCosto.setForeground(new Color(114, 209, 237));
		lblCosto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblCosto.setBounds(379, 131, 89, 26);
		contentPane.add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(379, 152, 203, 26);
		contentPane.add(textFieldCosto);
		
		lblMedicinas = new JLabel("Medicinas");
		lblMedicinas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicinas.setForeground(new Color(114, 209, 237));
		lblMedicinas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblMedicinas.setBounds(622, 55, 224, 26);
		contentPane.add(lblMedicinas);
		
		textFieldMedicinas = new JTextField();
		textFieldMedicinas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMedicinas.setColumns(10);
		textFieldMedicinas.setBounds(622, 80, 223, 98);
		contentPane.add(textFieldMedicinas);
		
		lblListaPacientes = new JLabel("Lista Tratamientos");
		lblListaPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaPacientes.setForeground(new Color(114, 209, 237));
		lblListaPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		lblListaPacientes.setBounds(500, 248, 299, 44);
		contentPane.add(lblListaPacientes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 295, 744, 231);
		contentPane.add(scrollPane);
		
		tablaTratamientos = new JTable();
		tablaTratamientos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "NOMBRE PACIENTE", "TRATAMIENTO", "COSTO", "MEDICINA"
			}
		));
		scrollPane.setViewportView(tablaTratamientos);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Tratamientos.class.getResource("/imagenes/cancelar.png")));
		lblNewLabel.setBounds(1059, 0, 25, 29);
		contentPane.add(lblNewLabel);

	}
}
