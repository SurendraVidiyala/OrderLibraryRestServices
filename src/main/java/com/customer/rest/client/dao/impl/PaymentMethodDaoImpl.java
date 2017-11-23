package com.customer.rest.client.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.rest.client.dao.PaymentMethodDao;
import com.customer.rest.client.model.PaymentMethod;

@Repository
public class PaymentMethodDaoImpl implements PaymentMethodDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(PaymentMethod paymentMethod) {
		sessionFactory.getCurrentSession().saveOrUpdate(paymentMethod);
		System.out.println("PaymentMethod ID is: " + paymentMethod.getPaymentId());
	}

	@SuppressWarnings("unchecked")
	public List<PaymentMethod> findPaymentMethods(Long customId) {
		Query myQuery = (Query) sessionFactory.getCurrentSession()
				.createQuery("from PaymentMethod as pm WHERE pm.customer.customerId = :id");
		List<PaymentMethod> list = myQuery.getResultList();
		return list;
	}

	public void deletePaymentMethods(Long customId) {
		sessionFactory.getCurrentSession()
				.createQuery("delete FROM PaymentMethod AS pm WHERE pm.customer.customerId = :id")
				.setLong("id", customId).executeUpdate();
	}

	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		sessionFactory.getCurrentSession().update(paymentMethod);
		System.out.println("Payment Updated successfully!");
		return paymentMethod;
	}

	public void insertPaymentMethods(List<PaymentMethod> methods) {
		try {
			for (PaymentMethod paymentMethod : methods) {
				sessionFactory.getCurrentSession().save(paymentMethod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PaymentMethod getPaymentMethod(Long paymentMethodId) {
		PaymentMethod pm = sessionFactory.getCurrentSession().get(PaymentMethod.class, paymentMethodId);
		return pm;
	}

}
