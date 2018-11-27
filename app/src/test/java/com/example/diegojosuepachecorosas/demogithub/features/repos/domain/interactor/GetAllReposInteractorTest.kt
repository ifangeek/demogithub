package com.example.diegojosuepachecorosas.demogithub.features.repos.domain.interactor

import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.repository.RepoRepository
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.amshove.kluent.mock
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class GetAllReposInteractorTest {
    @Mock
    lateinit var getAllReposInteractor: GetAllReposInteractor
    private var mockRepository = mock<RepoRepository>()
    private var repoEntityList = ArrayList<RepoEntity>()
    private lateinit var resultEntity: ResultEntity


    @Before
    fun setUp() {
        getAllReposInteractor = GetAllReposInteractor(mockRepository)
        resultEntity = ResultEntity(100, repoEntityList)
    }

    @Test
    fun `Get All repos When NoQuery Expected Throw`() {
        val throwable = Throwable()

        Mockito.`when`(mockRepository.allRepos("")).doReturn(Observable.error(throwable))

        val test = mockRepository.allRepos("").test()

        verify(mockRepository).allRepos("")

        //verificamos que el testObservsable reciba un onError
        test.assertError(throwable)
        test.assertNotComplete()
        test.assertNoValues()
    }

    @Test
    fun `Get All Repos When Has Query Expected Success`() {

        val query = "some query"


        Mockito.`when`(mockRepository.allRepos(query)).doReturn(Observable.just(resultEntity))

        //.test() para extender de TestObserver y poder testear el comportamiento del mismo.
        val test = mockRepository.allRepos(query).test()

        verify(mockRepository).allRepos(query)

        //verificamos si el test recibe un onComplete
        test.assertComplete()
        test.assertValue(resultEntity)
        test.assertNoErrors()
    }

}

