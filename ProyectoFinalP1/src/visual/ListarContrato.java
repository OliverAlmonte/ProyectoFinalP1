package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import code.Contrato;
import code.Empresa;
import code.Proyecto;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String identificador;
	private JButton btnProrrogar;
	private JButton btnTerminar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListarContrato() {
		setBounds(100, 100, 526, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 490, 276);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow() >= 0){
						btnProrrogar.setEnabled(true);
						btnTerminar.setEnabled(true);
						int index = table.getSelectedRow();
						identificador = (String)table.getModel().getValueAt(index, 0);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setColumnHeaderView(table);
			String[] columnNames = {"Identificador","Proyecto","Cliente","Precio","Estado"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table.setModel(model);
			loadTableContract();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnProrrogar = new JButton("Prorrogar");
			btnProrrogar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!identificador.equalsIgnoreCase("")){
						Contrato contract = Empresa.getInstance().findContratoById(identificador);
						if(contract.isProrroga() == false && contract.isEstado() == true){
						HacerProrroga pro = new HacerProrroga(contract);
						pro.setModal(true);
						pro.setVisible(true);
						}else if(contract.isProrroga() == true && contract.isEstado() == true){
							JOptionPane.showMessageDialog(null, "El contrato ya ha sido Prorrogado previamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
						if(contract.isEstado() == false){
							JOptionPane.showMessageDialog(null, "Este contrato no peude ser prorrogado por que ya esta terminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
					btnProrrogar.setEnabled(false);
					btnTerminar.setEnabled(false);
					}
				}
			});
			btnProrrogar.setEnabled(false);
			buttonPane.add(btnProrrogar);
			
			btnTerminar = new JButton("Terminar");
			btnTerminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!identificador.equalsIgnoreCase("")){
					Contrato contract = Empresa.getInstance().findContratoById(identificador);
					
					int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea dar por Terminado el Contrato: " + contract.getId(),"Información",JOptionPane.WARNING_MESSAGE);
					if(option == JOptionPane.OK_OPTION){
					contract.setEstado(false);
					contract.getCliente().setDisponibilidad(true);
					System.out.println(contract.getMisEmps().get(0).isDisp()+" creo que ya esta resulto");
					System.out.println(contract.getMisEmps().size()+" creo que ya esta resulto");
					for(int i = 0; i < contract.getMisEmps().size(); i++){//aqui cambio la disponiblilidad de lso emosps y lo los agrego al jlist de RegProyect
						contract.getMisEmps().get(i).setDisp(true);
						Empresa.getInstance().ModificarEmpleado(contract.getMisEmps().get(i));
						RegistrarProyecto.agregarEmpDisp(contract.getMisEmps().get(i));
						System.out.println("listo");
					}
					Empresa.getInstance().ModificarContrato(contract);
					Empresa.getInstance().ModificarCliente(contract.getCliente());
					loadTableContract();
					}
					}
					btnProrrogar.setEnabled(false);
					btnTerminar.setEnabled(false);
					
				}
			});
			btnTerminar.setEnabled(false);
			buttonPane.add(btnTerminar);
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
	public static void loadTableContract(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Contrato aux : Empresa.getInstance().getMisContratos()) {
			fila[0] = aux.getId();
			fila[1] = aux.getProyecto().getId();
			fila[2] = aux.getCliente().getId();
			fila[3] = aux.getPrecioP();
			fila[4] = aux.getEstadoActual();
			model.addRow(fila);
		}
	}
	
}
