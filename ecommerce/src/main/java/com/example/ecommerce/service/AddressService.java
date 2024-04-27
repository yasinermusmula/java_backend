package com.example.ecommerce.service;

import com.example.ecommerce.entity.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address,long userId);

    List<Address> findAll();

    Address getById(long getById);

    Address delete(long deleteById);
}
