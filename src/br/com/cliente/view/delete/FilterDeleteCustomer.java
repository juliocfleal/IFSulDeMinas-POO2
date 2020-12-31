package br.com.cliente.view.delete;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import br.com.cliente.controller.ControllerCustomer;
import br.com.cliente.enume.ECustomer;
import br.com.cliente.model.Customer;
import br.com.cliente.model.OnlineCustomer;
import br.com.cliente.view.CustomerMessage;
import br.com.cliente.view.SearchCustomerGUI;
import br.com.cliente.view.SearchMessageListener;
import br.com.cliente.view.update.CustomerUpdateGui;

public class FilterDeleteCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JButton btnPesquisa;
	private JButton btnOK;
	private JButton btnCancelar;
	private JComboBox comboBox;

	/* minhas variaveis */
	private Customer customer = null;
	private List<Customer> listCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterDeleteCustomer frame = new FilterDeleteCustomer();
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
	public FilterDeleteCustomer() {
		setResizable(false);
		setTitle("Filtro para deleção");
		setBounds(100, 100, 450, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecione o tipo de Cliente:");
		lblNewLabel.setBounds(10, 11, 406, 14);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 44, 413, 148);
		contentPane.add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (!comboBox.getSelectedItem().equals("Selecione")) {
					textFieldId.setEnabled(true);
					btnPesquisa.setEnabled(true);

				} else {
					textFieldId.setEnabled(false);
					btnPesquisa.setEnabled(false);
				}

			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "OnlineCustomer" }));
		comboBox.setBounds(25, 37, 360, 30);
		panel.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Cliente");
		lblNewLabel_1.setBounds(25, 12, 132, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Id para deleção");
		lblNewLabel_2.setBounds(25, 85, 164, 14);
		panel.add(lblNewLabel_2);

		textFieldId = new JTextField();
		textFieldId.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (textFieldId.getText().length() > 0) {
					btnOK.setEnabled(true);
				} else {
					btnOK.setEnabled(false);
				}
			}
		});
		textFieldId.setEnabled(false);
		textFieldId.setBounds(25, 108, 224, 27);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ECustomer tipo = ECustomer.valueOf((String) comboBox.getSelectedItem());
				switch (tipo) {

				case OnlineCustomer:

					listCustomer = ControllerCustomer.getInstance().ListByType(tipo);

					MySearchMessage mySearchMessage = new MySearchMessage();
					SearchCustomerGUI search = new SearchCustomerGUI();
					search.addSearchListener(mySearchMessage);
					search.updateTable();
					search.setLocationRelativeTo(null);
					search.setVisible(true);

					break;

				}

			}

		});
		btnPesquisa.setEnabled(false);
		btnPesquisa.setBounds(259, 108, 126, 27);
		panel.add(btnPesquisa);

		btnOK = new JButton("Prosseguir");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ECustomer tipo = ECustomer.valueOf((String) comboBox.getSelectedItem());
				int id = Integer.parseInt(textFieldId.getText());

				switch (tipo) {

				case OnlineCustomer:

					OnlineCustomer resposta = (OnlineCustomer) ControllerCustomer.getInstance().getCustomer(id, tipo);

					if (resposta == null) {

						JOptionPane.showMessageDialog(null, "Id não localizado", "Problema",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					customer = resposta;

					dispose();

					CustomerDeleteGui gui = new CustomerDeleteGui();

					MyCustomerMessage my = new MyCustomerMessage();

					gui.addCustomerMessage(my);
					gui.updateGUI();

					gui.setLocationRelativeTo(null);
					gui.setVisible(true);
					break;

				default:
					return;
				}

			}
		});
		btnOK.setEnabled(false);
		btnOK.setBounds(167, 203, 127, 34);
		contentPane.add(btnOK);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(315, 203, 108, 34);
		contentPane.add(btnCancelar);
	}

	private class MyCustomerMessage implements CustomerMessage {

		@Override
		public Customer receiveCustomer() {

			return customer;
		}

	}

	


		private class MySearchMessage implements SearchMessageListener {

			@Override
			public List<Customer> receiveList() {
				return listCustomer;
			}

			@Override
			public void sendIdentifier(int id) {
				String identifier = String.valueOf(id);
				textFieldId.setText(identifier);			
			}

		}


	}