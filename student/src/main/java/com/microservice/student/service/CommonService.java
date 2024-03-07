package com.microservice.student.service;

import com.microservice.student.feignclient.AddressFeignClient;
import com.microservice.student.model.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 07 Mar, 2024 at 4:05 PM
 ******************************************
 */

@Service
@Slf4j
public class CommonService {

    @Autowired
    AddressFeignClient addressFeignClient;

    private int count = 1;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallBackGetAddressById")
    public AddressResponse getAddressById(long id) {
        log.info("getAddressById() Count : " + count);
        count++;
        return addressFeignClient.getById(id);
    }
    public AddressResponse fallBackGetAddressById(long id, Throwable throwable) {
        log.error("getAddressById() Count : " + count);
        return new AddressResponse();
    }

}
