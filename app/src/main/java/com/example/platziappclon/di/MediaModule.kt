package com.example.platziappclon.di

import android.media.MediaPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MediaModule {

    @Singleton
    @Provides
    fun provideMediaPlayer(): MediaPlayer {
        return MediaPlayer()
    }
}