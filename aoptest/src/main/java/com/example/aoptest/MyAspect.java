package com.example.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public ProductVO com.example.aoptest.ProductService.findProduct(..))")
	public void beforeFindProduct() {
		System.out.println("[beforeFindProduct]");
	}
	
	@After("execution(* com.example..findProduct(..))")
	public void afterFindProduct() {
		System.out.println("[afterFindProduct]");
	}
	
	@AfterReturning(value = "execution(* findProduct(..))", returning = "vo")
	public void afterReturningFindProduct(ProductVO vo) {
		System.out.println("[afterReturningFindProduct] " + vo);		
	}
	
	@AfterThrowing(value = "execution(* *..findProduct(String))", throwing = "ex")
	public void afterThrowingFindProduct(Throwable ex) throws Throwable {
		System.err.println("[afterThrowingFindProduct] " + ex.getMessage());
	}
}
