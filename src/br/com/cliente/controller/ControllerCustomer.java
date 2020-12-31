package br.com.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.cliente.dao.CustomerDao;
import br.com.cliente.dao.factory.CustomerFactory;
import br.com.cliente.enume.ECustomer;
import br.com.cliente.model.Customer;
import br.com.cliente.model.OnlineCustomer;

public class ControllerCustomer {
	private static ControllerCustomer instance = null;
	private List<Customer> listCustomer = new ArrayList<Customer>();
	
	private ControllerCustomer() {}
	public static ControllerCustomer getInstance() {
		if(instance == null) {
			instance = new ControllerCustomer();
		}
		return instance;
	}
	public boolean add(Customer customer) {
		
	
		CustomerFactory factory = new CustomerFactory();
		CustomerDao dao = factory.getDaoCustomer(customer);
		boolean r = dao.saveCustomer(customer);
		return r;
	
	
	}
	public List<Customer> listAll(){
		listCustomer.clear();
		List<Customer> tempList = null;
		CustomerFactory factory = new CustomerFactory();
		for(ECustomer objeto: ECustomer.values()) {
			CustomerDao dao = factory.getDaoCustomer(objeto);
			tempList = dao.getAllCustomer();			
			if(tempList != null) {
				listCustomer.addAll(tempList);
				tempList.clear();
				
			}
			
		}
 		
		return listCustomer;
	}
	
	public Customer getCustomer(int id, ECustomer tipo) {
		
		
		CustomerFactory factory = new CustomerFactory();
		CustomerDao dao = factory.getDaoCustomer(tipo);
		Customer resposta = dao.getCustomer(id);
		return resposta;
	
	
	}
	
	
	public boolean Update(OnlineCustomer oc) {
		CustomerFactory factory = new CustomerFactory();
		CustomerDao dao = factory.getDaoCustomer(oc);
		boolean resposta = dao.updateCustomer(oc);
		return resposta;
	}
	public List<Customer> ListByType(ECustomer tipo){
		listCustomer.clear();
		CustomerFactory factory = new CustomerFactory();
		CustomerDao dao = factory.getDaoCustomer(tipo); 
		listCustomer = dao.getAllCustomer();
						
		return listCustomer; 
	}
	public boolean deleteCustomer(OnlineCustomer oc) {
		CustomerFactory factory = new CustomerFactory();
		CustomerDao dao = factory.getDaoCustomer(oc);
		boolean resposta = dao.deleteCustomer(oc);
		return resposta;
	}

}
