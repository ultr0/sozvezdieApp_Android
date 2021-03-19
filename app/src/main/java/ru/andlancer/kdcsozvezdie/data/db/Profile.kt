package ru.andlancer.kdcsozvezdie.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.andlancer.kdcsozvezdie.repository.converter.DateConverter
import java.util.*

@Entity(tableName = "Profile")
@TypeConverters(DateConverter::class)
data class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "birthDay") var birthDay: Date = Date(),
    @ColumnInfo(name = "height")
    var height: Int = 0,
    @ColumnInfo(name = "weight")
    var weight: Float = 0.0f,
    @ColumnInfo(name = "sex")
    var sex: Int = 0,
    @ColumnInfo(name = "calcActivity")
    var calcActivity: Float = 0.0f,
    @ColumnInfo(name = "calcGoal")
    var calcGoal: Int = 0,
)
