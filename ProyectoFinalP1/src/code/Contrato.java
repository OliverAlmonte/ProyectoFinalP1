package code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {

	private String id;
	private int tiempoEntrega;
	private Proyecto proyecto;
	private Cliente cliente;
	private boolean Prorroga =  false;
	private static int cantContratos = 0;
	private boolean estado = true;
	private double precioP = 0;
	//private double precio;
	public Contrato(String id, int tiempoEntrega, Proyecto proyecto, Cliente cliente) {
		super();
		this.id = id;
		this.tiempoEntrega = tiempoEntrega;
		this.proyecto = proyecto;
		this.cliente = cliente;
		cantContratos++;
	}
	public static String formatoFechaInicio(Date inicio){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = sdf.format(inicio);
		return fechaFormateada;
	}//se pude poner en cualquier parte est funcuon ya que es estatica
	
	public static int numeroDiasEntreDosFechas(Date fecha1, Date fecha2){
	     long startTime = fecha1.getTime();
	     long endTime = fecha2.getTime();
	     long diffTime = endTime - startTime;
	     long diffDays = diffTime / (1000 * 60 * 60 * 24);
	     return (int)diffDays;
	}//se peude poner en cualquier parte esta funcion ya que es estatica
	
	private  int salarioEmpleados(Proyecto proyecto){
		int total = 0;
		int i = 0;
		while(i < proyecto.getMisEmpleados().size()){
			total += proyecto.getMisEmpleados().get(i).getSalario();
			i++;
		}
		return total;
	}
	public double precioProyecto(Proyecto proyecto){
		double aux1 = 0;
		double aux2 = 0;
		aux1 = (numeroDiasEntreDosFechas(proyecto.getFechaInicial(), proyecto.getFechaFinal()) * 8 * salarioEmpleados(proyecto));
		aux2 = aux1 * 0.15;
		aux1 += aux2;
		return aux1;
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
	public boolean isProrroga() {
		return Prorroga;
	}
	public void setProrroga(boolean prorroga) {
		Prorroga = prorroga;
	}
	public static int getCantContratos() {
		return cantContratos;
	}
	public static void setCantContratos(int cantContratos) {
		Contrato.cantContratos = cantContratos;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public double getPrecioP() {
		return precioP;
	}
	public void setPrecioP(double precioP) {
		this.precioP = precioP;
	}

}
