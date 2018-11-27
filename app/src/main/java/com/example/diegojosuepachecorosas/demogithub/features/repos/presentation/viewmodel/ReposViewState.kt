package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel

import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ReposVM

sealed class ReposViewState {
    //operaciones que no tienen estado son objects, pues no se necesita distintas instancias.
    object Loading : ReposViewState()
    object noRepos : ReposViewState()
    class Error(val reason: String) : ReposViewState()
    class Success(val totalcount:Int,val repos: List<ReposVM>) : ReposViewState()
}