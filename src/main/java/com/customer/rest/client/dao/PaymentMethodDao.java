package com.customer.rest.client.dao;

import java.util.List;

import com.customer.rest.client.model.PaymentMethod;


public interface PaymentMethodDao {

	List<PaymentMethod> findPaymentMethods(Long customId);

	void deletePaymentMethods(Long customId);

	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

	void insertPaymentMethods(List<PaymentMethod> methods);

	PaymentMethod getPaymentMethod(Long paymentMethodId);
}
