package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import code.Contrato;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public class Prueba extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JDateChooser dateChooser;
    private JDateChooser dateChooser2;
    @SuppressWarnings("unused")
	private Calendar c1 = Calendar.getInstance();
	private Calendar c2 = new GregorianCalendar();
    /**
     * @wbp.nonvisual location=111,389
     */
    @SuppressWarnings("unused")
	private final JCalendar calendar = new JCalendar();
    private JTextField txtFechaI;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Prueba dialog = new Prueba();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Prueba() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		
		dateChooser.setBounds(96, 68, 87, 20);
		contentPanel.add(dateChooser);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(229, 68, 87, 20);
		contentPanel.add(dateChooser2);
		
		txtFechaI = new JTextField();
		txtFechaI.setEnabled(false);
		txtFechaI.setText(Integer.toString(c2.get(Calendar.DATE))+"/"+Integer.toString(c2.get(Calendar.MONTH)+1)+"/"+Integer.toString(c2.get(Calendar.YEAR)));
		txtFechaI.setBounds(96, 99, 86, 20);
		contentPanel.add(txtFechaI);
		txtFechaI.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("unused")
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date fecha, fecha2;
						Date fechaInicial = null;
						try {
							fechaInicial = dateFormat.parse(txtFechaI.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						fecha = dateChooser.getDate();
						fecha2 = dateChooser2.getDate();
						System.out.println(Contrato.formatoFechaInicio(fechaInicial));
						System.out.println(Contrato.formatoFechaInicio(fecha2));
						System.out.println(Contrato.numeroDiasEntreDosFechas(fechaInicial, fecha2));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
	public static int numeroDiasEntreDosFechas(Date fecha1, Date fecha2){
	     long startTime = fecha1.getTime();
	     long endTime = fecha2.getTime();
	     long diffTime = endTime - startTime;
	     long diffDays = diffTime / (1000 * 60 * 60 * 24);
	     return (int)diffDays;
	}
}
