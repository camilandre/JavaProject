package Vistas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class Carga extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblPorcentaje;
	private JLabel lblCamilaSnchez;
	private JLabel lblCargandoMdulos;
	private JLabel lblIconoDiente;
	private JLabel lblTituloAdministracion;
	
	

	public static void main(String[] args) {
		
			Carga inter = new Carga();
			inter.setVisible(true);
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(30);
					inter.progressBar.setValue(i);
					inter.lblPorcentaje.setText(Integer.toString(i) + "%");	
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}	
			}
			new Entrada().setVisible(true);
			inter.dispose();
	}

	/**
	 * Create the frame.
	 */
	public Carga() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTituloAdministracion = new JLabel("Clinica Dental El Dientito Feliz");
		lblTituloAdministracion.setForeground(new Color(114, 209, 237));
		lblTituloAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAdministracion.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblTituloAdministracion.setBounds(0, 11, 778, 45);
		panel.add(lblTituloAdministracion);
		
		lblIconoDiente = new JLabel("");
		lblIconoDiente.setIcon(new ImageIcon(Carga.class.getResource("/Imagenes/DienteImagen.png")));
		lblIconoDiente.setBounds(316, 67, 141, 162);
		panel.add(lblIconoDiente);
		
		lblCargandoMdulos = new JLabel("Cargando m\u00F3dulos...");
		lblCargandoMdulos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargandoMdulos.setForeground(new Color(114, 209, 237));
		lblCargandoMdulos.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblCargandoMdulos.setBounds(10, 279, 270, 45);
		panel.add(lblCargandoMdulos);
		
		lblCamilaSnchez = new JLabel("Por Camila S\u00E1nchez");
		lblCamilaSnchez.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamilaSnchez.setForeground(new Color(114, 209, 237));
		lblCamilaSnchez.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblCamilaSnchez.setBounds(316, 302, 167, 33);
		panel.add(lblCamilaSnchez);
		
		lblPorcentaje = new JLabel("%");
		lblPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentaje.setForeground(new Color(114, 209, 237));
		lblPorcentaje.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblPorcentaje.setBounds(232, 279, 38, 45);
		panel.add(lblPorcentaje);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(135, 206, 250));
		progressBar.setBounds(0, 346, 778, 14);
		panel.add(progressBar);
	}

	
}