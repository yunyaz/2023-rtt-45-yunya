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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
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
    private AuthenticatedUserService authenticatedUserService;

    private static final List<Integer> QUANTITY = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @GetMapping("/cart")
    public ModelAndView cart() {
        ModelAndView response = new ModelAndView("account/cart");
        log.debug("In order controller - cart");

        User user = authenticatedUserService.loadCurrentUser();

        Order order = new Order();

        if (orderDao.findOrderInCart(user.getId()) != null) {
            order = orderDao.findOrderInCart(user.getId());
        }

        response.addObject("order", order);

        Double orderTotal = orderDao.getOrderTotal(order.getId());
        response.addObject("orderTotal", orderTotal);

        Integer totalItems = orderDao.getTotalItems(order.getId());
        response.addObject("totalItems", totalItems);

        response.addObject("quantityList", QUANTITY);

        return response;
    }

    @PostMapping("/addToCart")
    public String addToCart(OrderFormBean form) {
        log.debug("In order controller - add to cart");

        User user = authenticatedUserService.loadCurrentUser();

        Order order = new Order();

        if (orderDao.findOrderInCart(user.getId()) != null) {
            order = orderDao.findOrderInCart(user.getId());
        } else {
            order.setStatus("cart");
            order.setUser(user);
        }

        Product product = productDao.findById(form.getProductId());

        OrderProduct orderProduct = new OrderProduct();
        if (orderProductDao.findByOrderIdAndProductIdAndSize(order.getId(), form.getProductId(), form.getSize()) != null) {
            orderProduct = orderProductDao.findByOrderIdAndProductIdAndSize(order.getId(), form.getProductId(), form.getSize());
            orderProduct.setQuantity(orderProduct.getQuantity() + form.getQuantity());
        } else {
            orderProduct.setSize(form.getSize());
            orderProduct.setQuantity(form.getQuantity());
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
        }

        orderProductDao.save(orderProduct);
        orderDao.save(order);

        return "redirect:/order/cart";
    }

    @PostMapping("/updateCart")
    public String updateCart(OrderFormBean form) {
        log.debug("In order controller - update cart");

        OrderProduct orderProduct = orderProductDao.findByOrderIdAndProductIdAndSize(form.getOrderId(), form.getProductId(), form.getSize());

        if (form.getQuantity() == 0) {
//            orderProductDao.deleteByOrderIdAndProductId(orderProduct.getOrderId(), orderProduct.getProductId());
            orderProductDao.deleteById(orderProduct.getId());
        } else {
            orderProduct.setQuantity(form.getQuantity());
            orderProductDao.save(orderProduct);
        }
        return "redirect:/order/cart";
    }
}
