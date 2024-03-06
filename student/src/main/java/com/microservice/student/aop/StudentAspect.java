package com.microservice.student.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 06 Mar, 2024 at 4:05 PM
 ******************************************
 */
@Component
@Aspect
@Slf4j
public class StudentAspect {

    @Before(value = "execution(* com.microservice.student.service.StudentServiceImpl.*(..))")
    public void beforeExecution(JoinPoint joinPoint) {
        log.info("Get call for {} at {}", joinPoint.toShortString(), new Date());
    }

    @After(value = "execution(* com.microservice.student.service.StudentServiceImpl.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        log.info("Method {} execution completed at {}", joinPoint.toShortString(), new Date());
    }
}
