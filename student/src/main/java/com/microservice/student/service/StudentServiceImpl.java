package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.feignclient.AddressFeignClient;
import com.microservice.student.model.request.CreateAddressRequest;
import com.microservice.student.model.request.CreateStudentRequest;
import com.microservice.student.model.response.AddressResponse;
import com.microservice.student.model.response.StudentResponse;
import com.microservice.student.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 3:53 PM
 ******************************************
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

//    @Autowired
//    AddressWebClient addressWebClient;

    @Autowired
    AddressFeignClient addressFeignClient;

    @Autowired
    CommonService commonService;

    @Override
    public StudentResponse create(CreateStudentRequest createStudentRequest) {
        AddressResponse addressResponse = createAddress(createStudentRequest.getAddress());

        Student student = Student.builder().firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .email(createStudentRequest.getEmail())
                .addressId(addressResponse.getId())
                .build();
        Student savedStudent = studentRepository.save(student);
        return StudentResponse.builder().id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .street(addressResponse.getStreet())
                .city(addressResponse.getCity())
                .build();
    }

    @Override
    public StudentResponse getById(long id) {
        Student student = studentRepository.findById(id).get();
        AddressResponse addressResponse = commonService.getAddressById(student.getAddressId());

        return StudentResponse.builder().id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .street(addressResponse.getStreet())
                .city(addressResponse.getCity())
                .build();
    }

//    public AddressResponse getAddressById(long id) {
//        Mono<AddressResponse> addressResponseMono = addressWebClient.adderssWebClient().get()
//                .uri("/get-by-id/"+id).retrieve().bodyToMono(AddressResponse.class);
//        return addressResponseMono.block();
//    }

//    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
//        Mono<AddressResponse> addressResponseMono = addressWebClient.adderssWebClient()
//                .post()
//                .uri("/create")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .body(Mono.just(createAddressRequest), CreateAddressRequest.class)
//                .retrieve().bodyToMono(AddressResponse.class);
//        return addressResponseMono.block();
//    }

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        return addressFeignClient.create(createAddressRequest);
    }


}
