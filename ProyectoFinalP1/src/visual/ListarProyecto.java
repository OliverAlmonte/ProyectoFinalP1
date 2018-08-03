package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import code.Contrato;
import code.Empresa;
import code.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class ListarProyecto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListarProyecto() {
		setTitle("Listado de Proyectos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarProyecto.class.getResource("/visual/project.png")));
		setBounds(100, 100, 502, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(0, 0, 486, 267);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setBackground(Color.LIGHT_GRAY);
					scrollPane.setColumnHeaderView(table);
					String[] columnNames = {"Identificador","Nombre","FechaInicial", "FechaEntrega","Tipo de proyeco"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
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
	}
	public void loadTable(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Proyecto aux : Empresa.getInstance().getMisProyectos()) {
			fila[0] = aux.getId();
			fila[1] = aux.getNombre();
			fila[2] = Contrato.formatoFechaInicio(aux.getFechaInicial());
			fila[3] = Contrato.formatoFechaInicio(aux.getFechaFinal());
			fila[4] = aux.getTipoProyect();
			model.addRow(fila);
		}
	}
}
