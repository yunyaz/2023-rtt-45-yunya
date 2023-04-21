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
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private ProductDAO productDao;

    private static final List<String> JERSEY_SIZE = Arrays.asList("S", "M", "L", "XL", "2XL");

    private static final List<Integer> QUANTITY = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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
        response.addObject("jerseySize", JERSEY_SIZE);
        response.addObject("quantityList", QUANTITY);

        return response;
    }

    @GetMapping("/team/{teamName}")
    public ModelAndView team(@PathVariable String teamName) {
        ModelAndView response = new ModelAndView("team");
        log.debug("In slash controller - team = " + teamName);

        List<Product> products = productDao.findBySportsTeam(teamName);
        response.addObject("productList", products);
        response.addObject("teamName", teamName);

        return response;
    }

    @GetMapping("/team/{teamName}/{category}")
    public ModelAndView category(@PathVariable String teamName, @PathVariable String category) {
        ModelAndView response = new ModelAndView("team");
        log.debug("In slash controller - team = " + teamName + " category = " + category);

        List<Product> products = productDao.findBySportsTeamAndCategory(teamName, category);
        response.addObject("productList", products);
        response.addObject("teamName", teamName);
//        response.addObject("category", category);

        return response;
    }
}
