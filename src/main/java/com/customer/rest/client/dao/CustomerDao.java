package com.customer.rest.client.dao;

import java.util.List;

import com.customer.rest.client.model.Customer;

public interface CustomerDao {

	Customer saveCustomer(Customer customer);

	Customer findCustomer(Customer customer); 

	Customer findCustomerFullData(Long customId);

    void deleteCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer findCustomerAddressData(Long customId);

	Customer getCustomer(Long customId);
	
    List<Customer> listCustomers();
}
