package com.yash.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.pms.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


}
