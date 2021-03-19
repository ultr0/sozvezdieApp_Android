package ru.andlancer.kdcsozvezdie.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var userId:Int ?= null,
    @SerializedName("access")
    @ColumnInfo(name = "accessToken")
    var accessToken: String? = null,
    @SerializedName("refresh")
    @ColumnInfo(name = "refreshToken")
    var refreshToken: String? = null
)
