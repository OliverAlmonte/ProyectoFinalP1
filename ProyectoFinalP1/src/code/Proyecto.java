package code;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
	//private Cliente miCliente;
	private ArrayList<Empleado> misEmpleados;
	private String nombre;
	private boolean status;
	private Date fechaInicial;
	private Date fechaFinal;

	public Proyecto(ArrayList<Empleado> misEmpleados, boolean status, Date fechaInicial, Date fechaFinal) {
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

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	

}
