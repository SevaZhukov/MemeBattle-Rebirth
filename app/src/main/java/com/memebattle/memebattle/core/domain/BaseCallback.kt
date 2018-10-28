package com.memebattle.memebattle.core.domain

import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes

interface BaseCallback<T> {
    fun onSuccess(data: T)
    fun onError(t: Throwable)
}