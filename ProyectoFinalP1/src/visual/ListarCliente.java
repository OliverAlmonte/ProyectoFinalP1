
package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import code.Cliente;
import code.Empresa;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador;
	private JButton btnEliminar;
	private JButton btnModificar;
	
	/**
	 
	 */
	
	
	/**
	 * Create the dialog.
	 */
	public ListarCliente() {
		setResizable(false);
		setBounds(100, 100, 497, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 16, 469, 254);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								int index = table.getSelectedRow();
								identificador = (String)table.getModel().getValueAt(index, 0);
								
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setColumnHeaderView(table);
					String[] columnNames = {"Identificador","Cedula","Nombre","Direccion","Estado"};
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
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!identificador.equalsIgnoreCase("")){
							Cliente cliente = Empresa.getInstance().findClienteById(identificador);
							RegistrarCliente clien = new RegistrarCliente(cliente);
							clien.setModal(true);
							clien.setVisible(true);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!identificador.equalsIgnoreCase("")){
							Cliente cliente = Empresa.getInstance().findClienteById(identificador);
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al Cliente: " + cliente.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION){
								Empresa.getInstance().getMisClientes().remove(cliente);
								loadTable();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
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
	public static void loadTable(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(Cliente aux : Empresa.getInstance().getMisClientes()){
			fila[0] = aux.getId();
			fila[1] = aux.getCedula();
			fila[2] = aux.getNombre();
			fila[3] = aux.getDireccion();
			fila[4] = aux.getDisponibilidad();
			
			model.addRow(fila);
			
		}
	}
}
