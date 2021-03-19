package ru.andlancer.kdcsozvezdie.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import ru.andlancer.kdcsozvezdie.data.db.Settings
import ru.andlancer.kdcsozvezdie.data.db.User

@Dao
interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSettings(user: Settings) : Completable

    @Query("SELECT * FROM Settings LIMIT 1")
    fun getSettings(): Single<Settings>

    @Delete
    fun deleteSettings(person:Settings) : Completable

    @Update
    fun updateSettings(person:Settings): Completable

}