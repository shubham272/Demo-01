package com.yash.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.pms.model.Product;
import com.yash.pms.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	@RequestMapping("/register")
	public String regProduct()
	{
		return "home";
	}
	@RequestMapping("/reg")
	public String registerProduct(@ModelAttribute Product p,Model m)
	{
		System.out.println(p.getPname());
		ps.saveProduct(p);
		
		return "home";
		
	}
	@RequestMapping("/showall")
	public String getAllProduct(Model m)
	{
		List<Product> products = ps.getAllProducts();
		m.addAttribute("product", products);
		if(products.isEmpty()) {
			return "register";
		}
		else
		{
			return "success";
		}
		
	}
	@RequestMapping("/update/{id}")
	public String updateProduct(@PathVariable(value = "id") int id,Model m)
	{
		System.out.println(id);
		Product byId = ps.getProductById(id);
		m.addAttribute("product", byId);
		return "update";
	}
	 @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") int id) {

	       ps.deleteProductById(id);
	        return "redirect:/showall";
	    }
}
