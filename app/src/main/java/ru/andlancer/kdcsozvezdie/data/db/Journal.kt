package ru.andlancer.kdcsozvezdie.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ru.andlancer.kdcsozvezdie.repository.converter.DateConverter
import java.util.*

@Entity(tableName = "Journal")
@TypeConverters(DateConverter::class)
data class Journal(
    @PrimaryKey(autoGenerate = true)
    @SerializedName( "deviceID")
    var id: Long? = null,
    var date: Date = Date(),
    var update: Long,
    @SerializedName( "id")
    var server_id: Long = 0L,
)
