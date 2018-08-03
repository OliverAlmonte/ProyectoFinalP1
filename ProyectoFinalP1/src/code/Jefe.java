package code;

public class Jefe extends Empleado {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5470656760971974477L;
	private int cantTrabajadores;




	public Jefe(String id, String nombre, String direccion, char sexo, int edad, float salario, String cargo) {
		super(id, nombre, direccion, sexo, edad, salario, cargo);
		this.cargo="Jefe de Proyecto";
	}

	public int getCantTrabajadores() {
		return cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

	

}
