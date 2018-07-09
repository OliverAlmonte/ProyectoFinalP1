package code;

public class Jefe extends Empleado {
	private int cantTrabajadores;

	public Jefe(String id, String nombre, String direccion, String evaluacion, char sexo, int edad, float salario,
			int cantTrabajadores) {
		super(id, nombre, direccion, evaluacion, sexo, edad, salario);
		this.setCantTrabajadores(cantTrabajadores);
	}

	public int getCantTrabajadores() {
		return cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

	

}
