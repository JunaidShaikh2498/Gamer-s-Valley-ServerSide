package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.gv.entities.CartItem;
import com.springboot.gv.entities.Product;
import com.springboot.gv.services.CartItemService;
import com.springboot.gv.services.ProductService;

import java.util.List;

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
    public void deleteCartItem(@PathVariable int prodId) {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        int cartItemId = 0;
        for( CartItem ci : cartItems)
        {
        	if(ci.getProduct().getProductId()== prodId)
        		cartItemId=ci.getId();
        }
        cartItemService.deleteCartItem(cartItemId);
    }

    // Add more endpoints as needed
}

