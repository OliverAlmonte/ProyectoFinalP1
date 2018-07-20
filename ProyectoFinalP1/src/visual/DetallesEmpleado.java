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

public class DetallesEmpleado extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private String cargo;
	private JTextField txtCargo;
	private JTextField txtEdad;
	private JTextField txtSexo;
	private JTextField txtEvaluacion;
	private JTextField txtFrecuencia;
	private JTextField txtLenguaje;
	private JTextField txtTrbajadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallesEmpleado frame = new DetallesEmpleado();
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
	public DetallesEmpleado() {
		setTitle("Detalles Del Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		txtFrecuencia = new JTextField();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 24, 46, 14);
		panel.add(lblID);
		
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
		txtNombre.setEditable(false);
		txtNombre.setBounds(212, 22, 286, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 65, 80, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(75, 63, 423, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(10, 107, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(177, 107, 46, 14);
		panel.add(lblEdad);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(336, 107, 46, 14);
		panel.add(lblCargo);
		
		JPanel panelJefe = new JPanel();
		panelJefe.setBounds(10, 194, 523, 70);
		panel.add(panelJefe);
		panelJefe.setLayout(null);
		panelJefe.setVisible(true);
		
		JLabel lblTrabajadoresASu = new JLabel("Trabajadores a su cargo actualmente:");
		lblTrabajadoresASu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrabajadoresASu.setEnabled(true);
		lblTrabajadoresASu.setBounds(10, 21, 269, 14);
		panelJefe.add(lblTrabajadoresASu);
		
		txtTrbajadores = new JTextField();
		txtTrbajadores.setEditable(false);
		txtTrbajadores.setBounds(237, 19, 86, 20);
		panelJefe.add(txtTrbajadores);
		txtTrbajadores.setColumns(10);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 265, 530, 33);
		panel.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setActionCommand("Cancel");
		buttonPane.add(btnSalir);
		
		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setBounds(378, 105, 117, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(215, 105, 64, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setBounds(48, 105, 46, 20);
		panel.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblEvaluacion = new JLabel("Evaluaci\u00F3n:");
		lblEvaluacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEvaluacion.setBounds(10, 144, 80, 14);
		panel.add(lblEvaluacion);
		
		JPanel PanelProgramador = new JPanel();
		PanelProgramador.setBounds(0, 184, 498, 70);
		panel.add(PanelProgramador);
		PanelProgramador.setLayout(null);
		
		JLabel lblLenguaje_1 = new JLabel("Lenguaje:");
		lblLenguaje_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLenguaje_1.setBounds(10, 11, 80, 20);
		PanelProgramador.add(lblLenguaje_1);
		
		txtLenguaje = new JTextField();
		txtLenguaje.setEditable(false);
		txtLenguaje.setBounds(88, 12, 86, 20);
		PanelProgramador.add(txtLenguaje);
		txtLenguaje.setColumns(10);
		PanelProgramador.setVisible(false);
		
		txtEvaluacion = new JTextField();
		txtEvaluacion.setEditable(false);
		txtEvaluacion.setBounds(75, 142, 86, 20);
		panel.add(txtEvaluacion);
		txtEvaluacion.setColumns(10);
		
		JPanel PanelPlanificador = new JPanel();
		PanelPlanificador.setBounds(0, 184, 504, 59);
		panel.add(PanelPlanificador);
		PanelPlanificador.setLayout(null);
		PanelPlanificador.setVisible(false);
		
		txtFrecuencia.setEditable(false);
		txtFrecuencia.setBounds(86, 13, 86, 20);
		PanelPlanificador.add(txtFrecuencia);
		txtFrecuencia.setColumns(10);
		
		JLabel lblFrecuencia = new JLabel("Frecuencia");
		lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFrecuencia.setBounds(10, 16, 66, 14);
		PanelPlanificador.add(lblFrecuencia);
		
		
		
	}
}
