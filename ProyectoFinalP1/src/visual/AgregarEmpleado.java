package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		setTitle("Registrar Nuevo Empleado");
		setBounds(100, 100, 507, 440);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 24, 46, 14);
		contentPanel.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(37, 22, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 81, 68, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(75, 79, 408, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 125, 68, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(75, 122, 408, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(10, 209, 46, 14);
		contentPanel.add(lblEdad);
		
		
		rdbtnM.setBounds(208, 206, 39, 23);
		contentPanel.add(rdbtnM);
		if(rdbtnM.isSelected())
			rdbtnF.setSelected(false);
		
		
		rdbtnF.setBounds(248, 206, 33, 23);
		contentPanel.add(rdbtnF);
		if(rdbtnF.isSelected())
			rdbtnM.setSelected(false);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(171, 210, 46, 14);
		contentPanel.add(lblSexo);
		
		
		spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
		spnEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnEdad.setBounds(49, 207, 56, 20);
		contentPanel.add(spnEdad);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(316, 210, 46, 14);
		contentPanel.add(lblCargo);
		
		
		panelInfo.setBorder(new TitledBorder(null, "Informaci\u00F3n Espec\u00EDfica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(0, 253, 493, 67);
		panelInfo.setVisible(false);
		
		
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
		cbxCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxCargo.setBounds(360, 207, 123, 20);
		contentPanel.add(cbxCargo);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLenguaje.setBounds(10, 26, 78, 14);
		panelInfo.add(lblLenguaje);
		
		
		cbxLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Elegir>", "C", "C++", "Java", "Python", "Web"}));
		cbxLenguaje.setBounds(82, 24, 91, 20);
		panelInfo.add(cbxLenguaje);
		
		JLabel lblTodosLosCampos = new JLabel("Todos los campos son obligatorios.");
		lblTodosLosCampos.setBounds(0, 346, 172, 11);
		contentPanel.add(lblTodosLosCampos);
		lblTodosLosCampos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTodosLosCampos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		
		JLabel lblSalario = new JLabel("Salario:  RD$");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSalario.setBounds(10, 169, 68, 14);
		contentPanel.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(86, 167, 86, 20);
		contentPanel.add(txtSalario);
		txtSalario.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Empleado emp=null;
						String id=null;
						String nombre = txtNombre.getText();
						String direccion = txtDireccion.getText();
						String cargo="";
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
						
						Empresa.getInstance().insertEmpleado(emp);
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
