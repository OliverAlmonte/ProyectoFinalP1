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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public AgregarEmpleado() {
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
		lblNombre.setBounds(10, 115, 68, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(75, 113, 408, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 159, 68, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(75, 156, 408, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(10, 209, 46, 14);
		contentPanel.add(lblEdad);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(208, 206, 39, 23);
		contentPanel.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(248, 206, 33, 23);
		contentPanel.add(rdbtnF);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(171, 210, 46, 14);
		contentPanel.add(lblSexo);
		
		JSpinner spnEdad = new JSpinner();
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
		
		JComboBox cbxLenguaje = new JComboBox();
		cbxLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Elegir>", "C", "C++", "Java", "Python", "Web"}));
		cbxLenguaje.setBounds(82, 24, 91, 20);
		panelInfo.add(cbxLenguaje);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
