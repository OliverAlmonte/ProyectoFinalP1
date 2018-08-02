package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import code.Empresa;

public class GraficaBarra extends JDialog {
	JPanel panel;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public GraficaBarra() {
		setBounds(100, 100, 817, 495);
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
		//
		init();
	}
	 private void init() {
	        panel = new JPanel();
	        getContentPane().add(panel);
	        // Fuente de Datos
	        double[] cantVj = Empresa.getInstance().cantGananciasJuegos();
	        double[] cantEscriotio = Empresa.getInstance().cantGananciasEscritorio();
	        double[] cantWeb = Empresa.getInstance().cantGananciasWeb();
	        double[] cantMoviles = Empresa.getInstance().cantGananciasAppsMoviles();
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(cantVj[1], "Esperadas", "Video juego");
	        dataset.setValue(cantVj[0], "Reales", "Video juego");
	        dataset.setValue(cantEscriotio[1], "Esperadas", "Escritorio");
	        dataset.setValue(cantEscriotio[0], "Reales", "Escritorio");
	        dataset.setValue(cantWeb[1], "Esperadas", "Paginas web");
	        dataset.setValue(cantWeb[0], "Reales", "Paginas web");
	        dataset.setValue(cantMoviles[1], "Esperadas", "App para moviles");
	        dataset.setValue(cantMoviles[0], "Reales", "App para moviles");
	        
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Comparacion de ganacias","Ganancias", "Escala", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.cyan);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.red); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	    }

}
