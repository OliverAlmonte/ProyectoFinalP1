
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class ListarCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setForeground(Color.BLACK);
		setTitle("Listado de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCliente.class.getResource("/visual/1046400.png")));
		setResizable(false);
		setBounds(100, 100, 497, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 16, 469, 254);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setBackground(Color.WHITE);
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
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setBackground(Color.GRAY);
				btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
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
				btnEliminar.setBackground(Color.GRAY);
				btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!identificador.equalsIgnoreCase("")){
							Cliente cliente = Empresa.getInstance().findClienteById(identificador);
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al Cliente: " + cliente.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION){
								Empresa.getInstance().getMisClientes().remove(cliente);
								try {
									Principal.guardar(Empresa.getInstance());
								} catch (ClassNotFoundException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
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
