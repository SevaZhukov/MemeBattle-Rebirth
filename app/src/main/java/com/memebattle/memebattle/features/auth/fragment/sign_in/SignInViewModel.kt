package com.memebattle.memebattle.features.auth.fragment.sign_in

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import com.memebattle.memebattle.features.auth.core.domain.interactor.AuthApiService
import javax.inject.Inject

class SignInViewModel : ViewModel() {

    lateinit var user: MutableLiveData<UserRes>
    lateinit var error: MutableLiveData<String>

    @Inject
    lateinit var authApiService: AuthApiService

    fun signIn(name: String) {
        authApiService.signIn(name, object : BaseCallback<UserRes> {
            override fun onSuccess(data: UserRes) {
                user.value = data
            }

            override fun onError(t: Throwable) {

            }
        })
    }
}