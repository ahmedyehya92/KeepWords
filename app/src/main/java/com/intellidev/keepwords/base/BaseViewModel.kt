package com.intellidev.keepwords.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.intellidev.usecases.engine.toMutableLiveData
import com.intellidev.usecases.usecases.TokenUseCase

class BaseViewModel (
    private val screenMutableLiveData : MutableLiveData<Int> = (-1).toMutableLiveData(),
    private val tokenUseCase: TokenUseCase = TokenUseCase()
    )
    :ViewModel()
{
    var screenIndicator
        get() = screenMutableLiveData.value
        set(screenValue) = screenMutableLiveData.setValue(screenValue)

    var isLoggedIn
        get() = tokenUseCase.isLoggedIn
        set(value) {tokenUseCase.isLoggedIn = false}
}