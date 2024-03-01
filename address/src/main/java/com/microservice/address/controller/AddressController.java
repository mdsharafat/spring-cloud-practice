package com.microservice.address.controller;

import com.microservice.address.model.request.CreateAddressRequest;
import com.microservice.address.model.response.AddressResponse;
import com.microservice.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 1:11 PM
 ******************************************
 */

@RestController
@RequestMapping("api/address/v1/")
@Slf4j
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("create")
    public AddressResponse create(@RequestBody CreateAddressRequest createAddressRequest) {
        log.info("Get call for creating new address. Inside controller. ");
        return addressService.create(createAddressRequest);
    }

    @GetMapping("/get-by-id/{id}")
    public AddressResponse getById(@PathVariable long id) {
        log.info("Get call for getting address details for id {}. Inside controller.", id);
        return addressService.getById(id);
    }
}
