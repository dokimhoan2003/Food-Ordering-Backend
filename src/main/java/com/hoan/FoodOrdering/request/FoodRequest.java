package com.hoan.FoodOrdering.request;

import com.hoan.FoodOrdering.model.Category;
import com.hoan.FoodOrdering.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class FoodRequest {
    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientsItem> ingredients;

}
