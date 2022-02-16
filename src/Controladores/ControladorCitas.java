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
import Vistas.Citas;
import net.proteanit.sql.DbUtils;

public class ControladorCitas implements Informacion{
	
	private Citas vistaCitas;
	
	public ControladorCitas() {
		this.vistaCitas= new Citas(); 
		asociaListeners();
		getPacientes();
		getTratamientos();
		listaCitas();
		vistaCitas.setVisible(true);
	}
	
	
	private void asociaListeners() {
		vistaCitas.btnGuardarCitas.addActionListener(new guardaActionListener());
		vistaCitas.btnBorrarCitas.addActionListener(new borraActionListener());
		vistaCitas.btnEditarCitas.addActionListener(new editaActionListener());
		vistaCitas.btnLimpiarCitas.addActionListener(new limpiaActionListener());
		vistaCitas.tablaCitas.addMouseListener(new deTablaACamposDeTextoMouseListener());
	}

	
	private class deTablaACamposDeTextoMouseListener implements MouseListener  {

		public void mouseClicked(MouseEvent e) {
			DefaultTableModel modelo= (DefaultTableModel) vistaCitas.tablaCitas.getModel();
			int indice= vistaCitas.tablaCitas.getSelectedRow();
			vistaCitas.citaId= Integer.valueOf(modelo.getValueAt(indice, 0).toString());
			vistaCitas.nombrePaciente.setSelectedItem(modelo.getValueAt(indice, 2).toString());
			vistaCitas.tratamiento.setSelectedItem(modelo.getValueAt(indice, 4).toString());
		
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
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
			if(vistaCitas.citaId == 0 ) {
				JOptionPane.showInputDialog(this, "Selecciona una cita");
			} else {
				try {
					vistaCitas.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "UPDATE citas SET FECHA_CITA='"+ vistaCitas.fechaCita.getDate().toString()+"'"+",PACIENTE='"+ vistaCitas.nombrePaciente.getSelectedItem().toString()+"'"+
					",HORA_CITA='"+ vistaCitas.hora.getSelectedItem().toString() +"'"+ ",TRATAMIENTO='"+ vistaCitas.tratamiento.getSelectedItem().toString() +"'" + "WHERE citaId=" + vistaCitas.citaId;  
					Statement agregar= vistaCitas.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Informacion de la cita editada exitosamente");
					 listaCitas();
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
			if(vistaCitas.citaId == 0 ) {
				JOptionPane.showInputDialog(this, "Selecciona una cita");
			} else {
				try {
					vistaCitas.con= DriverManager.getConnection(url, usuario, clave); 
					String Query = "DELETE FROM citas WHERE citaId=" + vistaCitas.citaId;
					Statement agregar= vistaCitas.con.createStatement();
					agregar.executeUpdate(Query);
					 JOptionPane.showInputDialog(this, "Cita eliminada exitosamente");
					 listaCitas();
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
			if(vistaCitas.nombrePaciente.getSelectedIndex() == -1 || vistaCitas.tratamiento.getSelectedIndex() == -1) {
				JOptionPane.showInputDialog(this, "No debe dejar campos vacios ");
			} else {
				try {
					tratarID();
					vistaCitas.con= DriverManager.getConnection(url, usuario, clave); 
					 PreparedStatement agregar= vistaCitas.con.prepareStatement("INSERT INTO citas VALUES(?,?,?,?,?)");  
					 agregar.setInt(1, vistaCitas.citaId);
					 agregar.setString(2, vistaCitas.fechaCita.getDate().toString());
					 agregar.setString(3, vistaCitas.nombrePaciente.getSelectedItem().toString());
					 agregar.setString(4, String.valueOf(vistaCitas.hora.getSelectedItem().toString()));
					 agregar.setString(5, vistaCitas.tratamiento.getSelectedItem().toString());
					 @SuppressWarnings("unused")
					int fila = agregar.executeUpdate();
					 JOptionPane.showInputDialog(this, "Cita agregada exitosamente");
					 vistaCitas.con.close();
					 limpiar();
					 listaCitas();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} 
			}
			
		}
		
	}
	
	
	private void limpiar() { 
			vistaCitas.nombrePaciente.setSelectedItem(0);
			vistaCitas.tratamiento.setSelectedItem(0);
		  }
	
	private void tratarID() {
		try {
			vistaCitas.St = vistaCitas.con.createStatement(); 
			vistaCitas.rsl = vistaCitas.St.executeQuery("SELECT MAX(citaId) FROM citas");
			vistaCitas.rsl.next();
			vistaCitas.citaId = vistaCitas.rsl.getInt(1)+1;
		} catch(Exception exce) {
			System.out.println(exce.getMessage());
		}
		
	}

	private void listaCitas() {
		try {
			vistaCitas.con = DriverManager.getConnection(url, usuario, clave);
			vistaCitas.St = vistaCitas.con.createStatement(); 
			vistaCitas.rs = vistaCitas.St.executeQuery("SELECT * FROM citas");
			vistaCitas.tablaCitas.setModel(DbUtils.resultSetToTableModel(vistaCitas.rs));
		}catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void getPacientes() {

		try {
			vistaCitas.con = DriverManager.getConnection(url, usuario, clave);
			vistaCitas.St = vistaCitas.con.createStatement(); 
			String query = "SELECT * from pacientes";
			vistaCitas.rs = vistaCitas.St.executeQuery(query);
			while(vistaCitas.rs.next()) {
				String miPaciente= vistaCitas.rs.getString("nombre_paciente"); 
				vistaCitas.nombrePaciente.addItem(miPaciente);
				
			}
		} catch (Exception exc) {
			
		}
		
	}

	//Metodo para obtener el nombre de los tratamientos desde tablaTratamientos
	@SuppressWarnings({ "unchecked" })
	private void getTratamientos() {
		
		try {
			vistaCitas.con = DriverManager.getConnection(url, usuario, clave);
			vistaCitas.St = vistaCitas.con.createStatement(); 
			String query = "SELECT * from tratamientos";
			vistaCitas.rs = vistaCitas.St.executeQuery(query);
			while(vistaCitas.rs.next()) {
				String miTratamiento= vistaCitas.rs.getString("NOMBRE_TRATAMIENTO"); 
				vistaCitas.tratamiento.addItem(miTratamiento);
				
			}
		} catch (Exception exc) {
			
		}
		
	}
	
	
}
