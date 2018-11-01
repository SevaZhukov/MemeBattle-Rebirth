package com.memebattle.memebattle.features.auth.core.data

import com.memebattle.memebattle.features.auth.core.domain.model.req.UserReq
import com.memebattle.memebattle.features.auth.core.domain.model.req.VkCode
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiAuth {
    @POST("lol")
    fun signIn(@Body userReq: UserReq): Call<UserRes>

    @POST("kek")
    fun signUp(@Body userReq: UserReq): Call<UserRes>

    @POST("kek")
    fun vkAuth(@Body code: VkCode): Call<UserRes>
}