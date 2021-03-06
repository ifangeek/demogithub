package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Debug
import android.util.Log
import com.example.diegojosuepachecorosas.demogithub.core.scheduler.SchedulerProvider
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.interactor.GetAllReposInteractor
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.ResultVMMapper
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RepoViewModel
@Inject constructor(private val schedulerProvider: SchedulerProvider,
                    private val getAllReposInteractor: GetAllReposInteractor) : ViewModel() {

    //Al extender de viewModel , esta clase se encargara de preparar y administrar los datos para una actividad o fragmento

    private val disposable = CompositeDisposable()
    val state = MutableLiveData<ReposViewState>()

    @SuppressLint("LogNotTimber")
    fun loadRepos(query: String) {
        disposable.add(getAllReposInteractor.execute(GetAllReposInteractor.Params(query))
                .map { ResultVMMapper.map(it.copy()) }
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { state.value = ReposViewState.Loading }
                .subscribe({
                    if (it.result.isEmpty()) {
                        state.value = ReposViewState.noRepos
                    } else {
                        state.value = ReposViewState.Success(it.totalCount,it.result)
                    }
                }, {
<<<<<<< HEAD
                    state.value = ReposViewState.Error("Error al conectar ")
                    Log.e(RepoViewModel::class.java.name,it.stackTrace.toString())
=======
                    state.value = ReposViewState.Error("Error al conectar al Servidor")
                    Log.e(RepoViewModel::class.java.name, it.printStackTrace().toString())
>>>>>>> 02ef840fac80d3f96d19ea03c8f6ccc28aed5fb6


                    // tracker algun comportamiento de la app o funcionalidad.
    /*                Debug.stopMethodTracing()
                    Debug.startMethodTracing()*/
                }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}