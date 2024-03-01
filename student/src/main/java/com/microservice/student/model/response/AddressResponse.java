package com.microservice.student.model.response;

import lombok.*;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 12:57 PM
 ******************************************
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
}
