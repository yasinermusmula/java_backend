package com.example.ecommerce.service;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.AddressRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AdressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    private UserServiceImpl userService;

    @Autowired
    public AdressServiceImpl(AddressRepository addressRepository,
                             UserServiceImpl userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }


    @Override
    public Address save(Address address,long userId) {
        User user = userService.findById(userId);
        address.setUser(user);
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(long getById) {
        Optional<Address> addressOptional = addressRepository.findById(getById);
        if (addressOptional.isPresent()){
            return addressOptional.get();
        }
        //TODO Make exception here
        return null;
    }

    @Override
    public Address delete(long deleteById) {
        Address address = getById(deleteById);
        addressRepository.delete(address);
        return address;
    }
}
