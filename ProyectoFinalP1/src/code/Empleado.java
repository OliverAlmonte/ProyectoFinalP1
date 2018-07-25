package code;

public abstract class Empleado {
	protected String id;
	protected String nombre;
	protected String direccion;
	protected String evaluacion;
	protected char sexo;
	protected int edad;
	protected float salario;
	//private Contrato contratoActual;
    private boolean disp =  false;
	protected String cargo;
	protected int proyectosTardios;
	private static int Idcount=0;

	public Empleado(String id, String nombre, String direccion, char sexo, int edad, float salario, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.sexo = sexo;
		this.edad = edad;
		this.salario = salario;
		this.cargo = cargo;
		Idcount++;
	}

    
	/*public String getDisponibilidad() {
		String Disponibilidad="";
		if (this.contratoActual==null)
			Disponibilidad="Disponible";
		else Disponibilidad="Ocupado";
		return Disponibilidad;
	}*/
	public String getDisponibilidad() {
		String Disponibilidad="";
		if (this.disp == true)
			Disponibilidad="Disponible";
		else Disponibilidad="Ocupado";
		return Disponibilidad;
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



	/*public Contrato getContratoActual() {
		return contratoActual;
	}



	public void setContratoActual(Contrato contratoActual) {
		this.contratoActual = contratoActual;
	}*/





	public static int getIdcount() {
		return Idcount;
	}





	public static void setIdcount(int idcount) {
		Idcount = idcount;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public int getProyectosTardios() {
		return proyectosTardios;
	}


	public void setProyectosTardios(int proyectosTardios) {
		this.proyectosTardios = proyectosTardios;
	}


	public boolean isDisp() {
		return disp;
	}


	public void setDisp(boolean disp) {
		this.disp = disp;
	}

}
