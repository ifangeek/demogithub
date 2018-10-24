package com.example.diegojosuepachecorosas.demogithub.core.navigation

import android.content.Context
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.activity.RepoActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(){
    fun showMain(context: Context){
        context.startActivity(RepoActivity.newInstance(context))
    }
}