package kz.reself.springdata.controller;

import kz.reself.springdata.entity.Address;
import kz.reself.springdata.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    public List<Address> getAllAddresses() {
        return addressService.getAll();
    }

    public void saveAddress(Address address) {
        addressService.save(address);
    }
}
