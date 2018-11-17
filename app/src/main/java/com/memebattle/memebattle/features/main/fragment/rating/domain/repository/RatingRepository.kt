package com.memebattle.memebattle.features.main.fragment.rating.domain.repository

import com.memebattle.memebattle.App
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingApiService
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingRoomService
import javax.inject.Inject

class RatingRepository {
    @Inject
    lateinit var apiService: RatingApiService
    @Inject
    lateinit var roomService: RatingRoomService

    init {
        App.instance.daggerComponentHelper.ratingComponent!!.inject(this)
    }

    private val FRESH_TIMEOUT = 30000
}