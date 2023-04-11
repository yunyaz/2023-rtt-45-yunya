package com.teksystems.controller;

import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
