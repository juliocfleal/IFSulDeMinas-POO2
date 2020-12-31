package br.com.cliente.dao.factory;

import br.com.cliente.dao.CustomerDao;
import br.com.cliente.dao.customer.OnlineCustomerDao;
import br.com.cliente.enume.ECustomer;
import br.com.cliente.model.Customer;
import br.com.cliente.model.OnlineCustomer;

public class CustomerFactory {
	public CustomerDao getDaoCustomer(Customer customer) {
		if (customer instanceof OnlineCustomer) {
			return new OnlineCustomerDao();
		}

		return null;

	}

	public CustomerDao getDaoCustomer(ECustomer tipo) {
		switch (tipo){
		case OnlineCustomer:
			return new OnlineCustomerDao();
	
			
	
		
		default:
			return null;

		
		}

}
}
