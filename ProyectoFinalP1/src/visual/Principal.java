package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
    private Dimension dim;//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/visual/logo.png")));
		setResizable(false);
		setTitle("Magic Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		

		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente clien = new RegistrarCliente(null);
				clien.setModal(true);
				clien.setVisible(true);
				
			}
		});
		mnRegistrar.add(mntmCliente);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEmpleado emp1 = new AgregarEmpleado();
				emp1.setModal(true);
				emp1.setVisible(true);
			}
		});
		mnRegistrar.add(mntmEmpleado);
		
		JMenuItem mntmProyecto = new JMenuItem("Proyecto");
		mntmProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProyecto proyecto = new RegistrarProyecto();
				proyecto.setModal(true);
				proyecto.setVisible(true);
			}
		});
		mnRegistrar.add(mntmProyecto);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		

		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente lista1 = new ListarCliente();
				lista1.setModal(true);
				lista1.setVisible(true);
			}
		});
		mnListar.add(mntmCliente_1);
		
		JMenuItem mntmEmpleado_1 = new JMenuItem("Empleado");
		mntmEmpleado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleados emp2 = new ListarEmpleados();
				emp2.setModal(true);
				emp2.setVisible(true);
			}
		});
		mnListar.add(mntmEmpleado_1);
		
		JMenuItem mntmProyecto_1 = new JMenuItem("Proyecto");
		mntmProyecto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnListar.add(mntmProyecto_1);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
