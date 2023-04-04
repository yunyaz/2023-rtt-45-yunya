package com.teksystems.database.dao;

import com.teksystems.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long>{

}
