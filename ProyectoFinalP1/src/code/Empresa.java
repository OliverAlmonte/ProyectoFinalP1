package code;

import java.sql.Array;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






public class Empresa {
    private ArrayList<Proyecto> misProyectos;
    private ArrayList<Empleado> misEmpleados;
    private ArrayList<Contrato> misContratos;
    private ArrayList<Cliente> misClientes;
    private double dineroFacturado = 0;
    private static Empresa emp = null;
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
