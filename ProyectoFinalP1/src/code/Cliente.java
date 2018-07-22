package code;

import java.util.ArrayList;

public class Cliente {
	private String id;
	  private String nombre;
	  private String direccion;
	  private boolean disponibilidad = true;
	  
	public Cliente(String id, String nombre, String direccion, boolean disponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.disponibilidad = disponibilidad;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	

	

	
	
}
