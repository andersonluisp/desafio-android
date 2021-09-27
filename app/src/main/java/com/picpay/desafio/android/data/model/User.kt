package com.picpay.desafio.android.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
data class User(
    val img: String,
   val name: String,
    @PrimaryKey val id: Int,
    val username: String
)