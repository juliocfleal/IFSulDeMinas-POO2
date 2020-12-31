package br.com.cliente.dao;

import java.util.List;

import br.com.cliente.model.Customer;

public interface CustomerDao {
	public boolean saveCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomer( int id);
	public List<Customer> getAllCustomer();


}
