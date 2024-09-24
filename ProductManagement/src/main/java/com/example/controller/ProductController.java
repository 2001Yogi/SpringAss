package com.example.controller;
import java.util.Arrays;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.model.Product;
import com.example.repo.ProductRepo;
import com.example.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	 
	@Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product"; // JSP view for adding a product
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "products";
    }

    @GetMapping
    public String viewProducts(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> productsPage = productService.getAllProductsPaginated(page, 5); // 5 items per page
        model.addAttribute("products", productsPage.getContent());
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "view-products"; // JSP view to display all products with pagination
    }
}
