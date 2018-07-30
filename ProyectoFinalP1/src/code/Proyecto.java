package code;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
	//private Cliente miCliente;
	private String id;
	private ArrayList<Empleado> misEmpleados;
	private String nombre;
	//private boolean status;
	private Date fechaInicial;
	private Date fechaFinal;
	//nuevo comentario
	private static int cantProyects = 0;

	public Proyecto(String id, String nombre, ArrayList<Empleado> misEmpleados,  Date fechaInicial, Date fechaFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.misEmpleados = misEmpleados;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		cantProyects++;
	}
   
 	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public static int getCantProyects() {
		return cantProyects;
	}

	public static void setCantProyects(int cantProyects) {
		Proyecto.cantProyects = cantProyects;
	}

	

}
