package br.com.cliente.view;

import java.util.List;

import br.com.cliente.model.Customer;

public interface SearchMessageListener {
	public List<Customer> receiveList();
	public void sendIdentifier(int id);
}
