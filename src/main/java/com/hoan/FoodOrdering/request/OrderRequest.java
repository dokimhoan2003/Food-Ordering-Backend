package com.hoan.FoodOrdering.request;

import com.hoan.FoodOrdering.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
