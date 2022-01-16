package com.mosericko.simplecaching.di

import android.app.Application
import androidx.room.Room
import com.mosericko.simplecaching.api.RestaurantAPI
import com.mosericko.simplecaching.roomdb.RestaurantDataBase
import com.mosericko.simplecaching.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantAPI =
        retrofit.create(RestaurantAPI::class.java)

    @Provides
    @Singleton
    fun providesDatabase(app: Application): RestaurantDataBase =
        Room.databaseBuilder(app, RestaurantDataBase::class.java, "restaurant_database")
            .build()
}