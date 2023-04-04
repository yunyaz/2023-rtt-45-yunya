package com.teksystems.database.dao;

import com.teksystems.database.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {
}
