
package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorPacientes;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Entrada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;
	private JLabel lblEquis;
	private JLabel lblIcono;
	private JLabel lblReset;
	private JButton btnInicioSesion;
	private JLabel lblContrasea;
	private JLabel lblUsuario;
	private JLabel lblTituloAdministracion_1;
	private JLabel lblSonrisasSanas;
	private JLabel lblPacientesFelices;
	private JLabel lblTituloAdministracion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entrada() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 254, 251));
		contentPane.setRequestFocusEnabled(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 287, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTituloAdministracion = new JLabel("Profesionales Expertos");
		lblTituloAdministracion.setBounds(10, 157, 279, 49);
		panel.add(lblTituloAdministracion);
		lblTituloAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAdministracion.setForeground(new Color(252, 252, 252 ));
		lblTituloAdministracion.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		
		lblPacientesFelices = new JLabel("Pacientes Felices");
		lblPacientesFelices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacientesFelices.setForeground(new Color(252, 252, 252));
		lblPacientesFelices.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblPacientesFelices.setBounds(10, 219, 236, 39);
		panel.add(lblPacientesFelices);
		
		lblSonrisasSanas = new JLabel("Sonrisas Sanas");
		lblSonrisasSanas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSonrisasSanas.setForeground(new Color(252, 252, 252));
		lblSonrisasSanas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSonrisasSanas.setBounds(10, 269, 236, 49);
		panel.add(lblSonrisasSanas);
		
		lblTituloAdministracion_1 = new JLabel("Clinica dental El Dientito Feliz");
		lblTituloAdministracion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAdministracion_1.setForeground(new Color(114, 209, 237));
		lblTituloAdministracion_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblTituloAdministracion_1.setBounds(273, 12, 515, 31);
		contentPane.add(lblTituloAdministracion_1);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(114, 209, 237));
		lblUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblUsuario.setBounds(404, 207, 104, 29);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(new Color(114, 209, 237));
		lblContrasea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblContrasea.setBounds(390, 254, 117, 29);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(516, 253, 160, 27);
		contentPane.add(passwordField);
		
		btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if( textFieldUsuario.getText().isEmpty() || passwordField.getText().isEmpty() ) {
					JOptionPane.showInputDialog(this, "Introduce el usuario y la contrase�a");
				} else if (textFieldUsuario.getText().equals("Admin") && passwordField.getText().equals("Password")) {
					try {
						new ControladorPacientes();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
				}else {
					JOptionPane.showInputDialog(this, "Contrase�a o usuario incorrecto ");
					textFieldUsuario.setText("");
					passwordField.setText("");
				}
			}
		});
		
		btnInicioSesion.setBackground(SystemColor.inactiveCaptionBorder);
		btnInicioSesion.setForeground(new Color(0, 191, 255));
		btnInicioSesion.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnInicioSesion.setBounds(488, 311, 130, 34);
		contentPane.add(btnInicioSesion);
		
		lblReset = new JLabel("Reset");
		lblReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldUsuario.setText("");
				passwordField.setText("");
			}
		});
		lblReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset.setForeground(new Color(114, 209, 237));
		lblReset.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblReset.setBounds(498, 356, 104, 29);
		contentPane.add(lblReset);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(517, 206, 160, 26);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblIcono = new JLabel("");
		lblIcono.setBounds(461, 31, 141, 172);
		contentPane.add(lblIcono);
		lblIcono.setIcon(new ImageIcon(Entrada.class.getResource("/Imagenes/DienteImagen.png")));
		
		lblEquis = new JLabel("");
		lblEquis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblEquis.setIcon(new ImageIcon(Entrada.class.getResource("/imagenes/cancelar.png")));
		lblEquis.setBounds(765, 0, 25, 29);
		contentPane.add(lblEquis);
	}
}
