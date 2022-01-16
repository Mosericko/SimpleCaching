package com.mosericko.simplecaching.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey
    val name: String,
    val type: String,
    val logo: String,
    val address: String
)
