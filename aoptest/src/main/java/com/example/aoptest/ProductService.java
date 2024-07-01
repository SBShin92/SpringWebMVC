package com.example.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVO findProduct(String keyword) throws RuntimeException {
		System.out.println("finding: [" + keyword + "]...");
		if (keyword.equals("bomb"))
			throw new RuntimeException("BBBBBBBBOOOOOOOOOOMMMMMMMMMM");
		
		System.out.println("found!");
		
		return new ProductVO(keyword);
	}

}
