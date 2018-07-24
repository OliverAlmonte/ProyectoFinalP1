package code;

import java.util.ArrayList;



public class Cliente {
	private String Id;
	  private String Nombre;
	  private String Direccion;
	  private boolean disponibilidad = true;
	  private  String Cedula;
	  private static int cantClien = 0;
	  
	public Cliente(String id, String cedula, String nombre, String direccion) {
		super();
		this.Id = id;
		this.Cedula = cedula;
		this.Nombre = nombre;
		this.Direccion = direccion;
		this.disponibilidad = disponibilidad;
		cantClien++;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		this.Cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public static int getCantClien() {
		return cantClien;
	}

	public static void setCantClien(int cantClien) {
		Cliente.cantClien = cantClien;
	}

	

	
	
}
