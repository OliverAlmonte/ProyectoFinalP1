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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente;
	private JTextField txtNombre;
	private JTextField textId;
	private JTextField txtDireccion;
	private JTextField textField;
	private JTextField txtCedula;

	/*

	 */

	
	/**
	 * Create the dialog.
	 */
	public RegistrarCliente(final Cliente cliente) {
		setTitle("Registro Cliente");
		setResizable(false);
		this.miCliente = cliente;
		if(miCliente == null){
			setTitle("Registro de Clientes");
		}else{
			setTitle("Modificar Cliente");
		}
		setBounds(100, 100, 498, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 10, -10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos personales", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.activeCaption));
		panel_1.setBounds(20, 27, 454, 257);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(25, 84, 80, 14);
		panel_1.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(115, 81, 115, 20);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);
		if(cliente != null){
			txtCedula.setEditable(false);
		}
		
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(25, 163, 80, 14);
		panel_1.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(115, 160, 231, 20);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblid = new JLabel(" ID:");
		lblid.setBounds(25, 125, 70, 14);
		panel_1.add(lblid);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(115, 122, 116, 20);
		panel_1.add(textId);
		textId.setColumns(10);
		
		if(cliente == null){
			textId.setText("Clien-"+(Cliente.getCantClien()+1));
		}else{
			textId.setText(cliente.getId());
		}
		
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(25, 33, 70, 32);
		panel_1.add(lblnombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 45, 231, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		{
	
		
		JTextArea txtrTodosLosCampos = new JTextArea();
		txtrTodosLosCampos.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
		txtrTodosLosCampos.setBackground(UIManager.getColor("Button.background"));
		txtrTodosLosCampos.setTabSize(2);
		txtrTodosLosCampos.setBounds(10, 295, 165, 22);
		contentPanel.add(txtrTodosLosCampos);
		txtrTodosLosCampos.setText("* Todos los campos son obligatorios");
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("");
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
							Empresa.getInstance().insertCliente(cliente);
							
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else{
							cliente.setCedula(txtCedula.getText());
							cliente.setNombre(txtNombre.getText());
							cliente.setDireccion(txtDireccion.getText());
							Empresa.getInstance().ModificarCliente(cliente);
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
		textId.setText("Clien-"+(Cliente.getCantClien()+1));
		txtNombre.setText("");
		txtDireccion.setText("");
		
	}
}
	