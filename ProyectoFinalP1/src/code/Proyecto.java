package code;
import java.util.ArrayList;

public class Proyecto {
	//private Cliente miCliente;
	private ArrayList<Empleado> misEmpleados;

	public Proyecto(ArrayList<Empleado> misEmpleados) {
		super();
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	

}
