package code;
import java.util.ArrayList;

public class Proyecto {
	//private Cliente miCliente;
	private ArrayList<Empleado> misEmpleados;
	private String nombre;
	private boolean status;
	private String fechaInicial;
	private String fechaFinal;

	public Proyecto(ArrayList<Empleado> misEmpleados, boolean status, String fechaInicial, String fechaFinal) {
		super();
		this.misEmpleados = misEmpleados;
		this.status = status;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
   
 	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	

}
