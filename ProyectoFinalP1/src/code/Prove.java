package code;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;
public class Prove {

	public Prove() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 /* Empresa emp = new Empresa();
	  Cliente clien = new Cliente("12", "ddd", "fer", "direc");
	  ArrayList<Empleado> losEmps = new ArrayList<>();
	  Empleado emple = new Jefe("", "", "", 'm', 12, 1200, "");
	  losEmps.add(emple);
	  Contrato con = new Contrato("", losEmps, null, null);
	  System.out.println(con.getMisEmps().get(0).getSexo());*/
		
	  /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date fechaInicial = null;
		try {
			fechaInicial = dateFormat.parse("29/07/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Date fechaFinal = null;
		try {
			fechaFinal = dateFormat.parse("31/08/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Proyecto pro = new Proyecto("", "", losEmps, fechaInicial, fechaFinal);
	  Contrato con = new Contrato("", 37, pro, clien);
      //System.out.println(Contrato.numeroDiasEntreDosFechas(pro.getFechaInicial(), pro.getFechaFinal()));
	  System.out.println(con.precioProyecto(con.getProyecto()));*/
		 /*ArrayList<Empleado> losEmps = new ArrayList<>();
		 Empleado emple = new Jefe("", "", "", 'm', 12, 1200, "");
		 Empleado emple2 = new Jefe("", "", "", 'f', 12, 1200, "");
		 Empleado emple3 = new Jefe("ff", "", "", 'm', 12, 1200, "");
		  losEmps.add(emple);
		  losEmps.add(emple2);
		  losEmps.add(emple3);
		  losEmps.remove(emple2);
		  for(int i = 0; i < losEmps.size(); i++){
			  System.out.println(i);
		  }*/
	
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date fechaInicial = null;
		try {
			fechaInicial = dateFormat.parse("3/08/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Date fechaFinal = null;
		try {
			fechaFinal = dateFormat.parse("2/08/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Proyecto pro = new Proyecto("", "", fechaInicial, fechaFinal);
		  
	      System.out.println(Contrato.numeroDiasEntreDosFechas(pro.getFechaInicial(), pro.getFechaFinal()));*/
	      
	      /*Empleado emp = new Jefe("", "", "", 'm', 18, 1200, "jefe");
	      
	      if(emp.getProyectosTardios() == -1){
	    	  System.out.println("Aun Sin evaluar");
	      }
	      if(emp.getProyectosTardios() >= 0){
	    	  System.out.println(emp.getEvaluacion());
	      }
	      System.out.println("Proyectos tardios: "+emp.getProyectosTardios());*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date fechaInicial = null;
		try {
			fechaInicial = dateFormat.parse("29/07/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Date fechaFinal = null;
		try {
			fechaFinal = dateFormat.parse("31/08/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Empresa emp = new Empresa();
		Proyecto pro = new Proyecto("", "", fechaInicial, fechaFinal);
		pro.setTipoProyect("Video juego");
		 Cliente clien = new Cliente("12", "ddd", "fer", "direc");
		 Contrato contract = new Contrato("", pro, clien);
		 contract.setPrecioP(5000);
		 contract.setPrecioOriginal(4000);
		 contract.setMiMes(1);
		 emp.insertContrato(contract);
		 emp.insertProyecto(pro);
		 double[] cant = emp.gananciasByMes();
		 System.out.println(cant[0]);
	      /*double monto = 5000;
	      double dinero = monto;
			double descuento;
			descuento = 10/100.0;
			monto = monto * descuento;
			dinero = dinero - monto;
		System.out.println(dinero);*/
		
		
	}
	

}
