package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class AgregarEmpleado extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtLenguaje;
	private String cargo;
	JPanel DynamicPanel = new JPanel();
	JLabel lblLenguaje = new JLabel("Lenguaje:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEmpleado frame = new AgregarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarEmpleado() {
		setTitle("Registrar Nuevo Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 24, 46, 14);
		panel.add(lblID);
		
		txtLenguaje = new JTextField();
		txtLenguaje.setBounds(73, 22, 108, 20);
		DynamicPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n espec\u00EDfica del tipo de empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		DynamicPanel.add(txtLenguaje);
		txtLenguaje.setColumns(10);
		txtLenguaje.setVisible(false);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(34, 21, 104, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(159, 24, 64, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(212, 22, 286, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 65, 80, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(75, 63, 423, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(10, 107, 46, 14);
		panel.add(lblSexo);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnM.setBounds(52, 104, 38, 23);
		panel.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F\r\n");
		rdbtnF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnF.setBounds(92, 104, 40, 23);
		panel.add(rdbtnF);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(177, 107, 46, 14);
		panel.add(lblEdad);
		
		JSpinner spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(1, 1, 120, 1));
		spnEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnEdad.setBounds(215, 104, 64, 20);
		panel.add(spnEdad);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(336, 107, 46, 14);
		panel.add(lblCargo);
		
		JSpinner spnCargo = new JSpinner();
		spnCargo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cargo = (String) spnCargo.getValue();
				if(cargo=="Programador") {
					txtLenguaje.setVisible(true);	
					lblLenguaje.setVisible(true);
				}
				else {
					txtLenguaje.setVisible(false);	
					lblLenguaje.setVisible(false);
				}
			}
		});
		spnCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnCargo.setModel(new SpinnerListModel(new String[] {"<Elegir>", "Jefe de Proyecto", "Programador", "Planificador", "Dise\u00F1ador"}));
		spnCargo.setBounds(381, 104, 117, 20);
		panel.add(spnCargo);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 201, 504, 33);
		panel.add(buttonPane);
		buttonPane.setLayout(null);
		
		JButton button = new JButton("Registrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(308, 9, 90, 23);
		button.setActionCommand("OK");
		buttonPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(408, 9, 86, 23);
		button_1.setActionCommand("Cancel");
		buttonPane.add(button_1);
		
		JLabel lblCamposObligatorios = new JLabel("Todos los campos son obligatorios.");
		lblCamposObligatorios.setForeground(Color.RED);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblCamposObligatorios.setBounds(10, 9, 180, 14);
		buttonPane.add(lblCamposObligatorios);
		
		
		DynamicPanel.setBounds(0, 136, 505, 65);
		panel.add(DynamicPanel);
		DynamicPanel.setLayout(null);
		
		
		lblLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLenguaje.setBounds(10, 24, 71, 14);
		DynamicPanel.add(lblLenguaje);
		lblLenguaje.setVisible(false);
		
		
	}
}
