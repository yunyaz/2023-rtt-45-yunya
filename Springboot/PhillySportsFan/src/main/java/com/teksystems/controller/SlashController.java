package com.teksystems.controller;

import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private ProductDAO productDao;

    @GetMapping({"/index", "/", "/index.html"})
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");

        List<Product> products = productDao.getAllProducts();

        response.addObject("productList", products);

        return response;
    }

    @GetMapping("/search")
    public ModelAndView searchProduct(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("search");
        log.debug("In slash controller - search product with searchParam = " + search);

        List<Product> products = productDao.findByProductNameContainingIgnoreCase(search);

        response.addObject("productList", products);
        response.addObject("searchParam", search);

        return response;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView productDetail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product");
        log.debug("In slash controller - product detail with id = " + id);

        Product product = productDao.findById(id);
        response.addObject("product", product);

        return response;
    }
}
