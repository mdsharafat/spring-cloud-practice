package com.microservice.address.service;

import com.microservice.address.model.request.CreateAddressRequest;
import com.microservice.address.model.response.AddressResponse;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 1:13 PM
 ******************************************
 */
public interface AddressService {
    public AddressResponse create(CreateAddressRequest createAddressRequest);

    public AddressResponse getById(long id);
}
