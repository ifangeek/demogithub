package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model


data class ResultVM(
        val totalCount: Int,
        val result: List<ReposVM> = emptyList()
)