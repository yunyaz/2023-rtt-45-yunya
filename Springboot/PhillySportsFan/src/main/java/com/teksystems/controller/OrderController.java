package com.teksystems.controller;

import com.teksystems.database.dao.OrderDAO;
import com.teksystems.database.dao.OrderProductDAO;
import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Order;
import com.teksystems.database.entity.OrderProduct;
import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.OrderFormBean;
import com.teksystems.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderProductDAO orderProductDao;

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;



    @GetMapping("/cart")
    public ModelAndView cart() {
        ModelAndView response = new ModelAndView("account/cart");
        log.debug("In order controller - cart");

        String email = authenticatedUserService.getCurrentUsername();
        User user = userDao.findByEmail(email);

        Order order = new Order();

        if (orderDao.findOrderInCart(user.getId()) != null) {
            order = orderDao.findOrderInCart(user.getId());
        }

        response.addObject("order", order);

        Double orderTotal = orderDao.getOrderTotal(order.getId());
        response.addObject("orderTotal", orderTotal);

        Integer totalItems = orderDao.getTotalItems(order.getId());
        response.addObject("totalItems", totalItems);

        return response;
    }

    @PostMapping("/cart")
    public ModelAndView cart(OrderFormBean form) {
        ModelAndView response = new ModelAndView("account/cart");
        log.debug("In order controller - add to cart");

        String email = authenticatedUserService.getCurrentUsername();
        User user = userDao.findByEmail(email);

        Order order = new Order();

        if (orderDao.findOrderInCart(user.getId()) != null) {
            order = orderDao.findOrderInCart(user.getId());
        } else {
            order.setStatus("cart");
            order.setUser(user);
        }

        Product product = productDao.findById(form.getProductId());

        OrderProduct orderProduct = new OrderProduct();
        if (orderProductDao.findByProductIdAndSize(order.getId(), form.getProductId(), form.getSize()) != null) {
            orderProduct = orderProductDao.findByProductIdAndSize(order.getId(), form.getProductId(), form.getSize());
            orderProduct.setQuantity(orderProduct.getQuantity() + 1);
        } else {
            orderProduct.setSize(form.getSize());
            orderProduct.setQuantity(form.getQuantity());
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
        }

        orderProductDao.save(orderProduct);
        orderDao.save(order);

        response.addObject("order", order);

        Double orderTotal = orderDao.getOrderTotal(order.getId());
        response.addObject("orderTotal", orderTotal);

        Integer totalItems = orderDao.getTotalItems(order.getId());
        response.addObject("totalItems", totalItems);

        return response;
    }
}
