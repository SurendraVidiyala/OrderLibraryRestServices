package com.customer.rest.client.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.rest.client.dao.AddressDao;
import com.customer.rest.client.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Address updateAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
		System.out.println("Address ID is: " + address.getCutomerId());
		return address;
	}

	@Override
	public Long deleteAddress(Long customId) {
		sessionFactory.getCurrentSession().createQuery("delete from Customer where id=:customerId").setParameter("customerId", customId).executeUpdate();
		return customId;

	}
}
