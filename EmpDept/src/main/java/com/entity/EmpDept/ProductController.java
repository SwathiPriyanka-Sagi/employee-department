package com.entity.EmpDept;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracxe.dao.ProductDAO;
import com.trx.model.Product;

@CrossOrigin(origins="*")
@RestController
public class ProductController {
	
	 @Autowired
	 private ProductDAO prodDAO;
	
	 @RequestMapping("/prods")
		public List<Product> showAllProducts() {
			return prodDAO.getAllProducts();
		}
	 
	@RequestMapping("/ProdById/{ID}")
    public Product getProdById(@PathVariable("ID")int id) {
    	return prodDAO.getProdById(id);
    }
	
	@RequestMapping("/prodByProductName/{name}")
	public Product getProductByName(@PathVariable("name")String productName) {
		return prodDAO.getProductByName(productName);
	}
	
	@RequestMapping("/product")
	public Product showProduct() {
		return new Product(100, "Mouse", 199.2);
	}
	
	@RequestMapping("/multipleproducts")
	public List <Product> multipleproduct() {
		List <Product> products = new ArrayList();
		Product prod = new Product(101, "KeyBoard", 200.99);
		Product prod1 = new Product(102, "CPU", 100.0);
		products.add(prod);
		products.add(prod1);
		return products;
	}
	
	@PostMapping("/registerProduct")
	public Product registerProduct(@RequestBody Product product) {
		return prodDAO.registerProduct(product);
	}
	
	
	
	
	
	

}
