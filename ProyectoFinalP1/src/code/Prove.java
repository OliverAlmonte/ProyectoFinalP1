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
	  Empresa emp = new Empresa();
	  Cliente clien = new Cliente("12", "ddd", "fer", "direc");
	  ArrayList<Empleado> losEmps = new ArrayList<>();
	  Empleado emple = new Jefe("", "", "", 'm', 12, 1200, "");
	  losEmps.add(emple);
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
	  Proyecto pro = new Proyecto("", "", losEmps, fechaInicial, fechaFinal);
	  Contrato con = new Contrato("", 37, pro, clien);
      //System.out.println(Contrato.numeroDiasEntreDosFechas(pro.getFechaInicial(), pro.getFechaFinal()));
	  System.out.println(con.precioProyecto(con.getProyecto()));
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
	}

}
