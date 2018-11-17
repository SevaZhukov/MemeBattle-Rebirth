package com.memebattle.memebattle.features.main.fragment.rating.domain.interactor

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.bignerdranch.android.osm.data.room.UserDao
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

class RatingRoomService(val dao: UserDao) {

    suspend fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<User>, error: MutableLiveData<String>) {
        val list = async(CommonPool) {
            dao.loadInit(params.pageSize)
        }
        list.await()
    }

    suspend fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<User>, error: MutableLiveData<String>) {
        val list = async(CommonPool) {
            dao.loadRange(params.startPosition, params.startPosition + params.loadSize)
        }
        list.await()
    }
}