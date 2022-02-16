package Controladores;


import java.sql.DriverManager;

import Conexion.Informacion;
import Vistas.Inicio;

public class ControladorInicio implements Informacion {
	
	private Inicio vistaInicio;
	
	public ControladorInicio() {
		this.vistaInicio= new Inicio();
		getData();
		vistaInicio.setVisible(true);
		
	}
	
	private void getData() {
		
		try {
			vistaInicio.con= DriverManager.getConnection(url, usuario, clave);
			vistaInicio.St= vistaInicio.con.createStatement();
			vistaInicio.St1= vistaInicio.con.createStatement();
			vistaInicio.St2= vistaInicio.con.createStatement();
			vistaInicio.rs= vistaInicio.St.executeQuery("SELECT COUNT (*) FROM pacientes");
			vistaInicio.rs1= vistaInicio.St1.executeQuery("SELECT COUNT (*) FROM tratamientos");
			vistaInicio.rs2 = vistaInicio.St2.executeQuery("SELECT COUNT (*) FROM prescripciones ");
			
			while(vistaInicio.rs.next()) {
				vistaInicio.numeroPacientes.setText(""+ vistaInicio.rs.getInt(1));
			}
			while(vistaInicio.rs1.next()) {
				vistaInicio.numeroTratamientos.setText(""+ vistaInicio.rs1.getInt(1));
			}
			while(vistaInicio.rs2.next()) {
				vistaInicio.numPrescripciones.setText(""+ vistaInicio.rs2.getInt(1));
			}
			
		} catch(Exception excep) {
			System.out.println(excep.getMessage());
		}
		
	}
	

}
