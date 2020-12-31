package br.com.cliente.dao.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.cliente.connection.ConnectFactory;
import br.com.cliente.dao.CustomerDao;
import br.com.cliente.model.Customer;
import br.com.cliente.model.OnlineCustomer;

public class OnlineCustomerDao implements CustomerDao {

	private GregorianCalendar dtn = new GregorianCalendar();
	Date date;

	@Override
	public boolean saveCustomer(Customer customer) {
		Connection connection = null;

		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();

			String query = "insert into clientes (nome, sobrenome, cpf, data_nascimento, salario, rg, telefone) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(query);
			prepare.setString(1, customer.getNome());
			prepare.setString(2, customer.getSobrenome());
			prepare.setString(3, customer.getCpf().replace("-", "").replace(".", ""));
			prepare.setDate(4, new java.sql.Date(customer.getDataNascimento().getTimeInMillis()));
			prepare.setDouble(5, Double.parseDouble(customer.getSalario()));
			prepare.setString(6, customer.getRg().replace("-", "").replace(".", ""));
			prepare.setString(7, customer.getTelefone().replace("-", "").replace(".", ""));
			prepare.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sucesso;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		Connection connection = null;

		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();

			String query = "DELETE FROM clientes WHERE id = ?";
			PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(query);
			prepare.setInt(1, customer.getId());
			prepare.executeUpdate();
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sucesso = false;
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return sucesso;
		
		
		}



	@Override
	public Customer getCustomer(int identti) {
		Connection connection = null;
		Statement st = null;
		OnlineCustomer onlinecustomer = null;

		try {
			connection = ConnectFactory.createConnection();

			String query = "SELECT id, nome, sobrenome, cpf, data_nascimento, salario, rg, telefone FROM clientes WHERE id = " + identti;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				Calendar dataNas = Calendar.getInstance();
				Date data = rs.getDate("data_nascimento");
				dataNas.setTime(data);
				Calendar dataNascimento = dataNas;
				String salario = String.valueOf(rs.getDouble("salario"));
				String rg = rs.getString("rg");
				String telefone = rs.getString("telefone");
				onlinecustomer = new OnlineCustomer(id, nome, sobrenome, cpf, dataNascimento, salario, rg, telefone);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return onlinecustomer;

	}

	@Override
	public List<Customer> getAllCustomer() {

		List<Customer> listCustomer = new ArrayList<Customer>();
		Connection connection = null;
		Statement st = null;

		try {
			connection = ConnectFactory.createConnection();

			String query = "SELECT id, nome, sobrenome, cpf, data_nascimento, salario, rg, telefone FROM clientes";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");

				date = rs.getDate("data_nascimento");
				dtn.setTime(date);

				Calendar dataNascimento = dtn;

				String salario = Double.toString(rs.getDouble("salario"));
				String rg = rs.getString("rg");
				String telefone = rs.getString("telefone");
				listCustomer.add(new OnlineCustomer(id, nome, sobrenome, cpf, dataNascimento, salario, rg, telefone));
			//	listCustomer.clear();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return listCustomer;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Connection connection = null;

		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();

			String query = "UPDATE clientes set nome=?, sobrenome=?, cpf=?, data_nascimento=?, salario=?, rg=?, telefone=? WHERE id = ?";
			PreparedStatement prepare = (PreparedStatement) connection.prepareStatement(query);
			prepare.setString(1, customer.getNome());
			prepare.setString(2, customer.getSobrenome());
			prepare.setString(3, customer.getCpf().replace("-", "").replace(".", ""));
			prepare.setDate(4, new java.sql.Date(customer.getDataNascimento().getTimeInMillis()));
			prepare.setDouble(5, Double.parseDouble(customer.getSalario()));
			prepare.setString(6, customer.getRg().replace("-", "").replace(".", ""));
			prepare.setString(7, customer.getTelefone().replace("-", "").replace(".", ""));
			prepare.setInt(8, customer.getId());
			prepare.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sucesso;
	}

}
