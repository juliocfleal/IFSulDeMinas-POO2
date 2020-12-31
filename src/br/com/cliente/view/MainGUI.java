package br.com.cliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.cliente.view.add.OnlineCustomerGUI;
import br.com.cliente.view.delete.CustomerDeleteGui;
import br.com.cliente.view.delete.FilterDeleteCustomer;
import br.com.cliente.view.report.ReportGUI;
import br.com.cliente.view.update.FilterUpdateCustomer;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainGUI {

	private JFrame frmSistemaDeClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmSistemaDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeClientes = new JFrame();
		frmSistemaDeClientes.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSistemaDeClientes.setResizable(false);
		frmSistemaDeClientes.setTitle("Sistema de Clientes");
		frmSistemaDeClientes.setBounds(100, 100, 720, 442);
		frmSistemaDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeClientes.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmSistemaDeClientes.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/scifi_starwars_darth_icon_157471(1).png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/R2D2-icon_34499.png")));
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap(1580, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addContainerGap(1666, Short.MAX_VALUE))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 650, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeClientes.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		mntmSair.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Millennium-Falcon-icon_34498.png")));
		mnArquivo.add(mntmSair);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenu mnClientes = new JMenu("Incluir");
		mnClientes.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Leia-icon_34495.png")));
		mnCadastro.add(mnClientes);
		
		JMenuItem mntmClienteOnline = new JMenuItem("Cliente Online");
		mntmClienteOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OnlineCustomerGUI interGUI = new OnlineCustomerGUI();
				interGUI.setLocationRelativeTo(null);
				interGUI.setVisible(true);
				
				
			}
		});
		mntmClienteOnline.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Leia-icon_34495.png")));
		mnClientes.add(mntmClienteOnline);
		
		JMenu mnAlterarClientes = new JMenu("Alterar");
		mnAlterarClientes.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Chewbacca-icon_34502.png")));
		mnCadastro.add(mnAlterarClientes);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar Cliente");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FilterUpdateCustomer interGUI = new FilterUpdateCustomer();
				interGUI.setLocationRelativeTo(null);
				interGUI.setVisible(true);
			
			
			}
		});
		mntmAlterar.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Chewbacca-icon_34502.png")));
		mnAlterarClientes.add(mntmAlterar);
		
		JMenu mnExcluirClientes = new JMenu("Excluir");
		mnExcluirClientes.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Death-Star-icon_34500.png")));
		mnCadastro.add(mnExcluirClientes);
		
		JMenuItem mntmExluir = new JMenuItem("Excluir Cliente");
		mntmExluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FilterDeleteCustomer interGUI = new FilterDeleteCustomer();
				interGUI.setLocationRelativeTo(null);
				interGUI.setVisible(true);
			
			
			}
		});
		mntmExluir.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Death-Star-icon_34500.png")));
		mnExcluirClientes.add(mntmExluir);
		
		JMenu mnRelatorio = new JMenu("Relatorio");
		menuBar.add(mnRelatorio);
		
		JMenuItem mntmVisualiarRelatorio = new JMenuItem("Visualiar Relatorio");
		mntmVisualiarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportGUI interGUI= new ReportGUI();
				interGUI.setLocationRelativeTo(null);
				interGUI.setVisible(true);
				
			}
		});
		mntmVisualiarRelatorio.setIcon(new ImageIcon(MainGUI.class.getResource("/br/com/cliente/view/img/Boba-Fett-icon_34504.png")));
		mnRelatorio.add(mntmVisualiarRelatorio);
	}
}
