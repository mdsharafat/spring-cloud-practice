package com.microservice.address.service;

import com.microservice.address.entity.Address;
import com.microservice.address.model.request.CreateAddressRequest;
import com.microservice.address.model.response.AddressResponse;
import com.microservice.address.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 1:13 PM
 ******************************************
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public AddressResponse create(CreateAddressRequest createAddressRequest) {

        log.info("Inside create address method. Address Request {} ", createAddressRequest.toString());

        Address address = Address.builder().street(createAddressRequest.getStreet())
                .city(createAddressRequest.getCity()).build();
        Address savedAddress = addressRepository.save(address);

        return AddressResponse.builder().id(savedAddress.getId()).street(savedAddress.getStreet())
                .city(savedAddress.getCity()).build();
    }

    @Override
    public AddressResponse getById(long id) {

        log.info("Inside getById implementation method. Given Id : {}", id);

        Address address = addressRepository.findById(id).get();
        return AddressResponse.builder().id(address.getId()).street(address.getStreet())
                .city(address.getCity()).build();
    }
}
