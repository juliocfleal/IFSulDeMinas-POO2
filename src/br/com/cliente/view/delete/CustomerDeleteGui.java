package br.com.cliente.view.delete;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.cliente.controller.ControllerCustomer;
import br.com.cliente.model.OnlineCustomer;
import br.com.cliente.view.CustomerMessage;

public class CustomerDeleteGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSobreNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldSalario;
	private JTextField textFieldTelefone;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAno;
	private JTextField textFieldId;
	private CustomerMessage customerMessage;

	public CustomerDeleteGui() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CustomerDeleteGui.class.getResource("/br/com/cliente/view/img/onlineshop_78377.png")));
		setResizable(false);
		setTitle("Excluir Cliente Online");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 760);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldNome.setColumns(10);

		JLabel lblSobreNome = new JLabel("Sobrenome:");
		lblSobreNome.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldSobreNome = new JTextField();
		textFieldSobreNome.setEditable(false);
		textFieldSobreNome.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldSobreNome.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldCPF = new JTextField();
		textFieldCPF.setEditable(false);
		textFieldCPF.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldCPF.setColumns(10);

		JButton btnIncluir = new JButton("DELETAR");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textFieldId.getText();
				String nome = textFieldNome.getText();
				String sobrenome = textFieldSobreNome.getText();
				String cpf = textFieldCPF.getText();
				String rg = textFieldRG.getText();
				String salario = textFieldSalario.getText();
				String telefone = textFieldTelefone.getText();
				int year = Integer.parseInt((String) comboBoxAno.getSelectedItem());
				int month = Integer.parseInt((String) comboBoxMes.getSelectedItem());
				int day = Integer.parseInt((String) comboBoxDia.getSelectedItem());


				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.set(Calendar.DAY_OF_MONTH, day);
				dataNascimento.set(Calendar.MONTH, (month - 1));
				dataNascimento.set(Calendar.YEAR, year);

				int iid = Integer.parseInt(id);

				OnlineCustomer Oc = new OnlineCustomer(iid, nome, sobrenome, cpf, dataNascimento, salario, rg,
						telefone);
				boolean r = ControllerCustomer.getInstance().deleteCustomer(Oc);
				dispose();

				if (r == true) {

					JOptionPane.showMessageDialog(null, Oc.toString() + "\n Alterado com sucesso!", "Incluido!",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (r == false) {
					JOptionPane.showMessageDialog(null, "\n Ocorreu um erro!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnIncluir.setIcon(new ImageIcon(CustomerDeleteGui.class.getResource("/br/com/cliente/view/img/Death-Star-icon_34500.png")));
		btnIncluir.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIcon(new ImageIcon(
				CustomerDeleteGui.class.getResource("/br/com/cliente/view/img/darth-mauls-lightsabers_87095(1).png")));
		btnCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancelar.setSelectedIcon(new ImageIcon(
				CustomerDeleteGui.class.getResource("/br/com/cliente/view/img/darth-mauls-lightsabers_87095(1).png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 20));

		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldRG = new JTextField();
		textFieldRG.setEditable(false);
		textFieldRG.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldRG.setColumns(10);

		JLabel lblSalrio = new JLabel("Salário:");
		lblSalrio.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldSalario = new JTextField();
		textFieldSalario.setEditable(false);
		textFieldSalario.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldSalario.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldTelefone = new JTextField();
		textFieldTelefone.setEditable(false);
		textFieldTelefone.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldTelefone.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data de nascimento: (dia/mes/ano)");
		lblDataNascimento.setFont(new Font("Dialog", Font.BOLD, 16));

		comboBoxDia = new JComboBox();
		comboBoxDia.setEnabled(false);
		comboBoxDia.addItem("1");
		comboBoxDia.addItem("2");
		comboBoxDia.addItem("3");
		comboBoxDia.addItem("4");
		comboBoxDia.addItem("5");
		comboBoxDia.addItem("6");
		comboBoxDia.addItem("7");
		comboBoxDia.addItem("8");
		comboBoxDia.addItem("9");
		comboBoxDia.addItem("10");
		comboBoxDia.addItem("11");
		comboBoxDia.addItem("12");
		comboBoxDia.addItem("13");
		comboBoxDia.addItem("14");
		comboBoxDia.addItem("15");
		comboBoxDia.addItem("16");
		comboBoxDia.addItem("17");
		comboBoxDia.addItem("18");
		comboBoxDia.addItem("19");
		comboBoxDia.addItem("20");
		comboBoxDia.addItem("21");
		comboBoxDia.addItem("22");
		comboBoxDia.addItem("23");
		comboBoxDia.addItem("24");
		comboBoxDia.addItem("25");
		comboBoxDia.addItem("26");
		comboBoxDia.addItem("27");
		comboBoxDia.addItem("28");
		comboBoxDia.addItem("29");
		comboBoxDia.addItem("30");
		comboBoxDia.addItem("31");

		comboBoxDia.setMaximumRowCount(32);
		comboBoxDia.setFont(new Font("Dialog", Font.BOLD, 14));

		comboBoxMes = new JComboBox();
		comboBoxMes.setEnabled(false);

		comboBoxMes.addItem("1");
		comboBoxMes.addItem("2");
		comboBoxMes.addItem("3");
		comboBoxMes.addItem("4");
		comboBoxMes.addItem("5");
		comboBoxMes.addItem("6");
		comboBoxMes.addItem("7");
		comboBoxMes.addItem("8");
		comboBoxMes.addItem("9");
		comboBoxMes.addItem("10");
		comboBoxMes.addItem("11");
		comboBoxMes.addItem("12");

		comboBoxMes.setFont(new Font("Dialog", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(CustomerDeleteGui.class.getResource("/br/com/cliente/view/img/R2D2-icon_34499.png")));

		comboBoxAno = new JComboBox();
		comboBoxAno.setEnabled(false);


		
		comboBoxAno.addItem("1970");
		comboBoxAno.addItem("1971");
		comboBoxAno.addItem("1972");
		comboBoxAno.addItem("1973");
		comboBoxAno.addItem("1974");
		comboBoxAno.addItem("1975");
		comboBoxAno.addItem("1976");
		comboBoxAno.addItem("1977");
		comboBoxAno.addItem("1978");
		comboBoxAno.addItem("1979");
		comboBoxAno.addItem("1980");
		comboBoxAno.addItem("1981");
		comboBoxAno.addItem("1982");
		comboBoxAno.addItem("1983");
		comboBoxAno.addItem("1984");
		comboBoxAno.addItem("1985");
		comboBoxAno.addItem("1986");
		comboBoxAno.addItem("1987");
		comboBoxAno.addItem("1988");
		comboBoxAno.addItem("1989");
		comboBoxAno.addItem("1990");
		comboBoxAno.addItem("1991");
		comboBoxAno.addItem("1992");
		comboBoxAno.addItem("1993");
		comboBoxAno.addItem("1994");
		comboBoxAno.addItem("1995");
		comboBoxAno.addItem("1996");
		comboBoxAno.addItem("1997");
		comboBoxAno.addItem("1998");
		comboBoxAno.addItem("1999");
		comboBoxAno.addItem("2000");
		comboBoxAno.addItem("2001");
		comboBoxAno.addItem("2002");
		comboBoxAno.addItem("2003");
		comboBoxAno.addItem("2004");
		comboBoxAno.addItem("2005");
		comboBoxAno.addItem("2006");
		comboBoxAno.addItem("2007");
		comboBoxAno.addItem("2008");
		comboBoxAno.addItem("2009");
		comboBoxAno.addItem("2010");
		comboBoxAno.addItem("2011");
		comboBoxAno.addItem("2012");
		comboBoxAno.addItem("2013");
		comboBoxAno.addItem("2014");
		comboBoxAno.addItem("2015");
		comboBoxAno.addItem("2016");
		comboBoxAno.addItem("2017");
		comboBoxAno.addItem("2018");
		comboBoxAno.addItem("2019");
		comboBoxAno.addItem("2020");


		comboBoxAno.setMaximumRowCount(100);
		comboBoxAno.setFont(new Font("Dialog", Font.BOLD, 14));

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldId.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldSobreNome, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRg, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldRG, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalrio, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldSalario, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSobreNome, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textFieldTelefone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
										.addGap(41)
										.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(comboBoxDia, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(comboBoxMes, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(comboBoxAno, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
								.addComponent(lblNewLabel)
								.addGap(19)))
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSobreNome, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldSobreNome, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblRg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldRG, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblSalrio, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(textFieldSalario, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxAno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnIncluir)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void addCustomerMessage(CustomerMessage customerMessage) {
		this.customerMessage = customerMessage;
	}

	public void updateGUI() {
		OnlineCustomer onlineCustomer = (OnlineCustomer) customerMessage.receiveCustomer();
		textFieldId.setText(String.valueOf(onlineCustomer.getId()));
		textFieldNome.setText(onlineCustomer.getNome());
		textFieldSobreNome.setText(onlineCustomer.getSobrenome());
		textFieldCPF.setText(onlineCustomer.getCpf());
		textFieldRG.setText(onlineCustomer.getRg());
		textFieldSalario.setText(onlineCustomer.getSalario());
		textFieldTelefone.setText(onlineCustomer.getTelefone());
		comboBoxAno.setSelectedIndex((Integer.parseInt(onlineCustomer.formataData(onlineCustomer.getDataNascimento()).substring(6,10)) - 1970));

		comboBoxMes.setSelectedIndex(Integer.parseInt(onlineCustomer.formataData(onlineCustomer.getDataNascimento()).substring(3,5))-1);
		comboBoxDia.setSelectedIndex(Integer.parseInt(onlineCustomer.formataData(onlineCustomer.getDataNascimento()).substring(0,2))-1);

	}
}
