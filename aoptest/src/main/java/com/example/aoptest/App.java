package com.example.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ProductService ps = ac.getBean(ProductService.class);
		
		ProductVO vo = ps.findProduct("노트북");
		System.out.println("제품: " + vo);
		System.out.println("=========================");
		
		try {
			vo = ps.findProduct("bomb");
			System.out.println("제품: " + vo);
		} catch (Throwable e) {}
	}
}
