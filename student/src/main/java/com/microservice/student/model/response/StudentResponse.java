package com.microservice.student.model.response;

import lombok.*;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 3:49 PM
 ******************************************
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
}
