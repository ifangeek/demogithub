package com.example.diegojosuepachecorosas.demogithub.features.repos.domain.interactor

import com.example.diegojosuepachecorosas.demogithub.core.interactor.Interactor
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.repository.RepoRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAllReposInteractor
@Inject constructor(private val repository: RepoRepository) : Interactor<GetAllReposInteractor.Params, Observable<ResultEntity>> {
    override fun execute(params: Params): Observable<ResultEntity> {
        return repository.allRepos(params.query)
    }

    data class Params(
            val query: String
    )
}