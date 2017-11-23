package com.customer.rest.client.dao;

import com.customer.rest.client.model.Address;

public interface AddressDao {

	Address updateAddress(Address address);

	Long deleteAddress(Long customId);
}
