
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Informacion;
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
public class Prescripciones extends JFrame implements Informacion {

	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblInicio;
	public JLabel lblElDientitoFeliz;
	public JLabel lblPacientes;
	public JLabel Prescripciones;
	public JLabel lblNewLabel_2;
	public JLabel lblTratamiento;
	public JLabel lblCosto;
	public JLabel lblPrescripciones;
	public JLabel lblPaciente;
	public JLabel lblCantidad;
	public JLabel medicinas;
	public JLabel lblListaPacientes;
	
	public JTextField textFieldMedicinas;
	public JTextField textFieldCantidad;
	public JTextField textFieldCosto;
	@SuppressWarnings("rawtypes")
	public JComboBox nombrePaciente;
	
	public JScrollPane scrollPane_1;
	public JScrollPane scrollPane;
	
	public JButton btnGuardarPr;
	public JButton btnEditarPr;
	public JButton btnBorrarPr;
	public JButton btnLimpiarPr;
	
	public JTable tablaPrescripciones;

	public Connection con = null;
	public Statement St= null;
	public ResultSet rs = null;
	public ResultSet rsl= null;
	public int ID=0;
	public int key= 1000;
	@SuppressWarnings("rawtypes")
	public JComboBox tratamientoJCb;
	public JLabel lblNewLabel_3;
	public JLabel lblTratamientos;
	public JLabel lblPrescripciones_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorPrescripciones();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings("rawtypes")
	public Prescripciones() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(114, 209, 237));
		panel.setBounds(0, 0, 243, 548);
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
		lblInicio.setBounds(86, 421, 69, 45);
		panel.add(lblInicio);
		
		lblElDientitoFeliz = new JLabel("El Dientito Feliz");
		lblElDientitoFeliz.setHorizontalAlignment(SwingConstants.LEFT);
		lblElDientitoFeliz.setForeground(Color.WHITE);
		lblElDientitoFeliz.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblElDientitoFeliz.setBounds(41, 11, 179, 45);
		panel.add(lblElDientitoFeliz);
		
		lblPacientes = new JLabel("Pacientes");
		lblPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ControladorPacientes();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		lblPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacientes.setForeground(Color.WHITE);
		lblPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPacientes.setBounds(62, 365, 112, 45);
		panel.add(lblPacientes);
		
		Prescripciones = new JLabel("Citas");
		Prescripciones.setHorizontalAlignment(SwingConstants.LEFT);
		Prescripciones.setForeground(Color.WHITE);
		Prescripciones.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		Prescripciones.setBounds(124, 73, 69, 45);
		panel.add(Prescripciones);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Prescripciones.class.getResource("/imagenes/PuntosDienteImagen.png")));
		lblNewLabel_2.setBounds(26, 31, 88, 104);
		panel.add(lblNewLabel_2);
		
		lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorTratamientos();
			}
		});
		lblTratamientos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamientos.setForeground(Color.WHITE);
		lblTratamientos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblTratamientos.setBounds(41, 309, 152, 45);
		panel.add(lblTratamientos);
		
		lblPrescripciones_1 = new JLabel("Prescripciones");
		lblPrescripciones_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorPrescripciones();
			}
		});
		lblPrescripciones_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrescripciones_1.setForeground(Color.WHITE);
		lblPrescripciones_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblPrescripciones_1.setBounds(26, 253, 166, 45);
		panel.add(lblPrescripciones_1);
		
		lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblTratamiento.setForeground(new Color(114, 209, 237));
		lblTratamiento.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblTratamiento.setBounds(286, 80, 119, 26);
		contentPane.add(lblTratamiento);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCosto.setForeground(new Color(114, 209, 237));
		lblCosto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblCosto.setBounds(286, 156, 89, 26);
		contentPane.add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(286, 177, 203, 26);
		contentPane.add(textFieldCosto);
		
		lblPrescripciones = new JLabel("Prescripciones");
		lblPrescripciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrescripciones.setForeground(new Color(114, 209, 237));
		lblPrescripciones.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		lblPrescripciones.setBounds(253, 11, 249, 58);
		contentPane.add(lblPrescripciones);
		
		nombrePaciente = new JComboBox();
		nombrePaciente.setToolTipText("\r\n");
		nombrePaciente.setForeground(Color.BLACK);
		nombrePaciente.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		nombrePaciente.setBackground(Color.LIGHT_GRAY);
		nombrePaciente.setBounds(525, 105, 268, 29);
		contentPane.add(nombrePaciente);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaciente.setForeground(new Color(114, 209, 237));
		lblPaciente.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblPaciente.setBounds(525, 80, 89, 26);
		contentPane.add(lblPaciente);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setForeground(new Color(114, 209, 237));
		lblCantidad.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblCantidad.setBounds(499, 156, 89, 26);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(499, 180, 159, 26);
		contentPane.add(textFieldCantidad);
		
		medicinas = new JLabel("Medicinas");
		medicinas.setHorizontalAlignment(SwingConstants.LEFT);
		medicinas.setForeground(new Color(114, 209, 237));
		medicinas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		medicinas.setBounds(803, 80, 126, 26);
		contentPane.add(medicinas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(804, 105, 177, 98);
		contentPane.add(scrollPane);
		
		textFieldMedicinas = new JTextField();
		scrollPane.setViewportView(textFieldMedicinas);
		textFieldMedicinas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMedicinas.setColumns(10);
		
		btnGuardarPr = new JButton("Guardar");
		btnGuardarPr.setForeground(new Color(0, 191, 255));
		btnGuardarPr.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnGuardarPr.setBackground(SystemColor.inactiveCaptionBorder);
		btnGuardarPr.setBounds(372, 223, 130, 34);
		contentPane.add(btnGuardarPr);
		
		btnEditarPr = new JButton("Editar");
		btnEditarPr.setForeground(new Color(0, 191, 255));
		btnEditarPr.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnEditarPr.setBackground(SystemColor.inactiveCaptionBorder);
		btnEditarPr.setBounds(519, 223, 130, 34);
		contentPane.add(btnEditarPr);
		
		btnBorrarPr = new JButton("Borrar");
		btnBorrarPr.setForeground(new Color(0, 191, 255));
		btnBorrarPr.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnBorrarPr.setBackground(SystemColor.inactiveCaptionBorder);
		btnBorrarPr.setBounds(659, 223, 130, 34);
		contentPane.add(btnBorrarPr);
		
		btnLimpiarPr = new JButton("Limpiar");
		btnLimpiarPr.setForeground(new Color(0, 191, 255));
		btnLimpiarPr.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnLimpiarPr.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpiarPr.setBounds(803, 223, 130, 34);
		contentPane.add(btnLimpiarPr);
		
		lblListaPacientes = new JLabel("Lista Pacientes");
		lblListaPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaPacientes.setForeground(new Color(114, 209, 237));
		lblListaPacientes.setFont(new Font("Yu Gothic Medium", Font.BOLD, 31));
		lblListaPacientes.setBounds(519, 268, 248, 44);
		contentPane.add(lblListaPacientes);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(276, 311, 795, 226);
		contentPane.add(scrollPane_1);
		
		tablaPrescripciones = new JTable();
		tablaPrescripciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelo= (DefaultTableModel) tablaPrescripciones.getModel();
				int indice= tablaPrescripciones.getSelectedRow();
				key= Integer.valueOf(modelo.getValueAt(indice, 0).toString());
				tratamientoJCb.setSelectedItem(modelo.getValueAt(indice, 1).toString());
				textFieldCosto.setText(modelo.getValueAt(indice, 2).toString());
				nombrePaciente.setSelectedItem(modelo.getValueAt(indice, 3));
				textFieldCantidad.setText(modelo.getValueAt(indice, 4).toString());
				textFieldMedicinas.setText(modelo.getValueAt(indice, 5).toString());
			}
		});
		tablaPrescripciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NombrePaciente", "Tratamientos", "Costo", "Medicinas", "Cantidad"
			}
		));
		scrollPane_1.setViewportView(tablaPrescripciones);
		
		tratamientoJCb = new JComboBox();
		tratamientoJCb.setToolTipText("\r\n");
		tratamientoJCb.setForeground(Color.BLACK);
		tratamientoJCb.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		tratamientoJCb.setBackground(Color.LIGHT_GRAY);
		tratamientoJCb.setBounds(286, 107, 229, 29);
		contentPane.add(tratamientoJCb);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Prescripciones.class.getResource("/imagenes/cancelar.png")));
		lblNewLabel_3.setBounds(1086, 0, 25, 29);
		contentPane.add(lblNewLabel_3);
	}
}
