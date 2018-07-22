package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
  //
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarProyecto() {
		setBounds(100, 100, 579, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 543, 416);
		contentPanel.add(panel);
		
		JLabel lblIdProyecto = new JLabel("Id Proyecto:");
		lblIdProyecto.setBounds(10, 24, 65, 14);
		panel.add(lblIdProyecto);
		
		textField = new JTextField();
		
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(97, 21, 145, 20);
		panel.add(textField);
		
		JLabel lblEmpleadosDisp = new JLabel("Empleados Disponibles:");
		lblEmpleadosDisp.setBounds(20, 164, 129, 14);
		panel.add(lblEmpleadosDisp);
		
		JLabel lblEmpleadosInvolucrados = new JLabel("Empleados involucrados:");
		lblEmpleadosInvolucrados.setBounds(318, 164, 129, 14);
		panel.add(lblEmpleadosInvolucrados);
		
		JButton button_1 = new JButton(">>");
		button_1.setEnabled(false);
		button_1.setBounds(239, 227, 49, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("<<");
		button_2.setEnabled(false);
		button_2.setBounds(236, 263, 51, 23);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 222, 206, 182);
		panel.add(scrollPane);
		
		JList listEmpDisp = new JList();
		scrollPane.setViewportView(listEmpDisp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 221, 206, 181);
		panel.add(scrollPane_1);
		
		JList listEmpInv = new JList();
		scrollPane_1.setViewportView(listEmpInv);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(10, 164, 11, 14);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setBounds(306, 164, 11, 14);
		panel.add(label_13);
		
		JLabel lblNombreDelProyect = new JLabel("Nombre del Proyecto:");
		lblNombreDelProyect.setBounds(20, 54, 111, 14);
		panel.add(lblNombreDelProyect);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 52, 242, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(10, 54, 11, 14);
		panel.add(label);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(20, 90, 81, 14);
		panel.add(lblFechaInicio);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(10, 90, 11, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 87, 158, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha Final:");
		lblNewLabel.setBounds(20, 121, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(9, 120, 11, 14);
		panel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 123, 161, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Programador", "Dise\u00F1ador", "Planificador"}));
		comboBox.setBounds(10, 188, 124, 20);
		panel.add(comboBox);
		
		JLabel label_14 = new JLabel("Los");
		label_14.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_14.setBounds(333, 0, 22, 14);
		contentPanel.add(label_14);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setBounds(348, 0, 11, 14);
		contentPanel.add(label_11);
		
		JLabel label_15 = new JLabel("indican campos obligatorios");
		label_15.setFont(new Font("Tahoma", Font.ITALIC, 9));
		label_15.setBounds(355, 0, 146, 14);
		contentPanel.add(label_15);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
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
