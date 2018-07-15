package code;

public class Contrato {

	private String id;
	private int tiempoEntrega;
	private Proyecto proyecto;
	private Cliente cliente;	
	public Contrato(String id, int tiempoEntrega, Proyecto proyecto, Cliente cliente) {
		super();
		this.id = id;
		this.tiempoEntrega = tiempoEntrega;
		this.proyecto = proyecto;
		this.cliente = cliente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
