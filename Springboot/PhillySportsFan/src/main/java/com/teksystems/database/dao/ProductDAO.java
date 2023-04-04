package com.teksystems.database.dao;

import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("from Product p")
    List<Product> getAllProducts();

    @Query("select p from Product p where p.id = :id")
    Product findById(Integer id);

    @Query("select p from Product p where lower(p.productName) LIKE lower(concat('%', :search, '%'))")
    List<Product> findByPartialSearch(String search);
}
