package com.microservice.student.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 01 Mar, 2024 at 6:14 PM
 ******************************************
 */
@Service
public class AddressWebClient {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    @Bean
    public WebClient adderssWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(addressServiceUrl)
                .build();
        return webClient;
    }

}
