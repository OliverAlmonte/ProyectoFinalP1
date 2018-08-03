package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import com.toedter.calendar.JDateChooser;

import code.Cliente;
import code.Contrato;
import code.Empleado;
import code.Empresa;
import code.Proyecto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class RegistrarProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JButton btnDer;
	private JButton btnIzq;
	private JComboBox cbxEncargo;
	private JComboBox cbxTipoProyect;
	private JDateChooser dateChooserF;
	private static JList<Object> listEmpDisp;
	private static JList<Object> listEmpInv;
	private static DefaultListModel<Object> modeloDisp = new DefaultListModel<>();
	private static DefaultListModel<Object> modeloInv = new DefaultListModel<>();
	private static float precioContrato = 0;
	private String datos;
	private static ArrayList<Empleado> empInvolucrados = new ArrayList<>();
	private static ArrayList<Empleado> empDisponibles = new ArrayList<>();
	
	private Cliente cliente = null;
	private JButton btnReg;
	private JButton btnEspecial;
	private JButton btnA;
	private JTextField txtIdContrato;
	private JTextField txtEntrega;
	private JPanel panelC;
	private JPanel panelP;
	private JTextField txtName;
	private JTextField txtDireccion;
	private JButton btnBuscar;
	private JTextField txtCedula;
	private JTextField txtFechaI;
	
	private Calendar c1 = Calendar.getInstance();
	private Calendar c2 = new GregorianCalendar();
  //
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarProyecto() {
		setBounds(100, 100, 579, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label_14 = new JLabel("Los");
		label_14.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_14.setBounds(333, 0, 22, 14);
		contentPanel.add(label_14);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setBounds(348, 0, 11, 14);
		contentPanel.add(label_11);
		
		JLabel label_15 = new JLabel("indican campos obligatorios");
		label_15.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_15.setBounds(355, 0, 146, 14);
		contentPanel.add(label_15);
		
		panelP = new JPanel();
		panelP.setBounds(10, 25, 543, 416);
		contentPanel.add(panelP);
		panelP.setLayout(null);
		panelP.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblIdProyecto = new JLabel("Id Proyecto:");
		lblIdProyecto.setBounds(10, 24, 77, 14);
		panelP.add(lblIdProyecto);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setText("Proyecto-"+(Empresa.getInstance().getCantProyects()+1));
		txtId.setColumns(10);
		txtId.setBounds(97, 21, 145, 20);
		panelP.add(txtId);
		
		JLabel lblEmpleadosDisp = new JLabel("Empleados Disponibles:");
		lblEmpleadosDisp.setBounds(20, 164, 151, 14);
		panelP.add(lblEmpleadosDisp);
		
		JLabel lblEmpleadosInvolucrados = new JLabel("Empleados involucrados:");
		lblEmpleadosInvolucrados.setBounds(318, 164, 172, 14);
		panelP.add(lblEmpleadosInvolucrados);
		
		btnDer = new JButton(">>");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!datos.equalsIgnoreCase("")){
					Empleado emp = buscarEmpDisp(listEmpDisp.getSelectedIndex());
					empDisponibles.remove(emp);
					loadEmpDisp();
					empInvolucrados.add(emp);
					modeloInv.addElement(emp.getId()+" "+emp.getClass().getSimpleName());
					listEmpInv.setModel(modeloInv);
					btnDer.setEnabled(false);
					btnIzq.setEnabled(false);
					
					datos = "";
				}
			}
		});
		btnDer.setEnabled(false);
		btnDer.setBounds(239, 227, 49, 23);
		panelP.add(btnDer);
		
		btnIzq = new JButton("<<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!datos.equalsIgnoreCase("")){
					Empleado emp = buscarEmpInv(listEmpInv.getSelectedIndex());
					empInvolucrados.remove(emp);
					modeloInv.removeElement(emp.getId()+" "+emp.getClass().getSimpleName());
					listEmpInv.setModel(modeloInv);
					empDisponibles.add(emp);
					loadEmpDisp();
					btnDer.setEnabled(false);
					btnIzq.setEnabled(false);
					
					datos = "";
				}
				
			}
		});
		btnIzq.setEnabled(false);
		btnIzq.setBounds(236, 263, 51, 23);
		panelP.add(btnIzq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 222, 206, 182);
		panelP.add(scrollPane);
		
		listEmpDisp = new JList<Object>();
		listEmpDisp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datos = (String)listEmpDisp.getModel().getElementAt(listEmpDisp.getSelectedIndex());
				btnDer.setEnabled(true);
			}
		});
		scrollPane.setViewportView(listEmpDisp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 221, 206, 181);
		panelP.add(scrollPane_1);
		
		listEmpInv = new JList<Object>();
		listEmpInv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datos = (String)listEmpInv.getModel().getElementAt(listEmpInv.getSelectedIndex());
				btnIzq.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(listEmpInv);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(10, 164, 11, 14);
		panelP.add(label_12);
		
		JLabel label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setBounds(306, 164, 11, 14);
		panelP.add(label_13);
		
		JLabel lblNombreDelProyect = new JLabel("Nombre:");
		lblNombreDelProyect.setBounds(20, 54, 111, 14);
		panelP.add(lblNombreDelProyect);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(137, 52, 242, 20);
		panelP.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(10, 54, 11, 14);
		panelP.add(label);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(20, 90, 107, 14);
		panelP.add(lblFechaInicio);
		
		JLabel lblNewLabel = new JLabel("Fecha Final:");
		lblNewLabel.setBounds(20, 121, 111, 14);
		panelP.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(9, 120, 11, 14);
		panelP.add(label_2);
		
		cbxEncargo = new JComboBox();
		cbxEncargo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Jefe de Proyecto", "Programador", "Dise\u00F1ador", "Planificador"}));
		cbxEncargo.setBounds(10, 188, 124, 20);
		panelP.add(cbxEncargo);
		
		dateChooserF = new JDateChooser();
		dateChooserF.setBounds(137, 115, 87, 20);
		panelP.add(dateChooserF);
	    
	    txtFechaI = new JTextField();
	    txtFechaI.setEnabled(false);
	    txtFechaI.setText(Integer.toString(c2.get(Calendar.DATE))+"/"+Integer.toString(c2.get(Calendar.MONTH)+1)+"/"+Integer.toString(c2.get(Calendar.YEAR)));
	    txtFechaI.setBounds(137, 87, 86, 20);
	    panelP.add(txtFechaI);
	    txtFechaI.setColumns(10);
	    
	    cbxTipoProyect = new JComboBox();
	    cbxTipoProyect.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Video juego", "Escritorio", "Pagina web", "App para movil"}));
	    cbxTipoProyect.setBounds(318, 118, 141, 20);
	    panelP.add(cbxTipoProyect);
	    
	    JLabel lblTipoDeProyecto = new JLabel("Tipo de Proyecto:");
	    lblTipoDeProyecto.setBounds(375, 90, 115, 14);
	    panelP.add(lblTipoDeProyecto);
	    
	    JLabel label_3 = new JLabel("*");
	    label_3.setForeground(Color.RED);
	    label_3.setBounds(368, 90, 11, 14);
	    panelP.add(label_3);
	    
	    panelC = new JPanel();
	    panelC.setBounds(10, 25, 543, 237);
	    contentPanel.add(panelC);
	    panelC.setVisible(false);
	    panelC.setLayout(null);
	    panelC.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
	    JLabel lblIdContrato = new JLabel("Id Contrato:");
	    lblIdContrato.setBounds(10, 24, 77, 14);
	    panelC.add(lblIdContrato);
	    
	    txtIdContrato = new JTextField();
	    txtIdContrato.setEnabled(false);
	    txtIdContrato.setText("Contrato-"+(Empresa.getInstance().getCantContracts()+1));
	    txtIdContrato.setColumns(10);
	    txtIdContrato.setBounds(97, 21, 145, 20);
	    panelC.add(txtIdContrato);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBorder(new TitledBorder(null, "Informaci\u00F3n para buscar al cliente para el contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel.setBounds(10, 88, 523, 126);
	    panelC.add(panel);
	    
	    txtName = new JTextField();
	    txtName.setEnabled(false);
	    txtName.setColumns(10);
	    txtName.setBounds(73, 58, 354, 20);
	    panel.add(txtName);
	    
	    txtDireccion = new JTextField();
	    txtDireccion.setEnabled(false);
	    txtDireccion.setColumns(10);
	    txtDireccion.setBounds(96, 95, 331, 20);
	    panel.add(txtDireccion);
	    
	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setBounds(24, 61, 55, 14);
	    panel.add(lblNombre);
	    
	    JLabel lblDireccion = new JLabel("Direccion:");
	    lblDireccion.setBounds(24, 98, 67, 14);
	    panel.add(lblDireccion);
	    
	    btnBuscar = new JButton("Buscar");
	    btnBuscar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cliente = Empresa.getInstance().findClienteByCedula(txtCedula.getText());
	    		if(cliente != null && cliente.isDisponibilidad() == true){
	    			txtName.setText(cliente.getNombre());
	    			txtDireccion.setText(cliente.getDireccion());
	    			txtName.setEnabled(false);
	    			txtDireccion.setEnabled(false);
	
	    		}else if(cliente != null && cliente.isDisponibilidad() == false){
	    			JOptionPane.showMessageDialog(null, "Este cliente ya esta bajo contrato", "Información", JOptionPane.INFORMATION_MESSAGE);
	    		} 
	    		if(cliente == null){
	    			txtName.setText("");
					txtDireccion.setText("");
					txtName.setEnabled(true);
					txtDireccion.setEnabled(true);
	    		}
	    	}
	    });
	    btnBuscar.setBounds(437, 21, 76, 23);
	    panel.add(btnBuscar);
	    
	    JLabel label_4 = new JLabel("*");
	    label_4.setForeground(Color.RED);
	    label_4.setBounds(11, 98, 11, 14);
	    panel.add(label_4);
	    
	    txtCedula = new JTextField();
	    txtCedula.setBounds(73, 22, 354, 20);
	    panel.add(txtCedula);
	    txtCedula.setColumns(10);
	    
	    JLabel label_5 = new JLabel("*");
	    label_5.setForeground(Color.RED);
	    label_5.setBounds(11, 61, 11, 14);
	    panel.add(label_5);
	    
	    JLabel lblNewLabel_2 = new JLabel("Cedula:");
	    lblNewLabel_2.setBounds(24, 25, 46, 14);
	    panel.add(lblNewLabel_2);
	    
	    JLabel label_6 = new JLabel("*");
	    label_6.setForeground(Color.RED);
	    label_6.setBounds(11, 25, 11, 14);
	    panel.add(label_6);
	    
	    JLabel lblNewLabel_1 = new JLabel("Precio:");
	    lblNewLabel_1.setBounds(361, 24, 124, 14);
	    panelC.add(lblNewLabel_1);
	    
	    txtEntrega = new JTextField();
	    txtEntrega.setBounds(361, 49, 124, 20);
	    panelC.add(txtEntrega);
	    txtEntrega.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReg = new JButton("Registrar");
				btnReg.setEnabled(false);
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date  fecha2;
						Date fechaInicial = null;
						try {
							fechaInicial = dateFormat.parse(txtFechaI.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						fecha2 = dateChooserF.getDate();
						
                         if(cliente != null){
                        	 cliente.setDisponibilidad(false);
                        	 Empresa.getInstance().ModificarCliente(cliente);
                        	 Proyecto proyect = new Proyecto(txtId.getText(), txtNombre.getText(), fechaInicial, fecha2);
                        	 Empresa.getInstance().aumentarcantProyects();
                        	 String tipo = cbxTipoProyect.getSelectedItem().toString();
                        	 proyect.setTipoProyect(tipo);
      
							Empresa.getInstance().insertProyecto(proyect);
							Contrato contract = new Contrato(txtIdContrato.getText(), proyect, cliente);
							Empresa.getInstance().aumentarcantContracts();
							for(int i = 0; i < empInvolucrados.size(); i++){//agrego los emps al contrato
								contract.getMisEmps().add(empInvolucrados.get(i));
							}
							contract.setPrecioP(contract.precioProyectoR(contract.getProyecto()));
							contract.setPrecioOriginal(contract.precioProyectoR(contract.getProyecto()));//conservo el precio original en caso de retraso
							
							int mon = c2.get(Calendar.MONTH)+1;
							contract.setMiMes(mon);
							System.out.println("este es mi mes: " +contract.getMiMes());
							Empresa.getInstance().insertContrato(contract);
							try {
								Principal.guardar(Empresa.getInstance());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//aqui va le trycatch
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							//System.out.println(contract.getPrecioP());
						}else{
							 Proyecto proyect = new Proyecto(txtId.getText(), txtNombre.getText(), fechaInicial, fecha2);
							 Empresa.getInstance().aumentarcantProyects();
							 String tipo = cbxTipoProyect.getSelectedItem().toString();
                        	 proyect.setTipoProyect(tipo);
							Empresa.getInstance().insertProyecto(proyect);
							cliente = new Cliente("Clien-"+(Cliente.getCantClien()+1), txtCedula.getText(), txtName.getText(), txtDireccion.getText());
							Empresa.getInstance().aumentarcantClients();
							cliente.setDisponibilidad(false);
							Empresa.getInstance().insertCliente(cliente);
							Contrato contract = new Contrato(txtIdContrato.getText(), proyect, cliente);
							Empresa.getInstance().aumentarcantContracts();
							for(int i = 0; i < empInvolucrados.size(); i++){
								contract.getMisEmps().add(empInvolucrados.get(i));
							}
							contract.setPrecioP(contract.precioProyectoR(contract.getProyecto()));
							contract.setPrecioOriginal(contract.precioProyectoR(contract.getProyecto()));//conservo el precio original en caso de retraso
							
							int mon = c2.get(Calendar.MONTH)+1;
							contract.setMiMes(mon);
							System.out.println("este es mi mes: " +contract.getMiMes());
							Empresa.getInstance().insertContrato(contract);
							try {
								Principal.guardar(Empresa.getInstance());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
                         
                         modeloInv.removeAllElements();
                         listEmpInv.setModel(modeloInv);
                         for(int i = 0; i < empInvolucrados.size(); i++){
                        	 empInvolucrados.get(i).setDisp(false);
                        	 Empresa.getInstance().ModificarEmpleado(empInvolucrados.get(i));
                         }
                         try {
								Principal.guardar(Empresa.getInstance());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                         /*for(int i = 0; i < empInvolucrados.size(); i++){
                        	 //empInvolucrados.remove(i);
                        	 empInvolucrados.remove(empInvolucrados.get(i));
                         }*/
                         empInvolucrados.clear();
                         System.out.println(empInvolucrados.size()+ " deberia ser cero");
                         clean();
                         cliente = null;
					}
				});
				
				btnA = new JButton("Atras");
				btnA.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnA.setEnabled(false);
						btnEspecial.setEnabled(true);
						panelC.setVisible(false);
						panelP.setVisible(true);
						btnReg.setEnabled(false);
					}
				});
				btnA.setEnabled(false);
				buttonPane.add(btnA);
				
				btnEspecial = new JButton("Siguiente");
				btnEspecial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						btnEspecial.setEnabled(false);
						btnA.setEnabled(true);
						panelP.setVisible(false);
						panelC.setVisible(true);
						btnReg.setEnabled(true);
						//btnReg.setEnabled(true);
					}
				});
				buttonPane.add(btnEspecial);
				btnReg.setActionCommand("OK");
				buttonPane.add(btnReg);
				getRootPane().setDefaultButton(btnReg);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	  loadEmpDisp();
	}
	public static void agregarEmpDisp(Empleado emp){
		empDisponibles.add(emp);
	}
	public static void loadEmpDisp(){
		modeloDisp = new DefaultListModel<>();
		for(Empleado aux : empDisponibles){
			//if(aux.isDisp() == true){
			modeloDisp.addElement(aux.getId()+" "+aux.getClass().getSimpleName());
			//}
		}
		listEmpDisp.setModel(modeloDisp);
	}
	private Empleado buscarEmpDisp(int index){
		Empleado emp = null;
		boolean find = false;
		int i = 0;
		while(i<empDisponibles.size()&&!find){
			if(i == index){
				emp = empDisponibles.get(i);
				find = true;
			}
			i++;
		}
		return emp;
	}
	private Empleado buscarEmpInv(int index){
		Empleado emp = null;
		boolean find = false;
		int i = 0;
		while(i<empInvolucrados.size()&&!find){
			if(i == index){
				emp = empInvolucrados.get(i);
				find = true;
			}
			i++;
		}
		return emp;
	}
	private void clean(){
		txtId.setText("Proyecto-"+(Empresa.getInstance().getCantProyects()+1));
		cbxTipoProyect.setSelectedIndex(0);
		cbxEncargo.setSelectedIndex(0);
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtName.setText("");
		dateChooserF.setDate(null);
		txtIdContrato.setText("Contrato-"+(Contrato.getCantContratos()+1));
		panelC.setVisible(false);
		panelP.setVisible(true);
		btnReg.setEnabled(false);
		btnA.setEnabled(false);
		btnEspecial.setEnabled(true);
	}
}
