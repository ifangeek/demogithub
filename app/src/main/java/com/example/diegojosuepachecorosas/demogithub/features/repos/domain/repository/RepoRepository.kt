package com.example.diegojosuepachecorosas.demogithub.features.repos.domain.repository

import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import io.reactivex.Observable

interface RepoRepository {

    fun allRepos(query:String) : Observable<ResultEntity>
}