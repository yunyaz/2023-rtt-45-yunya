package com.teksystems.database.dao;

import com.teksystems.database.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {

    @Query(value = "select * from order_product as op where op.order_id = :orderId " +
            "and op.product_id = :productId and op.size = :size", nativeQuery = true)
    OrderProduct findByOrderIdAndProductIdAndSize(Integer orderId, Integer productId, String size);

}
