package com.customer.rest.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.customer.rest.client.dao.CustomerDao;
import com.customer.rest.client.dao.PaymentMethodDao;
import com.customer.rest.client.model.Address;
import com.customer.rest.client.model.Customer;
import com.customer.rest.client.model.PaymentMethod;
import com.customer.rest.client.service.CustomerService;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private  CustomerDao customerDao;
	
	@Autowired
	private PaymentMethodDao paymentMethodDao;

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	public void deletePaymentMethods(Long customId) {
		paymentMethodDao.deletePaymentMethods(customId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Customer createCustomer(Customer customer) {
		Customer insertedCustomer = customerDao.saveCustomer(customer);
		return insertedCustomer;
	}

	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		return paymentMethodDao.updatePaymentMethod(paymentMethod);
	}

	public Customer findCustomerFullData(Long custId) {
		return customerDao.findCustomerFullData(custId);
	}

	public void createPaymentMethods(List<PaymentMethod> methods) {
		paymentMethodDao.insertPaymentMethods(methods);

	}

	public Customer findCustomerAddressData(Long custId) {
		return customerDao.findCustomerAddressData(custId);
	}

	public PaymentMethod getPaymentMethod(Long paymentMethodId) {
		return paymentMethodDao.getPaymentMethod(paymentMethodId);
	}

	public List<PaymentMethod> findPaymentMethods(Long custId) {
		return paymentMethodDao.findPaymentMethods(custId);
	}

	public Customer getCustomer(Long custId) {
		return customerDao.getCustomer(custId);
	}

	public void updateAddress(Address address) {

	}

	public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return customerDao.listCustomers();
	}


}