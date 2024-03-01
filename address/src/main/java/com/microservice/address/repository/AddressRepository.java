package com.microservice.address.repository;

import com.microservice.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 2:57 PM
 ******************************************
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
