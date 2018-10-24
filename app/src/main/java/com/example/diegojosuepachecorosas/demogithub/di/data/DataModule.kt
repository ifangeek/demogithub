package com.example.diegojosuepachecorosas.demogithub.di.data

import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.RepoDataSource
import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest.RepoRestDataSource
import com.example.diegojosuepachecorosas.demogithub.features.repos.data.repository.RepoRepositoryImpl
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.repository.RepoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun providePokemonDatasource(impl: RepoRestDataSource): RepoDataSource

    @Binds
    abstract fun providePokemonRepository(impl: RepoRepositoryImpl): RepoRepository
}