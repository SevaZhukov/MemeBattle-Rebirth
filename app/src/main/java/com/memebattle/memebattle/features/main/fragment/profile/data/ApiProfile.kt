package com.memebattle.memebattle.features.main.fragment.profile.data

import com.memebattle.memebattle.features.main.fragment.profile.domain.model.req.ProfileReq
import com.memebattle.memebattle.features.main.fragment.profile.domain.model.res.Profile
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.req.RatingReq
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiProfile {
    @POST("lol")
    fun getProfile(@Body profileReq: ProfileReq): Call<Profile>
}