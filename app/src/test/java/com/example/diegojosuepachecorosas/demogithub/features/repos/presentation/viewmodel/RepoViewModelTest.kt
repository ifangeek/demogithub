package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel


import android.arch.lifecycle.Observer
import com.example.diegojosuepachecorosas.demogithub.core.scheduler.SchedulerProvider
import com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest.api.ReposService
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.interactor.GetAllReposInteractor
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ReposVM
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ResultVM
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.utils.RxImmediateSchedulerRule
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class RepoViewModelTest {


    //Es una regla de JUnit que intercambia el ejecutor de fondo usado por los componentes
    // de arquitectura con uno diferente que ejecuta cada tarea de forma sincrona.
/*
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()
*/


    //test rue para hacer que RxJava corra de manera sincrona en unit test
    /* companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }*/

    @Mock
    lateinit var schedulerProvider: SchedulerProvider

    @Mock
    lateinit var getAllReposInteractor: GetAllReposInteractor

    @Mock
    lateinit var observer: Observer<ReposViewState>

    lateinit var repoViewModel: RepoViewModel

    @Before
    fun setUp() {
        // iniciamos el view
        schedulerProvider = SchedulerProvider()
        repoViewModel = RepoViewModel(schedulerProvider, getAllReposInteractor)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { h -> Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { h -> Schedulers.trampoline() }
    }

    @Test
    fun shouldShowListRepo() {
        val query = "some query "

        val repoEntity: ArrayList<RepoEntity> = ArrayList()
        val repoVM = ResultEntity(100, repoEntity)
//        val resultVM  = ResultVM(100, emptyList())

        Mockito.`when`(getAllReposInteractor.execute(GetAllReposInteractor.Params(query)))
                .thenReturn(Observable.just(repoVM))


        repoViewModel.loadRepos(query)
        repoViewModel.state.observeForever(observer)
    }
}