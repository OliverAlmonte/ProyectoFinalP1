package code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchiEmp {

	public ArchiEmp() {
		// TODO Auto-generated constructor stub
	}
	public void guardar(Empresa x)throws FileNotFoundException,IOException{
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("software.obj"));
		salida.writeObject(x);
		salida.close();
	}
	public Empresa recuperar() throws IOException,ClassNotFoundException{
		
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("software.obj"));
		Empresa emp = (Empresa) entrada.readObject();
		
		
		entrada.close();
		return emp;
	}

}
