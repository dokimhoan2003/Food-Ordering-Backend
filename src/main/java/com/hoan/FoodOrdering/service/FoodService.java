package com.hoan.FoodOrdering.service;

import com.hoan.FoodOrdering.model.Category;
import com.hoan.FoodOrdering.model.Food;
import com.hoan.FoodOrdering.model.Restaurant;
import com.hoan.FoodOrdering.request.FoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(FoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegetarian,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory
                                         );

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;


}
