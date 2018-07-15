package code;

import java.util.ArrayList;

public class Cliente {
	private String id;
	   private String nombre;
	   private String direccion;
	   private int CantProyectos;
	  private ArrayList<Proyecto> misProyectos;
	  
	public Cliente(String id, String nombre, String direccion, int cantProyectos, ArrayList<Proyecto> misProyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		CantProyectos = cantProyectos;
		this.misProyectos = misProyectos;
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

	public int getCantProyectos() {
		return CantProyectos;
	}

	public void setCantProyectos(int cantProyectos) {
		CantProyectos = cantProyectos;
	}

	public ArrayList<Proyecto> getMisProyectos() {
		return misProyectos;
	}

	public void setMisProyectos(ArrayList<Proyecto> misProyectos) {
		this.misProyectos = misProyectos;
	}
	
}
