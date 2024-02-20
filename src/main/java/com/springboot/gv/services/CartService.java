package com.springboot.gv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Cart;
import com.springboot.gv.entities.CartItem;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.repositories.CartItemRepository;
import com.springboot.gv.repositories.CartRepository;
import com.springboot.gv.repositories.CustomerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    
    @Autowired
    private CustomerRepo customerRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(int cartId) {
        return cartRepository.findById(cartId);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }

    public Cart saveCartWithItemsAndCustomer(List<CartItem> cartItems, int customerId) {
        // Retrieve the customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Create a new cart
        Cart cart = new Cart();
        cart.setCustomer(customer);

        // Save the cart to get the ID
        cart = cartRepository.save(cart);

        // Associate cart items with the cart
        for (CartItem cartItem : cartItems) {
            cartItem.setCart(cart);
            cartItemRepository.save(cartItem);
        }

        return cart;
    }

    // Add more service methods as needed
}

