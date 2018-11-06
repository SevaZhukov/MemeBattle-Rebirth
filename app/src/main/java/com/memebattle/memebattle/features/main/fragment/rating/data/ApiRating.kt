package com.memebattle.memebattle.features.main.fragment.rating.data

import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiRating {
    @POST("lol")
    fun getRating(@Query("start_position") start: String, @Query("end_position") end: String): Call<Rating>
}