package ru.andlancer.kdcsozvezdie.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Settings")
data class Settings(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int ?= null,
    @ColumnInfo(name = "firstRun")
    var firstRun: Boolean = false,
    var globalSync: Boolean = false
)
