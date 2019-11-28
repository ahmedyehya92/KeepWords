package com.intellidev.usecases.repository

import com.intellidev.entities.*
import com.intellidev.usecases.CafApis
import com.intellidev.usecases.PreferencesHelper
import com.intellidev.usecases.cafApis
import io.reactivex.Single
import retrofit2.Call


val repository: Repository by lazy { RepositoryImplementer() }

interface Repository {
    fun login (email: String, password: String): Single<LoginResponse>
    fun getTokenHeader(refreshToken: String): Call<LoginResponse>
    fun setLoggedInStatus(status:Boolean)
    fun getLoggedInStatus(): Boolean
    fun setToken(token: String)
    fun getToken():String
    fun setUserName(userName:String)
    fun setPassword(password: String)
    fun getUserName(): String
    fun getPassword(): String
    fun getRefreshToken(): String
    fun setRefreshToken(refreshToken: String)
}

class RepositoryImplementer (
    private val server: CafApis = cafApis,
    private val preferencesHelper: PreferencesHelper = PreferencesHelper()

) : Repository
{
    override fun setRefreshToken(refreshToken: String) {
        preferencesHelper.refreshToken = refreshToken
    }

    override fun getRefreshToken(): String {
        return preferencesHelper.refreshToken
    }


    override fun getTokenHeader(refreshToken: String): Call<LoginResponse> = server.getTokenInterceptor(RefreshTokenFields(refreshToken))
    override fun setUserName(userName: String) {
        preferencesHelper.username = userName
    }

    override fun setPassword(password: String) {
        preferencesHelper.password = password
    }

    override fun getUserName(): String {
        return preferencesHelper.username
    }

    override fun getPassword(): String {
        return preferencesHelper.password
    }

    override fun getLoggedInStatus(): Boolean {
        return preferencesHelper.isLoggedIn
    }

    override fun setToken(token: String) {
        preferencesHelper.token = token
    }

    override fun getToken(): String {
        return preferencesHelper.token
    }

    override fun setLoggedInStatus(status: Boolean) {
        preferencesHelper.isLoggedIn = status
    }

    override fun login(email: String, password: String) = server.login(LoginFields(email, password))




}


