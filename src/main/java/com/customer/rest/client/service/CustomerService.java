package com.customer.rest.client.service;

import java.util.List;

import com.customer.rest.client.model.Address;
import com.customer.rest.client.model.Customer;
import com.customer.rest.client.model.PaymentMethod;

public interface CustomerService {
	
	void updateAddress(Address address);

	Customer updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	void deletePaymentMethods(Long customId);

	Customer createCustomer(Customer customer);

	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

	Customer findCustomerFullData(Long customId);

	void createPaymentMethods(List<PaymentMethod> methods);

	Customer findCustomerAddressData(Long customId);
	
	PaymentMethod getPaymentMethod(Long paymentMethodId);
	
	List<PaymentMethod> findPaymentMethods(Long customId);
	
	Customer getCustomer(Long custId);
	
	List<Customer> listCustomers();


}
