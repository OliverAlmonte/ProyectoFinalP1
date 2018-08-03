package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import code.Programador;
import code.Disenador;
import code.Empleado;
import code.Empresa;
import code.Jefe;
import code.Planificador;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings("rawtypes")
public class AgregarEmpleado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private String cargo;
	JPanel panelInfo = new JPanel();
	JComboBox cbxCargo = new JComboBox();
	JSpinner spnEdad = new JSpinner();
	JRadioButton rdbtnM = new JRadioButton("M");
	JRadioButton rdbtnF = new JRadioButton("F");
	JComboBox cbxLenguaje = new JComboBox();
	JButton okButton = new JButton("Registrar");
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public AgregarEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEmpleado.class.getResource("/visual/employee.png")));
		getContentPane().setBackground(new Color(51, 153, 255));
		setBackground(new Color(51, 153, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setForeground(Color.BLACK);
		setTitle("Registrar Nuevo Empleado");
		setBounds(100, 100, 505, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.BLACK);
		
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBackground(new Color(51, 153, 255));
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(10, 32, 46, 14);
		contentPanel.add(lblID);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtID.setForeground(Color.BLACK);
		txtID.setBackground(Color.WHITE);
		txtID.setText("EMP-"+(Empresa.getInstance().getCantEmps()+1));
		txtID.setEditable(false);
		txtID.setBounds(83, 29, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBackground(new Color(51, 153, 255));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 67, 68, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(83, 65, 400, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBackground(new Color(51, 153, 255));
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(10, 111, 68, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setBounds(83, 108, 400, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBackground(new Color(51, 153, 255));
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(10, 196, 46, 14);
		contentPanel.add(lblEdad);
		rdbtnM.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnM.setForeground(Color.BLACK);
		rdbtnM.setBackground(Color.LIGHT_GRAY);
		rdbtnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnM.isSelected())
					rdbtnF.setSelected(false);
			}
		});
		
		
		rdbtnM.setBounds(208, 192, 39, 23);
		contentPanel.add(rdbtnM);
		rdbtnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnF.isSelected())
					rdbtnM.setSelected(false);
			}
		});
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnF.setForeground(Color.BLACK);
		rdbtnF.setBackground(Color.LIGHT_GRAY);
		
		
		
		rdbtnF.setBounds(248, 192, 33, 23);
		contentPanel.add(rdbtnF);
		
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBackground(new Color(51, 153, 255));
		lblSexo.setForeground(Color.BLACK);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(171, 196, 46, 14);
		contentPanel.add(lblSexo);
		spnEdad.setBackground(new Color(51, 153, 255));
		spnEdad.setForeground(Color.BLACK);
		
		
		spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
		spnEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		spnEdad.setBounds(50, 193, 56, 20);
		contentPanel.add(spnEdad);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBackground(new Color(51, 153, 255));
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargo.setBounds(310, 193, 46, 20);
		contentPanel.add(lblCargo);
		panelInfo.setForeground(Color.BLACK);
		panelInfo.setBackground(Color.LIGHT_GRAY);
		
		
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Espec\u00EDfica", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelInfo.setBounds(0, 221, 493, 67);
		panelInfo.setVisible(false);
		cbxCargo.setBackground(Color.WHITE);
		cbxCargo.setForeground(Color.BLACK);
		
		
		cbxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cargo=(String) cbxCargo.getSelectedItem();
			if(cargo=="Programador") {
				panelInfo.setVisible(true);
			}
			else {
				panelInfo.setVisible(false);
			}
			}
		});
		cbxCargo.setModel(new DefaultComboBoxModel(new String[] {"<Elegir>", "Programador", "Jefe de Proyecto", "Planificador", "Dise\u00F1ador"}));
		cbxCargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxCargo.setBounds(360, 193, 123, 20);
		contentPanel.add(cbxCargo);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setBackground(new Color(51, 153, 255));
		lblLenguaje.setForeground(Color.BLACK);
		lblLenguaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLenguaje.setBounds(10, 26, 78, 18);
		panelInfo.add(lblLenguaje);
		cbxLenguaje.setBackground(Color.WHITE);
		cbxLenguaje.setForeground(Color.BLACK);
		
		
		cbxLenguaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Elegir>", "C", "C++", "Java", "Python", "Web"}));
		cbxLenguaje.setBounds(82, 25, 91, 20);
		panelInfo.add(cbxLenguaje);
		
		JLabel lblSalario = new JLabel("Salario:  $");
		lblSalario.setBackground(new Color(51, 153, 255));
		lblSalario.setForeground(Color.BLACK);
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalario.setBounds(10, 155, 91, 14);
		contentPanel.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSalario.setBackground(Color.WHITE);
		txtSalario.setForeground(Color.BLACK);
		txtSalario.setBounds(83, 152, 120, 20);
		contentPanel.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblTodosLosCampos = new JLabel("*Todos los campos son obligatorios.");
		lblTodosLosCampos.setBounds(271, 11, 203, 14);
		contentPanel.add(lblTodosLosCampos);
		lblTodosLosCampos.setBackground(new Color(51, 153, 255));
		lblTodosLosCampos.setForeground(Color.RED);
		lblTodosLosCampos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.setBackground(Color.GRAY);
				okButton.setForeground(Color.BLACK);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Empleado emp=null;
						String id=txtID.getText();
						String nombre = txtNombre.getText();
						String direccion = txtDireccion.getText();
						String cargo=cbxCargo.getSelectedItem().toString();
						String lenguaje=(String) cbxLenguaje.getSelectedItem();
						int edad = (int) spnEdad.getValue();
						float salario = Float.valueOf(txtSalario.getText());
						
						char sexo='x';
						if(rdbtnM.isSelected())
							sexo='M';
						if(rdbtnF.isSelected())
							sexo='F';
						
						if(cbxCargo.getSelectedItem()=="Programador")
							emp = new Programador(id, nombre, direccion, sexo, edad, salario, cargo, lenguaje);
						if(cbxCargo.getSelectedItem()=="Diseñador")
							emp = new Disenador(id, nombre, direccion, sexo, edad, salario, cargo);	
						if(cbxCargo.getSelectedItem()=="Planificador")
							emp = new Planificador(id, nombre, direccion, sexo, edad, salario, cargo);
						if(cbxCargo.getSelectedItem()=="Jefe de Proyecto")
							emp = new Jefe(id, nombre, direccion, sexo, edad, salario, cargo);
						Empresa.getInstance().aumentarcantEmps();
						Empresa.getInstance().insertEmpleado(emp);
						try {
							Principal.guardar(Empresa.getInstance());
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						RegistrarProyecto.agregarEmpDisp(emp);
						clean();
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setForeground(Color.BLACK);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void clean(){
		txtID.setText("EMP-"+(Empresa.getInstance().getCantEmps()+1));
		txtNombre.setText("");
		txtDireccion.setText("");
		txtSalario.setText("");
		spnEdad.setValue(18);
		rdbtnM.setSelected(false);
		rdbtnF.setSelected(false);
		cbxCargo.setSelectedIndex(0);
		
	}
}
