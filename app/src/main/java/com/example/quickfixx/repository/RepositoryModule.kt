package com.example.quickfixx.repository

import com.example.quickfixx.repository.CarpenterRepo.CarpeRepo
import com.example.quickfixx.repository.CarpenterRepo.CarpeRepoImpl
import com.example.quickfixx.repository.UserRepository.UserRepository
import com.example.quickfixx.repository.UserRepository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindElectricianApiRepo(
        electricianApiRepo :RepositoryImpl
    ): Repository

    @Binds
    @Singleton
    abstract fun bindUserApiRepo(
        userApiRepo: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindCarpenterApiRepo(
        carpenterApiRepo: CarpeRepoImpl
    ): CarpeRepo
}