package com.memebattle.memebattle.features.main.fragment.rating.data

import com.memebattle.memebattle.features.main.fragment.rating.domain.model.req.RatingReq
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRating {
    @POST("lol")
    fun getRating(@Body ratingReq: RatingReq): Call<Rating>
}