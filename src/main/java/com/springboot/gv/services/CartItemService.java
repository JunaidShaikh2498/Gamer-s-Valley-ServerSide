package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.CartItem;
import com.springboot.gv.repositories.CartItemRepo;

@Service
public class CartItemService {
	@Autowired
    private CartItemRepo cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
