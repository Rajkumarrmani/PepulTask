package com.example.pepul.di

import com.example.pepul.data.repository.HomeRepository
import com.example.pepul.data.repository.HomeRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideHomeRepository(homeRepository: HomeRepositoryImplementation): HomeRepository
}