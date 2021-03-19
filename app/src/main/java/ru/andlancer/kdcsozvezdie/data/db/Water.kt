package ru.andlancer.kdcsozvezdie.data.db

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import ru.andlancer.kdcsozvezdie.network.Adapters.DateDeserializer
import ru.andlancer.kdcsozvezdie.network.Adapters.DateSerializer
import ru.andlancer.kdcsozvezdie.repository.converter.DateConverter
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "Water", foreignKeys = arrayOf(
    ForeignKey(
        entity = Journal::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_journal"),
        onDelete = CASCADE
    )
)
)
@TypeConverters(DateConverter::class)
data class Water(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("deviceID")
    var id: Long? = null,
    //@JsonAdapter(DateDeserializer::class)
    var time: Long = Date().time,
    var volume: Float,
    var volume_max: Float,
    @SerializedName("journal__deviceID")
    var id_journal: Long,
    @Ignore
    var server_id_journal: Long? = null,
    var update: Long,
    @SerializedName( "id")
    var server_id: Long = 0L,
){
    constructor():this(volume = 0f, volume_max = 0f, id_journal = 0L, update = 0L)
}
