package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import code.Disenador;
import code.Empleado;
import code.Empresa;
import code.Jefe;
import code.Planificador;
import code.Programador;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
@SuppressWarnings("rawtypes")
public class ListarEmpleados extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnDetalles;
	private static JButton btnEliminar;
	private String code;
	JComboBox cbxTipo;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked"})
	public ListarEmpleados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarEmpleados.class.getResource("/visual/lista.png")));
		this.code = "";
		setResizable(false);
		setTitle("Listado de Empleados");
		setBounds(100, 100, 658, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 11, 624, 293);
			contentPanel.add(panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 54, 604, 228);
				panel.add(scrollPane);
				
				table = new JTable();
				table.setFont(new Font("Tahoma", Font.PLAIN, 12));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow() >= 0){
							btnEliminar.setEnabled(true);
							btnDetalles.setEnabled(true);
							int index = table.getSelectedRow();
							code = (String)table.getModel().getValueAt(index, 0);
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableModel = new DefaultTableModel();
				String[] columnNames = {"ID","Nombre", "Disponibilidad", "Evaluacion", "Ocupación"};
				tableModel.setColumnIdentifiers(columnNames);
				loadTableQuesos(0);
				scrollPane.setColumnHeaderView(table);
				scrollPane.setViewportView(table);
			}
			{
				JLabel lblTipoDeEmpleado = new JLabel("Tipo de Empleado:");
				lblTipoDeEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblTipoDeEmpleado.setBounds(10, 29, 116, 14);
				panel.add(lblTipoDeEmpleado);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cbxTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selection = cbxTipo.getSelectedIndex();
						loadTableQuesos(selection);
					}
				});
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Jefe", "Programador", "Diseñador", "Planificador"}));
				cbxTipo.setBounds(127, 26, 157, 20);
				panel.add(cbxTipo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDetalles = new JButton("Detalles");
				btnDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Empleado aux = Empresa.getInstance().findQuesoById(code);
						//RegistrarQueso Empleado = new RegistrarQueso(0, aux);
						//Empleado.setModal(true);
						//Empleado.setVisible(true);
						btnEliminar.setEnabled(false);
						btnDetalles.setEnabled(false);
					}
				});
				btnDetalles.setEnabled(false);
				buttonPane.add(btnDetalles);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Empleado aux = Empresa.getInstance().findEmpleadoById(code);
						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar el Empleado: " + aux.getId(), null, JOptionPane.YES_NO_OPTION);
						if(delete == JOptionPane.YES_OPTION){
							Empresa.getInstance().getMisEmpleados().remove(aux);
							loadTableQuesos(0);
						}
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
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
	public static void loadTableQuesos(int selection){
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		
		switch (selection) {
		case 0:
			for (Empleado aux : Empresa.getInstance().getMisEmpleados()) {
				fila[0] = aux.getId();
				fila[1] = aux.getNombre();
				fila[2] = aux.getDisponibilidad();
				fila[3] = aux.getEvaluacion();
				if(aux instanceof Jefe)
					fila[4] = "Jefe";
				if(aux instanceof Programador)
					fila[4] = "Programador";
				if(aux instanceof Planificador)
					fila[4] = "Planificador";
				if(aux instanceof Disenador)
					fila[4] = "Diseñador";
				
				tableModel.addRow(fila);
			}
			break;
			
         case 1:
        	 for (Empleado aux : Empresa.getInstance().getMisEmpleados()) {
 			  if(aux instanceof Jefe){
 				fila[0] = aux.getId();
				fila[1] = aux.getNombre();
				fila[2] = aux.getDisponibilidad();
				fila[3] = aux.getEvaluacion();
				fila[4] = "Jefe";
 				tableModel.addRow(fila);
 			 }
 			}
			
			break;
			

         case 2:
        	 for (Empleado aux : Empresa.getInstance().getMisEmpleados()) {
      			if(aux instanceof Planificador){
      				fila[0] = aux.getId();
     				fila[1] = aux.getNombre();
     				fila[2] = aux.getDisponibilidad();
     				fila[3] = aux.getEvaluacion();
     				fila[4] = "Planificador";
      				tableModel.addRow(fila);
      			}
      		}
 			
 			break;
 			
         case 3:
        	 for (Empleado aux : Empresa.getInstance().getMisEmpleados()) {
    			  if(aux instanceof Disenador){
    				fila[0] = aux.getId();
   				fila[1] = aux.getNombre();
   				fila[2] = aux.getDisponibilidad();
   				fila[3] = aux.getEvaluacion();
   				fila[4] = "Disenador";
    				tableModel.addRow(fila);
    			 }
    			}
 			
 			break;
		}
		
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(130);
		columnModel.getColumn(4).setPreferredWidth(81);
	}
	
	
}
