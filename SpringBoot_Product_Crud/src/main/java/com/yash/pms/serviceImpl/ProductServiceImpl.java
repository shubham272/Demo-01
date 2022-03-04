package com.yash.pms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms.model.Product;
import com.yash.pms.repository.ProductRepository;
import com.yash.pms.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository pr;

	@Override
	public List<Product> getAllProducts() {
		
		return pr.findAll();
	}

	@Override
	public void saveProduct(Product Product) {
		
		pr.save(Product);
	}

	@Override
	public Product getProductById(int id) {
		Optional< Product > optional = pr.findById(id);
		Product Product = null;
        if (optional.isPresent()) {
        	Product = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return Product;
	}

	@Override
	public void deleteProductById(int id) {
		
		this.pr.deleteById(id);
	}



}
