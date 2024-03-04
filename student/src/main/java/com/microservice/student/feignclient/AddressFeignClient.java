package com.microservice.student.feignclient;

import com.microservice.student.model.request.CreateAddressRequest;
import com.microservice.student.model.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 02 Mar, 2024 at 11:38 AM
 ******************************************
 */

@FeignClient(value = "apigw")
public interface AddressFeignClient {

    @PostMapping("address-service/api/address/v1/create")
    public AddressResponse create(@RequestBody CreateAddressRequest createAddressRequest);
    @GetMapping("address-service/api/address/v1/get-by-id/{id}")
    public AddressResponse getById(@PathVariable long id);
}
