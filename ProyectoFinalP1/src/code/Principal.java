package code;

public class Principal {
	private String testing;
	private String nombre;

	public Principal() {
	}
    
	public Principal(String testing, String nombre) {
		super();
		this.testing = testing;
		this.nombre = nombre;
		
	}

	public String getTesting() {
		return testing;
	}

	public void setTesting(String testing) {
		this.testing = testing;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
