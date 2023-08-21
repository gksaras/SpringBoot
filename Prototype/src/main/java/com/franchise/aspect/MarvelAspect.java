package com.franchise.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class MarvelAspect {
	
	private static Logger log = Logger.getLogger(MarvelAspect.class);

	@Pointcut("execution(*com.franchise.controller.*.*(..))")
	public void loggingPointCut() {
		
	}
	
	@Before("loggingPointCut()")
	public void before(JoinPoint joinPoint) {
		log.info("before method invoked :: "+joinPoint.getSignature());
	}
	
	@After("loggingPointCut()")
	public void after(JoinPoint joinPoint) {
		log.info("after method invoked :: "+joinPoint.getSignature());
	}
}
