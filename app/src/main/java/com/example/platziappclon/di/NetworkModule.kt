package com.example.platziappclon.di

import com.example.platziappclon.data.network.Podcasts.PodcastsApiClient
import com.example.platziappclon.data.network.achievements.AchievementsApiClient
import com.example.platziappclon.data.network.lessons.LessonsApiClient
import com.example.platziappclon.data.network.paths.PathsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://platziclonrepo-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePodcastsApiClient(retrofit: Retrofit):PodcastsApiClient{
        return retrofit.create(PodcastsApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideAchievementsApiClient(retrofit: Retrofit):AchievementsApiClient{
        return retrofit.create(AchievementsApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideLessonsApiClient(retrofit: Retrofit):LessonsApiClient{
        return retrofit.create(LessonsApiClient::class.java)
    }

    @Singleton
    @Provides
    fun providePathsApiClient(retrofit: Retrofit):PathsApiClient{
        return  retrofit.create(PathsApiClient::class.java)
    }

}