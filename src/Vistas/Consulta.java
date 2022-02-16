package Vistas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Informacion;
import Controladores.ControladorInicio;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Consulta extends JFrame implements Informacion {

	public JPanel contentPane;
	public JTextField textClave;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBoxOpciones;
	public JLabel lblNewLabel;
	public JLabel generoPaciente;
	public JButton btnBuscar;
	public JLabel lblPacientes; 
	public JLabel Inicio;
	public JLabel lblElDientitoFeliz;
	public JLabel lblNewLabel_1_1;
	public JLabel lblConsulta;
	
	public Connection con = null;
	public Statement St= null;
	public ResultSet rs = null;
	public ResultSet rsl= null;
	private JTable tablaConsulta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void listaBusqueda() {
		
		String texto = comboBoxOpciones.getSelectedItem().toString();
		String claveBusqueda = textClave.getText(); 
		
		switch (texto) 	
		{
			case "ID":
				try {
					con = DriverManager.getConnection(url, usuario, clave);
					St = con.createStatement();
					String query = "SELECT * from pacientes WHERE ID='" + claveBusqueda + "'";
					rs = St.executeQuery(query);
					JOptionPane.showInputDialog(this, "Informacion encontrada!");
					tablaConsulta.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exc) {
					JOptionPane.showInputDialog(this, "No se encontro ninguna coincidencia");
				}
				break;
				
			case "NOMBRE": 
				try {
					con = DriverManager.getConnection(url, usuario, clave);
					St = con.createStatement();
					String query = "SELECT * from pacientes WHERE NOMBRE_PACIENTE LIKE '%" + claveBusqueda +"%'";
					rs = St.executeQuery(query);
					JOptionPane.showInputDialog(this, "Informacion encontrada!");
					tablaConsulta.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exc) {
					JOptionPane.showInputDialog(this, "No se encontro ninguna coincidencia");
				}
				break;
				
			case "TELEFONO": 
				try {
					con = DriverManager.getConnection(url, usuario, clave);
					St = con.createStatement();
					String query = "SELECT * from pacientes WHERE TELEFONO_PACIENTE='" + claveBusqueda +"'";
					rs = St.executeQuery(query);
					JOptionPane.showInputDialog(this, "Informacion encontrada!");
					tablaConsulta.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exc) {
					JOptionPane.showInputDialog(this, "No se encontro ninguna coincidencia");
				}
				break;
				
			case "GENERO": 
				
				if (claveBusqueda.equals("Mujer") || claveBusqueda.equals("Hombre") || claveBusqueda.equals("Sin especificar") ) {
					try {
						con = DriverManager.getConnection(url, usuario, clave);
						St = con.createStatement();
						String query = "SELECT * from pacientes WHERE GENERO_PACIENTE='" + claveBusqueda +"'";
						rs = St.executeQuery(query);
						JOptionPane.showInputDialog(this, "Informacion encontrada!");
						tablaConsulta.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception exc) {
						JOptionPane.showInputDialog(this, "No se encontro ninguna coincidencia");
						}
					} else {
						JOptionPane.showInputDialog(this, "Debe escribir: Mujer, Hombre o Sin especificar");
					}
				break;
				
		} 

	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Consulta() {
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 243, 384);
		contentPane.add(panel);
		
		lblConsulta = new JLabel("Consulta");
		lblConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblConsulta.setBounds(99, 56, 134, 45);
		panel.add(lblConsulta);
		
		lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Consulta.class.getResource("/Imagenes/PuntosDienteImagen.png")));
		lblNewLabel_1_1.setBounds(14, 28, 75, 93);
		panel.add(lblNewLabel_1_1);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 0, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		Inicio = new JLabel("Inicio");
		Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorInicio();
			}
		});
		Inicio.setHorizontalAlignment(SwingConstants.LEFT);
		Inicio.setForeground(Color.WHITE);
		Inicio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		Inicio.setBounds(81, 289, 75, 45);
		panel.add(Inicio);
		
		lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(Color.WHITE);
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblPacientes.setBounds(99, 89, 134, 45);
		panel.add(lblPacientes);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listaBusqueda();
				
			}
		});
		btnBuscar.setForeground(new Color(0, 191, 255));
		btnBuscar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnBuscar.setBackground(SystemColor.inactiveCaptionBorder);
		btnBuscar.setBounds(365, 98, 130, 36);
		contentPane.add(btnBuscar);
		
		generoPaciente = new JLabel("Consulta por:");
		generoPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		generoPaciente.setForeground(new Color(114, 209, 237));
		generoPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		generoPaciente.setBounds(263, 17, 166, 26);
		contentPane.add(generoPaciente);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Consulta.class.getResource("/Imagenes/cancelar.png")));
		lblNewLabel.setBounds(857, 0, 25, 29);
		contentPane.add(lblNewLabel);
		
		textClave = new JTextField();
		textClave.setBounds(429, 52, 147, 30);
		contentPane.add(textClave);
		textClave.setColumns(10);
		
		comboBoxOpciones = new JComboBox();
		comboBoxOpciones.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "NOMBRE", "TELEFONO", "GENERO"}));
		comboBoxOpciones.setForeground(Color.BLACK);
		comboBoxOpciones.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		comboBoxOpciones.setBackground(Color.WHITE);
		comboBoxOpciones.setBounds(262, 54, 142, 30);
		contentPane.add(comboBoxOpciones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 193, 603, 180);
		contentPane.add(scrollPane);
		
		tablaConsulta = new JTable();
		tablaConsulta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NOMBRE", "TELEFONO", "DIRECCION", "FECHA", "GENERO", "ALERGIAS"
			}
		));
		scrollPane.setViewportView(tablaConsulta);
		
		
	}
	

}
