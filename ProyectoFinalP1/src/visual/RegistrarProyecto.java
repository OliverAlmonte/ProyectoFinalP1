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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JButton btnDer;
	private JButton btnIzq;
	private JComboBox cbxEncargo;
	private JDateChooser dateChooserI;
	private JDateChooser dateChooserF;
	private JList listEmpDisp;
	private JList listEmpInv;
	
	private JButton btnReg;
	private JButton btnEspecial;
	private JButton btnA;
	private JComboBox cbxCliente;
	private JTextField txtIdContrato;
	private JTextField txtEntrega;
	private JPanel panelC;
	private JPanel panelP;
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
		
		panelC = new JPanel();
		panelC.setVisible(false);
		panelC.setLayout(null);
		panelC.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelC.setBounds(10, 25, 543, 189);
		contentPanel.add(panelC);
		
		JLabel label_3 = new JLabel("Id Proyecto:");
		label_3.setBounds(10, 24, 65, 14);
		panelC.add(label_3);
		
		txtIdContrato = new JTextField();
		txtIdContrato.setEnabled(false);
		txtIdContrato.setColumns(10);
		txtIdContrato.setBounds(97, 21, 145, 20);
		panelC.add(txtIdContrato);
		
		JLabel lblClintesDisponibles = new JLabel("Clintes Disponibles:");
		lblClintesDisponibles.setBounds(22, 76, 129, 14);
		panelC.add(lblClintesDisponibles);
		
		cbxCliente = new JComboBox();
		cbxCliente.setBounds(27, 101, 124, 20);
		panelC.add(cbxCliente);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(10, 76, 11, 14);
		panelC.add(label_5);
		
		txtEntrega = new JTextField();
		txtEntrega.setBounds(221, 101, 124, 20);
		panelC.add(txtEntrega);
		txtEntrega.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dias para Entregar:");
		lblNewLabel_1.setBounds(221, 76, 124, 14);
		panelC.add(lblNewLabel_1);
		
		panelP = new JPanel();
		panelP.setBounds(10, 25, 543, 416);
		contentPanel.add(panelP);
		panelP.setLayout(null);
		panelP.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblIdProyecto = new JLabel("Id Proyecto:");
		lblIdProyecto.setBounds(10, 24, 65, 14);
		panelP.add(lblIdProyecto);
		
		txtId = new JTextField();
		
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(97, 21, 145, 20);
		panelP.add(txtId);
		
		JLabel lblEmpleadosDisp = new JLabel("Empleados Disponibles:");
		lblEmpleadosDisp.setBounds(20, 164, 129, 14);
		panelP.add(lblEmpleadosDisp);
		
		JLabel lblEmpleadosInvolucrados = new JLabel("Empleados involucrados:");
		lblEmpleadosInvolucrados.setBounds(318, 164, 129, 14);
		panelP.add(lblEmpleadosInvolucrados);
		
		btnDer = new JButton(">>");
		btnDer.setEnabled(false);
		btnDer.setBounds(239, 227, 49, 23);
		panelP.add(btnDer);
		
		btnIzq = new JButton("<<");
		btnIzq.setEnabled(false);
		btnIzq.setBounds(236, 263, 51, 23);
		panelP.add(btnIzq);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 222, 206, 182);
		panelP.add(scrollPane);
		
		listEmpDisp = new JList();
		scrollPane.setViewportView(listEmpDisp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 221, 206, 181);
		panelP.add(scrollPane_1);
		
		listEmpInv = new JList();
		scrollPane_1.setViewportView(listEmpInv);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(10, 164, 11, 14);
		panelP.add(label_12);
		
		JLabel label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setBounds(306, 164, 11, 14);
		panelP.add(label_13);
		
		JLabel lblNombreDelProyect = new JLabel("Nombre del Proyecto:");
		lblNombreDelProyect.setBounds(20, 54, 111, 14);
		panelP.add(lblNombreDelProyect);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(137, 52, 242, 20);
		panelP.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(10, 54, 11, 14);
		panelP.add(label);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(20, 90, 81, 14);
		panelP.add(lblFechaInicio);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(10, 90, 11, 14);
		panelP.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Fecha Final:");
		lblNewLabel.setBounds(20, 121, 74, 14);
		panelP.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(9, 120, 11, 14);
		panelP.add(label_2);
		
		cbxEncargo = new JComboBox();
		cbxEncargo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Programador", "Dise\u00F1ador", "Planificador"}));
		cbxEncargo.setBounds(10, 188, 124, 20);
		panelP.add(cbxEncargo);
		
		dateChooserI = new JDateChooser();
		dateChooserI.setBounds(137, 90, 87, 20);
		panelP.add(dateChooserI);
		
		dateChooserF = new JDateChooser();
		dateChooserF.setBounds(137, 115, 87, 20);
		panelP.add(dateChooserF);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReg = new JButton("Registrar");
				btnReg.setEnabled(false);
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date f1;
						f1 = dateChooserI.getDate();
						System.out.println(formatoFechaInicio(f1));
					}
				});
				
				btnA = new JButton("Atras");
				btnA.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnA.setEnabled(false);
						btnEspecial.setEnabled(true);
						panelC.setVisible(false);
						panelP.setVisible(true);
					}
				});
				btnA.setEnabled(false);
				buttonPane.add(btnA);
				
				btnEspecial = new JButton("Siguiente");
				btnEspecial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnEspecial.setEnabled(false);
						btnA.setEnabled(true);
						panelP.setVisible(false);
						panelC.setVisible(true);
						btnReg.setEnabled(true);
					}
				});
				buttonPane.add(btnEspecial);
				btnReg.setActionCommand("OK");
				buttonPane.add(btnReg);
				getRootPane().setDefaultButton(btnReg);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public static String formatoFechaInicio(Date inicio){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = sdf.format(inicio);
		return fechaFormateada;
	}
}
