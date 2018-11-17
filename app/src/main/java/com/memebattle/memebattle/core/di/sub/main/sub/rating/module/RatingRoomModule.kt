package com.memebattle.memebattle.core.di.sub.main.sub.rating.module

import com.bignerdranch.android.osm.data.room.AppDatabase
import com.bignerdranch.android.osm.data.room.UserDao
import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingRoomService
import dagger.Module
import dagger.Provides

@Module
class RatingRoomModule {

    @Provides
    @FragmentScope
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @FragmentScope
    fun roomParamService(dao: UserDao): RatingRoomService {
        return RatingRoomService(dao)
    }
}