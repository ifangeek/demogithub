package com.example.diegojosuepachecorosas.demogithub.core.rest

import com.example.diegojosuepachecorosas.demogithub.core.exception.Failure
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection

abstract class BaseRestDatasource {
    companion object {
        const val DEFAULT_CONFLICT_CODE = "000"
        const val DEFAULT_CONFLICT_MESSAGE = "Error al realizar esta acción"
    }

    fun <T> parseResult(observable: Single<Response<T>>): Single<T> {
        return observable
                .flatMap {
                    when {
                        it.isSuccessful -> Single.just(it.body()!!)
                        it.code() == HttpURLConnection.HTTP_CONFLICT -> Single.error<T>(mapConflictError(it.errorBody()))
                        else -> Single.error<T>(Failure.ServerError())
                    }
                }

                .onErrorResumeNext{
                    when(it){
                        is Failure -> Single.error<T>(it)
                        is IOException -> Single.error<T>(Failure.NetworkConnection())
                        else -> Single.error<T>(Failure.ServerError())
                    }
                }
    }

    private fun mapConflictError(responseBody: ResponseBody?): Failure.ConflictFailure {
        return try {
            val conflicResponse = Gson().fromJson(responseBody!!.string(), ConflictFailureResponse::class.java)
            Failure.ConflictFailure(conflicResponse.code,conflicResponse.message.orEmpty())
        }catch (ex:Exception){
            Failure.ConflictFailure(DEFAULT_CONFLICT_CODE, DEFAULT_CONFLICT_MESSAGE)
        }
    }
}

data class ConflictFailureResponse(
        val code:String,
        val message:String?)

