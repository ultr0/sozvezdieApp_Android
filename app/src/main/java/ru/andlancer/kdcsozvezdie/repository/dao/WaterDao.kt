package ru.andlancer.kdcsozvezdie.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.andlancer.kdcsozvezdie.data.db.Water

@Dao
interface WaterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWater(water: Water) : Maybe<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWaters(water: List<Water>) : Maybe<List<Long>>

    @Query("SELECT * FROM Water Where id = :id")
    fun getWater(id: Int): Single<Water>

    @Query("SELECT * FROM Water")
    fun getWaters(): Single<List<Water>>

    @Query("SELECT * FROM Water Where id_journal = :id")
    fun getWatersById(id: Long): Single<List<Water>>

    @Delete
    fun deleteWater(water: Water) : Completable

    @Update
    fun updateWater(water: Water): Completable

}