package com.memebattle.memebattle.features.auth.fragment.sign_up

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.core.domain.interactor.AuthApiService
import com.memebattle.memebattle.features.auth.core.domain.model.req.UserReq
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import com.memebattle.newlegalclinic.feature.auth.core.domain.AuthSettingsService
import javax.inject.Inject

class SignUpViewModel: ViewModel() {

    val TAG = "code"

    lateinit var user: MutableLiveData<UserRes>
    lateinit var error: MutableLiveData<String>

    @Inject
    lateinit var authApiService: AuthApiService
    @Inject
    lateinit var authSettingsService: AuthSettingsService

    init {
        App.instance.daggerComponentHelper.authComponent!!.inject(this)
    }

    fun signUp(name: String) {
        val userReq = UserReq(name)
        authApiService.signUp(userReq, object : BaseCallback<UserRes> {
            override fun onSuccess(data: UserRes?) {
                Log.i(TAG, "success $data")
                user.value = data
                authSettingsService.setId("2")
            }

            override fun onError(t: Throwable) {
                Log.i(TAG, "error ${t.message}")
                user.value = UserRes("", "")
            }
        })
    }
}