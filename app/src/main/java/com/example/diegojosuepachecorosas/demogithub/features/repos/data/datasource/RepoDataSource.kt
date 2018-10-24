package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource

import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import io.reactivex.Observable

interface RepoDataSource {

    fun allRepos(query:String) : Observable<ResultEntity>
}