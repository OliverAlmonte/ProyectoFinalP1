package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import code.Contrato;
import code.Empresa;
import code.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ListarProyecto extends JDialog {

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
		setBounds(100, 100, 502, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado de Proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 476, 276);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					scrollPane.setColumnHeaderView(table);
					String[] columnNames = {"Identificador","Nombre","FechaInicial", "FechaEntrega"};
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	public void loadTable(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Proyecto aux : Empresa.getInstance().getMisProyectos()) {
			fila[0] = aux.getId();
			fila[1] = aux.getNombre();
			fila[2] = Contrato.formatoFechaInicio(aux.getFechaInicial());
			fila[3] = Contrato.formatoFechaInicio(aux.getFechaFinal());
			model.addRow(fila);
		}
	}
}
