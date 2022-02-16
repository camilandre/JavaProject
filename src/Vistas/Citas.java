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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Conexion.Informacion;
import Controladores.ControladorCitas;
import Controladores.ControladorInicio;
import Controladores.ControladorPacientes;
import Controladores.ControladorPrescripciones;
import Controladores.ControladorTratamientos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;


public class Citas extends JFrame implements Informacion {


	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable tablaCitas; 
	public JButton btnLimpiarCitas;
	public JButton btnBorrarCitas;
	public JButton btnEditarCitas;
	public JButton btnGuardarCitas;
	public JLabel lblNewLabel_1;
	public JScrollPane scrollPane;
	public JLabel lblCitas_1_1;
	public JDateChooser fechaCita;
	@SuppressWarnings("rawtypes")
	public JComboBox tratamiento;
	@SuppressWarnings("rawtypes")
	public JComboBox hora;
	@SuppressWarnings("rawtypes")
	public JComboBox nombrePaciente;
	public JLabel lblTratamientos;
	public JLabel lblHora;
	public JLabel lblPaciente;
	public JLabel lblFecha;
	public JLabel lblCitas_1;
	public JLabel lblNewLabel_2;
	public JLabel lblCitas;
	public JLabel lblPacientes_1;
	public JLabel lblElDientitoFeliz;
	public JLabel lblInicio;
	public JPanel panel;
	

	public Connection con = null;
	public Statement St= null;
	public ResultSet rs = null;
	public ResultSet rsl= null;
	public int citaId= 0;
	public JLabel lblPacientes;
	public JLabel lblPrescripciones;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorCitas();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Citas() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 569);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 243, 569);
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
		lblInicio.setBounds(41, 414, 69, 45);
		panel.add(lblInicio);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 0, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		lblPacientes_1 = new JLabel("Pacientes");
		lblPacientes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ControladorPacientes();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		lblPacientes_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes_1.setForeground(Color.WHITE);
		lblPacientes_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPacientes_1.setBounds(41, 358, 112, 45);
		panel.add(lblPacientes_1);
		
		lblCitas = new JLabel("Citas");
		lblCitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCitas.setForeground(Color.WHITE);
		lblCitas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblCitas.setBounds(124, 82, 69, 45);
		panel.add(lblCitas);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Citas.class.getResource("/imagenes/PuntosDienteImagen.png")));
		lblNewLabel_2.setBounds(41, 37, 88, 104);
		panel.add(lblNewLabel_2);
		
		lblPacientes = new JLabel("Tratamientos");
		lblPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorTratamientos();
			}
		});
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(Color.WHITE);
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPacientes.setBounds(39, 301, 154, 45);
		panel.add(lblPacientes);
		
		lblPrescripciones = new JLabel("Prescripciones");
		lblPrescripciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorPrescripciones();
			}
		});
		lblPrescripciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrescripciones.setForeground(Color.WHITE);
		lblPrescripciones.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPrescripciones.setBounds(41, 245, 179, 45);
		panel.add(lblPrescripciones);
		
		lblCitas_1 = new JLabel("Citas");
		lblCitas_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCitas_1.setForeground(new Color(114, 209, 237));
		lblCitas_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblCitas_1.setBounds(264, 11, 69, 45);
		contentPane.add(lblCitas_1);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(new Color(114, 209, 237));
		lblFecha.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblFecha.setBounds(274, 67, 89, 26);
		contentPane.add(lblFecha);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaciente.setForeground(new Color(114, 209, 237));
		lblPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblPaciente.setBounds(439, 67, 89, 26);
		contentPane.add(lblPaciente);
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setForeground(new Color(114, 209, 237));
		lblHora.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblHora.setBounds(698, 67, 89, 26);
		contentPane.add(lblHora);
		
		lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamientos.setForeground(new Color(114, 209, 237));
		lblTratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblTratamientos.setBounds(855, 67, 147, 26);
		contentPane.add(lblTratamientos);
		
		nombrePaciente = new JComboBox();
		nombrePaciente.setToolTipText("\r\n");
		nombrePaciente.setForeground(Color.BLACK);
		nombrePaciente.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		nombrePaciente.setBackground(Color.LIGHT_GRAY);
		nombrePaciente.setBounds(439, 97, 249, 29);
		contentPane.add(nombrePaciente);
		
		tratamiento = new JComboBox();
		tratamiento.setForeground(Color.BLACK);
		tratamiento.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		tratamiento.setBackground(Color.LIGHT_GRAY);
		tratamiento.setBounds(855, 97, 147, 29);
		contentPane.add(tratamiento);
		
		fechaCita = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		fechaCita.setBounds(271, 97, 147, 33);
		contentPane.add(fechaCita);
		
		lblCitas_1_1 = new JLabel("Lista de Citas");
		lblCitas_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCitas_1_1.setForeground(new Color(114, 209, 237));
		lblCitas_1_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblCitas_1_1.setBounds(542, 228, 262, 45);
		contentPane.add(lblCitas_1_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 284, 736, 240);
		contentPane.add(scrollPane);
		
		
		tablaCitas = new JTable();

		tablaCitas.setRowHeight(24);
		
		tablaCitas.setForeground(Color.BLACK);
		tablaCitas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaCitas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "NombrePaciente", "Tratamiento", "Fecha", "Hora"
			}
		));
		tablaCitas.getColumnModel().getColumn(1).setPreferredWidth(95);
		scrollPane.setViewportView(tablaCitas);
		
		btnGuardarCitas = new JButton("Guardar");
		btnGuardarCitas.setForeground(new Color(0, 191, 255));
		btnGuardarCitas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnGuardarCitas.setBackground(SystemColor.inactiveCaptionBorder);
		btnGuardarCitas.setBounds(362, 171, 130, 34);
		contentPane.add(btnGuardarCitas);
		
		btnBorrarCitas = new JButton("Borrar");
		btnBorrarCitas.setForeground(new Color(0, 191, 255));
		btnBorrarCitas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnBorrarCitas.setBackground(SystemColor.inactiveCaptionBorder);
		btnBorrarCitas.setBounds(668, 171, 130, 34);
		contentPane.add(btnBorrarCitas);
		
		btnEditarCitas = new JButton("Editar");
		btnEditarCitas.setForeground(new Color(0, 191, 255));
		btnEditarCitas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnEditarCitas.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditarCitas.setBounds(517, 171, 130, 34);
		contentPane.add(btnEditarCitas);
		
	
		btnLimpiarCitas = new JButton("Limpiar");
		btnLimpiarCitas.setForeground(new Color(0, 191, 255));
		btnLimpiarCitas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnLimpiarCitas.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpiarCitas.setBounds(819, 171, 130, 34);
		contentPane.add(btnLimpiarCitas);
	
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Citas.class.getResource("/imagenes/cancelar.png")));
		lblNewLabel_1.setBounds(1063, 0, 25, 29);
		contentPane.add(lblNewLabel_1);
		
		hora = new JComboBox();
		hora.setModel(new DefaultComboBoxModel(new String[] {"", "10AM", "11AM", "12AM", "2PM", "3PM", "4PM", "5PM", "6PM"}));
		hora.setBounds(698, 97, 136, 27);
		contentPane.add(hora);
	
	}
}
