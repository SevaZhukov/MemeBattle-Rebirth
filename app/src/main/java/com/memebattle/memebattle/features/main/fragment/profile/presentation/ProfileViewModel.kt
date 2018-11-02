package com.memebattle.memebattle.features.main.fragment.profile.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.main.fragment.profile.domain.interactor.ProfileApiService
import com.memebattle.memebattle.features.main.fragment.profile.domain.model.req.ProfileReq
import com.memebattle.memebattle.features.main.fragment.profile.domain.model.res.Profile
import javax.inject.Inject

class ProfileViewModel : ViewModel() {
    val TAG = "code"

    var profile = MutableLiveData<Profile>()
    var error = MutableLiveData<String>()

    @Inject
    lateinit var apiService: ProfileApiService

    init {
        App.instance.daggerComponentHelper.mainComponent!!.inject(this)
    }

    fun getProfile(id: String) {
        val profileReq = ProfileReq(id)
        apiService.getProfile(profileReq, object : BaseCallback<Profile> {
            override fun onSuccess(data: Profile?) {
                profile.value = data
            }

            override fun onError(t: Throwable) {
                error.value = t.message
            }
        })
    }
}