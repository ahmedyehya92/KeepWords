package com.intellidev.usecases.usecases

import android.annotation.SuppressLint
import android.util.Log
import com.intellidev.entities.LoginResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

abstract class TokenHelper (private val tokenUseCase: TokenUseCase = TokenUseCase()) {

    abstract fun onSuccess()
    abstract fun onFailur()
    private val disposables: CompositeDisposable = CompositeDisposable()

    init {
        getAccessToken()
    }

    @SuppressLint("CheckResult")
    private fun getAccessToken() {
        val servicep: Single<*>
        tokenUseCase.login(tokenUseCase.userName, tokenUseCase.password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleLoginResponse,this::handleLoginRequestError)
            .also { disposables.add(it) }

    }

    private fun handleLoginResponse(response: LoginResponse)
    {
        /* when(response.status)
         {
             true -> albumList.postValue(response.result!!.items)
             false -> run{
                 loginRequestErrorMessage.value = response.message
                 albumRequestStatus.postValue(ERRORFROMSERVER)
             }
         } */



        tokenUseCase.token = response.token

        Log.i("", "token: " + tokenUseCase.token )

        Log.i("", "isLoggedIn: " + tokenUseCase.isLoggedIn)

        onSuccess()

    }

    private fun handleLoginRequestError(error: Throwable)
    {
        Log.i("", error.message)

        Log.i("", error.message)
        //println(error.message)
        onFailur()
        when(error)
        {
            is HttpException -> Log.i("", "exception")
                .also {
                    Log.i("", error.code().toString())
               /*     when(error.code())
                    {

                        401 -> loginRequestErrorMessage.value = (
                                JsonParser().parse(error.response().errorBody()!!.string())
                                    .asJsonObject["message"]
                                    .asString     ).also { loginRequestStatus.postValue(
                            ERRORFROMSERVER
                        ) }
                        500 -> loginRequestErrorMessage.value = (
                                JsonParser().parse(error.response().errorBody()!!.string())
                                    .asJsonObject["message"]
                                    .asString     ).also { loginRequestStatus.postValue(
                            ERRORFROMSERVER
                        ) }

                        else -> loginRequestStatus.postValue(ERRORUNKNOWN)
                    }
                    */

                }
            //else -> loginRequestStatus.postValue(ERRORCONNECTION)
        }




        Log.i("", "error login")

    }

}