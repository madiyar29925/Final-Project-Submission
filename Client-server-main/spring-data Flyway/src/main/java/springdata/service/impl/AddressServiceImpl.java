package kz.reself.springdata.service.impl;

import kz.reself.springdata.entity.Address;
import kz.reself.springdata.repository.AddressRepository;
import kz.reself.springdata.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
}
