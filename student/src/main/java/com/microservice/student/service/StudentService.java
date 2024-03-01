package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.model.request.CreateStudentRequest;
import com.microservice.student.model.response.StudentResponse;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 3:53 PM
 ******************************************
 */
public interface StudentService {
    public StudentResponse create(CreateStudentRequest createStudentRequest);

    public StudentResponse getById(long id);
}
