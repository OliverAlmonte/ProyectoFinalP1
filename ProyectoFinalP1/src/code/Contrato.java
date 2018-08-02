package code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private double precioOriginal = 0;
	private Date fechaPro;
	private int cantEmp;
	//private double precio;
	private ArrayList<Empleado> misEmps;
	private int miMes;
	
	public Contrato(String id, Proyecto proyecto, Cliente cliente) {
		super();
		this.id = id;
		misEmps = new ArrayList<>();
		this.proyecto = proyecto;
		this.cliente = cliente;
		cantContratos++;
	}
	public void agregarArrays(Empleado emp){
		misEmps.add(emp);
	}
	
	public String getEstadoActual() {
		String Disponibilidad="";
		if (this.estado == true)
			Disponibilidad="Abierto";
		else Disponibilidad="Terminado";
		return Disponibilidad;
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
	
	
	private  int salarioEmpleados(){
		int total = 0;
		int i = 0;
		while(i < misEmps.size()){
			total += misEmps.get(i).getSalario();
			i++;
		}
		return total;
	}
	public double precioProyectoR(Proyecto proyecto){
		double aux1 = 0;
		double aux2 = 0;
		aux1 = (numeroDiasEntreDosFechas(proyecto.getFechaInicial(), proyecto.getFechaFinal()) * 8 * salarioEmpleados());
		aux2 = aux1 * 0.15;
		aux1 += aux2;
		return aux1;
	}
	public double precioPenalizado(double monto, int diasRetraso){
		double dinero = monto;
		double descuento;
		descuento = diasRetraso/100.0;
		monto = monto * descuento;
		dinero = dinero - monto;
		return dinero;
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
	public Date getFechaPro() {
		return fechaPro;
	}
	public void setFechaPro(Date fechaPro) {
		this.fechaPro = fechaPro;
	}
	public int getCantEmp() {
		return cantEmp;
	}
	public double getPrecioOriginal() {
		return precioOriginal;
	}
	public void setPrecioOriginal(double precioOriginal) {
		this.precioOriginal = precioOriginal;
	}
	
	public int getMiMes() {
		return miMes;
	}
	public void setMiMes(int miMes) {
		this.miMes = miMes;
	}
	public void setCantEmp(int cantEmp) {
		this.cantEmp = cantEmp;
	}
	public ArrayList<Empleado> getMisEmps() {
		return misEmps;
	}
	public void setMisEmps(ArrayList<Empleado> misEmps) {
		this.misEmps = misEmps;
	}
	

}
