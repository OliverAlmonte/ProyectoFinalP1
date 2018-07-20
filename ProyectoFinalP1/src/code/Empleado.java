package code;

public abstract class Empleado {
	private String id;
	private String nombre;
	private String direccion;
	private String evaluacion;
	private char sexo;
	private int edad;
	private float salario;
	private Contrato contratoActual;

	public Empleado(String id, String nombre, String direccion, String evaluacion, char sexo, int edad, float salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.evaluacion = evaluacion;
		this.sexo = sexo;
		this.edad = edad;
		this.salario = salario;
	}

	

	public String getID() {
		return id;
	}

	

	public void setID(String id) {
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

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}



	public Contrato getContratoActual() {
		return contratoActual;
	}



	public void setContratoActual(Contrato contratoActual) {
		this.contratoActual = contratoActual;
	}

}
