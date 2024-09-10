package com.hoan.FoodOrdering.repository;

import com.hoan.FoodOrdering.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
