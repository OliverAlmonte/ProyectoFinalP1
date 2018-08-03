package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.Contrato;
import code.Empresa;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HacerProrroga extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    @SuppressWarnings("unused")
	private Contrato contract;
    private JButton btnFinish;
    private JDateChooser dateChooserPro;
    private JTextField txtFechaActual;
    @SuppressWarnings("unused")
	private Calendar c1 = Calendar.getInstance();
   	@SuppressWarnings("unused")
	private Calendar c2 = new GregorianCalendar();
       /**
        * @wbp.nonvisual location=111,389
        */
       
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public HacerProrroga(Contrato contract) {
		setTitle("Realizar Prorroga");
		this.contract = contract;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		dateChooserPro = new JDateChooser();
		dateChooserPro.setBounds(290, 106, 87, 20);
		contentPanel.add(dateChooserPro);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setText(Contrato.formatoFechaInicio(contract.getProyecto().getFechaFinal()));
		txtFechaActual.setEnabled(false);
		txtFechaActual.setBounds(56, 106, 86, 20);
		contentPanel.add(txtFechaActual);
		txtFechaActual.setColumns(10);
		
		JLabel lblFechaDeEntega = new JLabel("Fecha de entrega original:");
		lblFechaDeEntega.setBounds(33, 81, 154, 14);
		contentPanel.add(lblFechaDeEntega);
		
		JLabel lblFechaParaLa = new JLabel("Fecha para la prorroga:");
		lblFechaParaLa.setBounds(270, 81, 134, 14);
		contentPanel.add(lblFechaParaLa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFinish = new JButton("Realizar");
				btnFinish.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date fecha;
						fecha = dateChooserPro.getDate();
						contract.setFechaPro(fecha);
						contract.setProrroga(true);
						
						Empresa.getInstance().ModificarContrato(contract);
						try {
							Principal.guardar(Empresa.getInstance());
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Operación satisfactoria el contrato ha sido Prorrogado", "Información", JOptionPane.INFORMATION_MESSAGE);
						System.out.println(Contrato.formatoFechaInicio(contract.getFechaPro()));
						dispose();
						
					}
				});
				btnFinish.setActionCommand("OK");
				buttonPane.add(btnFinish);
				getRootPane().setDefaultButton(btnFinish);
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
}
