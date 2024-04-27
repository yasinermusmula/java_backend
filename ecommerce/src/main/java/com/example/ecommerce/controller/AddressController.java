package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping("/{userId}")
    public Address save(@RequestBody Address address,
                        @PathVariable long userId){
        return addressService.save(address,userId);
    }
}
