package com.sahand.issuer.action;

import com.sahand.acquirer.data.CustomerDto;
import com.sahand.acquirer.model.Customer;
import com.sahand.acquirer.model.CustomerAcceptor;

public interface CustomerManagement {

	public Customer edit(CustomerDto customer) throws Exception;
	public Customer create(CustomerDto customer) throws Exception;

	public Customer find(String customerId) throws Exception;
	public void persist(Customer customer) throws Exception;
	public void update(Customer customer) throws Exception;
	
	public boolean isUniqueCustomer(String serialNo);
	
	public CustomerDto convertFrom(Customer customerDa,CustomerDto customerDto);
	public CustomerDto convertFrom(CustomerAcceptor customerAcceptorDa,CustomerDto customerDto);
	
	public CustomerAcceptor edit_(CustomerDto customer) throws Exception;
	public CustomerAcceptor create_(CustomerDto customer) throws Exception;

	public CustomerAcceptor find_(String customerId) throws Exception;
	public void persist_(CustomerAcceptor customer) throws Exception;
	public void update_(CustomerAcceptor customer) throws Exception;
	
}
