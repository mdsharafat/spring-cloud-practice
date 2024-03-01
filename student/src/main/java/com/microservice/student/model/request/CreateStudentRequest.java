package com.microservice.student.model.request;

import lombok.*;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 3:47 PM
 ******************************************
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private CreateAddressRequest address;
}
