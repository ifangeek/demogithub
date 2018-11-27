package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest

import com.example.diegojosuepachecorosas.demogithub.core.rest.BaseRestDatasource
import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.RepoDataSource
import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest.api.ReposService
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import io.reactivex.Observable
import javax.inject.Inject

class RepoRestDataSource
@Inject constructor(private val reposService: ReposService):BaseRestDatasource(), RepoDataSource {

    override fun allRepos(query: String): Observable<ResultEntity> {
        return parseResult(reposService.searchRepos(query))
                .map (ResultDataMapper::map)
                .toObservable()
    }
}

