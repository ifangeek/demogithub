package com.example.diegojosuepachecorosas.demogithub.di

import com.example.diegojosuepachecorosas.demogithub.core.scheduler.BaseSchedulerProvider
import com.example.diegojosuepachecorosas.demogithub.core.scheduler.SchedulerProvider
import com.example.diegojosuepachecorosas.demogithub.di.api.ApiModule
import com.example.diegojosuepachecorosas.demogithub.di.viewmodel.ViewModuleModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class, ViewModuleModule::class])
class ApplicationModule {

    //SINGLETON : DI solo instancia una vez providesScheduler
    @Singleton
    @Provides
    fun providesScheduler(provider: SchedulerProvider): BaseSchedulerProvider {
        return provider
    }
}