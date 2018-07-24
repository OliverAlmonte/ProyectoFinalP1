package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class RegistrarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nombre;
	private JTextField txt_id;
	private JTextField txt_direccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarClientes dialog = new RegistrarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarClientes() {
		setTitle("Registrar Cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(27, 27, 43, 19);
		contentPanel.add(lblnombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(80, 26, 173, 20);
		contentPanel.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		JLabel lblid = new JLabel(" ID:");
		lblid.setBounds(25, 78, 45, 14);
		contentPanel.add(lblid);
		
		txt_id = new JTextField();
		txt_id.setBounds(80, 75, 116, 20);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(27, 124, 55, 14);
		contentPanel.add(lblDireccion);
		
		txt_direccion = new JTextField();
		txt_direccion.setBounds(80, 121, 173, 20);
		contentPanel.add(txt_direccion);
		txt_direccion.setColumns(10);
		{
			JButton okButton = new JButton("Registrar");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mensaje;
					mensaje=txt_nombre.getText()+"Su id es "+txt_id.getText()+"Y su direccion es"+txt_direccion.getText();
					System.out.println(mensaje);
				}
			});
			okButton.setBounds(241, 205, 77, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(328, 205, 80, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 10, -10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 6, 414, 188);
		contentPanel.add(panel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
