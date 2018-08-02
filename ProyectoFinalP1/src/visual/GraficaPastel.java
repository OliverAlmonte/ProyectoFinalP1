package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import code.Empresa;

public class GraficaPastel extends JDialog {

	/**
	 * 
	 */
	JPanel panel;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GraficaPastel dialog = new GraficaPastel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        int[] cantProyecto=Empresa.getInstance().cantProyectoByTipo();
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Video Juego", cantProyecto[0]);
        data.setValue("Escritorio", cantProyecto[1]);
        data.setValue("Página Web", cantProyecto[2]);
        data.setValue("App Para Móvil", cantProyecto[3]);
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Proyectos Por Tipo", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
	/**
	 * Create the dialog.
	 */
	public GraficaPastel() {
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
		init();
	}

}
