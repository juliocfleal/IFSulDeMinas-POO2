package br.com.cliente.view.report;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.imageio.metadata.IIOMetadataNode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.cliente.controller.ControllerCustomer;
import br.com.cliente.model.Customer;

public class ReportGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ReportGUI() {
		setTitle("Relatorio");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);

		JButton btnNewButtonrELATORIO = new JButton("RELATORIO");
		btnNewButtonrELATORIO.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButtonrELATORIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Customer> listCustomer = ControllerCustomer.getInstance().listAll();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				table.setModel(modelo);
				int numeroLinhas = modelo.getRowCount();

				for (int i = 0; i < numeroLinhas; i++)
					modelo.removeRow(0);

				Object[] elementos = new Object[7];

				for (Customer customer : listCustomer) {
					Customer cliente = (Customer) customer;
					elementos[0] = cliente.getNome();
					elementos[1] = cliente.getSobrenome();
					elementos[2] = cliente.getCpf();
					elementos[3] = cliente.formataData(cliente.getDataNascimento());
					elementos[4] = cliente.getRg();
					elementos[5] = cliente.getSalario();
					elementos[6] = cliente.getTelefone();
					modelo.addRow(elementos);

				}				
			}
		});

		JButton btnNewButtoNcANCELAR = new JButton("CANCELAR");
		btnNewButtoNcANCELAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButtoNcANCELAR.setFont(new Font("Dialog", Font.BOLD, 20));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup().addGap(119).addComponent(btnNewButtonrELATORIO).addGap(44)
						.addComponent(btnNewButtoNcANCELAR).addContainerGap(158, Short.MAX_VALUE)));
		gl_panelSul.setVerticalGroup(gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
						.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButtonrELATORIO).addComponent(btnNewButtoNcANCELAR))
						.addContainerGap()));
		panelSul.setLayout(gl_panelSul);

		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(60, 60));
		panelNorth.setMinimumSize(new Dimension(60, 60));
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JLabel lblRelatorio = new JLabel("RELATORIO");
		lblRelatorio.setFont(new Font("Dialog", Font.BOLD, 20));
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNorth
				.createSequentialGroup().addGap(249).addComponent(lblRelatorio).addContainerGap(259, Short.MAX_VALUE)));
		gl_panelNorth.setVerticalGroup(
				gl_panelNorth.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNorth.createSequentialGroup()
						.addContainerGap().addComponent(lblRelatorio).addContainerGap(24, Short.MAX_VALUE)));
		panelNorth.setLayout(gl_panelNorth);

		JPanel panelCENTER = new JPanel();
		contentPane.add(panelCENTER, BorderLayout.CENTER);
		panelCENTER.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelCENTER.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Sobrenome", "CPF", "Data de Nascimento", "RG", "Sal\u00E1rio", "Telefone"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(table);
	}
}
