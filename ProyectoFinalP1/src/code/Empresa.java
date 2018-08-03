package code;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






public class Empresa implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8011965037374755950L;
	private ArrayList<Proyecto> misProyectos;
    private ArrayList<Empleado> misEmpleados;
    private ArrayList<Contrato> misContratos;
    private ArrayList<Cliente> misClientes;
    private double dineroFacturado = 0;
    private static Empresa emp = null;
    private int cantEmps = 0;
    private int cantClients = 0;
    private int cantContracts = 0;
    private int cantProyects = 0;
	public Empresa() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
				super();
				misProyectos = new ArrayList<>();
				misEmpleados= new ArrayList<>();
				misContratos = new ArrayList<>();
				misClientes = new ArrayList<>();
	}
	public static Empresa getInstance(){
		 if(emp == null){
			 emp = new Empresa();
		 }
		 
		 return emp;
	 }
	public void rellenar(Empresa aux){
		emp = aux;
	}
	public void aumentarcantClients(){
		   this.cantClients++;
	   }
	public void aumentarcantEmps(){
		   this.cantEmps++;
	   }
	public void aumentarcantContracts(){
		   this.cantClients++;
	   }
	public void aumentarcantProyects(){
		   this.cantClients++;
	   }
	public int[] cantProyectoByTipo(){
		int[] cant = new int[4];
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		
		for(Proyecto proyecto : misProyectos){
			if(proyecto.getTipoProyect()=="Video juego"){
				cant[0]++;
			}
			if(proyecto.getTipoProyect()=="Escritorio"){
				cant[1]++;
			}
			if(proyecto.getTipoProyect()=="Pagina web"){
				cant[2]++;
			}
			if(proyecto.getTipoProyect()=="App para movil"){
				cant[3]++;
			}
		}
		return cant;
	}
	
	public double[] gananciasByMes(){
		double[] cant = new double[12];
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		for(Contrato contrato : misContratos){
			if(contrato.getMiMes() == 1){
				cant[0] = cant[0] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 2){
				cant[1] = cant[1] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 3){
				cant[2] = cant[2] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 4){
				cant[3] = cant[3] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 5){
				cant[4] = cant[4] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 6){
				cant[5] = cant[5] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 7){
				cant[6] = cant[6] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 8){
				cant[7] = cant[7] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 9){
				cant[8] = cant[8] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 10){
				cant[9] = cant[9] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 11){
				cant[10] = cant[10] + contrato.getPrecioP();
			}
			if(contrato.getMiMes() == 12){
				cant[11] = cant[11] + contrato.getPrecioP();
			}
		}
		return cant;
	}
	public double[] cantGananciasJuegos(){
		double[] cant = new double[2];
		double acum1 = 0, acum2 = 0;
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		for(Contrato contrato : misContratos){
			if(contrato.getProyecto().getTipoProyect() == "Video juego"){
				acum1 = acum1 + contrato.getPrecioP();
				acum2 = acum2 + contrato.getPrecioOriginal();
			}
		}
		cant[0] = acum1;
		cant[1] = acum2;
		return cant;
	}
	
	public double[] cantGananciasEscritorio(){
		double[] cant = new double[2];
		double acum1 = 0, acum2 = 0;
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		for(Contrato contrato : misContratos){
			if(contrato.getProyecto().getTipoProyect() == "Escritorio"){
				acum1 = acum1 + contrato.getPrecioP();
				acum2 = acum2 + contrato.getPrecioOriginal();
			}
		}
		cant[0] = acum1;
		cant[1] = acum2;
		return cant;
	}
	public double[] cantGananciasWeb(){
		double[] cant = new double[2];
		double acum1 = 0, acum2 = 0;
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		for(Contrato contrato : misContratos){
			if(contrato.getProyecto().getTipoProyect() == "Pagina web"){
				acum1 = acum1 + contrato.getPrecioP();
				acum2 = acum2 + contrato.getPrecioOriginal();
			}
		}
		cant[0] = acum1;
		cant[1] = acum2;
		return cant;
	}
	public double[] cantGananciasAppsMoviles(){
		double[] cant = new double[2];
		double acum1 = 0, acum2 = 0;
		for (int i = 0; i < cant.length; i++) {
			cant[i]=0;
		}
		for(Contrato contrato : misContratos){
			if(contrato.getProyecto().getTipoProyect() == "App para movil"){
				acum1 = acum1 + contrato.getPrecioP();
				acum2 = acum2 + contrato.getPrecioOriginal();
			}
		}
		cant[0] = acum1;
		cant[1] = acum2;
		return cant;
	}
	public ArrayList<Proyecto> getMisProyectos() {
		return misProyectos;
	}
	public void setMisProyectos(ArrayList<Proyecto> misProyectos) {
		this.misProyectos = misProyectos;
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}
	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
	public void insertProyecto(Proyecto aux){
		misProyectos.add(aux);
	}
	public void insertEmpleado(Empleado aux){
		misEmpleados.add(aux);
	}
	public void insertCliente(Cliente aux){
		misClientes.add(aux);
	}
	public void insertContrato(Contrato aux){
		misContratos.add(aux);
	}
	
	public Cliente findClienteById(String id) {
		Cliente clien =null;
		boolean find = false;
		int i=0;
		while (i<misClientes.size()&&!find) {
			if(misClientes.get(i).getId().equalsIgnoreCase(id)){
				clien = misClientes.get(i);
				find = true;
			}
			i++;
		}
		return clien;
	}
	public Cliente findClienteByCedula(String cedula) {
		Cliente clien =null;
		boolean find = false;
		int i=0;
		while (i<misClientes.size()&&!find) {
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)){
				clien = misClientes.get(i);
				find = true;
			}
			i++;
		}
		return clien;
	}
	public Cliente findClienteByName(String name) {
		Cliente clien =null;
		boolean find = false;
		int i=0;
		while (i<misClientes.size()&&!find) {
			if(misClientes.get(i).getId().equalsIgnoreCase(name)){
				clien = misClientes.get(i);
				find = true;
			}
			i++;
		}
		return clien;
	}
	public Empleado findEmpleadoById(String id) {
		Empleado emp =null;
		boolean find = false;
		int i=0;
		while (i<misEmpleados.size()&&!find) {
			if(misEmpleados.get(i).getId().equalsIgnoreCase(id)){
				emp = misEmpleados.get(i);
				find = true;
			}
			i++;
		}
		return emp;
	}
	public Contrato findContratoById(String id) {
		Contrato contract =null;
		boolean find = false;
		int i=0;
		while (i<misContratos.size()&&!find) {
			if(misContratos.get(i).getId().equalsIgnoreCase(id)){
				contract = misContratos.get(i);
				find = true;
			}
			i++;
		}
		return contract;
	}
	private int buscarIndexClien(Cliente clien){
		int index = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misClientes.size()){
			if(misClientes.get(i).getId().equalsIgnoreCase(clien.getId())){
				index = i;
				encontrado = true;
			}
			i++;
		}
		
		return index;
	}
	public int getCantEmps() {
		return cantEmps;
	}
	public void setCantEmps(int cantEmps) {
		this.cantEmps = cantEmps;
	}
	public int getCantClients() {
		return cantClients;
	}
	public void setCantClients(int cantClients) {
		this.cantClients = cantClients;
	}
	public int getCantContracts() {
		return cantContracts;
	}
	public void setCantContracts(int cantContracts) {
		this.cantContracts = cantContracts;
	}
	public int getCantProyects() {
		return cantProyects;
	}
	public void setCantProyects(int cantProyects) {
		this.cantProyects = cantProyects;
	}
	public void ModificarCliente(Cliente clien){
		int index = buscarIndexClien(clien);
		misClientes.set(index, clien);
	}
	
	private int buscarIndexProyecto(Proyecto pro){
		int index = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misProyectos.size()){
			if(misProyectos.get(i).getNombre().equalsIgnoreCase(pro.getNombre())){
				index = i;
				encontrado = true;
			}
			i++;
		}
		
		return index;
	}
	public void ModificarProyecto(Proyecto pro){
		int index = buscarIndexProyecto(pro);
		misProyectos.set(index, pro);
	}
	
	private int buscarIndexContrato(Contrato contract){
		int index = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misContratos.size()){
			if(misContratos.get(i).getId().equalsIgnoreCase(contract.getId())){
				index = i;
				encontrado = true;
			}
			i++;
		}
		
		return index;
	}
	public void ModificarContrato(Contrato contract){
		int index = buscarIndexContrato(contract);
		misContratos.set(index, contract);
	}
	private int buscarIndexEmpleadp(Empleado emp){
		int index = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misEmpleados.size()){
			if(misEmpleados.get(i).getId().equalsIgnoreCase(emp.getId())){
				index = i;
				encontrado = true;
			}
			i++;
		}
		
		return index;
	}
	public double getDineroFacturado() {
		return dineroFacturado;
	}
	public void setDineroFacturado(double dineroFacturado) {
		this.dineroFacturado = dineroFacturado;
	}
	public void ModificarEmpleado(Empleado emp){
		int index = buscarIndexEmpleadp(emp);
		misEmpleados.set(index, emp);
	}
	public Empleado findEmpleadoByIndex(int index){
		Empleado emp = null;
		boolean find = false;
		int i = 0;
		while(i < misEmpleados.size()&&!find){
			if(i == index){
				emp = misEmpleados.get(i);
				find = true;
			}
			i++;
		}
		return emp;
	}
	public boolean Prorroga(String codigo, String newFechaFin){
		boolean doProrroga = false;
		
		return doProrroga;
		
	}
	
	public Proyecto buscarProyectoByContract(String id){
		Contrato contract = findContratoById(id);
		Proyecto pro = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misContratos.size()){
			if(misContratos.get(i).getId().equalsIgnoreCase(id)){
				pro = contract.getProyecto();
				encontrado = true;
			}
			i++;
		}
		return pro;
	}
}
