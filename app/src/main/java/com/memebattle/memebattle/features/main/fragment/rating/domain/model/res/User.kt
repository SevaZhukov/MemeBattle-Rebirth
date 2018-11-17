package com.memebattle.memebattle.features.main.fragment.rating.domain.model.res

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
abstract class User {
    @PrimaryKey
    lateinit var id: String
}