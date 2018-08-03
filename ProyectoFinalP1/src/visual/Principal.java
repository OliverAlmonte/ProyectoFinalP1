package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.ArchiEmp;
import code.Empresa;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private Dimension dim;//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("software.obj"));
					salida.writeObject(Empresa.getInstance());
					salida.close();
					Empresa emp = recuperar();
					Empresa.getInstance().rellenar(emp);
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
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
	
		setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setForeground(Color.BLACK);
		mnRegistrar.setIcon(new ImageIcon(Principal.class.getResource("/visual/employe2(1).png")));
		menuBar.add(mnRegistrar);
		

		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(Principal.class.getResource("/visual/1046400.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente clien = new RegistrarCliente(null);
				clien.setModal(true);
				clien.setVisible(true);
				
			}
		});
		mnRegistrar.add(mntmCliente);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/visual/employee.png")));
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEmpleado emp1 = new AgregarEmpleado();
				emp1.setModal(true);
				emp1.setVisible(true);
			}
		});
		mnRegistrar.add(mntmEmpleado);
		
		JMenuItem mntmProyecto = new JMenuItem("Proyecto");
		mntmProyecto.setIcon(new ImageIcon(Principal.class.getResource("/visual/project.png")));
		mntmProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProyecto proyecto = new RegistrarProyecto();
				proyecto.setModal(true);
				proyecto.setVisible(true);
			}
		});
		mnRegistrar.add(mntmProyecto);
		
		JMenu mnListar = new JMenu("Listar");
		mnListar.setForeground(Color.BLACK);
		mnListar.setIcon(new ImageIcon(Principal.class.getResource("/visual/list2.png")));
		menuBar.add(mnListar);
		

		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.setIcon(new ImageIcon(Principal.class.getResource("/visual/1046400.png")));
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente lista1 = new ListarCliente();
				lista1.setModal(true);
				lista1.setVisible(true);
			}
		});
		mnListar.add(mntmCliente_1);
		
		JMenuItem mntmEmpleado_1 = new JMenuItem("Empleado");
		mntmEmpleado_1.setIcon(new ImageIcon(Principal.class.getResource("/visual/employee.png")));
		mntmEmpleado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleados emp2 = new ListarEmpleados();
				emp2.setModal(true);
				emp2.setVisible(true);
			}
		});
		mnListar.add(mntmEmpleado_1);
		
		JMenuItem mntmProyecto_1 = new JMenuItem("Proyecto");
		mntmProyecto_1.setIcon(new ImageIcon(Principal.class.getResource("/visual/project.png")));
		mntmProyecto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProyecto pro = new ListarProyecto();
				pro.setModal(true);
				pro.setVisible(true);
			}
		});
		mnListar.add(mntmProyecto_1);
		
		JMenuItem mntmContrato = new JMenuItem("Contrato");
		mntmContrato.setIcon(new ImageIcon(Principal.class.getResource("/visual/contract.png")));
		mntmContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarContrato contract = new ListarContrato();
				contract.setModal(true);
				contract.setVisible(true);
			}
		});
		mnListar.add(mntmContrato);
		
		JMenu mnInforme = new JMenu("Informe");
		mnInforme.setForeground(Color.BLACK);
		mnInforme.setIcon(new ImageIcon(Principal.class.getResource("/visual/contract2.png")));
		menuBar.add(mnInforme);
		
		JMenuItem mntmProyectosPorTipo = new JMenuItem("Proyectos por Tipo");
		mntmProyectosPorTipo.setIcon(new ImageIcon(Principal.class.getResource("/visual/chart.png")));
		mntmProyectosPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaPastel grafica1 = new GraficaPastel();
				grafica1.setModal(true);
				grafica1.setVisible(true);
			}
		});
		mnInforme.add(mntmProyectosPorTipo);
		
		JMenuItem mntmGananciasPorTipo = new JMenuItem("Ganancias por Tipo de Proyecto");
		mntmGananciasPorTipo.setIcon(new ImageIcon(Principal.class.getResource("/visual/chart3.png")));
		mntmGananciasPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaBarra grafica = new GraficaBarra();
				grafica.setModal(true);
				grafica.setVisible(true);
			}
		});
		mnInforme.add(mntmGananciasPorTipo);
		
		JMenuItem mntmDineroFacturadoPor = new JMenuItem("Dinero Facturado por la Empresa");
		mntmDineroFacturadoPor.setIcon(new ImageIcon(Principal.class.getResource("/visual/chart2.png")));
		mntmDineroFacturadoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaGananciaMensual grafica2 = new GraficaGananciaMensual();
				grafica2.setModal(true);
				grafica2.setVisible(true);
			}
		});
		mnInforme.add(mntmDineroFacturadoPor);
		
		JMenuItem mntmListaDeEmpleados = new JMenuItem("Lista de Empleados Destacados");
		mntmListaDeEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/visual/1046406.png")));
		mntmListaDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleadosDestacados empDestacado = new ListarEmpleadosDestacados();
				empDestacado.setModal(true);
				empDestacado.setVisible(true);}
		});
		mnInforme.add(mntmListaDeEmpleados);

		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public static void guardar(Empresa ob)throws IOException, ClassNotFoundException{
		ArchiEmp per = new ArchiEmp();
		per.guardar(ob);
		System.out.println("Almacenamiento correcto");
	}
	public static Empresa recuperar()throws IOException,ClassNotFoundException{
		ArchiEmp per = new ArchiEmp();
		Empresa recuperar = per.recuperar();
		System.out.println("recuperacion correcta");
		return recuperar;
	}

}
