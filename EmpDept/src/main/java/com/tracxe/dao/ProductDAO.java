package com.tracxe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trx.model.Product;

@Service
public class ProductDAO {
	@Autowired
	private ProductRepository prodRepo;
	
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	public Product getProdById(int id) {
		return prodRepo.findById(id).orElse(new Product());
	}
	
	public Product getProductByName(String productName) {
		return prodRepo.findByName(productName);
	}
	
	public Product registerProduct(Product product) {
		return prodRepo.save(product);
	}

	public String deleteProductById(int id) {
		prodRepo.deleteById(id);
		return "product with id: " + id + "is deleted";
	}
}
