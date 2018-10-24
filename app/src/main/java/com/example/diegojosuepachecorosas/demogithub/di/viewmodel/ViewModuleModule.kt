package com.example.diegojosuepachecorosas.demogithub.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel.RepoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModuleModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindsPokemonsViewModel(pokemonViewModel: RepoViewModel): ViewModel
}