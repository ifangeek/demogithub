package com.example.diegojosuepachecorosas.demogithub.features.repos.data.repository

import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.RepoDataSource
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.repository.RepoRepository
import io.reactivex.Observable
import javax.inject.Inject

class RepoRepositoryImpl
@Inject constructor(private val repoDataSource: RepoDataSource) : RepoRepository{
    override fun allRepos(query: String): Observable<ResultEntity> {
        return repoDataSource.allRepos(query)
    }
}