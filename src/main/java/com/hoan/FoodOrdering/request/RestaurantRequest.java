package com.hoan.FoodOrdering.request;

import com.hoan.FoodOrdering.model.Address;
import com.hoan.FoodOrdering.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantRequest {
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;
}
