package kz.reself.springdata.service;

import kz.reself.springdata.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();
    void save(Address address);
}
