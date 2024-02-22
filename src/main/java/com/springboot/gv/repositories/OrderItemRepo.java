package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
	@Query(value="select * from order_item where oid in (select oid from orders where customer_id=:cid)",nativeQuery = true)
	public List<OrderItem> getOrderItemByCustomerId(int cid);
}
