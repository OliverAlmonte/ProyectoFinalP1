package code;

public class Planificador extends Empleado {
	private int frecuencia;

	public Planificador(String id, String nombre, String direccion, String evaluacion, char sexo, int edad,
			float salario, int frecuencia) {
		super(id, nombre, direccion, evaluacion, sexo, edad, salario);
		this.setFrecuencia(frecuencia);
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}



}
