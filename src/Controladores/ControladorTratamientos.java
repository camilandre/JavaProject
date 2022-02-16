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
import Vistas.Tratamientos;
import net.proteanit.sql.DbUtils;

public class ControladorTratamientos implements Informacion {
	
	private Tratamientos vistaTratamientos; 
	
	public ControladorTratamientos() {
		this.vistaTratamientos= new Tratamientos();
		asociaListeners();
		listaTratamientos();
		vistaTratamientos.setVisible(true);
	}
	
	private void asociaListeners() {
		vistaTratamientos.btnBorrarTratamiento.addActionListener(new borraActionListener());
		vistaTratamientos.btnEditarTratamiento.addActionListener(new editaActionListener());
		vistaTratamientos.btnLimpiarTratamiento.addActionListener(new limpiaActionListener());
		vistaTratamientos.btnGuardarTratamiento.addActionListener(new guardaActionListener());
		vistaTratamientos.tablaTratamientos.addMouseListener(new deTablaACamposDeTextoMouseListener());

	}
	
	private class deTablaACamposDeTextoMouseListener implements MouseListener  {

		public void mouseClicked(MouseEvent e) {
			DefaultTableModel modelo= (DefaultTableModel) vistaTratamientos.tablaTratamientos.getModel();
			int indice= vistaTratamientos.tablaTratamientos.getSelectedRow();
			vistaTratamientos.key= Integer.valueOf(modelo.getValueAt(indice, 0).toString());
			vistaTratamientos.textFieldNombre.setText(modelo.getValueAt(indice, 1).toString());
			vistaTratamientos.textFieldCosto.setText(modelo.getValueAt(indice, 2).toString());
			vistaTratamientos.textFieldMedicinas.setText(modelo.getValueAt(indice, 3).toString());
		
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
	
	private class borraActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(vistaTratamientos.key == 1000 ) {
				JOptionPane.showInputDialog(this, "Selecciona un tratamiento");
			} else {
				try {
					vistaTratamientos.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "DELETE FROM tratamientos WHERE treatId=" + vistaTratamientos.key;
					Statement agregar= vistaTratamientos.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Tratamiento borrado");
					 listaTratamientos();
					 limpiar();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} 
			}	
		}
	}
	
	private class editaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(vistaTratamientos.key == 1000 ) {
				JOptionPane.showInputDialog(this, "Selecciona un tratamiento");
			} else {
				try {
					vistaTratamientos.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "UPDATE tratamientos SET NOMBRE_TRATAMIENTO='"+ vistaTratamientos.textFieldNombre.getText()+"'"+",COSTO_TRATAMIENTO='"+ vistaTratamientos.textFieldCosto.getText()+"'"+
					",MEDICINAS_TRATAMIENTO='"+ vistaTratamientos.textFieldMedicinas.getText()+"'"+ "WHERE treatId=" + vistaTratamientos.key;  
					Statement agregar= vistaTratamientos.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Informacion del tratamiento editada exitosamente");
					 listaTratamientos();
					 limpiar();
				} catch (Exception ex) {
					 JOptionPane.showInputDialog(this, "Asegurese de haber rellenado todos los campos");
				} 
			}
		}
	}
	
	private class guardaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(vistaTratamientos.textFieldNombre.getText().isEmpty() || vistaTratamientos.textFieldCosto.getText().isEmpty() || vistaTratamientos.textFieldMedicinas.getText().isEmpty() ) {
				JOptionPane.showInputDialog(this, "No debe dejar campos vacios ");
			} else {
				try {
					 //int clav= 1; 
					tratarID();
					vistaTratamientos.con= DriverManager.getConnection(url, usuario, clave); 
					 PreparedStatement agregar= vistaTratamientos.con.prepareStatement("INSERT INTO tratamientos VALUES(?,?,?,?)");  
					 agregar.setInt(1, vistaTratamientos.treatId);
					 agregar.setString(2, vistaTratamientos.textFieldNombre.getText());
					 agregar.setInt(3, Integer.valueOf(vistaTratamientos.textFieldCosto.getText()));
					 agregar.setString(4, vistaTratamientos.textFieldMedicinas.getText());
					 @SuppressWarnings("unused")
					int fila = agregar.executeUpdate();
					 JOptionPane.showInputDialog(this, "Tratamiento agregado exitosamente");
					 vistaTratamientos.con.close();
					 limpiar();
					 listaTratamientos();
				} catch (Exception ex) {
					System.out.println("No se puede crear conexion");
				} 
			}
			
		}
	}

	private void tratarID() {
		
		try {
			vistaTratamientos.St = vistaTratamientos.con.createStatement(); 
			vistaTratamientos.rsl = vistaTratamientos.St.executeQuery("SELECT MAX(TREATID) FROM tratamientos");
			vistaTratamientos.rsl.next();
			vistaTratamientos.treatId = vistaTratamientos.rsl.getInt(1)+1;
		} catch(Exception exce) {
			System.out.println(exce.getMessage());
		}
		
	}
	
	private void listaTratamientos() {
		try {
			vistaTratamientos.con = DriverManager.getConnection(url, usuario, clave);
			vistaTratamientos.St = vistaTratamientos.con.createStatement(); 
			vistaTratamientos.rs = vistaTratamientos.St.executeQuery("SELECT * FROM tratamientos");
			vistaTratamientos.tablaTratamientos.setModel(DbUtils.resultSetToTableModel(vistaTratamientos.rs));
		}catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	
	private void limpiar() {
		vistaTratamientos.textFieldNombre.setText("");
		vistaTratamientos.textFieldCosto.setText("");
		vistaTratamientos.textFieldMedicinas.setText("");
		vistaTratamientos.key =1000;
	}
}
