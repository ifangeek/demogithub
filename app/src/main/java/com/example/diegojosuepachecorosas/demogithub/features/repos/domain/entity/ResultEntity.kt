package com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity

data class ResultEntity(
    val totalCount:Int,
    val result:ArrayList<RepoEntity> = ArrayList()
)