package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.Order_Item;

 
public interface OrderItemsRepo extends JpaRepository<Order_Item, Integer>  {
	
	@Query(value="select * from order_item where oid in (select oid from orders where customer_id=:cid)",nativeQuery = true)
	public List<Order_Item> getOrderItemByCustomerId(int cid);
	
}
