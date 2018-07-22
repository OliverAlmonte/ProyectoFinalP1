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
import javax.swing.border.TitledBorder;


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
		setBounds(100, 100, 509, 389);
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
		txtNombre.setEditable(false);
		txtNombre.setBounds(75, 113, 408, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(10, 159, 68, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(75, 156, 408, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(10, 209, 46, 14);
		contentPanel.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(171, 210, 46, 14);
		contentPanel.add(lblSexo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(316, 210, 46, 14);
		contentPanel.add(lblCargo);
		
		
		panelInfo.setBorder(new TitledBorder(null, "Informaci\u00F3n Espec\u00EDfica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(0, 253, 493, 67);
		panelInfo.setVisible(false);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLenguaje.setBounds(10, 26, 78, 14);
		panelInfo.add(lblLenguaje);
		
		txtLenguaje = new JTextField();
		txtLenguaje.setEditable(false);
		txtLenguaje.setBounds(78, 24, 86, 20);
		panelInfo.add(txtLenguaje);
		txtLenguaje.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEdad.setEditable(false);
		txtEdad.setBounds(49, 207, 68, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setEditable(false);
		txtSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSexo.setBounds(205, 207, 40, 20);
		contentPanel.add(txtSexo);
		txtSexo.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCargo.setBounds(358, 207, 86, 20);
		contentPanel.add(txtCargo);
		txtCargo.setColumns(10);
		
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
