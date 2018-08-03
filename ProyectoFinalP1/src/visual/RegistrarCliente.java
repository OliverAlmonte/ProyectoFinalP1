package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import code.Cliente;
import code.Empresa;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class RegistrarCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente;
	private JTextField txtNombre;
	private JTextField textId;
	private JTextField txtDireccion;
	@SuppressWarnings("unused")
	private JTextField textField;
	private JTextField txtCedula;

	/*

	 */

	
	/**
	 * Create the dialog.
	 */
	public RegistrarCliente(final Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarCliente.class.getResource("/visual/1046400.png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Registro Cliente");
		setResizable(false);
		this.miCliente = cliente;
		if(miCliente == null){
			setTitle("Registro de Clientes");
		}else{
			setTitle("Modificar Cliente");
		}
		setBounds(100, 100, 401, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 10, -10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 11, 415, 252);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(25, 84, 80, 14);
		panel_1.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCedula.setBounds(115, 81, 115, 20);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);
		if(cliente != null){
			txtCedula.setEditable(false);
		}
		
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(25, 163, 80, 14);
		panel_1.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDireccion.setBounds(115, 160, 231, 20);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblid = new JLabel(" ID:");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblid.setBounds(25, 125, 70, 14);
		panel_1.add(lblid);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.BOLD, 12));
		textId.setEditable(false);
		textId.setBounds(115, 122, 116, 20);
		panel_1.add(textId);
		textId.setColumns(10);
		
		if(cliente == null){
			textId.setText("Clien-"+(Empresa.getInstance().getCantClients()+1));
		}else{
			textId.setText(cliente.getId());
		}
		
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnombre.setBounds(25, 33, 70, 32);
		panel_1.add(lblnombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombre.setBounds(115, 45, 231, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
			
			JTextArea txtrTodosLosCampos = new JTextArea();
			txtrTodosLosCampos.setForeground(Color.RED);
			txtrTodosLosCampos.setBounds(10, 219, 165, 22);
			panel_1.add(txtrTodosLosCampos);
			txtrTodosLosCampos.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
			txtrTodosLosCampos.setBackground(Color.LIGHT_GRAY);
			txtrTodosLosCampos.setTabSize(2);
			txtrTodosLosCampos.setText("* Todos los campos son obligatorios");
		{
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("");
				okButton.setBackground(Color.GRAY);
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				if(cliente == null){
					okButton.setText("Registrar");
				}else{
					okButton.setText("Modificar");
				}
				okButton.setBounds(242, 348, 98, 23);
				//contentPanel.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cliente == null){
							String Id = textId.getText();
							String cedula = txtCedula.getText();
							String nombre = txtNombre.getText();
							String direccion = txtDireccion.getText();
							Cliente cliente = new Cliente(Id, cedula, nombre, direccion);
							Empresa.getInstance().aumentarcantClients();
							Empresa.getInstance().insertCliente(cliente);
							try {
								Principal.guardar(Empresa.getInstance());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else{
							cliente.setCedula(txtCedula.getText());
							cliente.setNombre(txtNombre.getText());
							cliente.setDireccion(txtDireccion.getText());
							Empresa.getInstance().ModificarCliente(cliente);
							try {
								Principal.guardar(Empresa.getInstance());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							ListarCliente.loadTable();
							dispose();
							
						}
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
			
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setBounds(363, 348, 92, 23);
				//contentPanel.add(cancelButton);
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}	
		}
		
	//loadCliente(cliente);
	}
		loadCliente(cliente);	

	}
	private void loadCliente(Cliente cliente){
		if(cliente != null){
			txtCedula.setText(cliente.getCedula());
			txtNombre.setText(cliente.getNombre());
			txtDireccion.setText(cliente.getDireccion());
			
		}
	}
	private void clean(){
		txtCedula.setText("");
		textId.setText("Clien-"+(Empresa.getInstance().getCantClients()+1));
		txtNombre.setText("");
		txtDireccion.setText("");
		
	}
}
	