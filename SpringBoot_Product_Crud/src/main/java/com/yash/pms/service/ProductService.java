package com.yash.pms.service;

import java.util.List;

import com.yash.pms.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
    void saveProduct(Product Product);
    Product getProductById(int id);
    void deleteProductById(int id);
}
