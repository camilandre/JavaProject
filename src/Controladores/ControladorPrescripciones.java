package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.Informacion;
import Vistas.Prescripciones;
import net.proteanit.sql.DbUtils;

public class ControladorPrescripciones implements Informacion{
	
	private Prescripciones vistaPrescripciones; 
	
	public ControladorPrescripciones() {
		this.vistaPrescripciones= new Prescripciones();
		asociaListeners();
		getPacientes();
		getTratamientos();
		listaPrescripciones();
		vistaPrescripciones.setVisible(true);
	}
	
	
	private void asociaListeners() {
		vistaPrescripciones.btnGuardarPr.addActionListener(new guardaActionListener());
		vistaPrescripciones.btnBorrarPr.addActionListener(new borraActionListener());
		vistaPrescripciones.btnEditarPr.addActionListener(new editaActionListener());
		vistaPrescripciones.btnLimpiarPr.addActionListener(new limpiaActionListener());
		vistaPrescripciones.tablaPrescripciones.addMouseListener(new deTablaACamposDeTextoMouseListener() );
	}
	
	private class deTablaACamposDeTextoMouseListener implements MouseListener  {

		public void mouseClicked(MouseEvent e) {
			
			DefaultTableModel modelo= (DefaultTableModel) vistaPrescripciones.tablaPrescripciones.getModel();
			int indice= vistaPrescripciones.tablaPrescripciones.getSelectedRow();
			vistaPrescripciones.key= Integer.valueOf(modelo.getValueAt(indice, 0).toString());
			vistaPrescripciones.tratamientoJCb.setSelectedItem(modelo.getValueAt(indice, 1).toString());
			vistaPrescripciones.textFieldCosto.setText(modelo.getValueAt(indice, 2).toString());
			vistaPrescripciones.nombrePaciente.setSelectedItem(modelo.getValueAt(indice, 3));
			vistaPrescripciones.textFieldCantidad.setText(modelo.getValueAt(indice, 4).toString());
			vistaPrescripciones.textFieldMedicinas.setText(modelo.getValueAt(indice, 5).toString());
		
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
			if(vistaPrescripciones.key == 1000 ) {
				JOptionPane.showInputDialog(this, "Selecciona una prescripcion");
			} else {
				try {
					vistaPrescripciones.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "UPDATE prescripciones SET TRATAMIENTOS_PR='"+ vistaPrescripciones.tratamientoJCb.getSelectedItem().toString()+"'"+",COSTO_PR='"+vistaPrescripciones.textFieldCosto.getText()+"'"+
					",PACIENTE_PR='"+ vistaPrescripciones.nombrePaciente.getSelectedItem().toString()+"'"+",CANTIDAD_PR='"+ vistaPrescripciones.textFieldCantidad.getText() + "'"+ ",MEDICINAS_PR='"+ vistaPrescripciones.textFieldMedicinas.getText() + "'" + 
				    "WHERE ID=" + vistaPrescripciones.key;  
					Statement agregar= vistaPrescripciones.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Informacion del tratamiento editada exitosamente");
					 listaPrescripciones();
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
			if(vistaPrescripciones.key == 1000 ) {
				JOptionPane.showInputDialog(this, "Selecciona una prescripcion");
			} else {
				try {
					vistaPrescripciones.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "DELETE FROM prescripciones WHERE ID=" + vistaPrescripciones.key;
					Statement agregar= vistaPrescripciones.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Prescripcion borrada");
					 listaPrescripciones();
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
			if(vistaPrescripciones.tratamientoJCb.getSelectedIndex()== -1 || vistaPrescripciones.textFieldCosto.getText().isEmpty() || vistaPrescripciones.textFieldMedicinas.getText().isEmpty() || vistaPrescripciones.textFieldCantidad.getText().isEmpty() || vistaPrescripciones.nombrePaciente.getSelectedIndex()== -1) {
				JOptionPane.showInputDialog(this, "No debe dejar campos vacios ");
			} else {
				try { 
					tratarID();
					vistaPrescripciones.con= DriverManager.getConnection(url, usuario, clave); 
					 PreparedStatement agregar= vistaPrescripciones.con.prepareStatement("INSERT INTO prescripciones VALUES(?,?,?,?,?,?)");  
					 agregar.setInt(1, vistaPrescripciones.ID);
					 agregar.setString(2, vistaPrescripciones.tratamientoJCb.getSelectedItem().toString());
					 agregar.setInt(3, Integer.valueOf(vistaPrescripciones.textFieldCosto.getText()));
					 agregar.setString(4, vistaPrescripciones.nombrePaciente.getSelectedItem().toString());
					 agregar.setInt(5, Integer.valueOf(vistaPrescripciones.textFieldCantidad.getText()));
					 agregar.setString(6, vistaPrescripciones.textFieldMedicinas.getText());
					 
					 @SuppressWarnings("unused")
					int fila = agregar.executeUpdate();
					 JOptionPane.showInputDialog(this, "Prescripcion agregada exitosamente");
					 vistaPrescripciones.con.close();
					 listaPrescripciones();
					 limpiar();
				} catch (Exception ex) {
					System.out.println("No se puede crear conexion");
				} 
			}	
		}	
	}
	
	private void listaPrescripciones() {
		try {
			vistaPrescripciones.con = DriverManager.getConnection(url, usuario, clave);
			vistaPrescripciones.St = vistaPrescripciones.con.createStatement(); 
			vistaPrescripciones.rs = vistaPrescripciones.St.executeQuery("SELECT * FROM prescripciones");
			vistaPrescripciones.tablaPrescripciones.setModel(DbUtils.resultSetToTableModel(vistaPrescripciones.rs));
		}catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	
	private void limpiar() {
		vistaPrescripciones.textFieldCosto.setText("");
		vistaPrescripciones.textFieldCantidad.setText("");
		vistaPrescripciones.textFieldMedicinas.setText("");
	}
	
	@SuppressWarnings("unchecked")
	private void getPacientes() {
		try {
			vistaPrescripciones.con = DriverManager.getConnection(url, usuario, clave);
			vistaPrescripciones.St = vistaPrescripciones.con.createStatement(); 
			String query = "SELECT * from pacientes";
			vistaPrescripciones.rs = vistaPrescripciones.St.executeQuery(query);
			while(vistaPrescripciones.rs.next()) {
				String miPaciente= vistaPrescripciones.rs.getString("nombre_paciente"); 
				vistaPrescripciones.nombrePaciente.addItem(miPaciente);
				
			}
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void getTratamientos() {
		try {
			vistaPrescripciones.con = DriverManager.getConnection(url, usuario, clave);
			vistaPrescripciones.St = vistaPrescripciones.con.createStatement(); 
			String query = "SELECT * from tratamientos";
			vistaPrescripciones.rs = vistaPrescripciones.St.executeQuery(query);
			while(vistaPrescripciones.rs.next()) {
				String miTratamiento= vistaPrescripciones.rs.getString("NOMBRE_TRATAMIENTO"); 
				vistaPrescripciones.tratamientoJCb.addItem(miTratamiento);
				
			}
		} catch (Exception exc) {
		 System.out.println(exc.getMessage());	
		}
	}

	private void tratarID() {
		try {
			vistaPrescripciones.St = vistaPrescripciones.con.createStatement(); 
			vistaPrescripciones.rsl = vistaPrescripciones.St.executeQuery("SELECT MAX(ID) FROM prescripciones");
			vistaPrescripciones.rsl.next();
			vistaPrescripciones.ID = vistaPrescripciones.rsl.getInt(1)+1;
		} catch(Exception exce) {
			System.out.println(exce.getMessage());
		}
		
	}
}


