package com.springboot.gv.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.springboot.gv.entities.CartItem;
import com.springboot.gv.repositories.CartItemRepository;
import com.springboot.gv.repositories.ProductRepo;

import java.util.List;

@Service
public class CartItemService  {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
    
    
    // Add more service methods as needed
}

