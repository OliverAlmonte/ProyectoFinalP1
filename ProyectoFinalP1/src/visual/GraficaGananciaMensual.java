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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import code.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class GraficaGananciaMensual extends JDialog {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public GraficaGananciaMensual() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaGananciaMensual.class.getResource("/visual/chart2.png")));
		setBounds(100, 100, 863, 494);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
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
	        double[] cant = Empresa.getInstance().gananciasByMes();
	        
	        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	        line_chart_dataset.addValue(cant[0], "ganancias", "Enero");
	        line_chart_dataset.addValue(cant[1], "ganancias", "Feb");
	        line_chart_dataset.addValue(cant[2], "ganancias", "Marzo");
	        line_chart_dataset.addValue(cant[3], "ganancias", "Abril");
	        line_chart_dataset.addValue(cant[4], "ganancias", "Mayo");
	        line_chart_dataset.addValue(cant[5], "ganancias", "Junio");
	        line_chart_dataset.addValue(cant[6], "ganancias", "Julio");
	        line_chart_dataset.addValue(cant[7], "ganancias", "Ag");
	        line_chart_dataset.addValue(cant[8], "ganancias", "Sep");
	        line_chart_dataset.addValue(cant[9], "ganancias", "Oct"); 
	        line_chart_dataset.addValue(cant[10], "ganancias", "Nov");   
	        line_chart_dataset.addValue(cant[11], "ganancias", "Dic");
	        // Creando el Grafico
	        JFreeChart chart=ChartFactory.createLineChart("Comparación Mensual a Escala",
	                "Mes","Dinero Facturado por la Empresa",line_chart_dataset,PlotOrientation.VERTICAL,
	                true,true,false);  
	        
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	    }
    

}
