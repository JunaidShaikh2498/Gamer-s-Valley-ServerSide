package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.gv.entities.Cart;
import com.springboot.gv.entities.CartItem;
import com.springboot.gv.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable int cartId) {
        return cartService.getCartById(cartId).orElse(null);
    }

    @PostMapping
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable int cartId) {
        cartService.deleteCart(cartId);
    }

    @PostMapping("/save_cart")
    public ResponseEntity<Cart> saveCartWithItemsAndCustomer(@RequestBody List<CartItem> cartItems,
                                                             @RequestParam int customerId) {
        // Save the cart with associated items and customer
        Cart savedCart = cartService.saveCartWithItemsAndCustomer(cartItems, customerId);

        // Check if the savedCart is not null
        if (savedCart != null) {
            return ResponseEntity.ok(savedCart);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Add more endpoints as needed
}

