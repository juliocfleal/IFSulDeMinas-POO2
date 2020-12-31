package br.com.cliente.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.cliente.model.Customer;

public class SearchCustomerGUI extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private SearchMessageListener mySearchListener;



	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public SearchCustomerGUI() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Relatórios de Pagamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);
		
		JButton btnSelecionarIdentifier = new JButton("Selecionar ID");
		btnSelecionarIdentifier.setEnabled(false);
		btnSelecionarIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				int id = Integer.parseInt(value);
				mySearchListener.sendIdentifier(id);
				dispose();
			}
		});
		btnSelecionarIdentifier.setIcon(new ImageIcon(SearchCustomerGUI.class.getResource("/br/com/cliente/view/img/Stormtrooper-icon_34494.png")));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(SearchCustomerGUI.class.getResource("/br/com/cliente/view/img/darth-mauls-lightsabers_87095(1).png")));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addGap(170)
					.addComponent(btnSelecionarIdentifier, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		gl_panelSul.setVerticalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSul.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelecionarIdentifier, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelSul.linkSize(SwingConstants.VERTICAL, new Component[] {btnSelecionarIdentifier, btnFechar});
		gl_panelSul.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSelecionarIdentifier, btnFechar});
		panelSul.setLayout(gl_panelSul);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Pesquisa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap(391, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(385))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSelecionarIdentifier.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "CPF", "Data de Nascimento", "Rg", "Salario", "Telefone"
			}
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(186);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(189);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(137);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
	            table.getTableHeader().getDefaultRenderer();
		
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		scrollPane.setViewportView(table);
	}
	
	public void addSearchListener(SearchMessageListener mySearchMessgeListener) {
		this.mySearchListener = mySearchMessgeListener;
	}
	
		
	public void updateTable() {
		
	/* recupero a lista de Payable */
		List<Customer> listCustomer = mySearchListener.receiveList();
		
		/* Código para popular a JTable */
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		table.setModel(modelo);
		
		int numeroLinhas = modelo.getRowCount();
		
		for(int i=0; i<numeroLinhas;i++)
			modelo.removeRow(0);
		
		Object[] elementos = new Object[8];
		
		
		for(Customer tipo_interface_customer : listCustomer) {
			
			if(tipo_interface_customer instanceof Customer) {
				Customer cliente = (Customer) tipo_interface_customer;
				elementos[0] = cliente.getId();
				elementos[1] = cliente.getNome();
				elementos[2] = cliente.getSobrenome();
				elementos[3] = cliente.getCpf();
				elementos[4] = cliente.formataData(cliente.getDataNascimento());
				elementos[5] = cliente.getRg();
				elementos[6] = cliente.getSalario();
				elementos[7] = cliente.getTelefone();


			}					modelo.addRow(elementos);
			
		}
	}
}
