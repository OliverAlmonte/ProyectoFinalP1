package code;

public class Disenador extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4253650450482034431L;

	public Disenador(String id, String nombre, String direccion, char sexo, int edad, float salario, String cargo) {
		super(id, nombre, direccion, sexo, edad, salario, cargo);
		this.cargo="Diseñador";
	}




	

}
