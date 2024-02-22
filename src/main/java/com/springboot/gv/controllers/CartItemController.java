package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.CartItem;
import com.springboot.gv.services.CartItemService;
import com.springboot.gv.services.ProductService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CartItemController {
	@Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private ProductService ps;

    @GetMapping("/view_cart")
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    
    
    @PostMapping("/cart_item")
    public void saveCart(@RequestBody int prodId)
    {
    	CartItem c=new CartItem(ps.getById(prodId),1);
    	cartItemService.saveCartItem(c);
    }

    @DeleteMapping("/deleteCartItem/{prodId}")
    public void deleteCartItem(@PathVariable("prodId") int prodId) {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        int cartItemId = 0;
        for( CartItem ci : cartItems)
        {
        	if(ci.getProduct().getProductId()== prodId)
        		cartItemId=ci.getId();
        }
        cartItemService.deleteCartItem(cartItemId);
    }
}
