package com.example.diegojosuepachecorosas.demogithub.di.activity

import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.activity.RepoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [])
    abstract fun providesRepoActivity(): RepoActivity
}