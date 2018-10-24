package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel

import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ReposVM

sealed class ReposViewState {
    object Loading : ReposViewState()
    class Error(val reason: String) : ReposViewState()
    object noRepos : ReposViewState()
    class Success(val totalcount:Int,val repos: List<ReposVM>) : ReposViewState()
}