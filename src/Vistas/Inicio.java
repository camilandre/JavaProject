package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Informacion;
import Controladores.ControladorCitas;
import Controladores.ControladorInicio;
import Controladores.ControladorPacientes;
import Controladores.ControladorPrescripciones;
import Controladores.ControladorTratamientos;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio extends JFrame implements Informacion {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel IconoPaciente;
	public JLabel iconoAgenda;
	public JLabel lblPacientes;
	public JLabel lblCitas;
	public JLabel Inicio;
	public JLabel lblElDientitoFeliz;
	public JLabel lblNewLabel_1_1;
	public JPanel panel;
	public JLabel Tratameintos;
	public JLabel Pacientes;
	
	public Connection con = null;
	public Statement St= null;
	public Statement St1= null;
	public Statement St2= null;
	public ResultSet rs = null;
	public ResultSet rs1= null;
	public ResultSet rs2= null;
	
	
	public  JLabel lblPrescripcion;
	public  JLabel iconoAgenda_1;
	public  JLabel numeroTratamientos;
	public  JLabel numeroPacientes;
	public  JLabel numPrescripciones;
	public  JLabel lblNewLabel_2;
	public  JLabel lblTratamientos;
	public  JLabel lblPrescripciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorInicio();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	
	/*
	 * private void getData() {
	 * 
	 * try { con= DriverManager.getConnection(url, usuario, clave); St=
	 * con.createStatement(); St1= con.createStatement(); St2=
	 * con.createStatement(); rs=
	 * St.executeQuery("SELECT COUNT (*) FROM pacientes"); rs1=
	 * St1.executeQuery("SELECT COUNT (*) FROM tratamientos"); rs2 =
	 * St2.executeQuery("SELECT COUNT (*) FROM prescripciones ");
	 * 
	 * while(rs.next()) { numeroPacientes.setText(""+ rs.getInt(1)); }
	 * while(rs1.next()) { numeroTratamientos.setText(""+ rs1.getInt(1)); }
	 * while(rs2.next()) { numPrescripciones.setText(""+ rs2.getInt(1)); }
	 * 
	 * } catch(Exception excep) { System.out.println(excep.getMessage()); }
	 * 
	 * }
	 */
	 
	
	public Inicio() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Tratameintos = new JLabel("Tratamientos");
		Tratameintos.setHorizontalAlignment(SwingConstants.LEFT);
		Tratameintos.setForeground(new Color(114, 209, 237));
		Tratameintos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		Tratameintos.setBounds(369, 118, 182, 45);
		contentPane.add(Tratameintos);
	
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 243, 560);
		contentPane.add(panel);
		
		Pacientes = new JLabel("Pacientes");
		Pacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ControladorPacientes();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Pacientes.setHorizontalAlignment(SwingConstants.LEFT);
		Pacientes.setForeground(Color.WHITE);
		Pacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		Pacientes.setBounds(51, 361, 134, 45);
		panel.add(Pacientes);
		
		lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/PuntosDienteImagen.png")));
		lblNewLabel_1_1.setBounds(51, 35, 75, 93);
		panel.add(lblNewLabel_1_1);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 0, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		Inicio = new JLabel("Inicio");
		Inicio.setHorizontalAlignment(SwingConstants.LEFT);
		Inicio.setForeground(Color.WHITE);
		Inicio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		Inicio.setBounds(131, 77, 112, 45);
		panel.add(Inicio);
		
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
		lblCitas.setBounds(78, 417, 69, 45);
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
		lblTratamientos.setBounds(41, 305, 154, 45);
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
		lblPrescripciones.setBounds(33, 249, 172, 45);
		panel.add(lblPrescripciones);
		
		lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(new Color(114, 209, 237));
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblPacientes.setBounds(770, 144, 124, 45);
		contentPane.add(lblPacientes);
		
		iconoAgenda = new JLabel("");
		iconoAgenda.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/cuaderno.png")));
		iconoAgenda.setHorizontalAlignment(SwingConstants.LEFT);
		iconoAgenda.setBounds(387, 159, 93, 94);
		contentPane.add(iconoAgenda);
		
		IconoPaciente = new JLabel("");
		IconoPaciente.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/pacienteP.png")));
		IconoPaciente.setBounds(746, 187, 93, 101);
		contentPane.add(IconoPaciente);
		
		lblPrescripcion = new JLabel("Prescripcion");
		lblPrescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrescripcion.setForeground(new Color(114, 209, 237));
		lblPrescripcion.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblPrescripcion.setBounds(519, 360, 182, 45);
		contentPane.add(lblPrescripcion);
		
		iconoAgenda_1 = new JLabel("");
		iconoAgenda_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/prescripcion.png")));
		iconoAgenda_1.setHorizontalAlignment(SwingConstants.LEFT);
		iconoAgenda_1.setBounds(540, 395, 104, 101);
		contentPane.add(iconoAgenda_1);
		
		numeroTratamientos = new JLabel("...");
		numeroTratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		numeroTratamientos.setForeground(new Color(255, 105, 180));
		numeroTratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		numeroTratamientos.setBounds(490, 187, 61, 45);
		contentPane.add(numeroTratamientos);
		
		numeroPacientes = new JLabel("...");
		numeroPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		numeroPacientes.setForeground(new Color(255, 105, 180));
		numeroPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		numeroPacientes.setBounds(859, 209, 61, 45);
		contentPane.add(numeroPacientes);
		
		numPrescripciones = new JLabel("...");
		numPrescripciones.setHorizontalAlignment(SwingConstants.LEFT);
		numPrescripciones.setForeground(new Color(255, 105, 180));
		numPrescripciones.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		numPrescripciones.setBounds(654, 427, 61, 45);
		contentPane.add(numPrescripciones);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/cancelar.png")));
		lblNewLabel_2.setBounds(988, 0, 25, 29);
		contentPane.add(lblNewLabel_2);
		
	}
}
