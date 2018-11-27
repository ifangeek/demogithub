package com.example.diegojosuepachecorosas.demogithub.features.repos.data.repository

import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.RepoDataSource
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.amshove.kluent.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class RepoRepositoryImplTest {


    var mockDataSource= mock<RepoDataSource>()
    @Mock
    lateinit var repositoryImpl: RepoRepositoryImpl
    var repoEntityList = ArrayList<RepoEntity>()
    lateinit var resultEntity: ResultEntity


    @Before
    fun setUp() {

        repositoryImpl = Mockito.spy(RepoRepositoryImpl(mockDataSource))
        resultEntity = ResultEntity(10, repoEntityList)
    }

    @Test
    fun GetAllRepos_WhenNoQuery_ExpectedThrow() {
        val throwable = Throwable()

        Mockito.`when`(repositoryImpl.allRepos(Mockito.anyString())).doReturn(Observable.error(throwable))

        val test = repositoryImpl.allRepos(Mockito.anyString()).test()
        verify(repositoryImpl, times(2)).allRepos(Mockito.anyString())

        test.assertError(throwable)
        test.assertNotComplete()
        test.assertNoValues()
    }

    @Test
    fun GetAllRepos_WhenHaveQuery_ExpectedSuccess() {

        val query = "some query"

        Mockito.`when`(mockDataSource.allRepos(query)).doReturn(Observable.just(resultEntity))

        val test = mockDataSource.allRepos(query).test()

        verify(mockDataSource).allRepos(query)

        test.assertComplete()
        test.assertValue(resultEntity)
        test.assertNoErrors()
    }
}