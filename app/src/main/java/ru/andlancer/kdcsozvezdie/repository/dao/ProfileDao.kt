package ru.andlancer.kdcsozvezdie.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import ru.andlancer.kdcsozvezdie.data.db.Profile
import ru.andlancer.kdcsozvezdie.data.db.Settings
import ru.andlancer.kdcsozvezdie.data.db.User

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile) : Completable

    @Query("SELECT * FROM Profile LIMIT 1")
    fun getProfile(): Single<Profile>

    @Delete
    fun deleteProfile(profile: Profile) : Completable

    @Update
    fun updateProfile(profile: Profile)

}