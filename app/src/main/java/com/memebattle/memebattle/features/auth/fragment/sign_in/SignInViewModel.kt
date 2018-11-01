package com.memebattle.memebattle.features.auth.fragment.sign_in

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import com.memebattle.memebattle.features.auth.core.domain.interactor.AuthApiService
import com.memebattle.memebattle.features.auth.core.domain.model.req.UserReq
import com.memebattle.newlegalclinic.feature.auth.core.domain.AuthSettingsService
import javax.inject.Inject

class SignInViewModel : ViewModel() {

    val TAG = "code"

    var user = MutableLiveData<UserRes>()
    var error = MutableLiveData<String>()

    @Inject
    lateinit var apiService: AuthApiService
    @Inject
    lateinit var settingsService: AuthSettingsService

    init {
        App.instance.authComponent!!.inject(this)
    }

    fun signIn(name: String) {
        val userReq = UserReq(name)
        apiService.signIn(userReq, object : BaseCallback<UserRes> {
            override fun onSuccess(data: UserRes?) {
                Log.i(TAG, "success $data")
                user.value = data
                settingsService.setId("2")
            }

            override fun onError(t: Throwable) {
                Log.i(TAG, "error ${t.message}")
                user.value = UserRes("", "")
            }
        })
    }
}