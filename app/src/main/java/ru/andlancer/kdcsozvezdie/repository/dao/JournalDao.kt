package ru.andlancer.kdcsozvezdie.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.andlancer.kdcsozvezdie.data.db.Journal
import ru.andlancer.kdcsozvezdie.data.db.Profile
import ru.andlancer.kdcsozvezdie.data.db.Settings
import ru.andlancer.kdcsozvezdie.data.db.User
import ru.andlancer.kdcsozvezdie.repository.converter.DateConverter
import java.util.*

@Dao
interface JournalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJournal(journal: Journal) : Maybe<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJournals(journal: List<Journal>) : Maybe<List<Long>>

    @Query("SELECT * FROM Journal Where id = :id")
    fun getJournal(id: Int): Single<Journal>

    @Query("SELECT * FROM Journal Where date = :date LIMIT 1")
    fun getJournalToday(@TypeConverters(DateConverter::class) date: Date): Single<Journal>

    @Query("SELECT * FROM Journal")
    fun getJournals(): Single<List<Journal>>

    @Delete
    fun deleteJournal(journal: Journal) : Completable

    @Update
    fun updateJournal(journal: Journal): Completable

}