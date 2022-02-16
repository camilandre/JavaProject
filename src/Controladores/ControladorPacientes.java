package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.Informacion;
import Vistas.Pacientes;
import net.proteanit.sql.DbUtils;

public class ControladorPacientes implements Informacion {
	
	private Pacientes vistaPacientes; 
	
	public ControladorPacientes() throws SQLException { 
		this.vistaPacientes= new Pacientes(); 
		asociaListeners();
		limpiar();
		listaPacientes();
		vistaPacientes.setVisible(true);
	}
	
	
	private void asociaListeners() {
		vistaPacientes.btnGuardar.addActionListener(new guardaActionListener());
		vistaPacientes.btnBorrar.addActionListener(new borraActionListener());
		vistaPacientes.btnEditar.addActionListener(new editaActionListener());
		vistaPacientes.btnLimpiar.addActionListener(new limpiaActionListener());
		vistaPacientes.tablaPacientes.addMouseListener(new deTablaACamposDeTextoMouseListener());
	}
	
	
	private class deTablaACamposDeTextoMouseListener implements MouseListener  {

		public void mouseClicked(MouseEvent e) {

			DefaultTableModel modelo= (DefaultTableModel) vistaPacientes.tablaPacientes.getModel();
			int indice= vistaPacientes.tablaPacientes.getSelectedRow();
			vistaPacientes.key= Integer.valueOf(modelo.getValueAt(indice, 0).toString());
			vistaPacientes.nombrePaciente.setText(modelo.getValueAt(indice, 1).toString());
			vistaPacientes.textFieldTelefono.setText(modelo.getValueAt(indice, 2).toString());
			vistaPacientes.textFieldDireccion.setText(modelo.getValueAt(indice, 3).toString());
			vistaPacientes.comboBoxGenero.setSelectedItem(modelo.getValueAt(indice, 5).toString());
			vistaPacientes.textFieldAlergias.setText(modelo.getValueAt(indice, 6).toString());			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}
	
	
	private class limpiaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			limpiar();
		} 
	}
	
	private class editaActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(vistaPacientes.key == 0 ) {
				JOptionPane.showInputDialog(this, "Selecciona un paciente");
			} else {
				try {
					vistaPacientes.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "UPDATE pacientes SET NOMBRE_PACIENTE='"+ vistaPacientes.nombrePaciente.getText()+"'"+
					",TELEFONO_PACIENTE='"+ vistaPacientes.textFieldTelefono.getText()+"'"+
					",DIRECCION_PACIENTE='"+ vistaPacientes.textFieldDireccion.getText()+"'"+
					",ALERGIAS_PACIENTE='"+ vistaPacientes.textFieldAlergias.getText()+"'"+
					",GENERO_PACIENTE='"+ vistaPacientes.comboBoxGenero.getSelectedItem().toString()+"'"+
					",FECHA_NACIMIENTO_PACIENTE='"+ vistaPacientes.nacimientoPaciente.getDate().toString() + "'"+ 
					"WHERE ID=" + vistaPacientes.key;  
					Statement agregar= vistaPacientes.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Informacion del paciente editada exitosamente");
					 listaPacientes();
					 limpiar();
				} catch (Exception ex) {
					 JOptionPane.showInputDialog(this, "Asegurese de haber rellenado todos los campos");
				} 
			}
		}
		
	}
	private class borraActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(vistaPacientes.id < 0 ) {
				JOptionPane.showInputDialog(this, "Selecciona un paciente");
			} else {
				try {
					vistaPacientes.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "DELETE FROM pacientes WHERE ID=" + vistaPacientes.key;
					Statement agregar= vistaPacientes.con.createStatement();
					agregar.executeUpdate(Query);
					JOptionPane.showInputDialog(this, "Paciente borrado");
					listaPacientes();
					limpiar();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} 
			}
			
		}
	
	}
	
	private class guardaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(vistaPacientes.nombrePaciente.getText().isEmpty() || vistaPacientes.textFieldAlergias.getText().isEmpty() || vistaPacientes.textFieldDireccion.getText().isEmpty() || vistaPacientes.textFieldTelefono.getText().isEmpty()) {
				JOptionPane.showInputDialog(this, "No debe dejar campos vacios ");
			} else {
				try {
					 generaID();
					 vistaPacientes.con= DriverManager.getConnection(url, usuario, clave); 
					 PreparedStatement agregar= vistaPacientes.con.prepareStatement("INSERT INTO pacientes VALUES(?,?,?,?,?,?,?)");  
					 agregar.setInt(1, vistaPacientes.id);
					 agregar.setString(2, vistaPacientes.nombrePaciente.getText());
					 agregar.setString(3, vistaPacientes.textFieldTelefono.getText());
					 agregar.setString(4, vistaPacientes.textFieldDireccion.getText());
					 agregar.setString(5, vistaPacientes.nacimientoPaciente.getDate().toString());
					 agregar.setString(6, vistaPacientes.comboBoxGenero.getSelectedItem().toString());
					 agregar.setString(7, vistaPacientes.textFieldAlergias.getText());
					 @SuppressWarnings("unused")
					int fila = agregar.executeUpdate();
					 JOptionPane.showInputDialog(this, "Paciente agregado exitosamente");
					 vistaPacientes.con.close();
					 listaPacientes();
					 limpiar();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} 
			}
			
		}
		
	}
	
	
	private void limpiar() {
		vistaPacientes.nombrePaciente.setText("");
		vistaPacientes.textFieldTelefono.setText("");
		vistaPacientes.textFieldAlergias.setText("");
		vistaPacientes.textFieldDireccion.setText("");
		vistaPacientes.nacimientoPaciente.setDate(null);
		vistaPacientes.comboBoxGenero.setSelectedItem(null);
	}
	
	private void generaID() {
		
		try {
			vistaPacientes.St = vistaPacientes.con.createStatement(); 
			vistaPacientes.rsl = vistaPacientes.St.executeQuery("SELECT MAX(ID) FROM pacientes");
			vistaPacientes.rsl.next();
			vistaPacientes.id = vistaPacientes.rsl.getInt(1)+1;
		} catch(Exception exce) {
			System.out.println(exce.getMessage());
		}
	}
	
	private void listaPacientes() {
		try {
			vistaPacientes.con = DriverManager.getConnection(url, usuario, clave);
			vistaPacientes.St = vistaPacientes.con.createStatement(); 
			vistaPacientes.rs = vistaPacientes.St.executeQuery("SELECT * FROM pacientes");
			vistaPacientes.tablaPacientes.setModel(DbUtils.resultSetToTableModel(vistaPacientes.rs));
		}catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

	}


}
