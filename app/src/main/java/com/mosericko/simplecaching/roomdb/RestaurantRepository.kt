package com.mosericko.simplecaching.roomdb

import androidx.room.withTransaction
import com.mosericko.simplecaching.api.RestaurantAPI
import com.mosericko.simplecaching.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantAPI,
    private val db: RestaurantDataBase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurant() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}