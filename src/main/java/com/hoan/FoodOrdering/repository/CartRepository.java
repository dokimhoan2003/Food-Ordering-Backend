package com.hoan.FoodOrdering.repository;

import com.hoan.FoodOrdering.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
