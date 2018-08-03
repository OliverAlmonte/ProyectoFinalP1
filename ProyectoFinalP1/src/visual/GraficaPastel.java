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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

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
	
	/**
	 * Create the dialog.
	 */
	public GraficaPastel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaPastel.class.getResource("/visual/chart.png")));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setVerticalAlignment(SwingConstants.TOP);
				buttonPane.add(cancelButton);
			}
		}
		init();
	}
	private void init() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
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
         "Proyectos por Tipo", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

}
