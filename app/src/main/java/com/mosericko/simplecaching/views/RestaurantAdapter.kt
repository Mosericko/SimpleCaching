package com.mosericko.simplecaching.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mosericko.simplecaching.databinding.RestaurantCardBinding
import com.mosericko.simplecaching.models.Restaurant

class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantAdapter.RestaurantVH>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantVH {
        val view = RestaurantCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantVH(view)
    }

    override fun onBindViewHolder(holder: RestaurantVH, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantVH(private val binding: RestaurantCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(img)

                name.text = restaurant.name
                type.text = restaurant.type
                address.text = restaurant.address
            }
        }

    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

    }
}