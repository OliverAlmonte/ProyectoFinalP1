package code;

public class Planificador extends Empleado {
	private int frecuencia;


	public Planificador(String id, String nombre, String direccion, char sexo, int edad, float salario, String cargo) {
		super(id, nombre, direccion, sexo, edad, salario, cargo);
		this.cargo="Planificador";
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}



}
