package com.example.beautyshop.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beautyshop.model.Cart;
import com.example.beautyshop.repository.CartRepository;

@RestController
@RequestMapping("/api/cart")   
@CrossOrigin
public class CartController {

    @Autowired
    private CartRepository repo;

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return repo.save(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @DeleteMapping("/{id}")   
    public void deleteCartItem(@PathVariable Long id) {
        repo.deleteById(id);
    }
    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Cart existing = repo.findById(id).orElseThrow();
        existing.setQuantity(cart.getQuantity());
        return repo.save(existing);
    }
}