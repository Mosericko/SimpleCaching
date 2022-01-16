package com.mosericko.simplecaching.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mosericko.simplecaching.models.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDataBase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}