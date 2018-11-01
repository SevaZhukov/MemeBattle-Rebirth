package com.memebattle.memebattle.features.auth.fragment.vk

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import com.memebattle.memebattle.features.auth.core.domain.interactor.AuthApiService
import com.memebattle.memebattle.features.auth.core.domain.model.req.VkCode
import com.memebattle.newlegalclinic.feature.auth.core.domain.AuthSettingsService
import javax.inject.Inject

class VkViewModel : ViewModel() {

    val TAG = "code"

    var user = MutableLiveData<UserRes>()
    var error = MutableLiveData<String>()

    @Inject
    lateinit var apiService: AuthApiService
    @Inject
    lateinit var settingsService: AuthSettingsService

    init {
        App.instance.daggerComponentHelper.authComponent!!.inject(this)
    }

    fun vkAuth(code: String) {
        val vkCode = VkCode(code)
        apiService.vkAuth(vkCode, object : BaseCallback<UserRes> {
            override fun onSuccess(data: UserRes?) {
                Log.i(TAG, "success $data")
                user.value = data
                settingsService.setId("2")
            }

            override fun onError(t: Throwable) {
                Log.i(TAG, "error ${t.message}")
                error.value = "error"
            }
        })
    }
}