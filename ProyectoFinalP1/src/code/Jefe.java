package code;

public class Jefe extends Empleado {
	private int cantTrabajadores;



	public Jefe(String id, String nombre, String direccion, char sexo, int edad, float salario, int cantTrabajadores) {
		super(id, nombre, direccion, sexo, edad, salario);
		this.cantTrabajadores = cantTrabajadores;
	}

	public int getCantTrabajadores() {
		return cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

	

}
