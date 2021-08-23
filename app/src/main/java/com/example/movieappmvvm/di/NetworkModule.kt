package com.example.movieappmvvm.di

import com.example.movieappmvvm.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun proviedMovieService(): MovieService {
        return MovieService.create()
    }
}