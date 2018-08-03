package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import code.Empleado;
import code.Empresa;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class DetallesEmpleado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	@SuppressWarnings("unused")
	private String cargo;
	JPanel panelInfo = new JPanel();
	private JTextField txtEdad;
	private JTextField txtSexo;
	private JTextField txtCargo;
	private JTextField txtLenguaje;
	private JTextField txtSalario;
	private JTextField txtEvaluacion;
	private JTextField txtDisponibilidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetallesEmpleado dialog = new DetallesEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetallesEmpleado.class.getResource("/visual/contract.png")));
		setTitle("Detalles de Empleado");
		setBounds(100, 100, 509, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(10, 24, 46, 14);
		contentPanel.add(lblID);
		
		txtID = new JTextField();
		txtID.setBackground(Color.WHITE);
		txtID.setFont(new Font("Dialog", Font.BOLD, 12));
		txtID.setForeground(Color.BLACK);
		txtID.setEditable(false);
		txtID.setBounds(37, 22, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 55, 68, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setEditable(false);
		txtNombre.setBounds(75, 53, 408, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(10, 99, 68, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(75, 96, 408, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(10, 139, 46, 14);
		contentPanel.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBackground(Color.WHITE);
		lblSexo.setForeground(Color.BLACK);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(171, 140, 46, 14);
		contentPanel.add(lblSexo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargo.setBounds(316, 140, 46, 14);
		contentPanel.add(lblCargo);
		panelInfo.setBackground(Color.LIGHT_GRAY);
		
		
		panelInfo.setBorder(new TitledBorder(null, "Informaci\u00F3n Espec\u00EDfica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(0, 253, 493, 67);
		panelInfo.setVisible(false);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setForeground(Color.BLACK);
		lblLenguaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLenguaje.setBounds(10, 26, 78, 14);
		panelInfo.add(lblLenguaje);
		
		txtLenguaje = new JTextField();
		txtLenguaje.setBackground(Color.WHITE);
		txtLenguaje.setFont(new Font("Dialog", Font.BOLD, 12));
		txtLenguaje.setForeground(Color.BLACK);
		txtLenguaje.setEditable(false);
		txtLenguaje.setBounds(78, 24, 86, 20);
		panelInfo.add(txtLenguaje);
		txtLenguaje.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBackground(Color.WHITE);
		txtEdad.setForeground(Color.BLACK);
		txtEdad.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEdad.setEditable(false);
		txtEdad.setBounds(49, 137, 68, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setBackground(Color.WHITE);
		txtSexo.setEditable(false);
		txtSexo.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSexo.setBounds(205, 137, 40, 20);
		contentPanel.add(txtSexo);
		txtSexo.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBackground(Color.WHITE);
		txtCargo.setForeground(Color.BLACK);
		txtCargo.setEditable(false);
		txtCargo.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCargo.setBounds(358, 137, 125, 20);
		contentPanel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalario.setForeground(Color.BLACK);
		lblSalario.setBounds(10, 190, 68, 14);
		contentPanel.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setBackground(Color.WHITE);
		txtSalario.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSalario.setForeground(Color.BLACK);
		txtSalario.setEditable(false);
		txtSalario.setBounds(59, 187, 86, 20);
		contentPanel.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblEvaluacin = new JLabel("Evaluaci\u00F3n:");
		lblEvaluacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEvaluacin.setForeground(Color.BLACK);
		lblEvaluacin.setBounds(221, 190, 86, 14);
		contentPanel.add(lblEvaluacin);
		
		txtEvaluacion = new JTextField();
		txtEvaluacion.setEditable(false);
		txtEvaluacion.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEvaluacion.setForeground(Color.BLACK);
		txtEvaluacion.setBounds(295, 187, 113, 20);
		contentPanel.add(txtEvaluacion);
		txtEvaluacion.setColumns(10);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisponibilidad.setForeground(Color.BLACK);
		lblDisponibilidad.setBounds(10, 228, 113, 14);
		contentPanel.add(lblDisponibilidad);
		
		txtDisponibilidad = new JTextField();
		txtDisponibilidad.setEditable(false);
		txtDisponibilidad.setFont(new Font("Dialog", Font.BOLD, 12));
		txtDisponibilidad.setForeground(Color.BLACK);
		txtDisponibilidad.setBounds(104, 225, 105, 20);
		contentPanel.add(txtDisponibilidad);
		txtDisponibilidad.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void VerDetalles(int filaSeleccionada) {
		Empleado aux = Empresa.getInstance().getMisEmpleados().get(filaSeleccionada);
		txtID.setText(aux.getId());
		txtNombre.setText(aux.getNombre());
		txtSalario.setText(Float.toString(aux.getSalario()));
		txtSexo.setText(Character.toString(aux.getSexo()));;
		txtEdad.setText(Integer.toString(aux.getEdad()));
		txtCargo.setText(aux.getCargo());
		txtEvaluacion.setText(aux.getEvaluacion());
		txtDireccion.setText(aux.getDireccion());
		txtDisponibilidad.setText(aux.getDisponibilidad());
	}
}
