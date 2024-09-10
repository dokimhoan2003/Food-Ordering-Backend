package com.hoan.FoodOrdering.service;

import com.hoan.FoodOrdering.dto.RestaurantDto;
import com.hoan.FoodOrdering.model.Address;
import com.hoan.FoodOrdering.model.Restaurant;
import com.hoan.FoodOrdering.model.User;
import com.hoan.FoodOrdering.repository.AddressRepository;
import com.hoan.FoodOrdering.repository.RestaurantRepository;
import com.hoan.FoodOrdering.repository.UserRepository;
import com.hoan.FoodOrdering.request.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(RestaurantRequest req, User user) {

        Address address = addressRepository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        restaurant.setDescription(req.getDescription());
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, RestaurantRequest updateRestaurant) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);
        if(restaurant.getCuisineType()!=null) {
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }
        if(restaurant.getDescription()!= null) {
            restaurant.setDescription(updateRestaurant.getDescription());
        }
        if(restaurant.getName()!=null) {
            restaurant.setName(updateRestaurant.getName());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);

    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {

        Optional<Restaurant> opt = restaurantRepository.findById(id);

        if(opt.isEmpty()) {
            throw new Exception("restaurant not found with id:"+id);
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {

        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);
        if(restaurant == null) {
            throw new Exception("restaurant not found with owner id:"+userId);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);

        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurantId);
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());

        boolean isFavorited = false;
        List<RestaurantDto> favorites = user.getFavorites();
        for (RestaurantDto favorite : favorites) {
            if(favorite.getId().equals(restaurantId)) {
                isFavorited = true;
                break;
            }
        }
        
        if(isFavorited) {
            favorites.removeIf(favorite -> favorite.getId().equals(restaurantId));
        }else {
            favorites.add(dto);
        }

        userRepository.save(user);
        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {

        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
