package com.mosericko.simplecaching.api

import com.mosericko.simplecaching.models.Restaurant
import retrofit2.http.GET

interface RestaurantAPI {

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}