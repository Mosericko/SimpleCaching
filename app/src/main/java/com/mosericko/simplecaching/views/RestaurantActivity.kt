package com.mosericko.simplecaching.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.mosericko.simplecaching.databinding.ActivityRestaurantBinding
import com.mosericko.simplecaching.utils.Resource
import com.mosericko.simplecaching.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding
    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instantiate restaurantAdapter
        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            restaurantRV.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(
                    this@RestaurantActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }

            viewModel.restaurants.observe(this@RestaurantActivity, { results ->
                restaurantAdapter.submitList(results.data)

                progressBar.isVisible = results is Resource.Loading && results.data.isNullOrEmpty()
                tvError.isVisible = results is Resource.Error && results.data.isNullOrEmpty()
                tvError.text = results.error?.localizedMessage
            })
        }

    }
}