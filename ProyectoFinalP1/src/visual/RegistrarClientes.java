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
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class RegistrarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_Id;
	private JTextField txt_cedula;
	private JTextField txt_Nombre;
	private JTextField txt_Direccion;

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
		setBounds(100, 100, 450, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 10, -10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 25, 413, 240);
		contentPanel.add(panel_1);
		
		JLabel label = new JLabel("Identificador:");
		label.setBounds(20, 21, 87, 20);
		panel_1.add(label);
		
		txt_Id = new JTextField();
		txt_Id.setEditable(false);
		txt_Id.setColumns(10);
		txt_Id.setBounds(10, 41, 109, 20);
		panel_1.add(txt_Id);
		
		JLabel label_1 = new JLabel("cedula:");
		label_1.setBounds(168, 24, 55, 14);
		panel_1.add(label_1);
		
		txt_cedula = new JTextField();
		txt_cedula.setColumns(10);
		txt_cedula.setBounds(160, 41, 226, 20);
		panel_1.add(txt_cedula);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 72, 76, 14);
		panel_1.add(lblName);
		
		txt_Nombre = new JTextField();
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(10, 88, 376, 20);
		panel_1.add(txt_Nombre);
		
		JLabel label_3 = new JLabel("Direccion:");
		label_3.setBounds(20, 135, 76, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(160, 24, 11, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(10, 72, 11, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(10, 135, 11, 14);
		panel_1.add(label_6);
		
		txt_Direccion = new JTextField();
		txt_Direccion.setColumns(10);
		txt_Direccion.setBounds(10, 155, 376, 20);
		panel_1.add(txt_Direccion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 286, 433, 33);
		contentPanel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnRegistrar = new JButton("Registar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registra aqui
			}
		});
		panel_2.add(btnRegistrar);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setActionCommand("Cancel");
		panel_2.add(button_1);
		
		JLabel label_7 = new JLabel("Los");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_7.setBounds(279, 11, 22, 14);
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(294, 11, 11, 14);
		contentPanel.add(label_8);
		
		JLabel label_9 = new JLabel("indican campos obligatorios");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_9.setBounds(298, 11, 146, 14);
		contentPanel.add(label_9);
	}
}
