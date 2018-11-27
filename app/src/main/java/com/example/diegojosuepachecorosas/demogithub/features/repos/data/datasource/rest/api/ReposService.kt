package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest.api

import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest.ResultResponseData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposService {

    //Single : Esperamos un valor como respuesta
    @GET("search/repositories")
    fun searchRepos(@Query("q") term: String): Single<Response<ResultResponseData>>


}