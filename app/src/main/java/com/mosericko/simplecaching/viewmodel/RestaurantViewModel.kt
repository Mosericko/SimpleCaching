package com.mosericko.simplecaching.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mosericko.simplecaching.roomdb.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurant().asLiveData()

    /*private val restaurantLiveData = MutableLiveData<List<Restaurant>>()

    //expose immutable livedata
    val restaurants: LiveData<List<Restaurant>> = restaurantLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            restaurantLiveData.value = restaurants
        }
    }*/
}