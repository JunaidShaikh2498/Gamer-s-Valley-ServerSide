package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.gv.entities.CartItem;
import com.springboot.gv.services.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping
    public CartItem saveCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteCartItem(@PathVariable int cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }

    // Add more endpoints as needed
}

