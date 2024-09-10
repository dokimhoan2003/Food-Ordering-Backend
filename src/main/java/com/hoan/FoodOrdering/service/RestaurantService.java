package com.hoan.FoodOrdering.service;

import com.hoan.FoodOrdering.dto.RestaurantDto;
import com.hoan.FoodOrdering.model.Restaurant;
import com.hoan.FoodOrdering.model.User;
import com.hoan.FoodOrdering.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(RestaurantRequest req, User user);

    public Restaurant updateRestaurant(Long restaurantId, RestaurantRequest updateRestaurant) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;
}
