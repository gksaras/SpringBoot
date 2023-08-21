package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.aop.model.Department;
import com.spring.aop.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {
	
	
	Logger log = LoggerFactory.getLogger(GeneralInterceptorAspect.class);
	
	//@Pointcut("execution(* com.spring.aop.controller.*.*(..))")
    //@Pointcut("within(com.spring.aop.service.*)")
    //@Pointcut("within(com.spring.aop..*)")
	//@Pointcut("this(com.spring.aop.service.DepartmentService)")
   @Pointcut("@annotation(com.spring.aop.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

//    @Before("loggingPointCut()")
//    public void before( JoinPoint joinPoint ){
//        log.info("Before method invoked::"+joinPoint.getSignature());
//    }
//    
//    @After("loggingPointCut()")
//    public void after( JoinPoint joinPoint ){
//        log.info("After method invoked::"+joinPoint.getSignature());
//    }

//    @AfterReturning(value = "execution(* com.spring.aop.controller.*.*(..))",
//            returning = "employee")
//    public void after( JoinPoint joinPoint, Employee employee ){
//        log.info("After method invoked::"+employee);
//    }
//
//    @AfterThrowing(value = "execution(* com.spring.aop.controller.*.*(..))",
//            throwing = "e")
//    public void after( JoinPoint joinPoint, Exception e ){
//        log.info("After method invoked::"+e.getMessage());
//    }


    @Around("loggingPointCut()")
    public Object around( ProceedingJoinPoint joinPoint ) throws Throwable {
    	//log.info("Before method invoked::"+joinPoint.getSignature());
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
        	//log.info("Before method invoked::"+joinPoint.getSignature());
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }else if(object instanceof Department){
        	//log.info("Before method invoked::"+joinPoint.getSignature());
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }

        return object;
    }
}
